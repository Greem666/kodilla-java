package com.kodilla.kodillapatterns2.adapter.bookclassifier;

import com.kodilla.kodillapatterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> bookSetOddItemsCount = IntStream.rangeClosed(0, 10)
                .mapToObj(n -> new Book("Author" + n, "Title " + n, 2010 + n, "Signature " + n))
                .collect(Collectors.toSet());

        Set<Book> bookSetEvenItemsCount = IntStream.range(0, 10)
                .mapToObj(n -> new Book("Author" + n, "Title " + n, 2020 + n, "Signature " + n))
                .collect(Collectors.toSet());

        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int oddMedianResult = medianAdapter.publicationYearMedian(bookSetOddItemsCount);
        int evenMedianResult = medianAdapter.publicationYearMedian(bookSetEvenItemsCount);

        // Then
        assertEquals(2015, oddMedianResult);
        assertEquals(2025, evenMedianResult);
    }
}
