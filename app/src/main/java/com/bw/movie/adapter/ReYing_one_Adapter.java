package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.bw.movie.bean.ReYingBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/14.
 * function：
 */
public class ReYing_one_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ReYingBean.ResultBean> resultBeans;

    public ReYing_one_Adapter(Context context, List<ReYingBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.reying_daapter, parent, false);
        return new ReYingHD(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReYingHD) {
            ((ReYingHD) holder).one_name.setText(resultBeans.get(position).getName());
            Glide.with(context).load(resultBeans.get(position).getImageUrl()).into(((ReYingHD) holder).one_image);
            ((ReYingHD) holder).reying_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String movieId = resultBeans.get(position).getMovieId();
                    onclickItem.setOnClick(movieId);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class ReYingHD extends RecyclerView.ViewHolder {

        private final ImageView one_image;
        private final TextView one_name;
        private final LinearLayout reying_linear;

        public ReYingHD(@NonNull View itemView) {
            super(itemView);
            one_image = itemView.findViewById(R.id.one_image);
            one_name = itemView.findViewById(R.id.one_name);
            reying_linear = itemView.findViewById(R.id.reying_linear);

        }
    }

    public onclickItem onclickItem;

    public void getClick(onclickItem onclickItem) {
        this.onclickItem = onclickItem;
    }

    public interface onclickItem {
        void setOnClick(String movieId);
    }
}
