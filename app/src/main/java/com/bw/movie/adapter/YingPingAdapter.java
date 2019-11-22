package com.bw.movie.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.YingPingBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/20.
 * function：
 */
public class YingPingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<YingPingBean.ResultBean>resultBeans;

    public YingPingAdapter(Context context, List<YingPingBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yingping_adapter, parent, false);
        return new YingPingHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof YingPingHolder){
            Glide.with(context).load(resultBeans.get(position).getCommentHeadPic()).into(((YingPingHolder) holder).yingping_image);
            ((YingPingHolder) holder).yingping_name.setText(resultBeans.get(position).getCommentUserName());
            ((YingPingHolder) holder).yingping_pingjia.setText(resultBeans.get(position).getCommentContent());
            Date date = new Date(resultBeans.get(position).getCommentTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((YingPingHolder) holder).yingping_riqi.setText(day);
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }
    public class YingPingHolder extends RecyclerView.ViewHolder{

        private final ImageView yingping_image;
        private final TextView yingping_name,yingping_pingjia,yingping_riqi,yingping_shijian;

        public YingPingHolder(@NonNull View itemView) {
            super(itemView);
            yingping_image = itemView.findViewById(R.id.yingping_image);
            yingping_name = itemView.findViewById(R.id.yingping_name);
            yingping_pingjia = itemView.findViewById(R.id.yingping_pingjia);
            yingping_riqi = itemView.findViewById(R.id.yingping_riqi);
            yingping_shijian = itemView.findViewById(R.id.yingping_shijian);

        }
    }
}
