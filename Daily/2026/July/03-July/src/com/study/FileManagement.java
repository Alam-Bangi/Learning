package com.study;

import java.io.IOException;
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
        try{
            Files.write(Paths.get(fileName),
                    book.fileWrite().getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Error writing in file");
        }
    }

    public List<Book> get() {
        List<Book> books = new ArrayList<>();
        if(this.validateData()) {
            Path filePath = Paths.get(fileName);
            try {
                List<String> rawData = Files.readAllLines(filePath);
                for(String data :rawData){
                    String[] attributes = data.split(REGEX);
                    Book book = new Book(attributes[0],attributes[1],attributes[2]);
                    books.add(book);
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        return books;
    }

    public void save(List<Book> books) {
        try {
            List<String> data = new ArrayList<>();

            for (Book book : books) {
                data.add(book.fileWrite());
            }

            Files.write(
                    Paths.get(fileName),
                    data,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}
