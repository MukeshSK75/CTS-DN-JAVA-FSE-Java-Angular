import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Ex27_Lambda {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("banana", "apple", "mango", "cherry", "date"));
        Collections.sort(words, (a, b) -> a.compareTo(b));
        System.out.println("Sorted: " + words);
    }
}
