package com.company.model;

public class Food extends StationaryObject<Food> {

  public Food(int row, int column) {
    super(row, column, Food.class, '*');
  }

}
