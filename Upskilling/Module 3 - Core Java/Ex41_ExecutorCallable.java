import java.util.concurrent.*;
import java.util.*;

public class Ex41_ExecutorCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int n = i;
            futures.add(pool.submit(() -> {
                int sq = n * n;
                System.out.println("Task " + n + " computed square: " + sq);
                return sq;
            }));
        }

        System.out.println("Results:");
        for (Future<Integer> f : futures)
            System.out.println(f.get());

        pool.shutdown();
    }
}
