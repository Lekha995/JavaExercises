package JavaExercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q6FileCopyOperation {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Source File and Destination File is not available");
            System.exit(1);
        }

        String sourceFile = args[0];
        String destFile = args[1];

        try {
            FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int length;

            // Copy data from source to destination file using buffer
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


