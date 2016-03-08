package com.jikexueyuan.fragmentdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.jikexueyuan.fragmentdemo.Controller.HomePageListAdapter;
import com.jikexueyuan.fragmentdemo.Controller.HomepageHeadview;
import com.jikexueyuan.fragmentdemo.Model.HomepageModel;
import com.jikexueyuan.fragmentdemo.R;


/**
 * Created by bowenzhang on 16/3/3.
 */
public class HomepageFragment extends Fragment {

    private ListView hpListView;
    private HomePageListAdapter hpAdapter;
    private View view;
    private HomepageHeadview homepageHeadeView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_page, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        hpAdapter = new HomePageListAdapter(getContext());
        hpListView.setAdapter(hpAdapter);
        hpAdapter.add(new HomepageModel(R.drawable.kuaican1, "KFC", 5, 10, 100, "Great"));
        hpAdapter.add(new HomepageModel(R.drawable.kuaican2, "BurgerKing", 5, 10, 200, "Good"));
        hpAdapter.add(new HomepageModel(R.drawable.kuaican3, "Subway", 20, 30, 300, "Normal"));
    }

    private void initView() {
        homepageHeadeView = new HomepageHeadview(getContext());
        hpListView = (ListView) view.findViewById(R.id.homepage_cell);
        hpListView.addHeaderView(homepageHeadeView);
    }

}
