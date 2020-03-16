package com.company.model;

public class Cow extends MovingObject<Cow> {

  private int hungerBarLevel = 0;
  private int stomachSize = 3;

  public Cow(int row, int column) {
    super(row, column, Type.Cow, 'C');
  }

  public void eatFood(){
    if (hungerBarLevel < stomachSize) {
      hungerBarLevel++;
    }
  }

  public void hungerLoseBar(){
    if (hungerBarLevel > 0)
      hungerBarLevel--;
  }

  public int getHungerBarLevel() {
    return hungerBarLevel;
  }

}
