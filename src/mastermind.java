import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class mastermind {
    public static void main(String[] args) {

        Random random = new Random();
        boolean GameOver = false;
        boolean GameWon = false;
        int combi[] = new int[4];
        int entry[] = new int[4];
        for (int i = 0; i <combi.length; i++) {
            boolean inCombi =false;
            int r;
            do {int rand = random.nextInt(1,10);
                inCombi = false;
                for (int j = 0; j < combi.length; j++) {
                    if (rand == combi[j]) {
                        inCombi = true;
                    }
                }
                r = rand;
            } while (inCombi);
            if (!inCombi) {
                combi[i] = r;
            }

        }
        int counter = 0;
        while (counter < 10 &&!GameWon) {
            entry = input();
            int nbRight = right(entry, combi);
            if (nbRight == 4) { GameWon = true; }
            else { System.out.println(in(entry, combi)+" Correct numbers and "+ nbRight+" In the correct place"); }
            counter++;

        }
        if (GameWon) {
            System.out.println("Congratulations you won!");
        } else {
            System.out.println("Sorry you lost. the nuber was "+Arrays.toString(combi));
        }
    }
    static int[] input(){
        Scanner sc = new Scanner(System.in);
        int[] entry = new int[4];
        System.out.println("Enter 4 numbers: ");
        for (int i = 0; i < 4; i++) {
            entry[i] = sc.nextInt();
        }
        return entry;

    }
    static int in(int[] entry, int[] combi){
        int totIn = 0;
        for (int i = 0; i < entry.length; i++) {
            for (int j = 0; j < combi.length; j++) {
                if (entry[i] == combi[j]) {totIn++;}
            }
        }
        return totIn;
    }
    static int right(int[] entry, int[] combi){
        int totRight = 0;
        for (int i = 0; i < combi.length; i++) {
            if (combi[i] == entry[i]) {totRight++;};
        }
        return totRight;
    }
}
