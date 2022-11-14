import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List<Vegetable> veg = new ArrayList<>();
        veg = VegDefault(veg);
        VegList(veg);



    }

    public static List<Vegetable> VegDefault(List<Vegetable> veg){
        veg.add(new LowCalorieVeg("Tomato",660,3));
        veg.add(new LowCalorieVeg("Cucumber",450,3));
        veg.add(new LowCalorieVeg("Carrot",1230,3));
        veg.add(new LowCalorieVeg("Cabbage",720,3));
        veg.add(new LowCalorieVeg("Onion",1170,3));
        return veg;
    }

    public static void VegList(List<Vegetable> list){
        for(int i=0;i<list.size();i++){
            System.out.println(String.format("\n\t%d.\n%s",i+1,list.get(i).toString()));
        }
    }

}