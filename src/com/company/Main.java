package com.company;

import java.io.*;
import java.util.InputMismatchException;

public class Main {

  public static void main(String[] args) throws IOException {
//
    String mapPath = "";
    int cowNumber = 0;
    int farmerNumber = 0;
    boolean stop = true;
    int foodNumber = 0;

    if (args.length !=10) {
      System.out.println("Missing input");
      System.exit(1);
    }

    for (int i = 0; i < args.length; i++){
      if (args[i].equals("-map")){
        i++;
        mapPath = args[i];
      } else if (args[i].equals("-cows")) {
        i++;
        cowNumber = Integer.parseInt(args[i]);
      } else if (args[i].equals("-farmer")) {
        i++;
        farmerNumber = Integer.parseInt(args[i]);
      } else if (args[i].equals("-food")) {
        i++;
        foodNumber = Integer.parseInt(args[i]);
      } else if (args[i].equals("-stop")) {
        i++;
        if (args[i].equals("false")){
          stop = false;
        }
      } else {
        System.out.println("Wrong input");
        System.exit(1);
      }
    }

//    String mapPath = "/Users/mertdedekoy/Documents/dev/FarmerCowGame/map";
//    int cowNumber = 4;
//    int farmerNumber = 2;
//    boolean stop = true;
//    int foodNumber = 3;

    new App(mapPath, cowNumber, farmerNumber, foodNumber, stop);

  }

}


