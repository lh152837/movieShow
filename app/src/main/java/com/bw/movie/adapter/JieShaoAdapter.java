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
 *@describe(描述)：JieShaoAdapter
 *@data（日期）: 2019/11/19
 *@time（时间）: 18:56
 *@author（作者）: Liuhe
 **/
public class JieShaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<JieShaoBean.ResultBean.MovieDirectorBean> list;

    public JieShaoAdapter(Context context, List<JieShaoBean.ResultBean.MovieDirectorBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.jieshao_adapter, parent, false);
        return new JieShaoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  JieShaoHolder){
            Glide.with(context).load(list.get(position).getPhoto()).into(((JieShaoHolder) holder).sView_rec_director);
            //((JieShaoHolder) holder).sView_rec_director.setImageURI(Uri.parse(list.get(position).getPhoto()));
            ((JieShaoHolder) holder).tv_name_rec_director.setText(list.get(position).getName());
       }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class JieShaoHolder extends RecyclerView.ViewHolder{
        //SimpleDraweeView sView_rec_director;
        ImageView sView_rec_director;
        TextView tv_name_rec_director;
        public JieShaoHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_director = itemView.findViewById(R.id.sView_rec_director);
            tv_name_rec_director = itemView.findViewById(R.id.tv_name_rec_director);
        }
    }
  /*  public OnSetClick onSetClick;
    public void getSetClick(OnSetClick onSetClick){
        this.onSetClick= onSetClick;
    }
    public interface OnSetClick{
        void setOnClick(String id);
    }*/
}
