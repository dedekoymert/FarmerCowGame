package com.company.model;

import java.util.Random;

public abstract class MovingObject<T> implements MapObject<T> {

  private int id;
  private int row;
  private int column;
  private int direction;
  private Type type;
  private char symbol;

  public MovingObject(int row, int column, Type type, char symbol) {
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

  public int getId() {
    return id;
  }

  @Override
  public Type getType() {
    return type;
  }

  @Override
  public char getSymbol() {
    return symbol;
  }

  public void setSymbol(char symbol){
    this.symbol = symbol;
  }

  public int getNextRow(){
    if (direction == 0) {
      return -1;
    } else if (direction == 1) {
      return 0;
    } else if (direction == 2) {
      return 1;
    } else {
      return 0;
    }
  }

  public int getNextColumn(){
    if (direction == 0) {
      return 0;
    } else if (direction == 1) {
      return 1;
    } else if (direction == 2) {
      return 0;
    } else {
      return -1;
    }
  }

  public int getDirection(){
    return direction;
  }

  public void setRow(int row){
    this.row = row;
  }

  public void setColumn(int column){
    this.column = column;
  }

}
