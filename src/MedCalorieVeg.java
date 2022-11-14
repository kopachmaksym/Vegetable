public class MedCalorieVeg extends Vegetable{

    private final double calorie;
    private final String type = "Medium-Calorie";

    MedCalorieVeg(String nm, double kcal) {
        super(nm);
        calorie = kcal;
    }

    public String toString(){
        return String.format("\t\tVegetable: %s\n\t\tCalorie: %.1f kcal/100g\n\t\tType: %s\n", name, calorie, type);
    }

}
