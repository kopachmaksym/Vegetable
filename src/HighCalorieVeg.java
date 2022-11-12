public class HighCalorieVeg extends Vegetable{

    private final double calorie;
    private final double mass;
    private final String type = "High-Calorie";

    HighCalorieVeg(String nm, double cal, double ms) {
        super(nm);
        calorie = cal;
        mass = ms;
    }

    public String toString(){
        return String.format("Vegetable: %s\nCalorie: %.3fkcal\nMass: %.3fkg\nType: %s\n", name, calorie, mass, type);
    }

}
