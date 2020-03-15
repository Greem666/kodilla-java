package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> booksList = new ArrayList<>();

        if (titleFragment.length() < 3) {
            return booksList;
        }

        List<Book> queryResult = libraryDatabase.listBooksWithCondition(titleFragment);
        if (queryResult.size() > 20) {
            return booksList;
        }

        booksList = queryResult;
        return booksList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> booksList = new ArrayList<>();
        Book placeholderBook = new Book("Placeholder title", "Placeholder author", 2000);
        booksList.add(placeholderBook);
        return booksList;
    }
}
