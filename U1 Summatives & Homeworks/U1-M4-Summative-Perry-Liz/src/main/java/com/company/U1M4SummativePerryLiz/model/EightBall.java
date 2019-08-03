package com.company.U1M4SummativePerryLiz.model;

import javax.validation.constraints.NotEmpty;

public class EightBall {
    private String response;
    @NotEmpty(message = "You must supply a question for the Magic 8 Ball.")
    private String question;

    public EightBall() {

    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
