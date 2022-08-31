package Polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        double fuel = Double.parseDouble(input[1]);
        double consumption = Double.parseDouble(input[2]);

        Vehicle car = new Car(fuel, consumption);

        input = scan.nextLine().split("\\s+");
        double fuel2 = Double.parseDouble(input[1]);
        double consumption2 = Double.parseDouble(input[2]);

        Vehicle truck = new Truck(fuel2, consumption2);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];
            String type = tokens[1];

            if(command.equals("Drive")){
                double distance = Double.parseDouble(tokens[2]);
                if(type.equals("Car")){
                    System.out.println(car.drive(distance));
                }else if(type.equals("Truck")){
                    System.out.println(truck.drive(distance));
                }

            }else if(command.equals("Refuel")){
                double fuelQuantity = Double.parseDouble(tokens[2]);
                if(type.equals("Car")){
                    car.refuel(fuelQuantity);
                }else if(type.equals("Truck")){
                    truck.refuel(fuelQuantity);
                }

            }

        }
        System.out.println(car.toString());
        System.out.println(truck.toString());


    }
}

//        Car 30.4 0.4
//        Truck 99.34 0.9
//        5
//        Drive Car 500
//        Drive Car 13.5
//        Refuel Truck 10.300
//        Drive Truck 56.2
//        Refuel Car 100.2
//
//        Car needs refueling
//        Car travelled 13,5 km
//        Truck needs refueling
//        Car: 113,05
//        Truck: 109,13