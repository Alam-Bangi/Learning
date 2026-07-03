package com.study;

import java.time.LocalDate;

public class Book {

    String name;
    String author;
    String publication;

    public Book() {

    }
    public Book(String name, String author, String publication) {
        this.name = name;
        this.author = author;
        this.publication = publication;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }
    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n")
                .append("Author: ").append(author).append("\n")
                .append("Publication: ").append(publication).append("\n");
        return sb.toString();
    }

    public String fileWrite() {
        StringBuilder fw = new StringBuilder();
        fw.append(name).append(" | ")
                .append(author).append(" | ")
                .append(publication).append("\n");
        return fw.toString();
    }
}
