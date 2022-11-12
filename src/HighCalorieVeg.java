public class HighCalorieVeg extends Vegetable{

    float calorie;
    float mass;

    HighCalorieVeg(String nm, float cal, float ms) {
        super(nm);
        calorie = cal;
        mass = ms;
    }

    public String toString(){
        return String.format("Vegetable: %s\nCalorie: %f\nMass: %f\nType: High-Calorie\n", name, calorie, mass);
    }

}
