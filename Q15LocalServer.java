package JavaExercises;

import java.io.*;
import java.net.*;

public class Q15LocalServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            // Create a server socket listening on port 12345
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started, waiting for a client...");

            // Wait for a connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read message from client and send response
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from client: " + message);
                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
