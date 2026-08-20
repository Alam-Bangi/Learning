package tryouts.file_handling;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandling {

    static String fileName = "resources/example.txt";

    // Create file
    static void createFile() throws IOException {
        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("File already exists.");
        } else if (file.createNewFile()) {
            System.out.println("File created successfully.");
        } else {
            System.out.println("Failed to create file.");
        }
    }

    // Write to the file
    static void writeFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

        writer.write("Hello Java!");
        writer.newLine();

        writer.write("This is the first line.");
        writer.newLine();

        writer.write("This is the second line.");

        writer.close();
        System.out.println("Data written successfully.\n");
    }

    // Read from the file
    static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        System.out.println("--- File Contents ---");

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Append to the file
    static void appendToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

        writer.newLine();
        writer.write("This line was appended.");
        writer.newLine();
        writer.write("This is another appended line.");

        writer.close();
        System.out.println("\nData appended successfully.");
    }

    // Add a line at a specific position
    static void addAtSpecificLine(int position, String newLine) throws IOException {
        File file = new File(fileName);

        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        // Index starts from 0
        if (position >= 0 && position <= lines.size()) {
            lines.add(position, newLine);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String currentLine : lines) {
                writer.write(currentLine);
                writer.newLine();
            }
            writer.close();
            System.out.println("Line added successfully at position " + position + ".");
        } else {
            System.out.println("Invalid line position.");
        }
    }

    // Rename file
    static void renameFile(String newFileName) throws IOException {
        File oldFile = new File(fileName);

        Path newPath = Paths.get(newFileName);
        File newFile = newPath.toFile();

        if (oldFile.renameTo(newFile)) {
            System.out.println("\nFile renamed successfully!");
        } else {
            System.out.println("\nFailed to rename file.");
        }
    }

    // Delete file
    static void deleteFile() throws IOException {
        File file = new File(fileName);

        if (file.delete()) {
            System.out.println("\nFile deleted successfully.");
        } else {
            System.out.println("\nFailed to delete file.");
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. Create file
        createFile();

        // 2. Write to file
        writeFile();

        // 3. Read file
        readFile();

        // 4. Append to file
        appendToFile();

        // 5. Read file again
        System.out.println("\n--- File Contents After Append ---");
        readFile();

        // 6. Add lines at specific positions
        System.out.println();
        addAtSpecificLine(2, "This line was added in the middle.");
        addAtSpecificLine(5, "This line was added at second last.");

        // 7. Read file again
        System.out.println("\n--- File Contents After Adding At Specific Line ---");
        readFile();

        // 8. Rename file
        renameFile("D:\\Github\\Learning\\Daily\\2026\\project\\resources\\test.txt");

        // 9. Delete file
//         deleteFile();
    }
}
