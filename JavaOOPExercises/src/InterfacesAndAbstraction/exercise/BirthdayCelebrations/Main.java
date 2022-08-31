package InterfacesAndAbstraction.exercise.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Birthable> birthDates = new ArrayList<>();

        while(!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String type = tokens[0];

            if(type.equals("InterfacesAndAbstraction.exercise.BirthdayCelebrations.Citizen")){
                String name  = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthdate = tokens[4];
                Birthable citizen = new Citizen(name, age, id, birthdate);
                birthDates.add(citizen);

            }else if(type.equals("InterfacesAndAbstraction.exercise.BirthdayCelebrations.Robot")){
                String id = tokens[1];
                String model = tokens[2];
                Robot robot = new Robot(id, model);

            }else if(type.equals("InterfacesAndAbstraction.exercise.BirthdayCelebrations.Pet")){
                String name = tokens[1];
                String birthdate = tokens[2];
                Birthable pet = new Pet(name, birthdate);
                birthDates.add(pet);
            }

            input = scan.nextLine();
        }

        int year = Integer.parseInt(scan.nextLine());

        for (Birthable birthDate : birthDates) {
            int birthYear = Integer.parseInt(birthDate.getBirthDate().split("\\/")[2]);
            if(year == birthYear){
                System.out.println(birthDate.getBirthDate());
            }
        }

    }
}
