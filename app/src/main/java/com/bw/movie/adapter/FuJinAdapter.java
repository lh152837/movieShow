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
import com.bw.movie.bean.FuJinBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/15.
 * function：
 */
public class FuJinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FuJinBean.ResultBean> resultBeans;

    public FuJinAdapter(Context context, List<FuJinBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fujin_adapter, parent, false);
        return new FuJin_Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FuJin_Holder) {
            ((FuJin_Holder) holder).fujin_dizhi.setText(resultBeans.get(position).getAddress());
            ((FuJin_Holder) holder).fujin_juli.setText(resultBeans.get(position).getDistance());
            ((FuJin_Holder) holder).fujin_yingyuan.setText(resultBeans.get(position).getId());
            Glide.with(context).load(resultBeans.get(position).getLogo()).into(((FuJin_Holder) holder).fujin_image);
        }

    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class FuJin_Holder extends RecyclerView.ViewHolder {

        private final TextView fujin_dizhi, fujin_juli, fujin_yingyuan;
        private final ImageView fujin_image;

        public FuJin_Holder(@NonNull View itemView) {
            super(itemView);
            fujin_dizhi = itemView.findViewById(R.id.fujin_dizhi);
            fujin_yingyuan = itemView.findViewById(R.id.fujin_yingyuan);
            fujin_juli = itemView.findViewById(R.id.fujin_juli);
            fujin_image = itemView.findViewById(R.id.fujin_image);

        }
    }
}

