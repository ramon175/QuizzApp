package com.example.ramon.quizzapp.models;

import java.util.List;

public class Question {

    private String title;
    private List<String> alternatives;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<String> alternatives) {
        this.alternatives = alternatives;
    }
}
