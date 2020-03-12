package com.company.model;

import java.util.Random;

public abstract class MovingObject<T> implements MapObject<T> {

  private int id;
  private int row;
  private int column;
  private int direction;
  private Class<T> type;
  private char symbol;

  public MovingObject(int row, int column, Class<T> type, char symbol) {
    this.type = type;
    this.id = new Random().nextInt(1000);
    this.row = row;
    this.column = column;
    this.direction = new Random().nextInt(4);
    this.symbol = symbol;
  }

  public void moveForward() {
    if (direction == 0) {
      row--;
    } else if (direction == 1) {
      column++;
    } else if (direction == 2) {
      row++;
    } else {
      column--;
    }
  }

  public void turn() {
    if (direction == 3) {
      direction = 0;
    } else {
      direction++;
    }
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public int getDirection() {
    return direction;
  }

  public int getId() {
    return id;
  }

  @Override
  public Class<T> getType() {
    return type;
  }

  @Override
  public char getSymbol() {
    return symbol;
  }

  public void setSymbol(char symbol){
    this.symbol = symbol;
  }

}
