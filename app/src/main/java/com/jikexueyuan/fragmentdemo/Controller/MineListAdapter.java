package com.jikexueyuan.fragmentdemo.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jikexueyuan.fragmentdemo.Model.MineModel;
import com.jikexueyuan.fragmentdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bowenzhang on 16/3/3.
 */
public class MineListAdapter extends BaseAdapter {

    private List<MineModel> mines = new ArrayList<MineModel>();
    private Context context;

    public MineListAdapter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return mines.size();
    }

    @Override
    public MineModel getItem(int position) {
        return mines.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mine_cell, null);
        }

        MineModel mine = getItem(position);

        ImageView iv = (ImageView) convertView.findViewById(R.id.mine_iv);
        TextView tv = (TextView) convertView.findViewById(R.id.mine_tv);

        tv.setText(mine.getLabel());
        iv.setImageResource(mine.getPhotoID());

        return convertView;
    }

    public void add(MineModel mine) {
        mines.add(mine);
    }
}
