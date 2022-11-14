import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vegetable> veg = new ArrayList<>();
        veg = VegDefault(veg);
        VegList(veg);

    }

    public static List<Vegetable> VegDefault(List<Vegetable> veg){
        veg.add(new LowCalorieVeg("Tomato",660));
        veg.add(new LowCalorieVeg("Cucumber",450));
        veg.add(new LowCalorieVeg("Carrot",1230));
        veg.add(new LowCalorieVeg("Cabbage",720));
        veg.add(new LowCalorieVeg("Onion",1170));
        return veg;
    }

    public static void VegList(List<Vegetable> list){
        for(int i=0;i<list.size();i++){
            System.out.println(String.format("\n\t%d.\n%s",i+1,list.get(i).toString()));
        }
    }

    public static List<Vegetable> VegSelect(Scanner scanner, List<Vegetable> choise){
        List<Vegetable> select = new ArrayList<>();
        while (true){
            VegList(choise);
            System.out.println("\tSelect: ");
            int var = scanner.nextInt();
            while (var<choise.size() && var>0){
                System.out.println("\tSelect: ");
                var = scanner.nextInt();
            }
            System.out.println();


        }
        return select;
    }

}