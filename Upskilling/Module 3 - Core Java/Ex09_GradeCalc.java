import java.util.Scanner;

public class Ex09_GradeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        int m = sc.nextInt();
        char grade;
        if (m >= 90) grade = 'A';
        else if (m >= 80) grade = 'B';
        else if (m >= 70) grade = 'C';
        else if (m >= 60) grade = 'D';
        else grade = 'F';
        System.out.println("Grade: " + grade);
        sc.close();
    }
}
