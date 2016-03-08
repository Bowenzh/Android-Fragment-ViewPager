package com.jikexueyuan.fragmentdemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jikexueyuan.fragmentdemo.R;

/**
 * Created by bowenzhang on 16/3/3.
 */
public class OrderFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.order, container, false);

        return view;
    }
}
