import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Locale;
public class Salat {
    private Scanner scanner = new Scanner(System.in);
    private String salat;
    private List<String> veg = new ArrayList<>();
    private List<Double> mass = new ArrayList<>();
    private List<Double> calories = new ArrayList<>();

    Salat(List<Vegetable> select){
        scanner.useLocale(Locale.US);
        System.out.print("Insert the name of the salat: ");
        salat = scanner.next();
        for (int i=0;i<select.size();i++){
            veg.add(select.get(i).getName());
            System.out.print("\nEnter the weight of the " + veg.get(i) + ": ");
            mass.add((double) scanner.nextFloat());
            calories.add((select.get(i).getCalorie()/100*(mass.get(mass.size()-1)*100)));
        }
    }

    public void CalRange(double more, double less){
        int j=1;
        System.out.println(String.format("%s's vegetable in range > %.1f and < %.1f",salat,more,less));
        for (int i=0;i<veg.size();i++){
            if(calories.get(i)>more && calories.get(i)< less){
                System.out.println(String.format("\t\t%d. %s - %.1fkcal",j,veg.get(i),calories.get(i)));
                j++;
            }
        }
    }

    public String toString(){

        double ms = 0, cl = 0;
        String text = String.format("\n\tName: %s\n",salat);
        String add ="\n\tVegetables in salat:\n";
        for (int i =0;i<veg.size();i++){
            ms += mass.get(i);
            cl += calories.get(i);
            add += String.format("\t\t%d. %s (%.3fkg, %.1fkcal)\n",(i+1), veg.get(i),mass.get(i),calories.get(i));
        }
        text += String.format("\tWeight: %.3fkg\n\tCalories: %.1fkcal",ms,cl);
        text += add;
        text += "\n";
        return text;
    }

}
