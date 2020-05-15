package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        // Given
        Book book1 = new Book("Does God Ever Speak through Cats?", "David Evans", LocalDate.of(2006, 7, 15));
        Book book2 = new Book("Toilet paper origami", "Linda Wright", LocalDate.of(2008, 9, 9));
        Book book3 = new Book("Outwitting Squirrels: 101 Cunning Stratagems to Reduce Dramatically the Egregious Misappropriation of Seed from Your Birdfeeder by Squirrels", "Bill Adler", LocalDate.of(1996, 10, 1));
        Book book4 = new Book("Eating People is Wrong", "Malcolm Bradbury.", LocalDate.of(2012, 9, 13));
        Book book5 = new Book("Everything I Know about Women I Learned from My Tractor", "Roger Welsch", LocalDate.of(2002, 9, 29));
        Book book6 = new Book("A Passion for Donkeys", "Elisabeth D. Svendsen", LocalDate.of(1992, 10, 15));

        Library library = new Library("Hilarious-ary");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);
        library.getBooks().add(book6);

        // When
        Library shallowCopyLibrary = null;
        try {
            shallowCopyLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepCopyLibrary = null;
        try {
            deepCopyLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(book4);

        // Then
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, shallowCopyLibrary.getBooks().size());
        Assert.assertEquals(6, deepCopyLibrary.getBooks().size());

        Assert.assertEquals(library.getBooks(), shallowCopyLibrary.getBooks());
        Assert.assertNotEquals(library.getBooks(), deepCopyLibrary.getBooks());
    }
}
