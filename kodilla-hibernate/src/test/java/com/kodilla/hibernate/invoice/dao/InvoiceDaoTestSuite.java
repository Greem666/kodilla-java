package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        // Given
        // ---> PRODUCTS <---
        Product product1 = new Product("Nintendo Switch");
        Product product2 = new Product("Jerry the Plush Wombat");
        Product product3 = new Product("Breville Barista Express Coffee Machine");

        // ---> ITEMS <---
        Item item1 = new Item(product1, new BigDecimal(299), 1);
        Item item2 = new Item(product1, new BigDecimal(249), 1);
        Item item3 = new Item(product2, new BigDecimal("7.99"), 4);
        Item item4 = new Item(product3, new BigDecimal(699), 1);

        // ---> INVOICE <---
        Invoice invoice = new Invoice("0001-Faktura-2020");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        // When
        invoiceDao.save(invoice);

        int product1Id = product1.getId();
        int product2Id = product2.getId();
        int product3Id = product3.getId();

        int item1Id = item1.getId();
        int item2Id = item2.getId();
        int item3Id = item3.getId();
        int item4Id = item4.getId();

        int invoiceId = invoice.getId();
        Optional<Invoice> returnedInvoice = invoiceDao.findById(invoiceId);

        // Then
        Assert.assertNotEquals(0, product1Id);
        Assert.assertNotEquals(0, product2Id);
        Assert.assertNotEquals(0, product3Id);

        Assert.assertNotEquals(0, item1Id);
        Assert.assertNotEquals(0, item2Id);
        Assert.assertNotEquals(0, item3Id);
        Assert.assertNotEquals(0, item4Id);

        Assert.assertNotEquals(0, invoiceId);
        Assert.assertTrue(returnedInvoice.isPresent());

        // Clean-up
        invoiceDao.deleteById(invoiceId);
    }
}