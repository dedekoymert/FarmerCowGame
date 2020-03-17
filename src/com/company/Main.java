package com.company;

import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    // write your code here
//    File file = new File("/home/hive/dev/IdeaProjects/FarmerCowGame/map");
//
//    BufferedReader br = new BufferedReader(new FileReader(file));
//
//    String st;
//    while ((st = br.readLine()) != null) {
//
//      System.out.println(st);
//    }
    String mapPath = "map";
    int cowNumber = 2;
    int farmerNumber = 2;
    boolean stop = true;
    int foodNumber = 2;
    new App(mapPath, cowNumber, farmerNumber, foodNumber, stop);

  }

}


