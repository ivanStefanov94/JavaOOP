package InterfacesAndAbstraction.lab.CarShop02extended;

public class Audi extends CarImpl implements Rentable{

    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced, int minRentDay, double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int minRentDay() {
        return this.minRentDay;
    }

    @Override
    public double pricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString(){
        return String.format("This is %s produced in %s and have %d tires%n" +
                        "Minimum rental period of %d days. Price per day %f", getModel(), countryProduced(),
                TIRES, minRentDay(), pricePerDay());
    }
}
