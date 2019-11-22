package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.ScheduleBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/20.
 * function：
 */
public class AllAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    private List<ScheduleBean.ResultBean>list;

    public AllAdapter(Context context, List<ScheduleBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.all_adapter, parent, false);
        return new AllHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AllHolder){
            Glide.with(context).load(list.get(position).getImageUrl()).into(((AllHolder) holder).all_image);
            ((AllHolder) holder).all_daoyan.setText(list.get(position).getDirector());
            ((AllHolder) holder).all_name.setText(list.get(position).getName());
            ((AllHolder) holder).all_pingfen.setText(list.get(position).getScore());
            ((AllHolder) holder).all_zhuyan.setText(list.get(position).getStarring());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class AllHolder extends RecyclerView.ViewHolder{

        private final TextView all_daoyan,all_name,all_pingfen,all_zhuyan;
        private final ImageView all_image;
        private Button all_goupiao;

        public AllHolder(@NonNull View itemView) {
            super(itemView);
            all_image = itemView.findViewById(R.id.all_image);
            all_daoyan = itemView.findViewById(R.id.all_daoyan);
            all_name = itemView.findViewById(R.id.all_name);
            all_pingfen = itemView.findViewById(R.id.all_pingfen);
            all_zhuyan = itemView.findViewById(R.id.all_zhuyan);
            all_goupiao = itemView.findViewById(R.id.all_goupiao);

        }
    }
}
