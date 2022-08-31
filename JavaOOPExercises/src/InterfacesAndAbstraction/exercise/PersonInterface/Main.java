package InterfacesAndAbstraction.exercise.PersonInterface;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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

            if(type.equals("Citizen")){
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];

                Birthable citizen = new Citizen(name,age,id,birthDate);
                birthDates.add(citizen);

            }else if(type.equals("Pet")){
                String name = tokens[1];
                String birthDate = tokens[2];

                Birthable pet = new Pet(name,birthDate);
                birthDates.add(pet);

            }else if(type.equals("Robot")){
                String model = tokens[1];
                String id = tokens[2];

                Robot robot = new Robot(id,model);
            }
            input = scan.nextLine();
        }

        int year = Integer.parseInt(scan.nextLine());

        for (Birthable birthDate : birthDates) {
            int birthYear = Integer.parseInt(birthDate.getBirthDate().split("\\/")[2]);

            if(birthYear == year){
                System.out.println(birthDate.getBirthDate());
            }

        }

    }
}
