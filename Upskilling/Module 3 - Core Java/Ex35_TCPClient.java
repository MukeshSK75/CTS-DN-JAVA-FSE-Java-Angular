import java.net.*;
import java.io.*;

public class Ex35_TCPClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (true) {
            System.out.print("You: ");
            line = stdin.readLine();
            out.println(line);
            System.out.println("Server: " + in.readLine());
            if (line.equalsIgnoreCase("bye")) break;
        }

        s.close();
    }
}
