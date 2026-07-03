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
    private String fileName = "record.txt";
    private String filePath = "";

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
            System.out.println("No records found.");
            return true;
        }
        return false;
    }

    public void add(Person person){
        try {
            Files.write(
                    Paths.get(fileName), // Which file to write to
                    person.fileWrite().getBytes(), // What to write
                    StandardOpenOption.CREATE, // Create file if it doesn't exist
                    StandardOpenOption.APPEND // Add to the end instead of replacing
            );
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public boolean validateData(){
        if(this.isFileExists()){
            Path filePath = Paths.get(fileName);
            try{
                List<String> rawData = Files.readAllLines(filePath);
                for(String data :rawData){
                    if (!(data.split(REGEX).length ==4))
                        return false;
                }

            }catch (Exception e) {

            }
            return true;
        }
        return false;
    }
    public List<Person> get(){
        List<Person> persons = new ArrayList<>();
        if(this.validateData()){
            Path filePath = Paths.get(fileName);
            try {
                List<String> rawData = Files.readAllLines(filePath);
                for(String data :rawData){
                    String[] attributes = data.split(REGEX);
                    Person person = new Person(attributes[0],attributes[1],attributes[2],attributes[3]);
                    persons.add(person);
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        return persons;
    }

    public void save(List<Person> persons) {
        try {
            List<String> data = new ArrayList<>();

            for (Person person : persons) {
                data.add(person.fileWrite());
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
