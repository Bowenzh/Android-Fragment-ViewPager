package com.jikexueyuan.fragmentdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jikexueyuan.fragmentdemo.Controller.MineListAdapter;
import com.jikexueyuan.fragmentdemo.Model.MineModel;
import com.jikexueyuan.fragmentdemo.R;

/**
 * Created by bowenzhang on 16/3/3.
 */
public class MineFragment extends Fragment {

    private ListView orderListView;
    private MineListAdapter clvadpter;
    private View orderHeadView;
    private View minefragmentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        minefragmentView = inflater.inflate(R.layout.mine, container, false);

        initView();
        initEvent();

        return minefragmentView;
    }

    private void initEvent() {
        clvadpter.add(new MineModel(R.drawable.dizhi, "My address"));
        clvadpter.add(new MineModel(R.drawable.tuiquan, "My refund"));
        clvadpter.add(new MineModel(R.drawable.kefu, "Online Service"));
        clvadpter.add(new MineModel(R.drawable.pingjia, "My Rating"));
        clvadpter.add(new MineModel(R.drawable.nuomi, "Baidu"));
        clvadpter.add(new MineModel(R.drawable.ruzhu, "Merchants settled"));
        clvadpter.add(new MineModel(R.drawable.wenti, "Common information"));
        clvadpter.add(new MineModel(R.drawable.xiaoxi, "My information"));
        clvadpter.add(new MineModel(R.drawable.fanxian, "Cash back"));
        clvadpter.add(new MineModel(R.drawable.guiji, "Growth Path"));
    }

    private void initView() {
        orderListView = (ListView) minefragmentView.findViewById(R.id.mine_listView);
        clvadpter = new MineListAdapter(getContext());
        orderHeadView = LayoutInflater.from(getContext()).inflate(R.layout.mine_headview, null);
        orderListView.addHeaderView(orderHeadView);
        orderListView.setAdapter(clvadpter);
    }


}
