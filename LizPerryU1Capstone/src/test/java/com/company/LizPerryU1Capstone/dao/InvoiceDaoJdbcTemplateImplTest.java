package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {
    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TShirtDao tShirtDao;
    @Autowired
    InvoiceDao invoiceDao;
    //Do I need these?

//    @Autowired
//    ProcessingFeeDao processingFeeDao;
//    @Autowired
//    SalesTaxRate salesTaxRate;

    @Before
    public void setUp() throws Exception {

        //Clean out db
        List<Console> console = consoleDao.getAllConsoles();
        for (Console con : console) {
            consoleDao.deleteConsole(con.getId());
        }

        List<Game> game = gameDao.getAllGames();
        for (Game g : game) {
            gameDao.deleteGame(g.getId());
        }

        List<TShirt> tShirt = tShirtDao.getAllTShirts();
        for (TShirt ts : tShirt) {
            tShirtDao.deleteTShirt(ts.getId());
        }

        List<Invoice> invoice = invoiceDao.getAllInvoices();
        for (Invoice i : invoice) {
            invoiceDao.deleteInvoice(i.getId());
        }

//        List<ProcessingFee> processingFee = processingFeeDao.get
    }

    @Test
    public void addGetDeleteInvoice() {

        Invoice invoice = new Invoice();
        invoice.setName("Ana McCree");
        invoice.setStreet("200 Main Street");
        invoice.setCity("Charlotte");
        invoice.setState("North Carolina");
        invoice.setZipCode("28056");
        invoice.setItemType("Consoles");
        invoice.setItemId(10);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("599.98"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("644.97"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice2 = invoiceDao.getInvoice(invoice.getId());

        assertEquals(invoice2, invoice);

        invoiceDao.deleteInvoice(invoice.getId());

        invoice2 = invoiceDao.getInvoice(invoice.getId());

        assertNull(invoice2);
    }

    @Test
    public void getAllInvoices() {

        Invoice invoice = new Invoice();
        invoice.setName("Ana McCree");
        invoice.setStreet("200 Main Street");
        invoice.setCity("Charlotte");
        invoice.setState("North Carolina");
        invoice.setZipCode("28056");
        invoice.setItemType("Consoles");
        invoice.setItemId(10);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("599.98"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("644.97"));

        invoiceDao.addInvoice(invoice);

        List<Invoice> iList = invoiceDao.getAllInvoices();
        assertEquals(1, iList.size());

        invoice = new Invoice();
        invoice.setName("Ashe McCree");
        invoice.setStreet("150 Main Street");
        invoice.setCity("Hickory");
        invoice.setState("North Carolina");
        invoice.setZipCode("28050");
        invoice.setItemType("Consoles");
        invoice.setItemId(10);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("599.98"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("644.97"));

        invoiceDao.addInvoice(invoice);

        iList = invoiceDao.getAllInvoices();
        assertEquals(2, iList.size());
    }

    @Test
    public void getInvoice() {

        Invoice invoice = new Invoice();
        invoice.setName("Ana McCree");
        invoice.setStreet("200 Main Street");
        invoice.setCity("Charlotte");
        invoice.setState("North Carolina");
        invoice.setZipCode("28056");
        invoice.setItemType("Consoles");
        invoice.setItemId(10);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("599.98"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("644.97"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice2 = new Invoice();
        invoice2.setName("Ana McCree");
        invoice2.setStreet("200 Main Street");
        invoice2.setCity("Charlotte");
        invoice2.setState("North Carolina");
        invoice2.setZipCode("28056");
        invoice2.setItemType("Consoles");
        invoice2.setItemId(10);
        invoice2.setUnitPrice(new BigDecimal("299.99"));
        invoice2.setQuantity(2);
        invoice2.setSubTotal(new BigDecimal("599.98"));
        invoice2.setTax(new BigDecimal(".05"));
        invoice2.setProcessingFee(new BigDecimal("14.99"));
        invoice2.setTotal(new BigDecimal("644.97"));

        invoiceDao.addInvoice(invoice2);

        List<Invoice> iList = invoiceDao.getAllInvoices();
        assertEquals(2, iList.size());
    }



}
