package InterfacesAndAbstraction.lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();


        while(!line.equals("End")){

            String[] tokens = line.split("\\s+");

            Identifiable identifiable;

            if(tokens.length == 2){
                identifiable = new Robot(tokens[1], tokens[0]);

            }else{
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            identifiables.add(identifiable);

            line = scan.nextLine();
        }

        String fakeIdPostFix = scan.nextLine();

        for (Identifiable identifiable : identifiables) {
            if(identifiable.getId().endsWith(fakeIdPostFix)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
