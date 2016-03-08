package com.jikexueyuan.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jikexueyuan.fragmentdemo.Controller.ViewPagerAdapter;
import com.jikexueyuan.fragmentdemo.Fragment.HomepageFragment;
import com.jikexueyuan.fragmentdemo.Fragment.MineFragment;
import com.jikexueyuan.fragmentdemo.Fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;


/*
* The MainActivity extends FragmentActivity
* There are three fragments corresponding to order, mine, homepage, respectively.
* Using three ImageView to execute a click event, ViewPager to make the those three fragments slide
* */


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    // at the bottom of the layout to change the fragment to homepage
    private ImageView homePageImageView;
    
    // at the bottom of the layout to change the fragment to mine
    private ImageView mineImageView;
    
    // at the bottom of the layout to change the fragment to order
    private ImageView orderImageView;
    
    // declare the FragmentManager. android.support.v4.app -- so it will use getSupportFragmentManager() function
    private FragmentManager fragmentManager;
    
    // declare the ViewPager which use to slide the fragments
    private ViewPager vp;
    
    // use this list to load the three fragments
    private List<Fragment> fragments;
    
    // declare ViewPagerAdapter Adapter
    private ViewPagerAdapter ViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
        initEvent();

    }

    /*
    * initial the view
    * first add three fragments into list<Fragment>, 
    * initial ImageView, ViewPager and set the Listener 
    * */

    private void initViews() {

        fragments = new ArrayList<Fragment>();
        fragments.add(new HomepageFragment());
        fragments.add(new OrderFragment());
        fragments.add(new MineFragment());

        homePageImageView = (ImageView) findViewById(R.id.homepage_image);
        mineImageView = (ImageView) findViewById(R.id.mine_image);
        orderImageView = (ImageView) findViewById(R.id.order_image);

        vp = (ViewPager) findViewById(R.id.viewPager);

        homePageImageView.setOnClickListener(this);
        mineImageView.setOnClickListener(this);
        orderImageView.setOnClickListener(this);

    }
    /*
    * set the ViewPagerAdapter
    * */

    private void initData() {
        
        fragmentManager = getSupportFragmentManager();
        ViewPagerAdapter = new ViewPagerAdapter(fragmentManager, fragments);
        vp.setAdapter(ViewPagerAdapter);
        
    }

    /*
    * When Fragments slide, we need to monitor events, so we should set PageChangeListener to ViewPager
     * there are three functions we should rewrite, onPagerScrolled, onPageSelected, onPageScrollStateChanged
     * I use homepageTab, orderTab, mineTab functions to change the icon state.
    * */
    
    private void initEvent() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        homepageTab();
                        break;
                    case 1:
                        orderTab();
                        break;
                    case 2:
                        mineTab();
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setTabSelection(0);
    }


    /*
    * this is click event
    * it can change the fragment and icon state
    * */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homepage_image:
                setTabSelection(0);
                break;
            case R.id.mine_image:
                setTabSelection(2);
                break;
            case R.id.order_image:
                setTabSelection(1);
                break;
            default:
                break;
        }
    }

    /*
    * setCurrentItem
    * Using this to change the fragments when you click the icon
    * */
    public void setTabSelection(int tabSelection) {
        switch (tabSelection) {
            case 0:
                homepageTab();
                vp.setCurrentItem(tabSelection);
                break;
            case 1:
                orderTab();
                vp.setCurrentItem(tabSelection);
                break;
            case 2:
                mineTab();
                vp.setCurrentItem(tabSelection);
                break;
            default:
                break;
        }
    }


    private void homepageTab() {
        homePageImageView.setImageResource(R.drawable.homepage);
        orderImageView.setImageResource(R.drawable.un_order);
        mineImageView.setImageResource(R.drawable.un_mine);
    }

    private void mineTab() {

        homePageImageView.setImageResource(R.drawable.un_homepage);
        orderImageView.setImageResource(R.drawable.un_order);
        mineImageView.setImageResource(R.drawable.mine);
    }

    private void orderTab() {
        homePageImageView.setImageResource(R.drawable.un_homepage);
        orderImageView.setImageResource(R.drawable.order);
        mineImageView.setImageResource(R.drawable.un_mine);
    }

}
