package JavaExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2CountCharacters {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int charCount = 0;
        System.out.println("Enter the characters" );
        int charInput;
        while ((charInput = reader.read()) != -1)
        {
            charCount++;
        }
        System.out.println("Total characters entered:" +charCount);
        reader.close();

    }
}
