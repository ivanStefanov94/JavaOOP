package Encapsulation.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if(toppingType.equals("Polymorphism.WildFarm.Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") ||
                toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        }else{
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    public void setWeight(double weight) {
        if(this.weight > 0 && this.weight <=50) {
            this.weight = weight;
        }else{
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
    }

    public double calculateCalories(){
        double toppingModifier = getToppingModificator(toppingType);
        return (2*this.weight) * toppingModifier;
    }

    private double getToppingModificator(String toppingType) {
        if(toppingType.equals("Polymorphism.WildFarm.Meat")){
            return 1.2;
        }else if(toppingType.equals("Veggies")){
            return 0.8;
        }else if(toppingType.equals("Cheese")){
            return 1.1;
        }else if(toppingType.equals("Sauce")){
            return 0.9;
        }else{
            return 0;
        }
    }
}
