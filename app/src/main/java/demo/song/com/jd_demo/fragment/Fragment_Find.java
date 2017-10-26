package demo.song.com.jd_demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import demo.song.com.jd_demo.GGactivity;
import demo.song.com.jd_demo.MainActivity;
import demo.song.com.jd_demo.MyAct;
import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.adapter.MyFragmentAdapter;
import demo.song.com.jd_demo.fragment_er.Fragment01;
import demo.song.com.jd_demo.fragment_er.Fragment02;
import demo.song.com.jd_demo.fragment_er.Fragment03;
import demo.song.com.jd_demo.fragment_er.Fragment04;
import demo.song.com.jd_demo.fragment_er.Fragment05;
import demo.song.com.jd_demo.fragment_er.Fragment06;

/**
 * data:2017/9/27 0027.
 * Created by ：宋海防  song on
 */

public class Fragment_Find extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyFragmentAdapter myFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,container,false);

        ImageView viewById = (ImageView) view.findViewById(R.id.tiao);

        initView(view);
        initViewPager();
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GGactivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.myTab);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
    }

    private void initViewPager() {
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment01());
        list.add(new Fragment02());
        list.add(new Fragment03());
        list.add(new Fragment04());
        list.add(new Fragment05());
        list.add(new Fragment06());
        myFragmentAdapter = new MyFragmentAdapter(getFragmentManager());
        myFragmentAdapter.setFragment(list);

        viewPager.setAdapter(myFragmentAdapter);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("精选");
        tabLayout.getTabAt(1).setText("直播");
        tabLayout.getTabAt(2).setText("订购");
        tabLayout.getTabAt(3).setText("视频购");
        tabLayout.getTabAt(4).setText("问答");
        tabLayout.getTabAt(5).setText("清单");
    }
}
