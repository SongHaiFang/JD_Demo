package demo.song.com.jd_demo.fragment_er;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

import demo.song.com.jd_demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment03 extends Fragment {

    private VideoView videoView;
    private View v;

    public Fragment03() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment01,container,false);
        videoView = v.findViewById(R.id.video1);
            videoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getContext(),"乔丹44分   公牛胜尼克斯",Toast.LENGTH_SHORT).show();
                }
            });
        Uri uri = Uri.parse("https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv/tieba-smallvideo-transcode/43050787_03c314abaf05714bd1cbab0b192962f3_1832d8a549e4_3.mp4");
        videoView.setMediaController(new MediaController(getContext()));
        videoView.setVideoURI(uri);
        //videoView.start();
        videoView.requestFocus();
        return v;
    }

}
