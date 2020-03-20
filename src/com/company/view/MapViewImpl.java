package com.company.view;

import com.company.model.MapObject;
import com.company.model.Type;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapViewImpl implements MapView {

  private boolean stop;
  private Presenter presenter;
  private List<List<Character>> firstMap;
  private int numberOfTurns = 0;


  public MapViewImpl(boolean stop) throws IOException {
    this.stop = stop;
  }

  @Override
  public void start() {
    System.out.println("Enter 1 for next turn");
    System.out.println("Enter 0 to finish");

    if (stop) {
      Scanner input = new Scanner(System.in);
      String goOn = input.next();

      while (goOn.equals("1")) {
        presenter.oneTurnPassed();
        numberOfTurns++;

        goOn = input.next();
        if (goOn.equals("0")) {
          break;
        }
      }
    }

    while (true) {
      presenter.oneTurnPassed();
      numberOfTurns++;
      if(numberOfTurns > (firstMap.size()*firstMap.size())) {
        System.out.println("Farmers can not catch cows");
        System.exit(0);
      }
    }
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }


  public void printMap(Map<Integer, Map<Integer, MapObject>> map) {
    for (int i = 0; i < firstMap.size(); i++) {
      for (int j = 0; j < firstMap.get(i).size(); j++) {
        if (map.get(i).get(j).getType().equals(Type.Cow)) {
          System.out.print(presenter.getCowColor(map.get(i).get(j).getId()));
        } else {
          System.out.print(map.get(i).get(j).getSymbol());
        }


      }
      System.out.println();
    }
  }

  @Override
  public void setFirstMap(List<List<Character>> firstMap) {
    this.firstMap = firstMap;
  }

}
