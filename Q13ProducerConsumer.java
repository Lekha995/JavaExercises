package JavaExercises;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Q13ProducerConsumer {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        producerThread.interrupt();
        consumerThread.interrupt();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Threads stopped.");
    }
}

class SharedQueue {
    private Queue<Integer> queue = new LinkedList<>();

    public synchronized void enqueue(int number) {
        queue.add(number);
        notify(); // Notify consumer that new item is available
    }

    public synchronized int dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until there is an item to consume
        }
        return queue.poll();
    }

    public synchronized void clear() {
        queue.clear();
        notifyAll(); // Notify any waiting threads (though none should be waiting if clear is called)
    }
}

class Producer implements Runnable {
    private SharedQueue sharedQueue;
    private Random random = new Random();
    private boolean running = true; // Flag to control thread execution

    public Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running && !Thread.currentThread().isInterrupted()) {
                int number = random.nextInt(100); // Generate random number between 0 and 99
                sharedQueue.enqueue(number);
                System.out.println("Produced: " + number);
                Thread.sleep(500); // Sleep for 0.5 seconds
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupted status
        }
    }
}

class Consumer implements Runnable {
    private SharedQueue sharedQueue;
    private volatile boolean running = true; // Flag to control thread execution

    public Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running && !Thread.currentThread().isInterrupted()) {
                int number = sharedQueue.dequeue();
                if (isPrime(number)) {
                    System.out.println("Consumed: " + number + " (Prime)");
                } else {
                    System.out.println("Consumed: " + number + " (Not Prime)");
                }
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupted status
        }
    }

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
}

