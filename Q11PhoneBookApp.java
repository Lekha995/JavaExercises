package JavaExercises;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class Q11PhoneBookApp {
    public static final String FILE_NAME = "PhoneBook.dat";
    public Hashtable<String,String> phoneBook;

    public Q11PhoneBookApp(){
        phoneBook = new Hashtable<>();
        loadPhoneBook();
    }

    public static void main(String[] args){
        Q11PhoneBookApp app = new Q11PhoneBookApp();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Phone Book Menu");
            System.out.println("1. Add Number");
            System.out.println("2. Delete Number");
            System.out.println("3. List all Data");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.println("Enter your Choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    app.addPhoneNumber(scanner);
                    break;
                case 2:
                    app.deletePhoneNumber(scanner);
                    break;
                case 3:
                    app.listAll();
                    break;
                case 4:
                    app.searchNumber(scanner);
                    break;
                case 5:
                    app.savePhoneBook();
                    scanner.close();
                    return;
                default:
                    System.out.println("Please enter the valid choice");
            }
        }
    }

    public void addPhoneNumber(Scanner scanner)
    {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your Number:");
        String number = scanner.nextLine();
        phoneBook.put(name,number);
        System.out.println("Number added successfully");
    }

    public void deletePhoneNumber(Scanner scanner)
    {
        System.out.println("Enter name to delete:");
        String name = scanner.nextLine();
        String delete = phoneBook.remove(name);
        if(delete!= null)
        {
            System.out.println("Number Deleted Successfully");
        }
        else
        {
            System.out.println("Please provide valid name");
        }
    }

    public void listAll(){
        if (phoneBook.isEmpty()){
            System.out.println("PhoneBook is empty");
        }
        else {
            System.out.println("PhoneBook Entries:");
            phoneBook.forEach((name,number)-> System.out.println("Name:"+name+""+"Number:"+number));
        }
    }

    public void searchNumber(Scanner scanner){
        System.out.println("Enter name to search:");
        String name = scanner.nextLine();
        String number= phoneBook.get(name);
        if(number!=null){
            System.out.println(name+""+number);
        }
        else
        {
            System.out.println("Name not found");
        }
    }

    private void loadPhoneBook() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Phone book file created: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Failed to create phone book file: " + e.getMessage());
            }
        }
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                phoneBook = (Hashtable<String, String>) ois.readObject();
            } catch (EOFException e) {
                System.out.println("Phone book file is empty.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading phone book: " + e.getMessage());
            }
        } else {
            System.out.println("Phone book file not found or is empty. Starting with an empty phone book.");
        }
    }

    public void savePhoneBook(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(phoneBook);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
