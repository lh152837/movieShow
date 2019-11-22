package com.bw.mvp_library.base;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.mvp_library.util.NetUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * describe:BaseActivity
 * date:2019/11/5
 * author:任(Lenovo)
 * function:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private Unbinder unbinder;
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        unbinder = ButterKnife.bind(this);
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected void initData(){};

    protected void initView(){};

    protected abstract P initPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (presenter!=null) {
            presenter.detachView();
        }
    }
    public boolean hasNetWork(){
        return NetUtil.hasNetwork(this);
    }
    public void showNoNetTip(){
        Toast.makeText(this, "无网", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context(){
        return this;
    }
}
