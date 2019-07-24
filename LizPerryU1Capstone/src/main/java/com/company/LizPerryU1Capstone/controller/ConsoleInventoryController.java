package com.company.LizPerryU1Capstone.controller;

import com.company.LizPerryU1Capstone.exception.NotFoundException;
import com.company.LizPerryU1Capstone.service.InvoiceInventoryService;
import com.company.LizPerryU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/console") // console API
public class ConsoleInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping //solutions way of Rest API post mapping, & shorter!
    @ResponseStatus(HttpStatus.CREATED)
    //create and save a new console
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel console) {

        return inventoryService.saveConsole(console);
    }

    @GetMapping
    public List<ConsoleViewModel> getAllConsoles() {
        return inventoryService.findAllConsoles();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int consoleId) {
        ConsoleViewModel console = inventoryService.findConsole(consoleId);

        if (console == null)
            throw new NotFoundException("Console could not be retrieved for id " + consoleId);
         return console;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId) {

        inventoryService.removeConsole(consoleId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody @Valid ConsoleViewModel consoleViewModel) {

        if (consoleViewModel.getId() == 0)
            consoleViewModel.setId(consoleId);

        if (consoleId != consoleViewModel.getId()) {
            throw new IllegalArgumentException("Console ID on path must match the ID in the Console object!");
        }
        inventoryService.updateConsole(consoleViewModel);
    }

    // UM IS THIS RIGHT!?
    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> consoles = inventoryService.findConsoleByManufacturer(manufacturer);
        if (consoles != null && consoles.size() == 0)
            throw new NotFoundException("Console could not be retrieved by manufacturer " + manufacturer);
        return consoles;
    }

}
