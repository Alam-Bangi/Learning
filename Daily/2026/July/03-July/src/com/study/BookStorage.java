package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookStorage {

    List<Book> books = new ArrayList<>();
    private List<Book> searchBook = new ArrayList<>();
    FileManagement fileManagement = new FileManagement();

    public void add(Book book) {
        if(Objects.nonNull(book)) {
            fileManagement.add(book);
            this.books = fileManagement.get();
        }
    }

    public List<Book> search(String searchName) {
        this.books = fileManagement.get();

        for(Book book : books) {
            if(book.getName().equalsIgnoreCase(searchName)) {
                searchBook.add(book);
            }
        }
        return searchBook;
    }

    public void delete(String searchName) {
        this.books = fileManagement.get();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(searchName)) {
                books.remove(i);
                fileManagement.save(books);
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public List<Book> get() {
        this.books = fileManagement.get();
        return books;
    }
}
