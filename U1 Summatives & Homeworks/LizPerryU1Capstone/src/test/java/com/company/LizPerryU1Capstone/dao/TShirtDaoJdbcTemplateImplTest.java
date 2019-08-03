package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.Console;
import com.company.LizPerryU1Capstone.model.Game;
import com.company.LizPerryU1Capstone.model.TShirt;
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
public class TShirtDaoJdbcTemplateImplTest {

    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {

        //clean out DB
        List<Console> console = consoleDao.getAllConsoles();
        for (Console c : console) {
            consoleDao.deleteConsole(c.getId());
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
    public void addGetDeleteTShirt() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Black");
        tShirt.setDescription("Overwatch Characters");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(20);

        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt2 = tShirtDao.getTShirt(tShirt.getId());

        assertEquals(tShirt2, tShirt);

        tShirtDao.deleteTShirt(tShirt.getId());

        tShirt2 = tShirtDao.getTShirt(tShirt.getId());

        assertNull(tShirt2);
    }

    @Test
    public void updateTShirt() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Black");
        tShirt.setDescription("Overwatch Characters");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(20);

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt.setSize("Large");
        tShirt.setColor("Grey");
        tShirt.setDescription("Diablo Characters");
        tShirt.setPrice(new BigDecimal("9.99"));
        tShirt.setQuantity(10);
        tShirtDao.updateTShirt(tShirt);

        TShirt tShirt2 = tShirtDao.getTShirt(tShirt.getId());
        assertEquals(tShirt2, tShirt);
    }

    @Test
    public void getAllTShirts() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Black");
        tShirt.setDescription("Overwatch Characters");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(20);

        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Small");
        tShirt2.setColor("White");
        tShirt2.setDescription("God of War Characters");
        tShirt2.setPrice(new BigDecimal("18.99"));
        tShirt2.setQuantity(15);
        tShirtDao.addTShirt(tShirt2);

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("Large");
        tShirt3.setColor("Grey");
        tShirt3.setDescription("Diablo Characters");
        tShirt3.setPrice(new BigDecimal("9.99"));
        tShirt3.setQuantity(10);
        tShirtDao.addTShirt(tShirt3);

        List<TShirt> tList = tShirtDao.getAllTShirts();
        assertEquals(3, tList.size());
    }

    @Test
    public void getTShirtsByColor() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Black");
        tShirt.setDescription("Overwatch Characters");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(20);

        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Small");
        tShirt2.setColor("White");
        tShirt2.setDescription("God of War Characters");
        tShirt2.setPrice(new BigDecimal("18.99"));
        tShirt2.setQuantity(15);
        tShirtDao.addTShirt(tShirt2);

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("Large");
        tShirt3.setColor("Black");
        tShirt3.setDescription("Diablo Characters");
        tShirt3.setPrice(new BigDecimal("9.99"));
        tShirt3.setQuantity(10);
        tShirtDao.addTShirt(tShirt3);

        TShirt tShirt4 = new TShirt();
        tShirt4.setSize("XLarge");
        tShirt4.setColor("Black");
        tShirt4.setDescription("Mario Bros");
        tShirt4.setPrice(new BigDecimal("8.99"));
        tShirt4.setQuantity(24);
        tShirtDao.addTShirt(tShirt4);

        List<TShirt> tList = tShirtDao.getTShirtsByColor("Black");
        assertEquals(3, tList.size());
    }

    @Test
    public void getTShirtsBySize() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("Small");
        tShirt.setColor("Black");
        tShirt.setDescription("Overwatch Characters");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(20);

        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Small");
        tShirt2.setColor("White");
        tShirt2.setDescription("God of War Characters");
        tShirt2.setPrice(new BigDecimal("18.99"));
        tShirt2.setQuantity(15);
        tShirtDao.addTShirt(tShirt2);

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("Large");
        tShirt3.setColor("Black");
        tShirt3.setDescription("Diablo Characters");
        tShirt3.setPrice(new BigDecimal("9.99"));
        tShirt3.setQuantity(10);
        tShirtDao.addTShirt(tShirt3);

        TShirt tShirt4 = new TShirt();
        tShirt4.setSize("XLarge");
        tShirt4.setColor("Black");
        tShirt4.setDescription("Mario Bros");
        tShirt4.setPrice(new BigDecimal("8.99"));
        tShirt4.setQuantity(24);
        tShirtDao.addTShirt(tShirt4);

        List<TShirt> tList = tShirtDao.getTShirtsBySize("Small");
        assertEquals(2, tList.size());
    }
























}
