public class Q12PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber prime = new PrimeNumber();
        Thread thread = new Thread(prime);
        thread.start();
        System.out.println("Thread execution in progress");
    }
}

class PrimeNumber implements Runnable {
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
