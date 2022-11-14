public class HighCalorieVeg extends Vegetable{

    private final double calorie;
    private final double mass;
    private final String type = "High-Calorie";

    HighCalorieVeg(String nm, double cal, double kg) {
        super(nm);
        calorie = cal;
        mass = kg;
    }

    public String toString(){
        return String.format("\t\tVegetable: %s\n\t\tCalorie: %.3fcal\n\t\tMass: %.3fkg\n\t\tType: %s\n", name, calorie, mass, type);
    }

}
