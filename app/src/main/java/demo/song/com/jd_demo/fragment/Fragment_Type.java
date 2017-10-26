package demo.song.com.jd_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.adapter.HomeAdapter;
import demo.song.com.jd_demo.adapter.MyFragmentAdapter;
import demo.song.com.jd_demo.bean.TypeBean;
import demo.song.com.jd_demo.fragment_er.Fragment_bot01;
import demo.song.com.jd_demo.fragment_er.Fragment_bot02;
import demo.song.com.jd_demo.fragment_er.Fragment_bot03;
import demo.song.com.jd_demo.fragment_er.Fragment_bot04;
import demo.song.com.jd_demo.fragment_er.Fragment_bot05;
import demo.song.com.jd_demo.fragment_er.Fragment_bot06;
import demo.song.com.jd_demo.fragment_er.Fragment_bot07;
import demo.song.com.jd_demo.fragment_er.Fragment_bot08;
import demo.song.com.jd_demo.fragment_er.Fragment_bot09;
import demo.song.com.jd_demo.fragment_er.Fragment_bot10;
import okhttp3.Call;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * data:2017/9/27 0027.
 * Created by ：宋海防  song on
 */

public class Fragment_Type extends Fragment{

    private View view;

    private String[] titles={"常用分类","潮流女装","品牌男装","内衣配饰","家用电器","手机数码","电脑办公","个护化妆","母婴频道","食物生鲜","酒水饮料","家居家纺","整车车品","鞋靴箱包","运动户外","图书","玩具乐器","钟表","居家生活","珠宝饰品","音像制品","家具建材","计生情趣","营养保健","奢侈礼品","生活服务","旅游出行"};
//    private TabLayout tabLayout;
    private ViewPager viewPager;
    private VerticalTabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_type,container,false);
        initView();
        initViewPager();

        return view;
    }

    private void initViewPager() {
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment_bot01());
        list.add(new Fragment_bot02());
        list.add(new Fragment_bot03());
        list.add(new Fragment_bot04());
        list.add(new Fragment_bot05());
        list.add(new Fragment_bot06());
        list.add(new Fragment_bot07());
        list.add(new Fragment_bot08());
        list.add(new Fragment_bot09());
        list.add(new Fragment_bot10());
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getFragmentManager());
        myFragmentAdapter.setFragment(list);

        viewPager.setAdapter(myFragmentAdapter);

        ITabView.TabTitle.Builder tabTitle = new ITabView.TabTitle.Builder();

        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));
        tabLayout.addTab(new QTabView(getContext()));


//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(0).setText(titles[0]);
//        tabLayout.getTabAt(1).setText(titles[1]);
//        tabLayout.getTabAt(2).setText(titles[2]);
//        tabLayout.getTabAt(3).setText(titles[3]);
//        tabLayout.getTabAt(4).setText(titles[4]);
//        tabLayout.getTabAt(5).setText(titles[5]);
//        tabLayout.getTabAt(6).setText(titles[6]);
//        tabLayout.getTabAt(7).setText(titles[7]);
//        tabLayout.getTabAt(8).setText(titles[8]);
//        tabLayout.getTabAt(9).setText(titles[9]);


    }


    private void initView() {
//        tabLayout = (TabLayout) view.findViewById(R.id.tab_type);
        viewPager = (ViewPager) view.findViewById(R.id.pager_type);
        tabLayout = (VerticalTabLayout) view.findViewById(R.id.tab_type);

    }


}
