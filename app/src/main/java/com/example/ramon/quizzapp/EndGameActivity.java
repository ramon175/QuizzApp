package com.example.ramon.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EndGameActivity extends AppCompatActivity {

    private TextView editTextPlayerName;
    private TextView editTextScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        editTextPlayerName = (TextView) findViewById(R.id.textView_username);
        editTextScore = (TextView) findViewById(R.id.textView_Score);

        Intent i = getIntent();

        Bundle extras = i.getExtras();

        if(extras.containsKey("playerName") && extras.containsKey("score")){

            String userName = extras.getString("playerName");
            int score = extras.getInt("score");

            editTextScore.setText(Integer.toString(score));
            editTextPlayerName.setText(userName);

        }

        Toast.makeText(this, "Para jogar novamente basta apertar o botão de voltar!", Toast.LENGTH_LONG).show();
    }
}
