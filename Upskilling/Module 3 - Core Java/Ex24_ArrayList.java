import java.util.ArrayList;
import java.util.Scanner;

public class Ex24_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            names.add(sc.nextLine());
        }
        System.out.println("Students: " + names);
        sc.close();
    }
}
