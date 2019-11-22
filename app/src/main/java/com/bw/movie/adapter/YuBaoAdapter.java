package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.YuBaoBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import retrofit2.http.PATCH;

/**
 * author: [Liu He]
 * data: 2019/11/19.
 * function：
 */
public class YuBaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private YuBaoBean yuBaoBean;

    public YuBaoAdapter(Context context, YuBaoBean yuBaoBean) {
        this.context = context;
        this.yuBaoBean = yuBaoBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yubao_layout, parent, false);
        return new YuBaoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof YuBaoHolder){
            ((YuBaoHolder) holder).jcv_ideo.setUp(yuBaoBean.getResult().getShortFilmList().get(position).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
            Glide.with(context).load(yuBaoBean.getResult().getMovieId()).into(((YuBaoHolder) holder).jcv_ideo.coverImageView);
        }

    }

    @Override
    public int getItemCount() {
        return yuBaoBean.getResult().getShortFilmList().size();
    }
    public class YuBaoHolder extends RecyclerView.ViewHolder{

        private final JCVideoPlayerStandard jcv_ideo;

        public YuBaoHolder(@NonNull View itemView) {
            super(itemView);
            jcv_ideo = itemView.findViewById(R.id.jcv_ideo);
        }
    }
}
