package com.company.model;

import java.util.Random;

public abstract class StationaryObject<T> implements MapObject<T> {

  private int id;
  private int row;
  private int column;
  private Type type;
  private char symbol;

  public StationaryObject(int row, int column, Type type, char symbol){
    this.id = new Random().nextInt(1000);
    this.row = row;
    this.column = column;
    this.type = type;
    this.symbol = symbol;
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

  public Type getType(){
    return type;
  }

  @Override
  public char getSymbol() {
    return symbol;
  }

}
