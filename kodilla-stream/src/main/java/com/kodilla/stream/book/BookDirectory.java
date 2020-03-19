package com.kodilla.stream.book;

import java.util.ArrayList;
import java.util.List;

public final class BookDirectory {
    private final List<Book> theBookList = new ArrayList<>();

    public BookDirectory() {
        theBookList.add(new Book("Major Marquis Warren", "Wild West", 1850, "0001"));
        theBookList.add(new Book("John Ruth", "To hang or not?", 1845, "0002"));
        theBookList.add(new Book("Daisy Domergue", "Sharing economy of the Wild West", 1849, "0003"));
        theBookList.add(new Book("Chris Mannix", "From renegate to sheriff in just 3 steps", 1850, "0004"));
        theBookList.add(new Book("Marco the Mexican", "Mexican cuisine in stews", 1852, "0005"));
        theBookList.add(new Book("English Pete Hicox", "English accent for dummies", 1839, "0006"));
        theBookList.add(new Book("Grouch Douglass", "How not to get disarmed by accident", 1852, "0007"));
        theBookList.add(new Book("General Sanford Smithers", "In search of family", 1850, "0008"));
        theBookList.add(new Book("O.B.", "Carriages - what drives them?", 1833, "0009"));
        theBookList.add(new Book("Jody Domergue", "2 days in the basement - ideas for spare time", 1850, "0010"));
    }

    public List<Book> getList() {
        return new ArrayList<>(theBookList);
    }
}
