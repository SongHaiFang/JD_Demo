package demo.song.com.jd_demo.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.bean.Jx_Bean;
import demo.song.com.jd_demo.bean.TypeBean;

import static android.media.CamcorderProfile.get;

public class JXAdapter extends RecyclerView.Adapter<JXAdapter.MyViewHolder> {
    private Jx_Bean bean;
    private Context context;

    public JXAdapter(Jx_Bean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener onItemClickListener;

    public void setOnItemClickLitener(OnItemClickLitener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.er, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        ObjectAnimator alpha = ObjectAnimator.ofFloat(holder.tv, "alpha", 0.3f, 1f);
        alpha.setDuration(2000).start();

        holder.tv.setText(bean.data.get(position).name);
        loderImage(bean.data.get(position).list.get(position).icon,holder.img);
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return bean.data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            img =(ImageView) view.findViewById(R.id.img_er);
        }
    }
    public  void loderImage(String url,ImageView imageView){
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(context);

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        instance.init(configuration);
        instance.displayImage(url, imageView ,options);

        //compile 'com.nostra13.universalimageloader:universal-image-loader:1.9.5'
    }

}