package com.study.fileoperation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLearn {
 /*  to do
    how to create file
    how to write in a file
        append in a file
        update a file
            update existing content
            delete existing content
    how to read a file
    how to delete file
 */
     public static void main(String[] args) {
//         createFile("example.txt");
//         writeFile("example.txt", "Amaan S");
//         writeFileWithoutTruncate("example.txt", "ALAM");
//         updateFileContent("example.txt", "ALAMN", "ALAM");
//         clearFileContent("example.txt");
//         writeFile("example.txt", "AMAAN");
//         appendToFile("example.txt", "\nAlam B");
//         appendToFile("example.txt", "\nAbrar M");
//         appendToFile("example.txt", "\nAbid M");
//         addToSpecificLine("example.txt", "Abrar");
//         updateFileContent("example.txt", "BANGI", "");
//         readLines("example.txt");
//         deleteFile("example.txt");
//         writeFile("ex.txt", "ABC");
//         writeFiles("ex.txt", "ABC");
//         deleteLine("example.txt", "Abid M");
//         deleteLine("example.txt", "Alam B");
         primeNumber();
     }

    public static void createFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    public static void writeFile(String filePath, String textContent) {
        Path path = Paths.get(filePath);
        try {
            // TRUNCATE_EXISTING clears old data; CREATE makes the file if it is missing
            Files.writeString(path, textContent, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
//            System.out.println("Data written successfully (overwrote old content).");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    public static void writeFileWithoutTruncate(String filePath, String textContent) {
        Path path = Paths.get(filePath);
        try {
            // CREATE: Makes the file if it doesn't exist
            // WRITE: Opens the file for writing without erasing existing content first
            // Writes on same content (eg: old content - "AMAAN" then after writing "ALAM" it becomes "ALAMN"
            Files.writeString(path, textContent, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//            System.out.println("Data written successfully (without truncation).");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void appendToFile(String filePath, String text) {
        Path path = Paths.get(filePath);
        try {
            // APPEND forces Java to write at the end of the file
            Files.writeString(path, text, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    public static void updateFileContent(String filePath, String targetWord, String replacementWord) {
        Path path = Paths.get(filePath);
        try {
            if (!Files.exists(path)) {
                System.out.println("File does not exist.");
                return;
            }
            // Read everything, swap the text, and write it back cleanly
            String content = Files.readString(path, StandardCharsets.UTF_8);
            if (content.contains(targetWord)) {
                String updatedContent = content.replace(targetWord, replacementWord);
                Files.writeString(path, updatedContent, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                System.out.println("Target phrase not found. No updates made.");
            }
        } catch (IOException e) {
            System.err.println("Error updating file: " + e.getMessage());
        }
    }

    public static void clearFileContent(String filePath) {
        Path path = Paths.get(filePath);
        try {
            if (Files.exists(path)) {
                Files.writeString(path, "", StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
//                System.out.println("File cleared. It is now completely empty.");
            }
        } catch (IOException e) {
            System.err.println("Error clearing file: " + e.getMessage());
        }
    }

    public static List<String> readLines(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            boolean deleted = Files.deleteIfExists(path);
            if (deleted) {
                System.out.println("File completely removed from storage.");
            } else {
                System.out.println("File could not be deleted because it does not exist.");
            }
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }

    public static void updateSpecificLine() throws IOException {
        Path path = Paths.get("sample.txt");

        List<String> lines = Files.readAllLines(path);

        for (int i = 0; i < lines.size(); i++) {

            if (lines.get(i).equals("Old Line")) {
                lines.set(i, "New Updated Line");
            }
        }
        Files.write(path, lines);
        System.out.println("Line updated by text match");
    }

    public static void addToSpecificIndex(String filePath, String newText, int targetLineNumber) {
        Path path = Paths.get(filePath);
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (targetLineNumber >= 0 && targetLineNumber <= lines.size()) {
                lines.add(targetLineNumber, newText);
            } else {
                System.out.println("Line number out of bounds. Appending to the end.");
                lines.add(newText);
            }
            Files.write(path, lines, StandardCharsets.UTF_8);
            System.out.println("Line inserted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFiles(String filePath, String textContent) {
        Path path = Paths.get(filePath);
        try {
            // TRUNCATE_EXISTING clears old data; CREATE makes the file if it is missing
            Files.writeString(path, textContent, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);
//            System.out.println("Data written successfully (overwrote old content).");
        } catch (IOException e) {
            System.err.println("alam Error writing to file: " + e.getMessage());
        }
    }

    public static void primeNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.nextLine();
        boolean isDivisible = false;

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                isDivisible = true;
            }
        }
        if(!isDivisible) {
            System.out.println("Number is prime");
        } else {
            System.out.println("Not a prime number");
        }
     }

    public static void deleteLine(String filePath, String name) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.removeIf(line -> line.toLowerCase().contains(name.toLowerCase()));
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
