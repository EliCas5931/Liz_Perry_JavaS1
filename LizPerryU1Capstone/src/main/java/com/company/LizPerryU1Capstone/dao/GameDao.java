package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int id);

    //other methods
    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByESRB(String esrbRating);

    List<Game> getGamesByTitle(String title);

}
