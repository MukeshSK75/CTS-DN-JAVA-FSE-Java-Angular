public class Ex26_Threads {

    static class MyThread extends Thread {
        String msg;
        MyThread(String msg) { this.msg = msg; }

        public void run() {
            for (int i = 0; i < 5; i++)
                System.out.println(msg + " - count " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
