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
public class GameDaoJdbcTemplateImplTest {

    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TShirtDao tShirtDao;

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
    public void addGetDeleteGame() {

        Game game = new Game();
        game.setTitle("Overwatch");
        game.setEsrbRating("T");
        game.setDescription("Team-based shooter game of powerful heroes in 6v6 combat.");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Blizzard");
        game.setQuantity(20);

        game = gameDao.addGame(game);

        Game game2 = gameDao.getGame(game.getId());

        assertEquals(game2, game);

        gameDao.deleteGame(game.getId());

        game2 = gameDao.getGame(game.getId());

        assertNull(game2);
    }

    @Test
    public void updateGame() {

        Game game = new Game();
        game.setTitle("Overwatch");
        game.setEsrbRating("T");
        game.setDescription("Team-based shooter game of powerful heroes in 6v6 combat.");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Blizzard");
        game.setQuantity(20);

        game = gameDao.addGame(game);

        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Single player style game following Kratos and his son Atreus.");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(14);
        gameDao.updateGame(game);

        Game game2 = gameDao.getGame(game.getId());
        assertEquals(game2, game);
    }

    @Test
    public void getAllGames() {

        Game game = new Game();
        game.setTitle("Overwatch");
        game.setEsrbRating("T");
        game.setDescription("Team-based shooter game of powerful heroes in 6v6 combat.");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Blizzard");
        game.setQuantity(20);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Single player style game following Kratos and his son Atreus.");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(14);
        gameDao.addGame(game);

        List<Game> gList = gameDao.getAllGames();
        assertEquals(2, gList.size());
    }

    @Test
    public void getAllGamesByStudio() {

        Game game = new Game();
        game.setTitle("Overwatch");
        game.setEsrbRating("T");
        game.setDescription("Team-based shooter game of powerful heroes in 6v6 combat.");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Blizzard");
        game.setQuantity(20);

        game = gameDao.addGame(game);

        Game game2 = new Game();
        game2.setTitle("World of Warcraft");
        game2.setEsrbRating("M");
        game2.setDescription("Mass multiplayer online role playing game.");
        game2.setPrice(new BigDecimal("9.99"));
        game2.setStudio("Blizzard");
        game2.setQuantity(34);
        gameDao.addGame(game2);

        List<Game> gList = gameDao.getGamesByStudio("Blizzard");
        assertEquals(2, gList.size());
    }

    @Test
    public void getAllGamesByESRBRating() {

        Game game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Single player style game following Kratos and his son Atreus.");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(14);

        game = gameDao.addGame(game);

        Game game2 = new Game();
        game2.setTitle("World of Warcraft");
        game2.setEsrbRating("T");
        game2.setDescription("Mass multiplayer online role playing game.");
        game2.setPrice(new BigDecimal("9.99"));
        game2.setStudio("Blizzard");
        game2.setQuantity(34);
        gameDao.addGame(game2);

        Game game3 = new Game();
        game3.setTitle("Diablo 3");
        game3.setEsrbRating("M");
        game3.setDescription("dungeon crawler hack-and-slash action role-playing game.");
        game3.setPrice(new BigDecimal("29.99"));
        game3.setStudio("Blizzard");
        game3.setQuantity(11);
        gameDao.addGame(game3);

        List<Game> gList = gameDao.getGamesByESRB("M");
        assertEquals(2, gList.size());
    }

    @Test
    public void getAllGamesByTitle() {

        Game game = new Game();
        game.setTitle("Overwatch");
        game.setEsrbRating("T");
        game.setDescription("Team-based shooter game of powerful heroes in 6v6 combat.");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Blizzard");
        game.setQuantity(20);

        Game game2 = new Game();
        game2.setTitle("World of Warcraft");
        game2.setEsrbRating("T");
        game2.setDescription("Mass multiplayer online role playing game.");
        game2.setPrice(new BigDecimal("9.99"));
        game2.setStudio("Blizzard");
        game2.setQuantity(34);
        gameDao.addGame(game2);

        Game game3 = new Game();
        game3.setTitle("Diablo 3");
        game3.setEsrbRating("M");
        game3.setDescription("Dungeon crawler hack-and-slash action role-playing game.");
        game3.setPrice(new BigDecimal("29.99"));
        game3.setStudio("Blizzard");
        game3.setQuantity(11);
        gameDao.addGame(game3);

        List<Game> gList = gameDao.getGamesByTitle("Diablo 3");
        assertEquals(1, gList.size());
    }

}
