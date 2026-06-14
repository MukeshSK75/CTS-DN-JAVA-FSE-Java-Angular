import java.util.Scanner;

public class Ex04_LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int yr = sc.nextInt();
        boolean leap = (yr % 4 == 0 && yr % 100 != 0) || (yr % 400 == 0);
        if (leap)
            System.out.println(yr + " is a Leap Year");
        else
            System.out.println(yr + " is not a Leap Year");
        sc.close();
    }
}
