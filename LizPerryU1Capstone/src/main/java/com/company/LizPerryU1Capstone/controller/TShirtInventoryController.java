package com.company.LizPerryU1Capstone.controller;

import com.company.LizPerryU1Capstone.exception.NotFoundException;
import com.company.LizPerryU1Capstone.service.InvoiceInventoryService;
import com.company.LizPerryU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/t_shirt") // tshirt API
public class TShirtInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody @Valid TShirtViewModel tShirt) {
        return inventoryService.saveTShirt(tShirt);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") int tShirtId) {
        TShirtViewModel tShirt = inventoryService.findTShirt(tShirtId);

        if (tShirt == null)
            throw new NotFoundException("TShirt could not be retrieved with id " + tShirtId);
        return tShirt;
    }

    @GetMapping
    public List<TShirtViewModel> getAllTShirts() {
        return inventoryService.findAllTShirts();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int tShirtId) {
        inventoryService.removeTShirt(tShirtId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("id") int tShirtId, @RequestBody @Valid TShirtViewModel tShirtViewModel) {

        if (tShirtViewModel.getId() == 0)
            tShirtViewModel.setId(tShirtId);

        if (tShirtId != tShirtViewModel.getId()) {
            throw new IllegalArgumentException("TShirt ID on path must match the ID in the TShirt object.");
        }
        inventoryService.updateTShirt(tShirtViewModel);
    }

    // Extra methods, unsure how correct they are
    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtByColor(@PathVariable("color") String color) {
        List<TShirtViewModel> tshirts = inventoryService.findTShirtByColor(color);
        if (tshirts != null && tshirts.size() == 0)
            throw new NotFoundException("TShirts could not be retrieved by color " + color);
        return tshirts;
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtBySize(@PathVariable("size") String size) {
        List<TShirtViewModel> tshirts = inventoryService.findTShirtBySize(size);
        if (tshirts != null && tshirts.size() == 0)
            throw new NotFoundException("TShirts could not be retrieved by size " + size);
        return tshirts;
    }




}
