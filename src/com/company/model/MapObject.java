package com.company.model;

public interface MapObject<T> {

  int getRow();

  int getColumn();

  int getId();

  Class<T> getType();

  char getSymbol();

}
