package com.example.picture_match.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.picture_match.Adapter.level_adapter;
import com.example.picture_match.R;

public class Hard extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;
    Button button;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        gridView=findViewById(R.id.hard_grid_view);
        button=findViewById(R.id.question_button);
        mode=getIntent().getStringExtra("mode");
        level_adapter level_adapter = new level_adapter(Hard.this,mode);
        gridView.setAdapter(level_adapter);
        preferences=getSharedPreferences("pref",MODE_PRIVATE);
        editor= preferences.edit();
        editor.putInt("lastlevel",-1);
        editor.commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Hard.this);
                builder.setTitle("How To Play Match 1");
                builder.setMessage("Tap on a squre to turn it over and see the"+"\n"+"pcture it hides"
                +"\n \n"+"Tap on another squre to turn it over too"
                        +"\n"+"if the picture match,they'll stay faciung up, if not,"
                        +"\n \n"+"Find all couples.");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();

            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}