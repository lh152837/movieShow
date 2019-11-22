package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.JuZhaoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import retrofit2.http.Url;

/**
 * author: [Liu He]
 * data: 2019/11/19.
 * function：
 */
public class JuZhaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String>list;

    public JuZhaoAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.juzhao_adapter, parent, false);
        return new JuZhaoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof JuZhaoHolder) {
            //((JuZhaoHolder) holder).juzhao_one_image.setImageURI(Uri.parse(result.getShortFilmList().get(position).getImageUrl()));
            Glide.with(context).load(list.get(position)).into(((JuZhaoHolder) holder).juzhao_one_image);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class JuZhaoHolder extends RecyclerView.ViewHolder {

        private ImageView juzhao_one_image;

        public JuZhaoHolder(@NonNull View itemView) {
            super(itemView);
            juzhao_one_image = itemView.findViewById(R.id.juzhao_one_image);
      /*      juzhao_two_image = itemView.findViewById(R.id.juzhao_two_image);
            juzhao_three_image = itemView.findViewById(R.id.juzhao_three_image);
            juzhao_four_image = itemView.findViewById(R.id.juzhao_four_image);*/
        }
    }
}
