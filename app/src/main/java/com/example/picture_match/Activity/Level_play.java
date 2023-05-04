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



public class Level_play extends AppCompatActivity  {
    int level;
    String status;
    ArrayList<String>imagearr=new ArrayList<>();

    List<String>arraylist=new ArrayList<>();
    ProgressBar progressBar;
    GridView gridView;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int numimage,colum;

    TextView textView;

    Toolbar toolbar;

    Button back,go;

    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_play);
        level=getIntent().getIntExtra("level",0);
        status=getIntent().getStringExtra("status");
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
        if (level<=3)
        {
            numimage=6;
            colum=3;
        }else if (level>3 && level<=7)
        {
            numimage=8;
            colum=4;

        }else if (level>7 && level<=10)
        {
            numimage=10;
            colum=4;

        }
        arraylist=imagearr.subList(0,numimage);
        arraylist.addAll(arraylist);
        Collections.shuffle(arraylist);
        play_adapter playAdapter = new play_adapter(this,arraylist);
        gridView.setNumColumns(colum);
        gridView.setAdapter(playAdapter);
    }


}