package com.company.U1M4SummativePerryLiz.controller;

import com.company.U1M4SummativePerryLiz.model.EightBall;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class EightBallController {

    private Random randomGenerator = new Random();

    private List<String> ballResponse = new ArrayList<>(6);

//    private List<@Valid EightBall> userQuestion = new ArrayList<@Valid EightBall>();

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String getResponse(@RequestBody EightBall eightBall) {

        ballResponse.add("Yes - definitely.");
        ballResponse.add("As I see it, yes.");
        ballResponse.add("Cannot predict now.");
        ballResponse.add("Ask again later.");
        ballResponse.add("My reply is no.");
        ballResponse.add("Very doubtful.");

        String r = ballResponse.get(randomGenerator.nextInt(ballResponse.size()));

//        userQuestion.add(eightBall);

        // try to concatenate the strings together so you can return it properly

        String userQuestion = eightBall.getQuestion();

        String fullResponse = userQuestion + " " + r;

        return  fullResponse;
    }

}