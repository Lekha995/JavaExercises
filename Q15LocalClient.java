import java.io.*;
import java.net.*;

/**
 * Place the below code in different machine and provide the IP address of machine where the LocalServer code is present
 */
public class Q15LocalClient {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            // Connect to the server
            socket = new Socket("server_ip_address", 12345); // Replace server_ip_address with the actual IP address
            System.out.println("Connected to the server");

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Read message from user and send it to the server
            String userInput;
            System.out.println("Enter message: ");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Received from server: " + in.readLine());
                System.out.println("Enter message: ");
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection");
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
