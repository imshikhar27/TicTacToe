package com.happybirthday.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ac=1;
    int[] in={0,0,0,0,0,0,0,0,0,0};
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int chance=1;
    int c=1;
    String p1="",p2="";

    public void tap(View view)
    {
        ImageView  img = (ImageView) view;
        TextView status=findViewById(R.id.status);
        int click=Integer.parseInt(img.getTag().toString());
        if(ac==0)
            reset(view);
        else
        {
            if(in[click]==0&&c<10)
            {
                in[click]=chance;
                if(chance==1)
                {
                    img.setImageResource(R.drawable.o);
                    chance=2;
                    status.setText(p2+"'s turn..");
                }
                else
                {
                    img.setImageResource(R.drawable.x);
                    chance=1;
                    status.setText(p1+"'s turn..");
                }
                c++;
            }
            if(c==10)
            {
                status.setText("Draw");
                ac=0;
            }
        }
        for(int[] wins:win)
        {

            if(in[wins[0]]==in[wins[1]]&&in[wins[1]]==in[wins[2]]&&in[wins[0]]!=0)
            {
                if (in[wins[0]] == 1)
                    status.setText(p1+" wins...");
                else
                    status.setText(p2+" wins...");
                ac=0;
            }
        }
    }
    public void reset(View view)
    {   ac=1;
        c=1;
        for(int i=0;i<9;i++)
            in[i]=0;
        chance=1;
        TextView status=findViewById(R.id.status);
        status.setText(p1+"'s turn.. ");
        ((ImageView)findViewById(R.id.a0)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a1)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a2)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a3)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a4)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a5)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a6)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a7)).setImageResource(R.drawable.blank);
        ((ImageView)findViewById(R.id.a8)).setImageResource(R.drawable.blank);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=getIntent();
        p1=i.getStringExtra("Player 1");
        p2=i.getStringExtra("Player 2");
        TextView status=findViewById(R.id.status);
        status.setText(p1+"'s turn..");
    }
}