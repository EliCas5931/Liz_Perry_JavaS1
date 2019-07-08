package com.company.U1M4SummativePerryLiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {

    private Random randomGenerator = new Random();

    private List<String> wordList = new ArrayList<>(10);

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public String getWord() {

        wordList.add("'Cattywampus - A term that you will find in the Midland and Southern United States. It is referring to something that is in disarray, that is askew, or something that isn't directly across from something.'");
        wordList.add("'Gardyloo - what people would shout out their windows in Edinburgh, Scottland before dumping their slop buckets out of their windows.'");
        wordList.add("'Taradiddle - references someone or something that is filled with pretentious nonsense or something that is a lie.'");
        wordList.add("'Flibbertigibbet - refers to someone who is silly and who talks incessantly.'");
        wordList.add("'Sialoquent - an action word for such an uncomfortable front row sensation.'");
        wordList.add("'Snollygoster - refers to a politician who does or say things for their own personal advancement instead of following their own principles.'");
        wordList.add("'Borborygm - a rumbling sensation you get in your stomach.'");
        wordList.add("'Brouhaha - refers to an uproar or big event.'");
        wordList.add("'Absquatulate - refers to yourself or someone else leaving suddenly. It can also mean that someone has absconded with something, as well.'");
        wordList.add("'Zoanthropy - refers to a person who has delusions that they are a form of animal or that they have changed into an animal.'");

        String w = wordList.get(randomGenerator.nextInt(wordList.size()));

        return w;

    }

}
