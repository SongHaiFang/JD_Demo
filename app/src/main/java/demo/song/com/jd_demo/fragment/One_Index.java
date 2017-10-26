package demo.song.com.jd_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.song.com.jd_demo.R;

/**
 * data:2017/10/17 0017.
 * Created by ：宋海防  song on
 */
public class One_Index extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_index,container,false);

        return view;
    }
}
