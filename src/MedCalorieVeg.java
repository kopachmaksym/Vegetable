public class MedCalorieVeg extends Vegetable{

    float calorie;
    float mass;

    MedCalorieVeg(String nm, float cal, float ms) {
        super(nm);
        calorie = cal;
        mass = ms;
    }

    public String toString(){
        return String.format("Vegetable: %s\nCalorie: %f\nMass: %f\nType: Medium-Calorie\n", name, calorie, mass);
    }

}