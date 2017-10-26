package demo.song.com.jd_demo.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * data:2017/8/3 0003.
 * Created by ：宋海防  song on
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    private String[] titles={"常用分类","潮流女装","品牌男装","内衣配饰","家用电器","手机数码","电脑办公","个护化妆","母婴频道","食物生鲜","酒水饮料","家居家纺","整车车品","鞋靴箱包","运动户外","图书","玩具乐器","钟表","居家生活","珠宝饰品","音像制品","家具建材","计生情趣","营养保健","奢侈礼品","生活服务","旅游出行"};
    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    private List<Fragment> lists;

    public void setFragment(List<Fragment> list){
        lists = list;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = lists.get(position);

        return fragment;
    }



    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}