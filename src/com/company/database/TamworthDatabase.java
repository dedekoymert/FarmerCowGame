package com.company.database;

import com.company.model.*;

import java.util.List;

public interface TamworthDatabase {

  void addFarmer(Farmer farmer);

  void addCow (Cow cow);

  void addFood (Food food);

  void addObstacle (Obstacle obstacle);

  List<Farmer> getFarmers();

  List<Cow> getCows();

  List<Food> getFoods();

  List<Obstacle> getObstacles();


}
