package com.company.LizPerryU1Capstone.dao;

import com.company.LizPerryU1Capstone.model.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tShirt);

    void deleteTShirt(int id);

    //other methods
    List<TShirt> getTShirtsByColor(String color);

    List<TShirt> getTShirtsBySize(String size);
}
