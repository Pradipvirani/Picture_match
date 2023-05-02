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

import com.example.picture_match.R;

import java.util.ArrayList;
import java.util.List;



public class Level_play extends AppCompatActivity implements View.OnClickListener {
    int level;
    String status;
    ArrayList<String>imagearr=new ArrayList<>();
    List<String>arrayliost=new ArrayList<>();
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

    }

    @Override
    public void onClick(View view)
    {

    }
}