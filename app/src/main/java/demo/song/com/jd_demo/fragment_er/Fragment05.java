package demo.song.com.jd_demo.fragment_er;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.song.com.jd_demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment05 extends Fragment {


    public Fragment05() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment01, container, false);
    }

}
