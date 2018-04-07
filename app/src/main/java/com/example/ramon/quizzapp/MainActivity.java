package com.example.ramon.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    private EditText playerName;
    private Button playBtn;
    private Button aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        playBtn = findViewById(R.id.button_play);
        playerName = findViewById(R.id.editText_playerName);
        aboutBtn = findViewById(R.id.button_sobre);

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = playerName.getText().toString();

                if(name.equals("")){
                    Toast.makeText(MainActivity.this, "Insira seu nome para prosseguir!", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(MainActivity.this, "Quizz iniciado!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this,GameActivity.class);
                    i.putExtra("playerName", name);
                    startActivity(i);


                }

            }
        });
    }
}
