import java.util.HashMap;
import java.util.Scanner;

public class Ex25_HashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many entries? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            map.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int key = sc.nextInt();
        if (map.containsKey(key))
            System.out.println("Name: " + map.get(key));
        else
            System.out.println("ID not found");
        sc.close();
    }
}
