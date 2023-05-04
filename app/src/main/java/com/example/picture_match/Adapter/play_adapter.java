package com.example.picture_match.Adapter;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.picture_match.Activity.Level_play;
import com.example.picture_match.R;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

public class play_adapter extends BaseAdapter
{
    Level_play level_play;
    List<String> arraylist;
    View firstview;
    int time;

    int click = 1,pos1=0,pos2=0,count=0;
    Runnable runnable;
    public play_adapter(Level_play level_play, List<String> arraylist) {
        this.level_play=level_play;
        this.arraylist=arraylist;
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
        convertView= LayoutInflater.from(level_play).inflate(R.layout.play_iteam,parent,false);
        imageView=convertView.findViewById(R.id.play_image);
        view=convertView.findViewById(R.id.view);
        InputStream inputStream=null;
        try {
            inputStream=level_play.getAssets().open(""+arraylist.get(position));
        } catch (IOException e) {

            e.getMessage();
        }
        Drawable drawable = Drawable.createFromStream(inputStream,null);
        imageView.setImageDrawable(drawable);
        Handler handler = new Handler();
        int delaytime=5000;
        runnable=new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.VISIBLE);
            }
        };
        handler.postAtTime(runnable,System.currentTimeMillis()+delaytime);
        handler.postDelayed(runnable,delaytime);

        return convertView;
    }
}
