package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.ReMenBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.view.XiangQiongActivity;
import com.stx.xhb.xbanner.XBanner;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/13.
 * function：
 */
public class ReYingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BannerBean.ResultBean> bannerBeans;
    private List<JiJiangBean.ResultBean> jijiang;
    private List<ReYingBean.ResultBean> reying;
    private List<ReMenBean.ResultBean> remen;

    public ReYingAdapter(Context context, List<BannerBean.ResultBean> bannerBeans, List<JiJiangBean.ResultBean> jijiang, List<ReYingBean.ResultBean> reying, List<ReMenBean.ResultBean> remen) {
        this.context = context;
        this.bannerBeans = bannerBeans;
        this.jijiang = jijiang;
        this.reying = reying;
        this.remen = remen;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.four_recycler, parent, false);
            return new myFourHolder(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.one_recycler, parent, false);
            return new myOneHolder(inflate);

        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two_recycler, parent, false);
            return new myTwoHolder(inflate);

        } else if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three_recycler, parent, false);
            return new myThreeHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                if (holder instanceof myFourHolder) {
                    ((myFourHolder) holder).xbanners.setData(bannerBeans, null);
                    ((myFourHolder) holder).xbanners.setmAdapter(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, Object model, View view, int position) {
                            Glide.with(context).load(bannerBeans.get(position).getImageUrl()).into((ImageView) view);
                        }
                    });
                }
                break;
            case 1:
                if (holder instanceof myOneHolder) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                    ((myOneHolder) holder).one_re.setLayoutManager(linearLayoutManager);
                    ReYing_one_Adapter reYing_one_adapter = new ReYing_one_Adapter(context, reying);
                    ((myOneHolder) holder).one_re.setAdapter(reYing_one_adapter);
                    reYing_one_adapter.getClick(new ReYing_one_Adapter.onclickItem() {
                        @Override
                        public void setOnClick(String id) {
                               /* SharedPreferences sp = context.getSharedPreferences("dong", Context.MODE_PRIVATE);
                                SharedPreferences.Editor edit = sp.edit();
                                edit.putString("id",id);
                                edit.commit();*/
                            //跳转到详情页面

                            Intent intent = new Intent(context, XiangQiongActivity.class);
                            intent.putExtra("id",id);
                            context.startActivity(intent);
                           // EventBus.getDefault().postSticky(id);
                        }
                    });
                }
                break;
            case 2:
                if (holder instanceof myTwoHolder) {
                    ((myTwoHolder) holder).two_re.setLayoutManager(new LinearLayoutManager(context));
                    JiJiangAdapter jiJiangAdapter = new JiJiangAdapter(context, jijiang);
                    ((myTwoHolder) holder).two_re.setAdapter(jiJiangAdapter);
                    //跳转j
                    jiJiangAdapter.getOnItemClick(new JiJiangAdapter.setonItemClick() {
                        @Override
                        public void onItemClick(String id) {
                            Intent intent = new Intent(context, XiangQiongActivity.class);
                            intent.putExtra("id",id);
                            context.startActivity(intent);
                        }
                    });


                }
                break;
            case 3:
                if (holder instanceof myThreeHolder) {
                    ((myThreeHolder) holder).three_re.setLayoutManager(new LinearLayoutManager(context));
                    ReMenAdapter reMenAdapter = new ReMenAdapter(context, remen);
                    ((myThreeHolder) holder).three_re.setAdapter(reMenAdapter);
                    reMenAdapter.getOnClick(new ReMenAdapter.setonClick() {
                        @Override
                        public void setClick(String id) {
                            Intent intent = new Intent(context, XiangQiongActivity.class);
                            intent.putExtra("id",id);
                            context.startActivity(intent);
                        }
                    });
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class myOneHolder extends RecyclerView.ViewHolder {

        private final RecyclerView one_re;

        public myOneHolder(@NonNull View itemView) {
            super(itemView);
            one_re = itemView.findViewById(R.id.one_re);
        }
    }

    public class myTwoHolder extends RecyclerView.ViewHolder {

        private final RecyclerView two_re;

        public myTwoHolder(@NonNull View itemView) {
            super(itemView);
            two_re = itemView.findViewById(R.id.two_re);
        }
    }

    public class myThreeHolder extends RecyclerView.ViewHolder {

        private final RecyclerView three_re;

        public myThreeHolder(@NonNull View itemView) {
            super(itemView);
            three_re = itemView.findViewById(R.id.three_re);
        }
    }

    public class myFourHolder extends RecyclerView.ViewHolder {

        private final XBanner xbanners;

        public myFourHolder(@NonNull View itemView) {
            super(itemView);
            xbanners = itemView.findViewById(R.id.xbanners);
        }
    }

}
