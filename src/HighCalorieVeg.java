public class HighCalorieVeg extends Vegetable{

    private double calorie;
    private double mass;

    HighCalorieVeg(String nm, double cal, double ms) {
        super(nm);
        calorie = cal;
        mass = ms;
    }

    public String toString(){
        return String.format("Vegetable: %s\nCalorie: %fcal\nMass: %fg\nType: Low-Calorie\n", name, calorie, mass);
    }

}
