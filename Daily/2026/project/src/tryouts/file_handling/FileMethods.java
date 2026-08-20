package tryouts.file_handling;

import java.io.File;
import java.io.IOException;

public class FileMethods {

    public static void main(String[] args) throws IOException {
        // Create File object
        File file = new File("example.txt");

        // 1. exists()
        System.out.println("1. Exists: " + file.exists());

        // 2. createNewFile()
        if (!file.exists()) {
            System.out.println("2. File created: " + file.createNewFile());
        } else {
            System.out.println("2. File already exists");
        }

        // 3. getName()
        System.out.println("3. Name: " + file.getName());

        // 4. getPath()
        System.out.println("4. Path: " + file.getPath());

        // 5. getAbsolutePath()
        System.out.println("5. Absolute Path: " + file.getAbsolutePath());

        // 6. isFile()
        System.out.println("6. Is File: " + file.isFile());

        // 7. isDirectory()
        System.out.println("7. Is Directory: " + file.isDirectory());

        // 8. length()
        System.out.println("8. File Size: " + file.length() + " bytes");

        // 9. canRead()
        System.out.println("9. Can Read: " + file.canRead());

        // 10. canWrite()
        System.out.println("10. Can Write: " + file.canWrite());

        // 11. canExecute()
        System.out.println("11. Can Execute: " + file.canExecute());

        // 12. lastModified()
        System.out.println("12. Last Modified: " + file.lastModified());

        // 13. renameTo()
        File newFile = new File("newExample.txt");

        if (file.renameTo(newFile)) {
            System.out.println("13. File renamed successfully");

            // 14. delete()
            if (newFile.delete()) {
                System.out.println("14. File deleted successfully");
            } else {
                System.out.println("14. File could not be deleted");
            }
        } else {
            System.out.println("13. File rename failed");
        }

        // -------- DIRECTORY METHODS --------

        // 15. mkdir()
        File directory = new File("TestFolder");
        if (directory.mkdir()) {
            System.out.println("15. Directory created");
        } else {
            System.out.println("15. Directory already exists");
        }

        // 16. isDirectory()
        System.out.println("16. Is Directory: " + directory.isDirectory());

        // 17. getName()
        System.out.println("17. Directory Name: " + directory.getName());

        // 18. getPath()
        System.out.println("18. Directory Path: " + directory.getPath());

        // 19. getAbsolutePath()
        System.out.println("19. Directory Absolute Path: " + directory.getAbsolutePath());

        // 20. list()
        String[] files = directory.list();

        if (files != null) {
            System.out.println("20. Files in directory:");

            for (String name : files) {
                System.out.println(name);
            }
        }

        // 21. listFiles()
        File[] fileObjects = directory.listFiles();

        if (fileObjects != null) {
            System.out.println("21. File objects in directory:");

            for (File f : fileObjects) {
                System.out.println(f.getName());
            }
        }

        // 22. delete directory
        if (directory.delete()) {
            System.out.println("22. Directory deleted successfully");
        } else {
            System.out.println("22. Directory could not be deleted");
        }
    }
}