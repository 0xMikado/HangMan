package com.example.nimar5.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final ImageButton ibPlay = findViewById(R.id.ibPlay);
        final ImageButton ibInfo = findViewById(R.id.ibInfo);
        final ImageButton ibExit = findViewById(R.id.ibExit);


        ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mi_intent = new Intent(v.getContext() , Jugar.class);
                startActivity(mi_intent);

            }
        });


        ibInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mi_intent = new Intent(v.getContext() , HowToPlay.class);
                startActivity(mi_intent);

            }
        });

        ibExit.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}

