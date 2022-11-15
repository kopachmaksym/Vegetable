package com.cooking;

public class Vegetable {
    /*
    Class with name of vegetable
    */
    protected String name;

    Vegetable(String nm){
        name = nm;
    }

    public String getName(){
        return name;
    }

    public double getCalorie(){
        return 0;
    }

    public String toString(){
        return "";
    }

}
