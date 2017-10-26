package demo.song.com.jd_demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import demo.song.com.jd_demo.ErWeiMa;
import demo.song.com.jd_demo.MyAct;
import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.adapter.HomeAdapter;
import demo.song.com.jd_demo.adapter.JXAdapter;
import demo.song.com.jd_demo.adapter.MyFragmentAdapter;
import demo.song.com.jd_demo.adapter.NewAdapter;
import demo.song.com.jd_demo.bean.Jx_Bean;
import demo.song.com.jd_demo.bean.TypeBean;
import demo.song.com.jd_demo.fragment_er.Fragment01;
import demo.song.com.jd_demo.fragment_er.Fragment02;
import demo.song.com.jd_demo.fragment_er.Fragment03;
import okhttp3.Call;

/**
 * data:2017/9/27 0027.
 * Created by ：宋海防  song on
 */

public class Fragment_Index extends Fragment {

    private Banner banner;
    Integer [] arr = {R.drawable.jsbundles_jdreactintlbrand_images_brand_enter_price,
            R.drawable.jsbundles_jdreactintlbrand_images_brand_enter_advance_bg,
            R.drawable.jsbundles_jdreactintlbrand_images_brand_promotions_ads};
    List<Integer> list;

    private View view;
    private ViewPager pager;
    private RadioGroup groups;
    private RecyclerView recyclerView;
    private NewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_index,container,false);

        initView();
        three_Index();
        ban();
        okGet();

        return view;
    }

    private void okGet() {
        OkHttpUtils.get()
                .url("http://huixinguiyu.cn/Assets/js/data.js")
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        String string = response.toString();
                        TypeBean jx_bean = new Gson().fromJson(string, TypeBean.class);
                        adapter = new NewAdapter(R.layout.er,jx_bean.apk);
                        recyclerView.setAdapter(adapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(linearLayoutManager);
                    }
                });
    }

    private void ban() {
//轮播图
        list= new ArrayList<>();
        for (Integer a:arr) {
            list.add(a);
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(list);
//        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
//        banner.setDelayTime(2000);
        banner.start();

    }

    private void three_Index() {
        pager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                switch (position%3) {
                    case 0:
                        fragment=new One_Index();
                        break;
                    case 1:
                        fragment=new Two_Index();
                        break;
                    default:
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                groups.check(groups.getChildAt(arg0).getId());
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

//    private void runOnUiThread(Runnable runnable) {
//
//    }

    private void initView() {
        pager = (ViewPager) view.findViewById(R.id.viewpager_index);
        groups = (RadioGroup) view.findViewById(R.id.gr);
        banner = (Banner) view.findViewById(R.id.myBanner);
        recyclerView = (RecyclerView) view.findViewById(R.id.myRecy);
    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }

    }
}
