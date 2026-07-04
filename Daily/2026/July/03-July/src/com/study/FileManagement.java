package com.study;

import com.study.fileoperation.FileLearn;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        FileLearn.createFile(fileName);
        FileLearn.appendToFile(fileName, book.fileWrite());
    }

    public List<Book> get() {

        List<Book> books = new ArrayList<>();

        List<String> lines = FileLearn.readLines(fileName);

        for(String line : lines){
            String[] data = line.split(REGEX);
            books.add(new Book(data[0], data[1], data[2]));
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
}
