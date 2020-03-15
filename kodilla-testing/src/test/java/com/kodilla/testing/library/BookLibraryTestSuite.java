package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookLibraryTestSuite {
    @Test
    public void testListBooksWithConditionReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> listOfMatchingBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        listOfMatchingBooks.add(book1);
        listOfMatchingBooks.add(book2);
        listOfMatchingBooks.add(book3);
        listOfMatchingBooks.add(book4);

        // When
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(listOfMatchingBooks);

        // Then
        Assert.assertEquals(4, bookLibrary.listBooksWithCondition("Secret").size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> listOfBooks = new ArrayList<>();
        for (int i = 0; i < booksQuantity; i++) {
            listOfBooks.add(new Book("Book " + i, "Author " + i, 1970 + i));
        }
        return listOfBooks;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> listOf0Books = new ArrayList<>();
        List<Book> listOf15Books = generateListOfNBooks(15);
        List<Book> listOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(listOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("zero")).thenReturn(listOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("40")).thenReturn(listOf40Books);

        // When
        List<Book> resultListOf0Books = bookLibrary.listBooksWithCondition("zero");
        List<Book> resultListOf15Books = bookLibrary.listBooksWithCondition("Any string");  // kiedy ta linia miala argument "15", to resultListOf15Books.size() = 0. Czemu?
        List<Book> resultListOf40Books = bookLibrary.listBooksWithCondition("40");

        // Then
        Assert.assertEquals(0, resultListOf0Books.size());
        Assert.assertEquals(15, resultListOf15Books.size());
        Assert.assertEquals(0, resultListOf40Books.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> listOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(listOf10Books);

        // When
        List<Book> resultListOf10Books = bookLibrary.listBooksWithCondition("An");

        // Then
        Assert.assertEquals(0, resultListOf10Books.size());
        verify(libraryDatabaseMock, never()).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfHolderWithNoBooks() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("John", "Doe", "111222333");

        List<Book> listOf0Books = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(listOf0Books);

        // When
        List<Book> resultListOf0Books = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        Assert.assertEquals(0, resultListOf0Books.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(any(LibraryUser.class));
    }

    @Test
    public void testListBooksInHandsOfHolderWithOneBook() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("John", "Doe", "111222333");

        List<Book> listOf1Book = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(listOf1Book);

        // When
        List<Book> resultListOf1Book = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        Assert.assertEquals(1, resultListOf1Book.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(any(LibraryUser.class));
    }

    @Test
    public void testListBooksInHandsOfHolderWithFiveBooks() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("John", "Doe", "111222333");

        List<Book> listOf5Books = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(listOf5Books);

        // When
        List<Book> resultListOf5Books = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        Assert.assertEquals(5, resultListOf5Books.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(any(LibraryUser.class));
    }


}
