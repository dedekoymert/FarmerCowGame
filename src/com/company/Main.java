package com.company;

import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    for (int i = 0; i < args.length; i++){

    }

    String mapPath = args[0];
    int cowNumber = Integer.parseInt(args[1]);
    int farmerNumber = Integer.parseInt(args[2]);
    boolean stop = true;
    if (args[3].equals("false")) {
      stop = false;
    }
    int foodNumber = Integer.parseInt(args[4]);

//    String mapPath = "/Users/mertdedekoy/Documents/dev/FarmerCowGame/map";
//    int cowNumber = 4;
//    int farmerNumber = 2;
//    boolean stop = true;
//    int foodNumber = 3;

    new App(mapPath, cowNumber, farmerNumber, foodNumber, stop);

  }

}


