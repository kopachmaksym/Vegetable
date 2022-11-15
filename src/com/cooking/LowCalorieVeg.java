package com.cooking;

public class LowCalorieVeg extends Vegetable {

    private final double calorie;
    private final String type = "Low-Calorie";

    LowCalorieVeg(String nm, double kcal) {
        super(nm);
        calorie = kcal;
    }

    public double getCalorie(){
        return calorie;
    }

    public String toString(){
        return String.format("\t\tVegetable: %s\n\t\tCalorie: %.1f kcal/100g\n\t\tType: %s\n\n", name, calorie, type);
    }

}
