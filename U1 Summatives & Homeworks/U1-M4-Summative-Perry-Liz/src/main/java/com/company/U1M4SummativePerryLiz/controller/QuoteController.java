package com.company.U1M4SummativePerryLiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {

    private Random randomGenerator = new Random();

    private List<String> quoteList = new ArrayList<String>(10);

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getQuote() {

        quoteList.add("'You know you're in love when you can't fall asleep because reality is finally better than your dreams' - Dr. Suess");
        quoteList.add("'Get busy living or get busy dying' - Stephen King");
        quoteList.add("'20 years from now you will be more disappointed by the things that you didn't do than by the ones you did do.' - Mark Twain");
        quoteList.add("'Great minds discuss ideas; average minds discuss events; small minds discuss people.' - Eleanor Roosevelt");
        quoteList.add("'Those who dare to fail miserably can achieve greatly.' - John F. Kennedy");
        quoteList.add("'A successful man is one who can lay a firm foundation with the bricks others have thrown at him.' - David Brinkley");
        quoteList.add("I'm a success today because I had a friend who believed in me and I didn't have the heart to let him down.' - Abraham Lincoln");
        quoteList.add("'It is hard to fail, but it is worse never to have tried to succeed.' - Theodore Roosevelt");
        quoteList.add("'Let us always meet each other with smile, for the smile is the beginning of love.' - Mother Theresa");
        quoteList.add("'Challenges are what make life interesting and overcoming them is what makes life meaningful.' - Joshua J. Marine");

        String q = quoteList.get(randomGenerator.nextInt(quoteList.size()));

//        return quoteList;

        return q;
    }

}
