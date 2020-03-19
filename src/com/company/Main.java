package com.company;

import java.io.*;
import java.util.InputMismatchException;

public class Main {

  public static void main(String[] args) throws IOException {

    String mapPath = "";
    int cowNumber = 0;
    int farmerNumber = 0;
    boolean stop = true;
    int foodNumber = 0;

    for (int i = 0; i < args.length; i++){
      if (args[i].equals("-map")){
        i++;
        mapPath = "/Users/mertdedekoy/Documents/dev/FarmerCowGame/map";
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
        return;
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


