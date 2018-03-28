package com.example.nimar5.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Jugar extends AppCompatActivity implements View.OnClickListener {

    Button bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM, bN, bO, bP, bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ;
    ImageView ivHangMan;
    TextView tvWord, tvTest;
    ImageButton ibHome;


    boolean WordIsGuessed = false;
    boolean FailedToGuessWord = false;
    int AttemptCount = 0;

    int Size = 0;
    String[] ArrayPalabras = new String[Size];
    String Word;
    int SizeWord = 0;
    char[] LetterGuessed;

    private int ReadFileSize() throws IOException {

        InputStream ISpalabras = getResources().openRawResource(R.raw.palabras);
        BufferedReader BRpalabras = new BufferedReader(new InputStreamReader(ISpalabras));

        String ReadPalabras;
        int i = 0;
        while ((ReadPalabras = BRpalabras.readLine()) != null) {
            i++;
        }
        ISpalabras.close();
        return i;
    }

    private String[] ReadFile(int i) throws IOException {
        InputStream ISpalabras = getResources().openRawResource(R.raw.palabras);
        BufferedReader BRpalabras = new BufferedReader(new InputStreamReader(ISpalabras));

        String ReadPalabras;
        String[] ReadPalabrasArray = new String[i];
        int a = 0;
        while ((ReadPalabras = BRpalabras.readLine()) != null) {
            ReadPalabrasArray[a] = ReadPalabras;
            a++;
        }
        ISpalabras.close();
        return ReadPalabrasArray;
    }

    public void DisplayWord(int Size, char[] LetterGuessed) {
        TextView tvWord = findViewById(R.id.tvWord);

        StringBuilder builder = new StringBuilder(2 * Size);
        for (char s : LetterGuessed)
            builder.append(s).append(" ");
        tvWord.setText(builder.toString());
    }

    public void DisplayImage(int Attempt) {

        ImageView ivHangMan = (ImageView) findViewById(R.id.ivHangMan);

        switch (Attempt) {
            case 1:
                ivHangMan.setImageResource(R.mipmap.namelogo);
                break;
            case 2:
                ivHangMan.setImageResource(R.mipmap.t);
                break;
            case 3:
                ivHangMan.setImageResource(R.mipmap.tc);
                break;
            case 4:
                ivHangMan.setImageResource(R.mipmap.tcj);
                break;
            case 5:
                ivHangMan.setImageResource(R.mipmap.namelogo);
                break;
            case 6:
                ivHangMan.setImageResource(R.mipmap.ic_launcher);
                break;
            case 7:
                FailedToGuessWord=true;
                break;
        }
    }

    public void WordGuessedOrFailed (){

        boolean Contains = false;

        for (char a : LetterGuessed){
            if (a=='_'){
                Contains  = true;
                break;
            }
        } if (!Contains)
            WordIsGuessed = true;


        if (FailedToGuessWord){
            // Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this , EndOfGame.class);
            startActivity(intent);
        }
        else if (WordIsGuessed){
            //Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
            Intent mi_intent = new Intent(this , EndOfGame.class);
            startActivity(mi_intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);


        //////////////////////// INITIALIZATION////////////////////////

        Button bA = (Button) findViewById(R.id.bA);
        Button bB = (Button) findViewById(R.id.bB);
        Button bC = (Button) findViewById(R.id.bC);
        Button bD = (Button) findViewById(R.id.bD);
        Button bE = (Button) findViewById(R.id.bE);
        Button bF = (Button) findViewById(R.id.bF);
        Button bG = (Button) findViewById(R.id.bG);
        Button bH = (Button) findViewById(R.id.bH);
        Button bI = (Button) findViewById(R.id.bI);
        Button bJ = (Button) findViewById(R.id.bJ);
        Button bK = (Button) findViewById(R.id.bK);
        Button bL = (Button) findViewById(R.id.bL);
        Button bM = (Button) findViewById(R.id.bM);
        Button bN = (Button) findViewById(R.id.bN);
        Button bO = (Button) findViewById(R.id.bO);
        Button bP = (Button) findViewById(R.id.bP);
        Button bQ = (Button) findViewById(R.id.bQ);
        Button bR = (Button) findViewById(R.id.bR);
        Button bS = (Button) findViewById(R.id.bS);
        Button bT = (Button) findViewById(R.id.bT);
        Button bU = (Button) findViewById(R.id.bU);
        Button bV = (Button) findViewById(R.id.bV);
        Button bW = (Button) findViewById(R.id.bW);
        Button bX = (Button) findViewById(R.id.bX);
        Button bY = (Button) findViewById(R.id.bY);
        Button bZ = (Button) findViewById(R.id.bZ);

        TextView tvTest = (TextView) findViewById(R.id.tvTest);
        TextView tvWord = (TextView) findViewById(R.id.tvWord);
        ImageView ivHangMan = (ImageView) findViewById(R.id.ivHangMan);
        ImageButton ibHome = (ImageButton) findViewById(R.id.ibHome);


        try {
            Size = ReadFileSize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayPalabras = ReadFile(Size);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        int random = rand.nextInt(Size);
        Word = ArrayPalabras[random];
        SizeWord = ArrayPalabras[random].length();
        LetterGuessed = new char[SizeWord];

        for (int i = 0; i < SizeWord; i++) {
            LetterGuessed[i] = '_';
        }

        DisplayWord(SizeWord, LetterGuessed);
        tvTest.setText(Word);




        bQ.setOnClickListener(this);
        bW.setOnClickListener(this);
        bE.setOnClickListener(this);
        bR.setOnClickListener(this);
        bT.setOnClickListener(this);
        bY.setOnClickListener(this);
        bU.setOnClickListener(this);
        bI.setOnClickListener(this);
        bO.setOnClickListener(this);
        bA.setOnClickListener(this);
        bP.setOnClickListener(this);
        bS.setOnClickListener(this);
        bD.setOnClickListener(this);
        bF.setOnClickListener(this);
        bG.setOnClickListener(this);
        bH.setOnClickListener(this);
        bJ.setOnClickListener(this);
        bK.setOnClickListener(this);
        bL.setOnClickListener(this);
        bZ.setOnClickListener(this);
        bX.setOnClickListener(this);
        bC.setOnClickListener(this);
        bV.setOnClickListener(this);
        bB.setOnClickListener(this);
        bN.setOnClickListener(this);
        bM.setOnClickListener(this);


        ibHome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        TextView tvWord = findViewById(R.id.tvWord);
        int Success = 0;

        if (v.getId() == R.id.ibHome) {
            Intent mi_intent = new Intent(v.getContext(), HowToPlay.class);
            startActivity(mi_intent);
        } else {
          Button bt = (Button)v;
           String LetterPressed = bt.getText().toString();

           for (int i=0;i<SizeWord;i++)
            {
                if (Word.charAt(i)==LetterPressed.charAt(0))
                {
                    LetterGuessed[i]=LetterPressed.charAt(0);
                    Success++;
                }
            }
            DisplayWord(SizeWord, LetterGuessed);

           if (Success==0)
           {
               AttemptCount++;
           }
           DisplayImage(AttemptCount);
           WordGuessedOrFailed();
        }

    }
}

