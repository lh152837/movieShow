package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.MingXiBean;
import com.bw.movie.bean.QuYuBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/20.
 * function：
 */
public class XuanZuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private Context context;
        private List<QuYuBean.ResultBean>list;

    public XuanZuoAdapter(Context context, List<QuYuBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xuanzuo_adapter, parent, false);
        return new XuanZuoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof XuanZuoHolder){
            ((XuanZuoHolder) holder).xuanzuo_text.setText(list.get(position).getRegionName());
            ((XuanZuoHolder) holder).xuanzuo_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String regionId = list.get(position).getRegionId();
                    setonItemClick.setItemClick(regionId);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class XuanZuoHolder extends RecyclerView.ViewHolder{

        private final TextView xuanzuo_text;
        private final LinearLayout xuanzuo_linear;

        public XuanZuoHolder(@NonNull View itemView) {
            super(itemView);
            xuanzuo_text = itemView.findViewById(R.id.xuanzuo_text);
            xuanzuo_linear = itemView.findViewById(R.id.xuanzuo_linear);
        }
    }
    public setonItemClick setonItemClick;
    public void getOnClick(setonItemClick setonItemClick){
        this.setonItemClick = setonItemClick;
    }
    public interface setonItemClick{
        void setItemClick(String id);
    }
}
