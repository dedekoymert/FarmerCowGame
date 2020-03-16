package com.company.model;

public class NonUsable extends StationaryObject<NonUsable> {

  public NonUsable(int row, int column) {
    super(row, column, Type.NonUsable, ' ');
  }

}
