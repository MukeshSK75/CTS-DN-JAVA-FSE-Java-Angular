import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Ex22_FileWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write: ");
        String txt = sc.nextLine();
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(txt);
            System.out.println("Data written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        sc.close();
    }
}
