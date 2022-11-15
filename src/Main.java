import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
        Starting
         */
        Scanner scanner = new Scanner(System.in);
        List<Vegetable> veg = new ArrayList<>();
        veg = VegDefault(veg);

        /*
        Salat creating
         */
        Salat sal = new Salat(VegSelect(scanner, veg));
        System.out.println(sal.toString());


        /*
        Ranging calories in salat
         */
        double more, less;
        System.out.print("\tEnter the range:\n\t\tMore: ");
        more = scanner.nextFloat();
        System.out.print("\t\tLess: ");
        less = scanner.nextFloat();
        sal.CalRange(more,less);
    }

    public static List<Vegetable> VegDefault(List<Vegetable> veg){
        veg.add(new LowCalorieVeg("Tomato",660));
        veg.add(new LowCalorieVeg("Cucumber",450));
        veg.add(new HighCalorieVeg("Carrot",1230));
        veg.add(new LowCalorieVeg("Cabbage",720));
        veg.add(new HighCalorieVeg("Onion",1170));
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
            System.out.print("\n\t\tList of selected vegetables: ");
            for(int i=0;i<select.size();i++){
                System.out.print(select.get(i).getName() + " ");
            }
            System.out.print("\n\n\tSelect: ");
            int var = scanner.nextInt();
            while (var>choise.size() && var<0){
                System.out.print("\tSelect: ");
                var = scanner.nextInt();
            }
            if (var == 0){
                break;
            }
            select.add(choise.get((var - 1)));
            choise.remove((var-1));
            System.out.println();


        }
        return select;
    }

}