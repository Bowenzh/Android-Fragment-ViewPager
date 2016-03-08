package com.jikexueyuan.fragmentdemo.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jikexueyuan.fragmentdemo.Model.HomepageModel;
import com.jikexueyuan.fragmentdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bowenzhang on 16/3/3.
 */

/*
* this is a listAdapter
* in the view part, I set the content of deliver need.
* */
public class HomePageListAdapter extends BaseAdapter {

    private List<HomepageModel> homepageModels = new ArrayList<HomepageModel>();
    private Context context;

    public HomePageListAdapter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override

    public int getCount() {
        return homepageModels.size();
    }

    @Override
    public HomepageModel getItem(int position) {
        return homepageModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.home_page_cell, null);
        }

        HomepageModel homepageModel = getItem(position);

        ImageView iv = (ImageView) convertView.findViewById(R.id.homepage_iv);
        TextView name = (TextView) convertView.findViewById(R.id.homepage_name);
        TextView startValue = (TextView) convertView.findViewById(R.id.homepage_startValue);
        TextView deliverFee = (TextView) convertView.findViewById(R.id.homepage_deliverFee);
        TextView review = (TextView) convertView.findViewById(R.id.homepage_review);
        TextView sell = (TextView) convertView.findViewById(R.id.homepage_sell);

        iv.setImageResource(homepageModel.getPhotoID());
        name.setText(homepageModel.getName());
        startValue.setText("startValue: " + String.valueOf(homepageModel.getStartValue()) + "dollars");
        deliverFee.setText("deliverFee: " + String.valueOf(homepageModel.getDeliverFee()) + "dollars");
        review.setText("review: " + homepageModel.getReview());
        sell.setText("sold: " + String.valueOf(homepageModel.getSellNumber()));

        return convertView;
    }

    public void add(HomepageModel homepageModel) {
        homepageModels.add(homepageModel);
    }
}
