package JavaExercises;

public class Q4FibonacciSeries {


    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Not provided the command line argument");
            System.exit(1);
        }
        // Parse input from command line argument
        int n;
        try {
            n = Integer.parseInt(args[0]);
            if (n < 0) {
                throw new IllegalArgumentException("Number must be non-negative.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format");
            return;
        }


        System.out.println("Fibonacci series up to " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }


    public static int fibonacci(int i) {
        if (i <= 1) {
            return i;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }
}
