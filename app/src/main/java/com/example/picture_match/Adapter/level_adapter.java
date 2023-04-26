package com.example.picture_match.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.picture_match.R;

public class level_adapter extends BaseAdapter {
     Context context;
    Button button;
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
        button.setText("level"+(i+1));
        return view;
    }
}
