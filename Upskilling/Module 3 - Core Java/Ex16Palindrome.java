import java.util.Scanner;

public class Ex16Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String rev = new StringBuilder(clean).reverse().toString();
        if (clean.equals(rev))
            System.out.println("\"" + s + "\" is a Palindrome");
        else
            System.out.println("\"" + s + "\" is NOT a Palindrome");
        sc.close();
    }
}
