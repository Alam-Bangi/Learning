package com.study;

import com.study.fileoperation.FileLearn;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagement {
    public static final String REGEX = " \\| ";
    private String fileName = "books.txt";
    private String path = "";
    InputData inputData = new InputData();

    public boolean isFileExists() {
        Path filePath = Paths.get(this.fileName);
        if (Files.exists(filePath)) {
            return true;
        }
        return false;
    }
    public boolean validateData(){
        if(this.isFileExists()){
            Path filePath = Paths.get(fileName);
            try{
                List<String> rawData = Files.readAllLines(filePath);
                for(String data :rawData){
                    if (!(data.split(REGEX).length ==3))
                        return false;
                }

            }catch (Exception e) {

            }
            return true;
        }
        return false;
    }
    public void add(Book book) {
        createFile();
        append(book.fileWrite());
    }
    public List<Book> get() {
        List<Book> books = new ArrayList<>();
        try {
            if(isFileExists()) {
                List<String> lines = Files.readAllLines(getFile());
                for(String line : lines){
                    String[] data = line.split(REGEX);
                    books.add(new Book(data[0], data[1], data[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file.");
        }
        return books;
    }
    public void clearFile() {
        Path path = Paths.get(fileName);
        try {
            if (Files.exists(path)) {
                Files.writeString(path, "", StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("File cleared");
            }
        } catch (IOException e) {
            System.err.println("Error clearing file: " + e.getMessage());
        }
    }
    private void createFile() {
        Path path = Paths.get(fileName);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }
    private void append(String text) {
        Path path = Paths.get(fileName);
        try {
            // APPEND forces Java to write at the end of the file
            Files.writeString(path, text, StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
    private Path getFile() {
        return Paths.get(fileName);
    }
    public void deleteLine(String name) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            lines.removeIf(line -> line.toLowerCase().contains(name.toLowerCase()));
            Files.write(Paths.get(fileName), lines);
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    public void update(String targetWord, String replacementWord) {
        Path path = Paths.get(fileName);
        try {
            if (!Files.exists(path)) {
                System.out.println("File does not exist.");
                return;
            }
            List<String> content = new ArrayList<>(Files.readAllLines(path));
            System.out.println("Enter name of book to update");
            String name = inputData.search();
            for (int i = 0; i < content.size(); i++) {
                String line = content.get(i);
                if(line.toLowerCase().contains(name.toLowerCase())){
                    if (line.contains(targetWord)) {
                        content.set(i, line.replace(targetWord, replacementWord));
                    }
                }
            }
            Files.write(path, content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error updating file: " + e.getMessage());
        }
    }
    public void addToSpecificIndex(Book book, int lineNumber) {
        List<Book> books = get();
        int index = lineNumber - 1;
        if (index < 0) {
            index = 0;
        }
        if (index > books.size()) {
            books.add(book); // Add at end
        } else {
            books.add(index, book); // Insert at specific line
        }
    }
}
//    public void save(List<Book> books) {
//        StringBuilder builder = new StringBuilder();
//
//        for(Book book : books){
//            builder.append(book.fileWrite());
//        }
//        FileLearn.writeFile(fileName, builder.toString());
//    }