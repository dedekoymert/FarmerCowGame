package com.company.presenter;

import com.company.database.TamworthDatabase;
import com.company.model.*;
import com.company.view.MapView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MapViewPresenter implements MapView.Presenter {

  private MapView view;
  private TamworthDatabase database;
  private List<List<Character>> firstMap;
  private Map<Integer, Map<Integer, MapObject>> map = new HashMap<>();
  private String ANSI_RESET = "\u001B[0m";
  private String ANSI_RED = "\u001B[31m";
  private String ANSI_GREEN = "\u001B[32m";
  private String ANSI_YELLOW = "\u001B[33m";
  private String ANSI_PURPLE = "\u001B[35m";
  private String ANSI_WHITE = "\u001B[37m";

  public MapViewPresenter(TamworthDatabase database, MapView view, String mapPath, int cowNumber, int farmerNumber, int foodNumber)
    throws IOException {
    this.database = database;
    this.view = view;
    view.setPresenter(this);

    File file = new File(mapPath);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    firstMap = new ArrayList<>();
    while ((st = br.readLine()) != null) {
      firstMap.add(st.chars()
                     .mapToObj(c -> (char) c)
                     .collect(Collectors.toList()));
    }

    view.setFirstMap(firstMap);
    placeObstacle();
    placeEmpty();
    for (int i = 0; i < farmerNumber; i++) {
      placeFarmer();
    }
    for (int i = 0; i < cowNumber; i++) {
      placeCow();
    }
    for (int i = 0; i < foodNumber; i++) {
      placeFood();
    }

    view.printMap(map);
    view.start();
  }

  private void placeObstacle() {
    for (int i = 0; i < firstMap.size(); i++) {
      map.put(i, new HashMap<>());
      for (int j = 0; j < firstMap.get(i).size(); j++) {
        if (firstMap.get(i).get(j) == '#') {
          Obstacle obstacle = new Obstacle(i, j);
          map.get(i).put(j, obstacle);
          database.addObstacle(obstacle);
        }
      }
    }
  }

  private void placeEmpty() {
    for (int i = 0; i < firstMap.size(); i++) {
      int row = i;
      int minColumnOfRow = database.getObstacles().stream()
                                   .filter(obstacle -> obstacle.getRow() == row)
                                   .min(Comparator.comparingInt(Obstacle::getColumn)).get().getColumn();
      int maxColumnOfRow = database.getObstacles().stream()
                                   .filter(obstacle -> obstacle.getRow() == row)
                                   .max(Comparator.comparingInt(Obstacle::getColumn)).get().getColumn();
      for (int j = 0; j < firstMap.get(i).size(); j++) {
        if (firstMap.get(i).get(j) == ' ') {
          int column = j;
          int minRowOfColumn = database.getObstacles().stream()
                                       .filter(obstacle -> obstacle.getColumn() == column)
                                       .min(Comparator.comparingInt(Obstacle::getRow)).get().getRow();
          int maxRowOfColumn = database.getObstacles().stream()
                                       .filter(obstacle -> obstacle.getColumn() == column)
                                       .max(Comparator.comparingInt(Obstacle::getRow)).get().getRow();
          if (i > minRowOfColumn && j > minColumnOfRow && i < maxRowOfColumn && j < maxColumnOfRow) {
            if (map.get(i).get(j - 1).getSymbol() == '#' && map.get(i).getOrDefault(j + 1, null) != null &&
                map.get(i - 1).get(j).getSymbol() == '#' && map.get(i + 1).get(j).getType().equals(Type.Obstacle)) {
              map.get(i).put(j, new NonUsable(i, j));
            } else {
              Empty empty = new Empty(i, j);
              map.get(i).put(j, empty);
//              database.addEmpty(empty);
            }
          } else {
            map.get(i).put(j, new NonUsable(i, j));
          }
        }
      }
    }
  }

  private void placeFarmer() {
    while (true) {
      int row = new Random().nextInt(firstMap.size());
      int column = new Random().nextInt(firstMap.get(0).size());
      if (map.get(row).get(column).getType().equals(Type.Empty)) {
        Farmer farmer = new Farmer(row, column);
        database.addFarmer(farmer);
        map.get(row).replace(column, farmer);
        break;
      }
    }
  }

  private void placeCow() {
    while (true) {
      int row = new Random().nextInt(firstMap.size());
      int column = new Random().nextInt(firstMap.get(0).size());
      if (map.get(row).get(column).getType().equals(Type.Empty)) {
        Cow cow = new Cow(row, column);
        database.addCow(cow);
        map.get(row).replace(column, cow);
        break;
      }
    }
  }

  private void placeFood() {
    while (true) {
      int row = new Random().nextInt(firstMap.size());
      int column = new Random().nextInt(firstMap.get(0).size());
      if (map.get(row).get(column).getType().equals(Type.Empty)) {
        Food food = new Food(row, column);
        database.addFood(food);
        map.get(row).replace(column, food);
        break;
      }
    }
  }

  @Override
  public String getCowColor(int cowId) {

    Cow cow = database.getCows().stream()
                      .filter(c -> c.getId() == cowId)
                      .findFirst().get();

    if (cow.getHungerBarLevel() == 0) {
      return ANSI_PURPLE + cow.getSymbol() + ANSI_RESET;
    } else if (cow.getHungerBarLevel() == 1) {
      return ANSI_RED + cow.getSymbol() + ANSI_RESET;
    } else if (cow.getHungerBarLevel() == 2) {
      return ANSI_YELLOW + cow.getSymbol() + ANSI_RESET;
    } else if (cow.getHungerBarLevel() == 3) {
      return ANSI_GREEN + cow.getSymbol() + ANSI_RESET;
    }
    return ANSI_WHITE + cow.getSymbol() + ANSI_RESET;
  }

  @Override
  public void oneTurnPassed() {
    oneTurnCow();


    view.printMap(map);
  }

  private void oneTurnCow(){
    database.getCows().forEach(cow -> {
      int nextRow = cow.getRow()+cow.getNextRow();
      int nextColumn = cow.getColumn()+cow.getNextColumn();
      int direction = cow.getDirection();

      if (map.get(nextRow).get(nextColumn).getType().equals(Type.Food)) {
        if (cow.getHungerBarLevel() < 3) {
          cow.eatFood();
          database.removeFood(map.get(nextRow).get(nextColumn).getId());
          map.get(cow.getRow()).replace(cow.getColumn(), new Empty(cow.getRow(), cow.getColumn()));
          map.get(nextRow).replace(nextColumn, cow);
          cow.setRow(nextRow);
          cow.setColumn(nextColumn);
        } else {
          cow.turn();
        }
      } else if (map.get(nextRow).get(nextColumn).getType().equals(Type.Empty)) {
        map.get(cow.getRow()).replace(cow.getColumn(), new Empty(cow.getRow(), cow.getColumn()));
        map.get(nextRow).replace(nextColumn, cow);
        cow.setRow(nextRow);
        cow.setColumn(nextColumn);
      } else {
        cow.turn();
      }
    });
  }


  @Override
  public Map<Integer, Map<Integer, MapObject>> getMap() {
    return map;
  }
}
