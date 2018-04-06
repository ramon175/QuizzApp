package com.example.ramon.quizzapp.models;


public class Questions {

    private String questoes[] = {
            "Qual é o primeiro planeta do sistema solar?",
                    "Qual é o segundo planeta do sistema solar?",
                    "Qual é o terceiro planeta do sistema solar?",
                    "Qual é o quarto planeta do sistema solar?",
                    "Qual é o quinto planeta do sistema solar?",
                    "Qual é o sexto planeta do sistema solar?",
                    "Qual é o sétimo planeta do sistema solar?",
                    "Qual é o oitavo planeta do sistema solar?",
                    "Qual é o nono planeta do sistema solar?"
    };

    private String respostas[][] = {
            {"Mercúrio","Venus","Marte","Saturno"},
            {"Júpiter","Venus","Terra","Netuno"},
            {"Terra","Júpiter","Plutão","Venus"},
            {"Júpiter","Saturno","Marte","Terra"},
            {"Júpiter","Plutão","Mercúrio","Terra"},
            {"Urano","Venus","Marte","Saturno"},
            {"Saturno","Plutão","Urano","Terra"},
            {"Venus","Netuno","Plutão","Marte"},
            {"Mercúrio","Venus","Marte","Plutão"}
    };

    private String respostasCorretas[] = {"Mercúrio","Venus","Terra","Marte","Júpiter","Saturno","Urano","Netuno","Plutão"};


    public String[] getQuestions(){
        return questoes;
    }

    public String getQuestion(int i){
        String questao = questoes[i];
        return questao;
    }

    public String[][] getRespostas(){
        return respostas;
    }

    public String getRespostaCorreta(int i){
        return respostasCorretas[i];
    }
}
