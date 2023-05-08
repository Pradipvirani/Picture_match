package com.example.picture_match.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.picture_match.Adapter.play_adapter;
import com.example.picture_match.R;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Level_play extends AppCompatActivity  {
    int level;
    String mode;
    ArrayList<String>imagearr=new ArrayList<>();

    List<String>arraylist=new ArrayList<>();
    ProgressBar progressBar;
    GridView gridView;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int numimage,colum,maxtime,delaytime;

    TextView textView;

    Toolbar toolbar;

    Button back,go;

    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_play);
        level=getIntent().getIntExtra("level",0);
        mode=getIntent().getStringExtra("mode");
        progressBar=findViewById(R.id.progress);
        gridView=findViewById(R.id.grid_view_play);
        preferences=getSharedPreferences("pre",MODE_PRIVATE);
        editor=preferences.edit();
        String image[];
        try {
            image=getAssets().list("");
            imagearr= new ArrayList<String>(Arrays.asList(image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int min=0,max=20;
        int random=new Random().nextInt(max-min)+min;
        if (mode.equals("notime")) {
            if (level <= 3) {
                numimage = 6 + random;
                maxtime = 100;
                delaytime = 5;
                colum = 3;
            } else if (level > 3 && level <= 7) {
                numimage = 8 + random;
                maxtime = 120;
                delaytime = 7;
                colum = 4;

            } else if (level > 7 && level <= 10) {
                numimage = 10 + random;
                maxtime = 150;
                delaytime = 9;
                colum = 4;

            }
        }
        if (mode.equals("normal")) {
            if (level <= 3) {
                numimage = 6 + random;
                maxtime = 20;
                delaytime = 5;
                colum = 3;
            } else if (level > 3 && level <= 7) {
                numimage = 8 + random;
                maxtime = 25;
                delaytime = 7;
                colum = 4;

            } else if (level > 7 && level <= 10) {
                numimage = 10 + random;
                maxtime =30;
                delaytime = 9;
                colum = 4;

            }
        }
        if (mode.equals("hard")) {
            if (level <= 3) {
                numimage = 6 + random;
                maxtime = 5;
                delaytime = 5;
                colum = 3;
            } else if (level > 3 && level <= 7) {
                numimage = 8 + random;
                maxtime = 10;
                delaytime = 7;
                colum = 4;

            } else if (level > 7 && level <= 10) {
                numimage = 10 + random;
                maxtime = 20;
                delaytime = 9;
                colum = 4;

            }
        }
        arraylist=imagearr.subList(random,numimage);
        arraylist.addAll(arraylist);
        Collections.shuffle(arraylist);
        play_adapter playAdapter = new play_adapter(this,arraylist,maxtime,delaytime,mode,level);
        gridView.setNumColumns(colum);
        gridView.setAdapter(playAdapter);
    }


}