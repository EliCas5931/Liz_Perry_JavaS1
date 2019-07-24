package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.Console;
import com.company.LizPerryU1Capstone.model.Game;
import com.company.LizPerryU1Capstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {

    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TShirtDao tShirtDao;
    //Should I include the other DAOs?
//    @Autowired
//    ProcessingFeeDao processingFeeDao;
//    @Autowired
//    SalesTaxRateDao salesTaxRateDao;
//    @Autowired
//    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {

        // clean out DB
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
    }

    @Test
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setModel("PlayStation Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(5);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getId());

        console1 = consoleDao.getConsole(console.getId());

        assertNull(console1);
    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("PlayStation Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(5);

        consoleDao.addConsole(console);

        List<Console> cList = consoleDao.getAllConsoles();
        assertEquals(1, cList.size());

        console = new Console();
        console.setModel("Xbox One X");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar");
        console.setPrice(new BigDecimal("399.99"));
        console.setQuantity(10);

        consoleDao.addConsole(console);

        cList = consoleDao.getAllConsoles();
        assertEquals(2, cList.size());
    }

    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("PlayStation Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(5);

        console = consoleDao.addConsole(console);

        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32 GB");
        console.setProcessor("Cortex-A57 ");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(12);

        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);
    }

    @Test
    public void getConsoleByManufacturer() {
        // this could be extremely wrong but we shall see
        Console console = new Console();

        console.setModel("PlayStation Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(5);

        console = consoleDao.addConsole(console);

        Console console2 = new Console();
        console2.setModel("PlayStation 4");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("500 GB");
        console2.setProcessor("AMD Falcon");
        console2.setPrice(new BigDecimal("249.99"));
        console2.setQuantity(6);
        consoleDao.addConsole(console2);

        Console console3 = new Console();
        console3.setModel("Xbox One");
        console3.setManufacturer("Microsoft");
        console3.setMemoryAmount("500 GB");
        console3.setProcessor("AMD Jaguar");
        console3.setPrice(new BigDecimal("449.99"));
        console3.setQuantity(6);
        consoleDao.addConsole(console3);

        // I want to pass manufacturer "Sony" in this but not sure how to do so
        List<Console> cList = consoleDao.getConsoleByManufacturer("Sony");
        assertEquals(2, cList.size());

        List<Console> xList = consoleDao.getConsoleByManufacturer("Microsoft");
        assertEquals(1, xList.size());
    }

























}
