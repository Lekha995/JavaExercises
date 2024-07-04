package JavaExercises;

import java.io.DataInputStream;
import java.io.IOException;

public class Q1ReadInput {

    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("Enter something :");
        String input = dis.readLine();
        System.out.println("Value entered:" +input);
    }
}
