package com.cooking;
import java.io.IOException;
import java.util.*;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    List<Vegetable> veg = new ArrayList<>();

    public Menu(){
        /*
        Constructor
         */
        veg = VegDefault(veg);
    }

    private List<Vegetable> VegDefault(List<Vegetable> veg){
        /*
        Default vegetables for easier using (you don't need to create a lot of new vegetables)
         */
        veg.add(new LowCalorieVeg("Tomato",660));
        veg.add(new LowCalorieVeg("Cucumber",450));
        veg.add(new HighCalorieVeg("Carrot",1230));
        veg.add(new LowCalorieVeg("Cabbage",720));
        veg.add(new HighCalorieVeg("Onion",1170));
        return veg;
    }

    public void Selection() throws IOException {
        /*
        Main menu
         */
        Salat sal = null;
        System.out.println("\n\n\t\t\t\t\t\tMenu");
        int var;
        while(true){
            System.out.println("""

                    \t\t\t1.Vegetables (show, add, remove)
                    \t\t\t2.Salat(show all, creation, sorting, calories ranging)
                    \t\t\t3.Read list of salats from file
                    \t\t\t4.Help
                    \t\t\t5.Exit
                    """);
            System.out.print("\t\tSelect: ");
            var = scanner.nextInt();
            while (var <=0 || var > 5){
                System.out.print("\t\tSelect: ");
                var = scanner.nextInt();
            }
            if(var == 5){
                break;
            }
            else if (var == 1) {
                        /*
                        Submenu for vegetables and his operations
                        */
                System.out.println("""

                        \t\t\tVegetables
                        \t\t\t\t1.Show list
                        \t\t\t\t2.Add new vegetables
                        \t\t\t\t3.Remove one
                        \t\t\t\t4.Cancel
                        """) ;
                System.out.print("\t\t\tSelect: ");
                var = scanner.nextInt();
                while (var <=0 || var > 4){
                    System.out.print("\t\t\tSelect: ");
                    var = scanner.nextInt();
                }
                if (var == 4){
                    continue;
                }
                else if (var == 1) {
                    VegList(veg);
                }
                else if (var == 2) {
                    veg = AddVegetables(veg);
                }
                else {
                    veg = VegRemove(veg);
                }
            }
            else if (var == 2) {
                        /*
                        Submenu for salats and his operations
                        */
                System.out.println("""

                        \t\t\tSalat
                        \t\t\t\t1.Create
                        \t\t\t\t2.Sort
                        \t\t\t\t3.Find by parameter(calories)
                        \t\t\t\t4.Cancel
                        """);
                System.out.print("\t\t\tSelect: ");
                var = scanner.nextInt();
                while (var <= 0 || var > 4) {
                    System.out.print("\t\t\tSelect: ");
                    var = scanner.nextInt();
                }
                if (var == 4) {
                    continue;
                } else if (var == 1) {
                    sal = new Salat(VegSelect());
                    System.out.println(sal.toString());
                    FileWorking file = new FileWorking();
                    file.FileWriting(sal.toString());
                } else if (var == 2) {
                    if (sal == null){
                        System.out.println("You didn't make a salat. First, select the create option.");
                    }
                    else {
                        System.out.print("Choose parameter of sorting (1)by mass (2)by calories: ");
                        var = scanner.nextInt();
                        while (var!=1 && var!=2){
                            System.out.print("\t\t\tSelect: ");
                            var = scanner.nextInt();
                        }
                        sal.bubbleSort(var);
                    }
                } else {
                    if (sal == null){
                        System.out.println("You didn't make a salat. First, select the create option.");
                    }
                    else {
                        sal.CalRange();
                    }

                }
            }
            else if (var == 3) {
                        /*
                        Read file Salats.txt (it contains all saved salats)
                        */
                System.out.println("\n\n\n");
                FileWorking file = new FileWorking();
                file.FileReading("C:\\Users\\mk410\\OneDrive\\Desktop\\JavaProjects\\ComplexWork\\src\\com\\cooking\\Salats.txt");
                System.out.print("Insert any number to continue: ");
                int numb = scanner.nextInt();
            }
            else {
                        /*
                        Read file Help.txt (it contains documentation of using progmamme)
                        */
                System.out.println("\n\n\n");
                FileWorking file = new FileWorking();
                file.FileReading("C:\\Users\\mk410\\OneDrive\\Desktop\\JavaProjects\\ComplexWork\\src\\com\\cooking\\Help.txt");
                System.out.print("Insert any number to continue: ");
                int numb = scanner.nextInt();
            }
        }
    }

    private void VegList(List<Vegetable> list){
        /*
        List of vegetables
         */
        for(int i=0;i<list.size();i++){
            System.out.printf("\n\t%d.\n%s%n",i+1,list.get(i).toString());
        }
    }

    private List<Vegetable> AddVegetables(List<Vegetable> veg){
        /*
        Add new vegetables to List
         */
        scanner.useLocale(Locale.US);
        String name;
        double cal;
        do {
            System.out.print("\nInsert the vegetable: ");
            name = scanner.next();
            System.out.print("\nInsert the calories in 100 gramm: ");
            cal = scanner.nextFloat();

            if (cal >= 1000) {
                veg.add(new HighCalorieVeg(name, cal));
            } else {
                veg.add(new LowCalorieVeg(name, cal));
            }
            while (!name.equals("Y") && !name.equals("N")) {
                System.out.println("\nAdd another one(Y/N): ");
                name = scanner.next();
            }

        } while (!name.equals("N"));
        return veg;
    }

    private List<Vegetable> VegRemove(List<Vegetable> veg){
        /*
        Remove vegetable from List
         */
        VegList(veg);
        System.out.print("Select: ");
        int var = scanner.nextInt();
        while(var <= 0 && var > veg.size()){
            System.out.print("Select: ");
            var = scanner.nextInt();
        }
        veg.remove((var-1));
        return veg;
    }

    private List<Vegetable> VegSelect(){
        /*
        Creating salat from vegetables
         */
        List<Vegetable> choise = veg;
        List<Vegetable> select = new ArrayList<>();
        System.out.println("List of not selected vegetables: ");

        do {
            VegList(choise);
            System.out.print("\n\t\tList of selected vegetables(insert '0' to complete the operation): ");
            for (Vegetable vegetable : select) {
                System.out.print(vegetable.getName() + " ");
            }
            System.out.print("\n\n\tSelect: ");
            int var = scanner.nextInt();
            while (var > choise.size() && var < 0) {
                System.out.print("\tSelect: ");
                var = scanner.nextInt();
            }
            if (var == 0) {
                break;
            }
            select.add(choise.get((var - 1)));
            choise.remove((var - 1));
            System.out.println();


        } while (choise.size() != 0);
        return select;
    }

}