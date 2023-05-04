package com.example.picture_match.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.picture_match.Activity.Level_play;
import com.example.picture_match.R;

public class level_adapter extends BaseAdapter {
     Context context;
    Button button;
    int level[]={1,2,3,4,5,6,7,8,9,10};
    public level_adapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.level_item_view,viewGroup,false);
        button=view.findViewById(R.id.level_button);
        button.setText("level"+level[i]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Level_play.class);
                intent.putExtra("level",level[i]);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
