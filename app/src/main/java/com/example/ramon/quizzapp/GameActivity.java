package com.example.ramon.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramon.quizzapp.models.Questions;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    private Questions questions = new Questions();

    private TextView questionTitle;
    private RadioGroup radioGroup;
    private Button nextButton;

    private String[] questoes = questions.getQuestions();
    private String[][] respostas = questions.getRespostas();

    private int i = 0;

    private int pontuacao = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionTitle = (TextView) findViewById(R.id.questionTitle);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        nextButton = (Button) findViewById(R.id.button_next);

        nextButton.setVisibility(View.INVISIBLE);


        prepareQuestion(questoes,i);
        prepareAnswers(respostas,i,radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    nextButton.setVisibility(View.VISIBLE);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton radioSelecionado = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String respostaSelecionada = radioSelecionado.getText().toString();

                verificaResposta(respostaSelecionada,i);

                i++;

                prepareQuestion(questoes,i);
                prepareAnswers(respostas,i,radioGroup);
                nextButton.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void prepareQuestion(String[] q, int index){

        Log.v("Q length", Integer.toString(q.length));
        Log.v("Index", Integer.toString(index));

        if(index < q.length) {

            String title = q[index];

            questionTitle.setText(title);
            if(index == q.length-1){
                nextButton.setText("Ver resultado");
            }
        }else{
            finishGame();
            return;
        }

    }

    private void prepareAnswers( String[][] a,  int i, RadioGroup rg){

        if(i < questoes.length) {
            rg.removeAllViews();
            createRadioButtons(a[i].length, radioGroup, a[i]);
        }else{
            return;
        }

    }


    private void verificaResposta(String respostaSelecionada, int i){

        String respostaCorreta = questions.getRespostaCorreta(i);

        if(respostaSelecionada.equals(respostaCorreta)){
            pontuacao++;
        }else{
            return;
        }
    }

    private void createRadioButtons(int size, RadioGroup rg, String[] answers){
        final RadioButton[] rb = new RadioButton[size];

        for(int j = 0; j < size; j++){
            rb[j] = new RadioButton(this);
            rg.addView(rb[j]);
            rb[j].setText(answers[j]);
            rb[j].setMinimumHeight(300);
        }

    }



    private void finishGame() {

        Intent intent = getIntent();

        String playerName = intent.getStringExtra("playerName");

        Intent i = new Intent(GameActivity.this,EndGameActivity.class);

        i.putExtra("playerName", playerName);
        i.putExtra("score",pontuacao);

        startActivity(i);

        finish();
    }
}
