package WorkingWithAbstraction.exercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suit = scan.nextLine();

        RankPowers rankPowers = RankPowers.valueOf(rank);
        SuitPowers suitPowers = SuitPowers.valueOf(suit);

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit,
                rankPowers.getRankPower()+suitPowers.getSuitPower());
    }
}
