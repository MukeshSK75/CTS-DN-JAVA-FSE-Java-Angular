import java.util.Scanner;

public class Ex15_StringRev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println("Reversed: " + rev);
        sc.close();
    }
}
