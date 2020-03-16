package com.company.model;


import java.util.Random;

public class Farmer extends MovingObject<Farmer> {

  private int caughtCowCount = 0;

  public Farmer(int row, int column) {
    super(row, column, Type.Farmer, '0');
  }

  public void increaseCowCaughtCount(){
    caughtCowCount++;
  }

  public int getCaughtCowCount(){
    return caughtCowCount;
  }

}
