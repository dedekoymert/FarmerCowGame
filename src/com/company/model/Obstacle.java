package com.company.model;

public class Obstacle extends StationaryObject<Obstacle> {

  public Obstacle(int row, int column) {
    super(row, column, Obstacle.class, '#');
  }

}
