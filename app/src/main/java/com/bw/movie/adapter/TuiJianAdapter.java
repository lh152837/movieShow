package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.TuiJianBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/15.
 * function：
 */
public class TuiJianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<TuiJianBean.ResultBean>resultBeans;

    public TuiJianAdapter(Context context, List<TuiJianBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yuijian_layout, parent, false);
        return new TuiJian_Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TuiJian_Holder){
            ((TuiJian_Holder) holder).tuijian_dizhi.setText(resultBeans.get(position).getAddress());
            ((TuiJian_Holder) holder).tuijian_juli.setText(resultBeans.get(position).getId());
            ((TuiJian_Holder) holder).tuijian_yingyuan.setText(resultBeans.get(position).getName());
            Glide.with(context).load(resultBeans.get(position).getLogo()).into(((TuiJian_Holder) holder).tuijian_image);
            ((TuiJian_Holder) holder).tuijian_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String id = resultBeans.get(position).getId();
                    setOnItemClick.setItem(id);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }
    public class TuiJian_Holder extends RecyclerView.ViewHolder{

        private final ImageView tuijian_image;
        private final TextView tuijian_dizhi,tuijian_juli,tuijian_yingyuan;
        private final RelativeLayout tuijian_linear;

        public TuiJian_Holder(@NonNull View itemView) {
            super(itemView);
            tuijian_image = itemView.findViewById(R.id.tuijian_image);
            tuijian_dizhi = itemView.findViewById(R.id.tuijian_dizhi);
            tuijian_juli = itemView.findViewById(R.id.tuijian_juli);
            tuijian_yingyuan = itemView.findViewById(R.id.tuijian_yingyuan);
            tuijian_linear = itemView.findViewById(R.id.tuijian_linear);
        }
    }
    public setOnItemClick setOnItemClick;
    public void getOnClick(setOnItemClick setOnItemClick){
        this.setOnItemClick = setOnItemClick;
    }
    public  interface setOnItemClick{
        void setItem(String id);
    }

}
