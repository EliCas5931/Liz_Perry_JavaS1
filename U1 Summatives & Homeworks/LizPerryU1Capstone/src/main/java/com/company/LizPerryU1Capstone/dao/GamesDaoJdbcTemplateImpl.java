package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.Game;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GamesDaoJdbcTemplateImpl implements GameDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_GAME_SQL =
            "insert into game (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAME_SQL =
            "select * from game";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

    private static final String DELETE_GAME_SQL =
            "delete from game where game_id = ?";

    //extra methods
    private static final String SELECT_GAME_BY_STUDIO_SQL =
            "select * from game where studio = ?";

    private static final String SELECT_GAME_BY_ESRB_RATING_SQL =
            "select * from game where esrb_rating = ?";

    private static final String SELECT_GAME_BY_TITLE_SQL =
            "select * from game where title = ?";

    public GamesDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(
           INSERT_GAME_SQL,
           game.getTitle(),
           game.getEsrbRating(),
           game.getDescription(),
           game.getPrice(),
           game.getStudio(),
           game.getQuantity()
        );

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        game.setId(id);

        return game;
    }

    @Override
    public Game getGame(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToAlbum, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this game id, return null
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {

        return jdbcTemplate.query(SELECT_ALL_GAME_SQL, this::mapRowToAlbum);

    }

    @Override
    public void updateGame(Game game) {

        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getId()
        );

    }

    @Override
    public void deleteGame(int id) {

        jdbcTemplate.update(DELETE_GAME_SQL, id);

    }

    @Override
    public List<Game> getGamesByStudio(String studio) {

        return jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::mapRowToAlbum, studio);

    }

    @Override
    public List<Game> getGamesByESRB(String esrbRating) {

        return jdbcTemplate.query(SELECT_GAME_BY_ESRB_RATING_SQL, this::mapRowToAlbum, esrbRating);

    }

    @Override
    public List<Game> getGamesByTitle(String title) {

        return jdbcTemplate.query(SELECT_GAME_BY_TITLE_SQL, this::mapRowToAlbum, title);

    }

    private Game mapRowToAlbum(ResultSet rs, int rowNum) throws SQLException {

        Game game = new Game();

        game.setId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
