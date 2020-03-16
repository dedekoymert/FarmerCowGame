package com.company.model;

public interface MapObject<T> {

  int getRow();

  int getColumn();

  int getId();

  Type getType();

  char getSymbol();

}
