import java.net.*;
import java.io.*;

public class Ex35_TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started on port 5000. Waiting for client...");
        Socket client = ss.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Client: " + line);
            System.out.print("You: ");
            String reply = stdin.readLine();
            out.println(reply);
            if (reply.equalsIgnoreCase("bye")) break;
        }

        client.close();
        ss.close();
    }
}
