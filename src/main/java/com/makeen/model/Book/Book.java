package com.makeen.model.Book;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private static AtomicInteger nextId = new AtomicInteger(500);
    private int Book_id;
    private String Book_name;
    private boolean isAvailable;
    //private boolean isDelete;



    public static AtomicInteger getNextId() {
        return nextId;
    }

    public String getUser_name() {
        return Book_name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public int getBook_id() {
        return Book_id;
    }

    public Book(String Book_name) {
        this.Book_id = nextId.getAndIncrement();
        this.Book_name = Book_name;
        this.isAvailable = true;
    }

    public void update_Book(String Book_name) {
        this.Book_name = Book_name;

    }

    @Override
    public String toString() {
        return "Book{" +
                "Book_id=" + Book_id +
                ", Book_name='" + Book_name + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

