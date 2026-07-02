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
}
