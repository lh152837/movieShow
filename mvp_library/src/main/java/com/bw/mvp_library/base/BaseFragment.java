package com.bw.mvp_library.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.mvp_library.ap.App;
import com.bw.mvp_library.util.NetUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 声明规范和使用规范同BaseActivity
 * {@link BaseActivity}
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    protected P mPresenter;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(provideLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = providePresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract P providePresenter();

    protected void initData() {
    }

    protected void initView() {
    }

    protected abstract int provideLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    public boolean hasNetwork() {
        return NetUtil.hasNetwork(context());
    }

    public void showNoNetTip() {
        Toast.makeText(context(), "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext() == null ? App.getAppContext() : getContext();
    }
}
