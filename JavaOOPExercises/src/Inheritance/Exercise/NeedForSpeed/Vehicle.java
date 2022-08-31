package Inheritance.Exercise.NeedForSpeed;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower){
        this.fuel = fuel;
        this.horsePower = horsePower;
        setFuelConsumption(getDefaultFuelConsumption());
    }

    public void drive(double kilometers){
        double consumedFuel = getFuelConsumption() * kilometers;

        if(consumedFuel <= getFuel()){
            setFuel(getFuel() - consumedFuel);
        }
    }

    public int getHorsePower() {
        return horsePower;
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
