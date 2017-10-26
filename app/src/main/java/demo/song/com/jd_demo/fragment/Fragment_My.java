package demo.song.com.jd_demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import demo.song.com.jd_demo.MainActivity;
import demo.song.com.jd_demo.MyAct;
import demo.song.com.jd_demo.R;

/**
 * data:2017/9/27 0027.
 * Created by ：宋海防  song on
 */

public class Fragment_My extends Fragment {

    private ImageView image_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);

        image_view = (ImageView) view.findViewById(R.id.image_view);
        image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZhuCeAct.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
