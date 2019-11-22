package com.bw.movie.adapter;

import android.content.Context;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/13.
 * function：
 */
public class JiJiangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<JiJiangBean.ResultBean> list;

    public JiJiangAdapter(Context context, List<JiJiangBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.jijiang_adapter, parent, false);
        return new JiJiang_Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof JiJiang_Holder){
            ((JiJiang_Holder) holder).jijiang_name.setText(list.get(position).getName());
            Date date = new Date(list.get(position).getReleaseTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((JiJiang_Holder) holder).jijiang_shangying.setText(day);
            ((JiJiang_Holder) holder).jijiang_xiangkan.setText(list.get(position).getWantSeeNum());
            Glide.with(context).load(list.get(position).getImageUrl()).into(((JiJiang_Holder) holder).jijiang_image);
            ((JiJiang_Holder) holder).jijiang_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String movieId = list.get(position).getMovieId();
                    setonItemClick.onItemClick(movieId);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class JiJiang_Holder extends RecyclerView.ViewHolder {

        private final TextView jijiang_name, jijiang_shangying, jijiang_xiangkan;
        private final ImageView jijiang_image;
        private final LinearLayout jijiang_linear;

        public JiJiang_Holder(@NonNull View itemView) {
            super(itemView);
            jijiang_image = itemView.findViewById(R.id.jijiang_image);
            jijiang_name = itemView.findViewById(R.id.jijiang_name);
            jijiang_shangying = itemView.findViewById(R.id.jijiang_shangying);
            jijiang_xiangkan = itemView.findViewById(R.id.jijiang_xiangkan);
            jijiang_linear = itemView.findViewById(R.id.jijiang_linear);

        }
    }
    public setonItemClick setonItemClick;
    public void getOnItemClick(setonItemClick setonItemClick){
        this.setonItemClick= setonItemClick;
    }
    public interface setonItemClick{
        void onItemClick(String id);
    }
}
