package com.example.picture_match;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2,button3,button4,button5,button6;
    MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.no_time);
        button2=findViewById(R.id.normal);
        button3=findViewById(R.id.hard);
        button4=findViewById(R.id.remove_ads);
        button5=findViewById(R.id.share);
        button6=findViewById(R.id.more_games);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==button1.getId())
        {
            Intent intent = new Intent(MainActivity.this,No_time.class);
            startActivity(intent);
        }
        if (view.getId()==button2.getId())
        {
            Intent intent = new Intent(MainActivity.this,Normal.class);
            startActivity(intent);
        }
        if (view.getId()==button3.getId())
        {
            Intent intent = new Intent(MainActivity.this,Hard.class);
            startActivity(intent);
        }
        if (view.getId()==button4.getId())
        {

        }
        if (view.getId()==button5.getId())
        {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,"my application");
            startActivity(Intent.createChooser(shareIntent, "choose one"));

        }
        if (view.getId()==button6.getId())
        {

        }

    }
}