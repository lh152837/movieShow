package com.bw.movie.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.mvp_library.base.BaseActivity;
import com.bw.mvp_library.base.BasePresenter;

public class MainActivity extends BaseActivity {

    private int count=3;
    private TextView tv;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage( Message msg) {
            super.handleMessage(msg);
            if (count<0){
                startActivity(new Intent(MainActivity.this, MovieActivity.class));
                finish();
            }else {
                tv.setText(count+"S");
                count--;
                handler.sendEmptyMessageDelayed(99, 1000);
            }
        }
    };
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        tv = findViewById(R.id.tv);
        handler.sendEmptyMessageDelayed(99, 1000);
    }
}
