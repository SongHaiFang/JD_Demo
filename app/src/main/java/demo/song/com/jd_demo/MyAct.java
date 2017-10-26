package demo.song.com.jd_demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hjm.bottomtabbar.BottomTabBar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import demo.song.com.jd_demo.adapter.MyFragmentAdapter;
import demo.song.com.jd_demo.fragment.Fragment_Find;
import demo.song.com.jd_demo.fragment.Fragment_Index;
import demo.song.com.jd_demo.fragment.Fragment_My;
import demo.song.com.jd_demo.fragment.Fragment_Shop;
import demo.song.com.jd_demo.fragment.Fragment_Type;


/**
 * data:2017/9/27 0027.
 * Created by ：宋海防  song on
 */
public class MyAct extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyFragmentAdapter fragmentAdapter;
    private BottomTabBar tabBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myact);

//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

//        initView();
//        initViewpager();
        tabBar = (BottomTabBar) findViewById(R.id.bottomBar);
        tabBar.init(getSupportFragmentManager())
                .addTabItem("首页",R.drawable.index_red,R.drawable.index,Fragment_Index.class)
                .addTabItem("分类",R.drawable.type_red,R.drawable.type,Fragment_Type.class)
                .addTabItem("发现",R.drawable.find_red,R.drawable.find,Fragment_Find.class)
                .addTabItem("购物车",R.drawable.car_red,R.drawable.car,Fragment_Shop.class)
                .addTabItem("我的",R.drawable.user_red,R.drawable.user,Fragment_My.class);
        bottomBar();

//        EventBus.getDefault().register(this);


    }

    private void bottomBar() {


    }

    private void initViewpager() {
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment_Index());
        list.add(new Fragment_Type());
        list.add(new Fragment_Find());
        list.add(new Fragment_Shop());
        list.add(new Fragment_My());
        fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.setFragment(list);

        viewPager.setAdapter(fragmentAdapter);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("首页");
        tabLayout.getTabAt(1).setText("分类");
        tabLayout.getTabAt(2).setText("发现");
        tabLayout.getTabAt(3).setText("购物车");
        tabLayout.getTabAt(4).setText("我的");
        tabLayout.getTabAt(0).setIcon(R.drawable.index);
        tabLayout.getTabAt(1).setIcon(R.drawable.type);
        tabLayout.getTabAt(2).setIcon(R.drawable.find);
        tabLayout.getTabAt(3).setIcon(R.drawable.car);
        tabLayout.getTabAt(4).setIcon(R.drawable.user);
    }

    private void initView() {
//        tabLayout = (TabLayout) findViewById(R.id.tab_main);
//        viewPager = (ViewPager) findViewById(R.id.ViewPager_main);

    }



    public void saoyisao(View v){
        IntentIntegrator integrator = new IntentIntegrator(MyAct.this);
        // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setCaptureActivity(ErWeiMa.class);
        integrator.setPrompt("请扫描二维码"); //底部的提示文字，设为""可以置空
        integrator.setCameraId(0); //前置或者后置摄像头
        integrator.setBeepEnabled(false); //扫描成功的「哔哔」声，默认开启
        integrator.setBarcodeImageEnabled(true);//是否保留扫码成功时候的截图
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //二维码
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            String result = scanResult.getContents();
            Toast.makeText(MyAct.this, "关闭", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
