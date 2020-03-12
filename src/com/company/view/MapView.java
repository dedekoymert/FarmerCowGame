package com.company.view;

import com.company.model.Cow;
import com.company.model.MapObject;

import java.util.List;
import java.util.Map;

public interface MapView {

  void setPresenter(Presenter presenter);

  void start();

  void printMap(Map<Integer, Map<Integer, MapObject>> map);

  void setFirstMap(List<List<Character>> firstMap);

  public interface Presenter {

    Map<Integer, Map<Integer, MapObject>> getMap();

    String getCowColor(int cowId);

    void oneTurnPassed();

  }

}
