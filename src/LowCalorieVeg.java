public class LowCalorieVeg extends Vegetable {

    private float calorie;
    private float mass;

    LowCalorieVeg(String nm, float cal, float ms) {
        super(nm);
        calorie = cal;
        mass = ms;
    }

    public String toString(){
        return String.format("Vegetable: %s\nCalorie: %f\nMass: %f\nType: Low-Calorie\n", name, calorie, mass);
    }

}
