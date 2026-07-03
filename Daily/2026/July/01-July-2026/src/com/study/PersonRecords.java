package com.study;

import java.util.*;
import java.util.List;

class PersonRecords {

    private List<Person> personList = new ArrayList<>();
    private List<Person> searchPersonsList = new ArrayList<>();
    private FileManagement fileManagement = new FileManagement();

    public List<Person> searchRecord(String searchName) {

        this.personList= fileManagement.get();
        for (Person person : personList) {
            if (person.fileWrite().toLowerCase().contains(searchName.toLowerCase())) {
                searchPersonsList.add(person);
            }
        }
        return searchPersonsList;
    }

    public void add(Person person) {
        if(Objects.nonNull(person)){
            fileManagement.add(person);
            this.personList = fileManagement.get();
        }
    }

    public List<Person> getData() {
        this.personList = this.fileManagement.get();
        return personList;
    }

    public void delete(String searchName) {
        this.personList = fileManagement.get();

        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().equalsIgnoreCase(searchName)) {
                personList.remove(i);
                fileManagement.save(personList);
                System.out.println("Record deleted successfully.");
                return;
            }
        }
        System.out.println("Record not found.");
    }
}
