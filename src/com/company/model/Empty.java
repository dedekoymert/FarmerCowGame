package com.company.model;

public class Empty extends StationaryObject<Empty> {

  public Empty(int row, int column) {
    super(row, column, Empty.class, '@');
  }

}
