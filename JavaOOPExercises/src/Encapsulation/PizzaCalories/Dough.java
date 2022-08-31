package Encapsulation.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);

    }

    private void setWeight(double weight) {
        if(weight > 0 && weight <= 200){
        this.weight = weight;
        }else{
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(this.bakingTechnique.equals("Crispy") || this.bakingTechnique.equals("Chewy")
                || this.bakingTechnique.equals("Homemade")){

            this.bakingTechnique = bakingTechnique;
        }else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setFlourType(String flourType) {
        if(this.flourType.equals("White") || this.flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        }else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories(){
        double flourTypeModificator = getFlourTypeModificator(this.flourType);
        double bakingTechniqueModificator = getBakingTechniqueModificator(this.bakingTechnique);

        return (2*this.weight) * flourTypeModificator * bakingTechniqueModificator;
    }

    private double getBakingTechniqueModificator(String bakingTechnique) {
        if(this.bakingTechnique.equals("Crispy")){
            return 0.9;
        }else if(this.bakingTechnique.equals("Chewy")){
            return 1.1;
        }else if(this.bakingTechnique.equals("Homemade")){
            return 1.0;
        }else{
            return 0;
        }
    }

    private double getFlourTypeModificator(String flourType) {

        if(this.flourType.equals("White")){
            return 1.5;
        }else if(this.flourType.equals("Wholegrain")){
            return 1.0;
        }else{
            return 0;
        }
    }
}
