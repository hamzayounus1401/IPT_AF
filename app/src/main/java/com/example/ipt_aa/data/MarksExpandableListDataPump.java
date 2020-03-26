package com.example.ipt_aa.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MarksExpandableListDataPump {
    public static HashMap<String, List<Marks>> getData() {
        HashMap<String, List<Marks>> expandableListDetail = new HashMap<String, List<Marks>>();
        List<Marks> cricket = new ArrayList<Marks>();
        cricket.add(new Marks("1", "2", "3", "4", "5", "6", "7", "8"));
        cricket.add(new Marks("1", "2", "3", "4", "5", "6", "7", "8"));
        cricket.add(new Marks("1", "2", "3", "4", "5", "6", "7", "8"));
        cricket.add(new Marks("1", "2", "3", "4", "5", "6", "7", "8"));
        cricket.add(new Marks("1", "2", "3", "4", "5", "6", "7", "8"));


        List<Marks> cricke2t = new ArrayList<Marks>();
        cricke2t.add(new Marks("1", "2", "3", "4", "5", "6", "7", "8"));
        cricke2t.add(new Marks("1", "2", "3", "4", "5", "6", "7", "8"));


        expandableListDetail.put("Quizes", cricket);
        expandableListDetail.put("Mid", cricke2t);


        return expandableListDetail;
    }
}