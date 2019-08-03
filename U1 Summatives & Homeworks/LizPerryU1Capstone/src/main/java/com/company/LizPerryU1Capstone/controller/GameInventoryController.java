package com.company.LizPerryU1Capstone.controller;

import com.company.LizPerryU1Capstone.exception.NotFoundException;
import com.company.LizPerryU1Capstone.service.InvoiceInventoryService;
import com.company.LizPerryU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game") // game API
public class GameInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel game) {
        return inventoryService.saveGame(game);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") int gameId) {
        GameViewModel game = inventoryService.findGame(gameId);

        if (game == null)
            throw new NotFoundException("Game could not be retrieved for id " + gameId);
        return game;
    }

    @GetMapping
    public List<GameViewModel> getAllGames() {
        return inventoryService.findAllGames();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {

        inventoryService.removeGame(gameId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int gameId, @RequestBody @Valid GameViewModel gameViewModel) {

        if (gameViewModel.getId() == 0)
            gameViewModel.setId(gameId);

        if (gameId != gameViewModel.getId()) {
            throw new IllegalArgumentException("Game ID on path must match the ID in the Game object!");
        }
        inventoryService.updateGame(gameViewModel);
    }

    //IDK IF THIS IS RIGHT BUT FINGERS CROSSED!
    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
        List<GameViewModel> games = inventoryService.findGameByStudio(studio);
        if (games != null && games.size() == 0)
            throw new NotFoundException("Games could not be retrieved by studio " + studio);
        return games;
    }

    @GetMapping("/esrbRating/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByESRBRating(@PathVariable("esrbRating") String esrbRating) {
        List<GameViewModel> games = inventoryService.findGamesByESRBRating(esrbRating);
        if (games != null && games.size() == 0)
            throw new NotFoundException("Games could not be retrieved by esrbRating " + esrbRating);
        return games;
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title) {
        List<GameViewModel> games = inventoryService.findGamesByTitle(title);
        if (games != null && games.size() == 0)
            throw new NotFoundException("Games could not be retrieved by title " + title);
        return games;
    }



















}
