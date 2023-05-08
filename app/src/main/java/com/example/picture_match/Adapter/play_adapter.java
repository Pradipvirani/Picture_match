package com.example.picture_match.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.picture_match.Activity.Hard;
import com.example.picture_match.Activity.Level_play;
import com.example.picture_match.Activity.MainActivity;
import com.example.picture_match.Activity.No_time;
import com.example.picture_match.Activity.Normal;
import com.example.picture_match.R;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

public class play_adapter extends BaseAdapter
{
    Level_play level_play;
    List<String> arraylist;
    View firstview;

    int time,maxtime,delaytime,level;
    String mode;

    SharedPreferences preferences;

    SharedPreferences.Editor editor;

    int click = 1,pos1=0,pos2=0,count=0;
    Runnable runnable;
    public play_adapter(Level_play level_play, List<String> arraylist, int maxtime, int delaytime, String mode, int level) {
        this.level_play=level_play;
        this.arraylist=arraylist;
        this.maxtime=maxtime;
        this.delaytime=delaytime;
        this.mode=mode;
        this.level=level;
        this.preferences = level_play.getPreferences(Context.MODE_PRIVATE);
        editor=preferences.edit();
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        View view;
        RelativeLayout relativeLayout;
        convertView= LayoutInflater.from(level_play).inflate(R.layout.play_iteam,parent,false);
        imageView=convertView.findViewById(R.id.play_image);
        view=convertView.findViewById(R.id.view);
        relativeLayout=convertView.findViewById(R.id.Relative_layaout);
        InputStream inputStream=null;
        try {
            inputStream=level_play.getAssets().open(""+arraylist.get(position));
        } catch (IOException e) {

            e.getMessage();
        }
        Drawable drawable = Drawable.createFromStream(inputStream,null);
        imageView.setImageDrawable(drawable);
        new CountDownTimer(1000*delaytime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Startgame(relativeLayout,view,position);
                view.setVisibility(View.VISIBLE);
            }
        }.start();




        return convertView;
    }

    private void Startgame(RelativeLayout relativeLayout, View view, int position) {
        Handler handler = new Handler();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click==1)
                {
                    view.setVisibility(View.INVISIBLE);
                    pos1=position;
                    firstview=view;
                    click=3;
                    runnable =new Runnable() {
                        @Override
                        public void run() {
                            click=2;
                        }
                    };
                    handler.postDelayed(runnable,200);
                }
                if (click==2)
                {
                    pos2=position;
                    view.setVisibility(View.INVISIBLE);
                    click=3;
                    if (arraylist.get(pos1).equals(arraylist.get(pos2)))
                    {
                        count++;
                        if (count==6 && level<=3)
                        {
                            editor.putString("status"+level,"win");
                            editor.putInt("lastlevel",level);
                            editor.commit();
                            AlertDialog.Builder builder = new AlertDialog.Builder(level_play);
                            builder.setTitle("Good job");
                            builder.setMessage("congratulation");

                       builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               if (mode.equals("notime")) {
                                   Intent intent = new Intent(level_play, No_time.class);
                                   intent.putExtra("mode", "notime");
                                   level_play.startActivity(intent);
                               }
                               if (mode.equals("normal")) {
                                   Intent intent = new Intent(level_play, Normal.class);
                                   intent.putExtra("mode", "normal");
                                   level_play.startActivity(intent);
                               }
                               if (mode.equals("hard")) {
                                   Intent intent = new Intent(level_play, Hard.class);
                                   intent.putExtra("mode", "hard");
                                   level_play.startActivity(intent);
                               }
                           }
                       });builder.show();

                        }
                        if (count==8 &&level > 3 && level<=7)
                        {
                            editor.putString("status"+level,"win");
                            editor.putInt("lastlevel",level);
                            editor.commit();
                            AlertDialog.Builder builder = new AlertDialog.Builder(level_play);
                            builder.setTitle("Good job");
                            builder.setMessage("congratulation");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (mode.equals("notime")) {
                                        Intent intent = new Intent(level_play, No_time.class);
                                        intent.putExtra("mode", "notime");
                                        level_play.startActivity(intent);
                                    }
                                    if (mode.equals("normal")) {
                                        Intent intent = new Intent(level_play, Normal.class);
                                        intent.putExtra("mode", "normal");
                                        level_play.startActivity(intent);
                                    }
                                    if (mode.equals("hard")) {
                                        Intent intent = new Intent(level_play, Hard.class);
                                        intent.putExtra("mode", "hard");
                                        level_play.startActivity(intent);
                                    }
                                }
                            });builder.show();

                        }
                        if (count==10 && level > 7 && level<=10)
                        {
                            editor.putString("status"+level,"win");
                            editor.putInt("lastlevel",level);
                            editor.commit();
                            AlertDialog.Builder builder = new AlertDialog.Builder(level_play);
                            builder.setTitle("Good job");
                            builder.setMessage("congratulation");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (mode.equals("notime")) {
                                        Intent intent = new Intent(level_play, No_time.class);
                                        intent.putExtra("mode", "notime");
                                        level_play.startActivity(intent);
                                    }
                                    if (mode.equals("normal")) {
                                        Intent intent = new Intent(level_play, Normal.class);
                                        intent.putExtra("mode", "normal");
                                        level_play.startActivity(intent);
                                    }
                                    if (mode.equals("hard")) {
                                        Intent intent = new Intent(level_play, Hard.class);
                                        intent.putExtra("mode", "hard");
                                        level_play.startActivity(intent);
                                    }
                                }
                            });builder.show();

                        }
                        runnable=new Runnable() {
                            @Override
                            public void run() {
                                click=1;
                            }
                        };
                        handler.postDelayed(runnable,200);
                    }
                    else
                    {
                        runnable=new Runnable() {
                            @Override
                            public void run() {
                                view.setVisibility(View.VISIBLE);
                                firstview.setVisibility(View.VISIBLE);
                                click=1;
                            }
                        };
                        handler.postDelayed(runnable,200);
                    }
                }
            }
        });
    }
}
