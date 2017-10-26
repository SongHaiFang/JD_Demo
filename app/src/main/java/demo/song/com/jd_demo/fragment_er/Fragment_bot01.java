package demo.song.com.jd_demo.fragment_er;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.adapter.HomeAdapter;
import demo.song.com.jd_demo.adapter.NewAdapter;
import demo.song.com.jd_demo.bean.TypeBean;
import okhttp3.Call;

/**
 * data:2017/10/23 0023.
 * Created by ：宋海防  song on
 */
public class Fragment_bot01 extends android.support.v4.app.Fragment {

    private RecyclerView recy;
    private NewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bot01, container, false);
        recy = view.findViewById(R.id.recy_type);

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
                        recy.setAdapter(adapter);
                        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 3);
                        recy.setLayoutManager(linearLayoutManager);
                    }
                });

//        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Toast.makeText(getContext(),"点击了",Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;

    }
}
