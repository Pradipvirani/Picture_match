package com.example.picture_match;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class Normal extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        gridView=findViewById(R.id.normal_grid_view);
        button=findViewById(R.id.question_button);
        level_adapter level_adapter = new level_adapter(Normal.this);
        gridView.setAdapter(level_adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Normal.this,Level_play.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Normal.this);
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