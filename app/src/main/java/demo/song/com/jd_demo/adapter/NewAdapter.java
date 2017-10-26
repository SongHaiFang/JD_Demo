package demo.song.com.jd_demo.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.bean.TypeBean;

/**
 * data:2017/10/25 0025.
 * Created by ：宋海防  song on
 */

public class NewAdapter extends BaseQuickAdapter<TypeBean.ApkBean,BaseViewHolder> {

    public NewAdapter(@LayoutRes int layoutResId, @Nullable List<TypeBean.ApkBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TypeBean.ApkBean item) {
        helper.setText(R.id.id_num,item.name);
        Glide.with(mContext).load(item.iconUrl).into((ImageView) helper.getView(R.id.img_er));
    }
}
