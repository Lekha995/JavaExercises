package JavaExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q7ReadFileWithLineNumbers {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("FileName is not provided");
            return;
        }
        String filename = args[0];
        try  {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line" + lineNumber + ":" + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


