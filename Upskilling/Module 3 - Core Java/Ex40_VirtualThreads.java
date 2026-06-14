import java.util.concurrent.atomic.AtomicInteger;

public class Ex40_VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        int count = 100_000;
        AtomicInteger done = new AtomicInteger();
        Thread[] vThreads = new Thread[count];

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            vThreads[i] = Thread.startVirtualThread(() -> {
                done.incrementAndGet();
            });
        }

        for (Thread t : vThreads) t.join();

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Launched " + done.get() + " virtual threads in " + elapsed + "ms");
    }
}
