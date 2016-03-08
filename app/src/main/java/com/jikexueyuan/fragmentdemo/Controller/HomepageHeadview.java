package com.jikexueyuan.fragmentdemo.Controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.jikexueyuan.fragmentdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bowenzhang on 16/3/6.
 */

/*
* this is a headView for Homepage
* I set a new GridView called MyGridView to make the icon be 2*4
* then i make the icon correspond to iconName using the R.layout.homepage_headview_cell
* */
public class HomepageHeadview extends LinearLayout{

    private GridView gridView;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private int[] icon = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
            R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,};
    private String[] iconName = {"food", "market","fruit","tea",
            "rich","cake","snack","fast"};

    public HomepageHeadview(Context context) {

        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.homepage_headview,this);
        gridView = (GridView)findViewById(R.id.gv_homepage_headview);
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String[] from = {"image","text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(getContext(), data_list, R.layout.homepage_headview_cell,from, to);
        gridView.setAdapter(sim_adapter);


    }


    public List<Map<String, Object>> getData() {
        for (int i = 0; i <icon.length ; i++) {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }
}
