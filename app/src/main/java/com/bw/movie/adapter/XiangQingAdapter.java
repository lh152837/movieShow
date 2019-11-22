package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangQingBean;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: [Liu He]
 * data: 2019/11/18.
 * function：
 */
public class XiangQingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private XiangQingBean list;

    public XiangQingAdapter(Context context, XiangQingBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xiangqing_layout, parent, false);
        return new XiangQingHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof XiangQingHolder){
            XiangQingBean.ResultBean resultBean = list.getResult();
            Glide.with(context).load(resultBean.getImageUrl()).into(((XiangQingHolder) holder).image_rec_movies);
            ((XiangQingHolder) holder).tv_name_rec_movies.setText(resultBean.getName());
            ((XiangQingHolder) holder).tv_type_rec_movies.setText(resultBean.getMovieType());
            ((XiangQingHolder) holder).tv_duration_rec_movies.setText(resultBean.getDuration());
            ((XiangQingHolder) holder).tv_place_rec_movies.setText(resultBean.getPlaceOrigin()+"上映");
            ((XiangQingHolder) holder).tv_commentNum_rec_movies.setText(resultBean.getCommentNum()+"万条");
            ((XiangQingHolder) holder).tv_score_rec_movies.setText(resultBean.getScore()+"分");
            Date date = new Date(resultBean.getReleaseTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((XiangQingHolder) holder).tv_releaseTime_rec_movies.setText(day);

        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class XiangQingHolder extends RecyclerView.ViewHolder{
        ImageView image_rec_movies;
        TextView tv_name_rec_movies,tv_type_rec_movies,tv_duration_rec_movies,tv_place_rec_movies,tv_commentNum_rec_movies,tv_score_rec_movies,tv_releaseTime_rec_movies;
        public XiangQingHolder(@NonNull View itemView) {
            super(itemView);
            image_rec_movies = itemView.findViewById(R.id.image_rec_movies);
            tv_name_rec_movies = itemView.findViewById(R.id.tv_name_rec_movies);
            tv_type_rec_movies = itemView.findViewById(R.id.tv_type_rec_movies);
            tv_duration_rec_movies = itemView.findViewById(R.id.tv_duration_rec_movies);
            tv_place_rec_movies = itemView.findViewById(R.id.tv_place_rec_movies);
            tv_score_rec_movies = itemView.findViewById(R.id.tv_score_rec_movies);
            tv_commentNum_rec_movies = itemView.findViewById(R.id.tv_commentNum_rec_movies);
            tv_releaseTime_rec_movies = itemView.findViewById(R.id.tv_releaseTime_rec_movies);
        }
    }
/*    public setonItemClick setonItemClick;
    public void getonClick(setonItemClick setonItemClick){
        this.setonItemClick = setonItemClick;
    }
    public interface setonItemClick{
        void setItemClick(String movieid);
    }*/
}
