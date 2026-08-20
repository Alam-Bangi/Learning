package tryouts.file_handling;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class NumberFileManager {

    static String fileName = "resources/numbers.txt";

    // Create file
    static void createFile() throws IOException {
        File file = new File(fileName);

        if(file.exists()) {
            FileWriter writer = new FileWriter(fileName, false);
            writer.close();
        } else if (file.createNewFile()) {
            System.out.println("File created successfully.");
        } else {
            System.out.println("File already exists.");
        }
    }

    // Add a number
    static void addNumber(int number) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);

        writer.write(number + "\n");
        writer.close();

        System.out.println(number + " added.");
    }

    // Display numbers
    static void displayNumbers() throws IOException {
        Scanner sc = new Scanner(new File(fileName));

        System.out.println("\nNumbers in file:");
        while (sc.hasNextInt()) {
            System.out.println(sc.nextInt());
        }
        sc.close();
    }

    // Update a number
    static void updateNumber(int oldNumber, int newNumber) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }
        sc.close();

        boolean found = false;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == oldNumber) {
                numbers.set(i, newNumber);
                found = true;
                break;
            }
        }
        if (found) {
            FileWriter writer = new FileWriter(fileName);
            for (int num : numbers) {
                writer.write(num + "\n");
            }
            writer.close();
            System.out.println(oldNumber + " updated to " + newNumber);
        } else {
            System.out.println(oldNumber + " not found.");
        }
    }

    // Delete a number
    static void deleteNumber(int number) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }
        sc.close();

        boolean found = numbers.remove(Integer.valueOf(number));

        if (found) {
            FileWriter writer = new FileWriter(fileName);
            for (int num : numbers) {
                writer.write(num + "\n");
            }
            writer.close();
            System.out.println(number + " deleted.");
        } else {
            System.out.println(number + " not found.");
        }
    }

    public static void main(String[] args) throws IOException {

        createFile();

        addNumber(10);
        addNumber(20);
        addNumber(980);
        addNumber(30);
        addNumber(120);
        addNumber(40);
        addNumber(650);
        addNumber(23);

        displayNumbers();

        updateNumber(20, 200);

        displayNumbers();

        deleteNumber(30);

        displayNumbers();
    }
}