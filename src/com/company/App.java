package com.company;

import com.company.database.TamworthDatabase;
import com.company.database.TamworthDatabaseImpl;
import com.company.presenter.MapViewPresenter;
import com.company.view.MapView;
import com.company.view.MapViewImpl;

import java.io.IOException;

public class App {

  public App(String mapPath, int cowNumber, int farmerNumber, int foodNumber, boolean stop) throws IOException {
    MapView view = new MapViewImpl(stop);
    TamworthDatabase database = new TamworthDatabaseImpl();
    MapViewPresenter mapViewPresenter = new MapViewPresenter(database, view, mapPath, cowNumber, farmerNumber, foodNumber);
  }

}
