import java.util.Scanner;
import java.util.Random;

public class Ex10_GuessGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;
        int tries = 0;

        System.out.println("Guess the number between 1 and 100!");
        do {
            System.out.print("Your guess: ");
            guess = sc.nextInt();
            tries++;
            if (guess < target) System.out.println("Too low!");
            else if (guess > target) System.out.println("Too high!");
            else System.out.println("Correct! You got it in " + tries + " tries.");
        } while (guess != target);

        sc.close();
    }
}
