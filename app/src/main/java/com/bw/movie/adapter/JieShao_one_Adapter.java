package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.JieShaoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/19.
 * function：
 */
public class JieShao_one_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<JieShaoBean.ResultBean.MovieActorBean>list;

    public JieShao_one_Adapter(Context context, List<JieShaoBean.ResultBean.MovieActorBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.jieshao_one_adapter, parent, false);
        return new JieShaoOneHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  JieShaoOneHolder){
            Glide.with(context).load(list.get(position).getPhoto()).into(((JieShaoOneHolder) holder).sView_rec_performer);
            //((JieShaoOneHolder) holder).sView_rec_performer.setImageURI(Uri.parse(list.get(position).getPhoto()));
            ((JieShaoOneHolder) holder).tv_name_rec_performer.setText(list.get(position).getName());
            ((JieShaoOneHolder) holder).tv_play_rec_performer.setText(list.get(position).getRole());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class JieShaoOneHolder extends RecyclerView.ViewHolder{
        ImageView sView_rec_performer;
       //SimpleDraweeView sView_rec_performer;
        TextView tv_name_rec_performer,tv_play_rec_performer;
        public JieShaoOneHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_performer = itemView.findViewById(R.id.sView_rec_performer);
            tv_name_rec_performer = itemView.findViewById(R.id.tv_name_rec_performer);
            tv_play_rec_performer = itemView.findViewById(R.id.tv_play_rec_performer);
        }
    }
}
