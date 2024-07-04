package JavaExercises;
import java.util.Scanner;
import java.util.Vector;
public class Q10QueueMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Queue of Strings
        Queue<String> queue = new Queue<>();

        while (true) {
            System.out.println("\nQueue Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. List Elements");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    String itemToAdd = scanner.nextLine();
                    queue.enqueue(itemToAdd);
                    System.out.println(itemToAdd + " enqueued.");
                    break;
                case 2:
                    String dequeuedItem = queue.dequeue();
                    if (dequeuedItem == null) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        System.out.println("Dequeued element: " + dequeuedItem);
                    }
                    break;
                case 3:
                    queue.listElements();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}

class Queue<T> extends Vector<T> {

    public void enqueue(T item) {
        addElement(item);
    }
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return remove(0);
    }
    public void listElements() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Elements in the queue:");
        for (int i = 0; i < size(); i++) {
            System.out.println(elementAt(i));
        }
    }
}

