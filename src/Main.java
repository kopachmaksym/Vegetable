import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List<Vegetable> veg = new ArrayList<>();
        veg.add(new LowCalorieVeg("Max",200,200));
        System.out.println(veg.get(0).toString());
//        Vegetable veg = new LowCalorieVeg("Banana", 177.4, 200);
//        System.out.println(veg.toString());
    }
}