package com.company.model;

public class Cow extends MovingObject<Cow> {

  private int hungerBarLevel = 0;
  private int stomachSize = 3;
  private int hungerTurn = 0;

  public Cow(int row, int column) {
    super(row, column, Type.Cow, 'C');
  }

  public void eatFood() {
    if (hungerBarLevel < stomachSize) {
      hungerBarLevel++;
      hungerTurn = 0;
    }
  }

  public void hungerLoseBar() {
    if (hungerBarLevel > 0)
      hungerBarLevel--;
  }

  public int getHungerBarLevel() {
    return hungerBarLevel;
  }

  public void increaseHungerTurn() {
    if (hungerTurn == 4){
      hungerTurn = 0;
      hungerLoseBar();
    } else {
      hungerTurn++;
    }
  }

}
