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

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        // Given

        // ---> ITEMS <---

        Item nintendoSwitchEOFYSpecial = new Item(new BigDecimal(299), 1);
        itemDao.save(nintendoSwitchEOFYSpecial);
        int nintendoSwitchEOFYSpecialId = nintendoSwitchEOFYSpecial.getId();

        Item nintendoSwitchChristmasSpecial = new Item(new BigDecimal(249), 1);
        itemDao.save(nintendoSwitchChristmasSpecial);
        int nintendoSwitchChristmasSpecialId = nintendoSwitchChristmasSpecial.getId();

        Item plushWombatSouvenir = new Item(new BigDecimal("9.99"), 1);
        itemDao.save(plushWombatSouvenir);
        int plushWombatSouvenirId = plushWombatSouvenir.getId();

        Item plushWombatGiftPack = new Item(new BigDecimal("7.99"), 4);
        itemDao.save(plushWombatGiftPack);
        int plushWombatGiftPackId = plushWombatGiftPack.getId();

        Item brevilleBaristaExpressEOFYSpecial = new Item(new BigDecimal(699), 1);
        itemDao.save(brevilleBaristaExpressEOFYSpecial);
        int brevilleBaristaExpressEOFYSpecialId = brevilleBaristaExpressEOFYSpecial.getId();

        Item brevilleBaristaExpressRegular = new Item(new BigDecimal(899), 1);
        itemDao.save(brevilleBaristaExpressRegular);
        int brevilleBaristaExpressRegularId = brevilleBaristaExpressRegular.getId();


        // ---> PRODUCTS <---

        Product nintendoSwitchProduct = new Product("Nintendo Switch");
        nintendoSwitchProduct.getItems().add(nintendoSwitchEOFYSpecial);
        nintendoSwitchProduct.getItems().add(nintendoSwitchChristmasSpecial);
        productDao.save(nintendoSwitchProduct);
        int nintendoSwitchProductId = nintendoSwitchProduct.getId();

        Product plushWombat = new Product("Jerry the Plush Wombat");
        plushWombat.getItems().add(plushWombatSouvenir);
        plushWombat.getItems().add(plushWombatGiftPack);
        productDao.save(plushWombat);
        int plushWombatId = plushWombat.getId();

        Product brevilleBaristaExpress = new Product("Breville Barista Express Coffee Machine");
        brevilleBaristaExpress.getItems().add(brevilleBaristaExpressEOFYSpecial);
        brevilleBaristaExpress.getItems().add(brevilleBaristaExpressRegular);
        productDao.save(brevilleBaristaExpress);
        int brevilleBaristaExpressId = brevilleBaristaExpress.getId();


        // ---> INVOICED <---

        Invoice consoleAndCoffeeEOFYInvoice = new Invoice("0001-EOFY-2020");
        consoleAndCoffeeEOFYInvoice.getItems().add(nintendoSwitchEOFYSpecial);
        consoleAndCoffeeEOFYInvoice.getItems().add(brevilleBaristaExpressEOFYSpecial);
        invoiceDao.save(consoleAndCoffeeEOFYInvoice);
        int consoleAndCoffeeEOFYInvoiceId = consoleAndCoffeeEOFYInvoice.getId();

        Invoice consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoice = new Invoice("0002-XMas-2020");
        consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoice.getItems().add(nintendoSwitchChristmasSpecial);
        consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoice.getItems().add(plushWombatGiftPack);
        consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoice.getItems().add(brevilleBaristaExpressRegular);
        invoiceDao.save(consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoice);
        int consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoiceId = consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoice.getId();

        Invoice coffeeMachinesAndPlushToysInvoice = new Invoice("0003-REG-2020");
        coffeeMachinesAndPlushToysInvoice.getItems().add(brevilleBaristaExpressEOFYSpecial);
        coffeeMachinesAndPlushToysInvoice.getItems().add(brevilleBaristaExpressEOFYSpecial);
        coffeeMachinesAndPlushToysInvoice.getItems().add(plushWombatSouvenir);
        invoiceDao.save(coffeeMachinesAndPlushToysInvoice);
        int coffeeMachinesAndPlushToysInvoiceId = coffeeMachinesAndPlushToysInvoice.getId();

        // When
        Optional<Product> nintendoSwitchProductSearchResult = productDao.findById(nintendoSwitchProductId);
        Optional<Product> plushWombatProductSearchResult = productDao.findById(plushWombatId);
        Optional<Product> brevilleBaristaExpressProductSearchResult = productDao.findById(brevilleBaristaExpressId);

        Optional<Item> nintendoSwitchEOFYSpecialItemSearchResult = itemDao.findById(nintendoSwitchEOFYSpecialId);
        Optional<Item> nintendoSwitchChristmasSpecialItemSearchResult = itemDao.findById(nintendoSwitchChristmasSpecialId);
        Optional<Item> plushWombatSouvenirItemSearchResult = itemDao.findById(plushWombatSouvenirId);
        Optional<Item> plushWombatGiftPackItemSearchResult = itemDao.findById(plushWombatGiftPackId);
        Optional<Item> brevilleBaristaExpressEOFYSpecialItemSearchResult = itemDao.findById(brevilleBaristaExpressEOFYSpecialId);
        Optional<Item> brevilleBaristaExpressRegularItemSearchResult = itemDao.findById(brevilleBaristaExpressRegularId);

        Optional<Invoice> consoleAndCoffeeEOFYInvoiceSearchResult = invoiceDao.findById(consoleAndCoffeeEOFYInvoiceId);
        Optional<Invoice> consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoiceSearchResult = invoiceDao.findById(consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoiceId);
        Optional<Invoice> coffeeMachinesAndPlushToysInvoiceSearchResult = invoiceDao.findById(coffeeMachinesAndPlushToysInvoiceId);

        // Then
        Assert.assertTrue(nintendoSwitchProductSearchResult.isPresent());
        Assert.assertEquals(2, productDao.findById(nintendoSwitchProductId).get().getItems().size());

        Assert.assertTrue(plushWombatProductSearchResult.isPresent());
        Assert.assertEquals(2, productDao.findById(plushWombatId).get().getItems().size());

        Assert.assertTrue(brevilleBaristaExpressProductSearchResult.isPresent());
        Assert.assertEquals(2, productDao.findById(brevilleBaristaExpressId).get().getItems().size());

        Assert.assertTrue(nintendoSwitchEOFYSpecialItemSearchResult.isPresent());
        Assert.assertTrue(nintendoSwitchChristmasSpecialItemSearchResult.isPresent());
        Assert.assertTrue(plushWombatSouvenirItemSearchResult.isPresent());
        Assert.assertTrue(plushWombatGiftPackItemSearchResult.isPresent());
        Assert.assertTrue(brevilleBaristaExpressEOFYSpecialItemSearchResult.isPresent());
        Assert.assertTrue(brevilleBaristaExpressRegularItemSearchResult.isPresent());

        Assert.assertTrue(consoleAndCoffeeEOFYInvoiceSearchResult.isPresent());
        Assert.assertEquals(2, invoiceDao.findById(consoleAndCoffeeEOFYInvoiceId).get().getItems().size());

        Assert.assertTrue(consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoiceSearchResult.isPresent());
        Assert.assertEquals(3, invoiceDao.findById(consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoiceId).get().getItems().size());

        Assert.assertTrue(coffeeMachinesAndPlushToysInvoiceSearchResult.isPresent());
        Assert.assertEquals(3, invoiceDao.findById(coffeeMachinesAndPlushToysInvoiceId).get().getItems().size());

        // Clean-up
//        try {
//            productDao.deleteById(nintendoSwitchProductId);
//            productDao.deleteById(plushWombatId);
//            productDao.deleteById(brevilleBaristaExpressId);
//
//            itemDao.deleteById(nintendoSwitchEOFYSpecialId);
//            itemDao.deleteById(nintendoSwitchChristmasSpecialId);
//            itemDao.deleteById(plushWombatSouvenirId);
//            itemDao.deleteById(plushWombatGiftPackId);
//            itemDao.deleteById(brevilleBaristaExpressEOFYSpecialId);
//            itemDao.deleteById(brevilleBaristaExpressRegularId);
//
//            invoiceDao.deleteById(consoleAndCoffeeEOFYInvoiceId);
//            invoiceDao.deleteById(consoleChristmasAndPlushToyGiftPackAndCoffeeRegularInvoiceId);
//            invoiceDao.deleteById(coffeeMachinesAndPlushToysInvoiceId);
//
//        } catch (Exception e) {
//            // Do nothing
//        }

    }
}