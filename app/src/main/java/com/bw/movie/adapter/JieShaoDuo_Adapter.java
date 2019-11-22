package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.JieShaoBean;

/**
 * author: [Liu He]
 * data: 2019/11/19.
 * function：
 */
public class JieShaoDuo_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private JieShaoBean.ResultBean resultBean;
    private Context context;

    public JieShaoDuo_Adapter(JieShaoBean.ResultBean resultBean, Context context) {
        this.resultBean = resultBean;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.jianjie_layout, parent, false);
            return new JianJieViewHolder(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.yanzhi_layout, parent, false);
            return new YanZhiViewHolder(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.yanyuan, parent, false);
            return new YanYuanViewHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                if (holder instanceof JianJieViewHolder) {
                    ((JianJieViewHolder) holder).tv_summary.setText(resultBean.getSummary());
                }
                break;
            case 1:
                if (holder instanceof YanZhiViewHolder) {
                    JieShaoAdapter jieShaoAdapter = new JieShaoAdapter(context, resultBean.getMovieDirector());
                        ((YanZhiViewHolder) holder).rec_home_movies_js_director.setAdapter(jieShaoAdapter);
                }
                break;
            case 2:
                if (holder instanceof YanYuanViewHolder) {
                    JieShao_one_Adapter jieShao_one_adapter = new JieShao_one_Adapter(context, resultBean.getMovieActor());
                    ((YanYuanViewHolder) holder).rec_home_movies_js_performer.setAdapter(jieShao_one_adapter);
                }
                break;
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }

    public class JianJieViewHolder extends RecyclerView.ViewHolder {
        TextView tv_summary;

        public JianJieViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_summary = itemView.findViewById(R.id.tv_summary);
        }
    }

    public class YanZhiViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_home_movies_js_director;

        public YanZhiViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_home_movies_js_director = itemView.findViewById(R.id.rec_home_movies_js_director);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            rec_home_movies_js_director.setLayoutManager(linearLayoutManager);
        }
    }

    public class YanYuanViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_home_movies_js_performer;

        public YanYuanViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_home_movies_js_performer = itemView.findViewById(R.id.rec_home_movies_js_performer);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
            rec_home_movies_js_performer.setLayoutManager(gridLayoutManager);
        }
    }


}
