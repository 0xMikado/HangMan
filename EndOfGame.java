package com.example.nimar5.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EndOfGame extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_game);

        final ImageButton ibHome = findViewById(R.id.ibHome);
        final ImageButton ibAgain = findViewById(R.id.ibAgain);

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mi_intent = new Intent(v.getContext() , HomePage.class);
                startActivity(mi_intent);

            }
        });

        ibAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mi_intent = new Intent(v.getContext() , Jugar.class);
                startActivity(mi_intent);

            }
        });
    }
}
