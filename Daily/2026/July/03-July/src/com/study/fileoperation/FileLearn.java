package com.study.fileoperation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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
//         writeFile("example.txt", "AMAAN");
//         writeFileWithoutTruncate("example.txt", "ALAM");
//         appendToFile("example.txt", " BANGI");
//         updateFileContent("example.txt", "ALAMN", "ALAM");
//         clearFileContent("example.txt");
//         writeFile("example.txt", "AMAAN");
//         appendToFile("example.txt", "\nALAM BANGI");
//         readFile("example.txt");
//         deleteFile("example.txt");
     }

    public static void createFile(String filePath) {
        Path path = Paths.get(filePath);
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

    public static void appendToFile(String filePath, String textToAppend) {
        Path path = Paths.get(filePath);
        try {
            // APPEND forces Java to write at the end of the file
            Files.writeString(path, textToAppend, StandardCharsets.UTF_8,
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
//                System.out.println("File content updated successfully.");
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
}
