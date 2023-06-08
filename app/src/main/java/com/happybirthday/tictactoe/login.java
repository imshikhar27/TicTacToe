package com.happybirthday.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {
    public void start(View view)
    {
        EditText p1=findViewById(R.id.player1);
        EditText p2=findViewById(R.id.player2);
        Intent i= new Intent(this,MainActivity.class);
        i.putExtra("Player 1",p1.getText().toString());
        i.putExtra("Player 2",p2.getText().toString());
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}