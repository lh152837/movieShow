package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.PaiQiLieBiaoBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/21.
 * function：
 */
public class PaiQiLieBiaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<PaiQiLieBiaoBean.ResultBean>list;

    public PaiQiLieBiaoAdapter(Context context, List<PaiQiLieBiaoBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.paiqiliebiao_layout, parent, false);
        return new PaiQiLieBiaoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof PaiQiLieBiaoHolder){
        ((PaiQiLieBiaoHolder) holder).time_jieshu.setText(list.get(position).getEndTime());
        ((PaiQiLieBiaoHolder) holder).time_kaishi.setText(list.get(position).getBeginTime());
        ((PaiQiLieBiaoHolder) holder).paiqiliebiao_name.setText(list.get(position).getScreeningHall());
    }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class PaiQiLieBiaoHolder extends RecyclerView.ViewHolder{

        private final TextView time_kaishi,time_jieshu,paiqiliebiao_name;

        public PaiQiLieBiaoHolder(@NonNull View itemView) {
            super(itemView);
            time_kaishi = itemView.findViewById(R.id.time_kaishi);
            time_jieshu = itemView.findViewById(R.id.time_jieshu);
            paiqiliebiao_name = itemView.findViewById(R.id.paiqiliebiao_name);
        }
    }
}
