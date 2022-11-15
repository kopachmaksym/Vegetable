package com.cooking;

import java.util.*;
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

    public void CalRange(){
        int j=1;
        double more, less;
        System.out.print("\tEnter the range:\n\t\tMore: ");
        more = scanner.nextFloat();
        System.out.print("\t\tLess: ");
        less = scanner.nextFloat();
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

    public void bubbleSort(int var){
        Double[] sortarr = new Double[mass.size()];
        Double[] addsort = new Double[calories.size()];
        String[] veget = new String[veg.size()];
        sortarr = mass.toArray(sortarr);
        addsort = calories.toArray(addsort);
        veget = veg.toArray(veget);
        int len = sortarr.length;

        switch (var){
            case (1):
                for (int i=0;i<len-1;++i){

                    for(int j=0;j<len-i-1; ++j){

                        if(sortarr[j+1]<sortarr[j]){

                            Double swap = sortarr[j];
                            sortarr[j] = sortarr[j+1];
                            sortarr[j+1] = swap;

                            swap = addsort[j];
                            addsort[j] = addsort[j+1];
                            addsort[j+1] = swap;

                            String sw = veget[j];
                            veget[j] = veget[j+1];
                            veget[j+1] = sw;

                        }
                    }
                }
            case (2):
                for (int i=0;i<len-1;++i){

                    for(int j=0;j<len-i-1; ++j){

                        if(addsort[j+1]<addsort[j]){

                            Double swap = sortarr[j];
                            sortarr[j] = sortarr[j+1];
                            sortarr[j+1] = swap;

                            swap = addsort[j];
                            addsort[j] = addsort[j+1];
                            addsort[j+1] = swap;

                            String sw = veget[j];
                            veget[j] = veget[j+1];
                            veget[j+1] = sw;
                        }
                    }
                }
        }

        double ms = 0, cl = 0;
        String text = String.format("\n\tName: %s\n",salat);
        String add ="\n\tVegetables in salat:\n";
        for (int i =0;i<veget.length;i++){
            ms += sortarr[i];
            cl += addsort[i];
            add += String.format("\t\t%d. %s (%.3fkg, %.1fkcal)\n",(i+1), veget[i],sortarr[i],addsort[i]);
        }
        text += String.format("\tWeight: %.3fkg\n\tCalories: %.1fkcal",ms,cl);
        text += add;
        text += "\n";
        System.out.println(text);

    }

}
