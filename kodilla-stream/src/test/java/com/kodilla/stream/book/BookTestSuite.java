package com.kodilla.stream.book;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {
    @Test
    public void testGetListUsingFor() {
        // Given
        BookDirectory bookDirectory = new BookDirectory();

        // When
        List<Book> books = bookDirectory.getList();

        // Then
        int numberOfBooksPublishedAfter1845 = 0;
        for (Book book: books) {
            if (book.getYearOfPublication() > 1845) {
                numberOfBooksPublishedAfter1845++;
            }
        }
        Assert.assertEquals(7, numberOfBooksPublishedAfter1845);
    }
    @Test
    public void testGetListUsingForUsingIntStream() {
        // Given
        BookDirectory bookDirectory = new BookDirectory();

        // When
        List<Book> books = bookDirectory.getList();

        // Then
        long numberOfBooksPublishedAfter1845 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 1845)
                .count();
        Assert.assertEquals(7, numberOfBooksPublishedAfter1845);
    }
}
