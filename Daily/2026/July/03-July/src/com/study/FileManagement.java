package com.study;

import com.study.fileoperation.FileLearn;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    public static final String REGEX = " \\| ";
    private String fileName = "books.txt";
    private String path = "";

    public boolean isFileExists() {
        Path filePath = Paths.get(this.fileName);
        if (Files.exists(filePath)) {
            return true;
        }
        return false;
    }

    public boolean isFileEmpty() throws IOException {
        Path filePath = Paths.get(this.fileName);
        if (Files.exists(filePath) && Files.size(filePath) == 0) {
            System.out.println("No books found.");
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

    public void save(List<Book> books) {
        StringBuilder builder = new StringBuilder();

        for(Book book : books){
            builder.append(book.fileWrite());
        }
        FileLearn.writeFile(fileName, builder.toString());
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
//        save(books); // Rewrite the file
//        FileLearn.addToSpecificIndex(fileName, book.fileWrite(), index);
    }

    public void clearFile() {
        FileLearn.clearFileContent(fileName);
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
}
