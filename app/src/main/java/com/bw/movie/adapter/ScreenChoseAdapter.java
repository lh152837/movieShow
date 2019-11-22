package com.bw.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.ChaXunZuoWeiBean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/11/21.
 * function：
 */
public class ScreenChoseAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ChaXunZuoWeiBean.ResultBean>list;

    public ScreenChoseAdapter(Context context, List<ChaXunZuoWeiBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.screen_checkbox_layout, parent, false );
        return new CViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CViewHolder){
            final CViewHolder cViewHolder = (CViewHolder) holder;

            int status = list.get(position).getStatus();
            String row = list.get ( position ).getRow ();
            String seat = list.get ( position ).getSeat ();
            if (status==2){
                cViewHolder.screen_box.setEnabled ( false );
                cViewHolder.screen_box.setBackgroundResource ( R.drawable.screen_checkboxy );
            }

            cViewHolder.screen_box.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    boolean checked = cViewHolder.screen_box.isChecked ();
                    if (checked==true){
                        cViewHolder.screen_box.setBackgroundResource ( R.drawable.screen_checkboxd );
                    }else {
                        cViewHolder.screen_box.setBackgroundResource ( R.drawable.screen_checkbox );
                    }
                }
            } );
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class CViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox screen_box;

        public CViewHolder(@NonNull View itemView) {
            super ( itemView );
            screen_box = itemView.findViewById ( R.id.screen_check );
        }
    }
}
