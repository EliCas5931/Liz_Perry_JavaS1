package com.company.LizPerryU1Capstone.dao;


import com.company.LizPerryU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int id);

    // other methods
    // Check to see if you need to pass anything
    // into the method since it's from the same
    // class (console)
    List<Console> getConsoleByManufacturer(String manufacturer);
}
