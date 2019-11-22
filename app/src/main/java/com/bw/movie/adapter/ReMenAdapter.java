package com.bw.movie.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.ReMenBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/13.
 * function：
 */
public class ReMenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<ReMenBean.ResultBean>resultBeans;

    public ReMenAdapter(Context context, List<ReMenBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.remen_adapter, parent, false);
        return new RemenHD(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  RemenHD){
            ((RemenHD) holder).remen_text.setText(resultBeans.get(position).getName());
            Glide.with(context).load(resultBeans.get(position).getImageUrl()).into(((RemenHD) holder).remen_image);
            ((RemenHD) holder).remen_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   String movieId = resultBeans.get(position).getMovieId();
                   setonClick.setClick(movieId);
                }
            });
         }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }
    public class RemenHD extends RecyclerView.ViewHolder{

        private final ImageView remen_image;
        private final TextView remen_text;
        private final LinearLayout remen_linear;

        public RemenHD(@NonNull View itemView) {
            super(itemView);
            remen_image = itemView.findViewById(R.id.remen_image);
            remen_text = itemView.findViewById(R.id.remen_text);
            remen_linear = itemView.findViewById(R.id.remen_linear);
        }
    }
    public setonClick setonClick;
    public void getOnClick(setonClick setonClick){
        this.setonClick =setonClick;
    }
    public interface setonClick{
        void setClick(String id);
    }
}
