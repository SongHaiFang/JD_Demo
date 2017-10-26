package demo.song.com.jd_demo.fragment_er;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.adapter.HomeAdapter;
import demo.song.com.jd_demo.adapter.JXAdapter;
import demo.song.com.jd_demo.bean.Jx_Bean;
import demo.song.com.jd_demo.bean.TypeBean;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment02 extends Fragment {
    private RecyclerView recy;

    public Fragment02() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jingxuan, container, false);

        recy = view.findViewById(R.id.recy_jx);

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
                        HomeAdapter adapter = new HomeAdapter(jx_bean, getContext());
                        recy.setAdapter(adapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        recy.setLayoutManager(linearLayoutManager);
                    }
                });

        return view;
    }

}
