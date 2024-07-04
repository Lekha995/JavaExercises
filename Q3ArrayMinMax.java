package JavaExercises;

import java.util.Random;

public class Q3ArrayMinMax {

    public static void main(String[] args) {
        // Create a 4x5x8 array
        int[][][] array = new int[4][5][8];


        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 8; k++) {
                    array[i][j][k] = random.nextInt(1000);
                }
            }
        }

        System.out.println("Array contents:");
        printArray(array);

        int smallest = array[0][0][0];
        int largest = array[0][0][0];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 8; k++) {
                    int value = array[i][j][k];
                    if (value < smallest) {
                        smallest = value;
                    }
                    if (value > largest) {
                        largest = value;
                    }
                }
            }
        }
        System.out.println("Smallest"+smallest);
        System.out.println("Largest:"+largest);
    }
    public static void  printArray(int[][][] array){
        for (int i = 0; i < 4; i++) {
            System.out.println("Layer " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 8; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }


    }
}
