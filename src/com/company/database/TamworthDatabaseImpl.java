package com.company.database;

import com.company.model.*;

import java.util.ArrayList;
import java.util.List;

public class TamworthDatabaseImpl implements TamworthDatabase {

  private List<Cow> cows = new ArrayList<>();
  private List<Farmer> farmers = new ArrayList<>();
  private List<Food> foods = new ArrayList<>();
  private List<Obstacle> obstacles = new ArrayList<>();
  private List<Empty> empties = new ArrayList<>();

  public TamworthDatabaseImpl() {
  }

  @Override
  public void addFarmer(Farmer farmer) {
    farmers.add(farmer);
  }

  @Override
  public void addCow(Cow cow) {
    cows.add(cow);
  }

  @Override
  public void addFood(Food food) {
    foods.add(food);
  }

  @Override
  public void addObstacle(Obstacle obstacle) {
    obstacles.add(obstacle);
  }

  @Override
  public void addEmpty(Empty empty) {
    empties.add(empty);
  }

  @Override
  public List<Farmer> getFarmers() {
    return new ArrayList<>(farmers);
  }

  @Override
  public List<Cow> getCows() {
    return new ArrayList<>(cows);
  }

  @Override
  public List<Food> getFoods() {
    return new ArrayList<>(foods);
  }

  @Override
  public List<Obstacle> getObstacles() {
    return new ArrayList<>(obstacles);
  }

  @Override
  public List<Empty> getEmpties() {
    return new ArrayList<>(empties);
  }

  @Override
  public void removeFood(int foodId) {
    foods.removeIf(f -> f.getId() == foodId);
  }

  @Override
  public void removeCow(int cowId) {
    cows.removeIf(cow -> cow.getId() == cowId);
  }
}
