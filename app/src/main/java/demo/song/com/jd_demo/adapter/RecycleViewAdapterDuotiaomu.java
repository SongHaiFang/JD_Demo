package demo.song.com.jd_demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import demo.song.com.jd_demo.R;
import demo.song.com.jd_demo.bean.Jx_Bean;
import demo.song.com.jd_demo.bean.TypeBean;
import demo.song.com.jd_demo.utils.ImageLoaderUtils;

public class RecycleViewAdapterDuotiaomu extends RecyclerView.Adapter<RecycleViewAdapterDuotiaomu.MyViewHolder> implements View.OnClickListener {

    private Context context;
    private View view;
    private TypeBean bean;

    public RecycleViewAdapterDuotiaomu(TypeBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

       if (viewType == Type0) {
            view = View.inflate(context, R.layout.itema, null);
            return new MyViewHolder(view);
        } else if (viewType == Type1) {
            view = View.inflate(context, R.layout.itemb, null);
            return new MyViewHolder(view);
        } else {
            view = View.inflate(context, R.layout.itemc, null);
            return new MyViewHolder(view);
        }

    }

    @Override
    public void onClick(View view) {
        if (mMyItemclickListener != null) {
            mMyItemclickListener.itemclick(view, (Integer) view.getTag());
        }
    }

    public interface MyItemclickListener {
        void itemclick(View view, int position);
    }

    public MyItemclickListener mMyItemclickListener;

    public void setmMyItemclickListener(MyItemclickListener mMyItemclickListener) {
        this.mMyItemclickListener = mMyItemclickListener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        int type = getItemViewType(position);
        switch (type) {

            case Type0:
                holder.tv_title.setText(bean.apk.get(position).name);
                holder.tv_title.setOnClickListener(this);
                break;
            case Type1:
                holder.tv1.setText(bean.apk.get(position).name);
                holder.tv2.setText(bean.apk.get((position+1)%(bean.apk.size())).name);
                holder.tv1.setOnClickListener(this);
                holder.tv2.setOnClickListener(this);
                break;
            case Type2:
                ImageLoaderUtils.setImageView(bean.apk.get(position).iconUrl,context,holder.image1);
                ImageLoaderUtils.setImageView(bean.apk.get((position+1)%(bean.apk.size())).iconUrl,context,holder.image2);
                holder.image1.setOnClickListener(this);
                holder.image2.setOnClickListener(this);
                break;
            default:
                break;
        }
        holder.itemView.setTag(position);

    }

    public final int Type = 212;
    public final int Type0 = 1;
    public final int Type1 = 2;
    public final int Type2 = 3;

    @Override
    public int getItemViewType(int position) {

      if (position % 3 == 0) {
            return Type0;
        } else if (position % 3 == 1) {
            return Type1;
        } else {
            return Type2;
        }
    }


    @Override
    public int getItemCount() {
        return bean.apk.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_icon;
        private final TextView tv_title;
        private final ImageView image1;
        private final ImageView image2;
        private final TextView tv1;
        private final TextView tv2;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_title = itemView.findViewById(R.id.tv_title);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }


}