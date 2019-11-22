package com.bw.movie.fragment;

import com.bw.movie.R;
import com.bw.movie.presenter.UserPresenter;
import com.bw.mvp_library.base.BaseFragment;
import com.bw.mvp_library.base.BasePresenter;

/**
 * author: [Liu He]
 * data: 2019/11/12.
 * function：
 */
public class MyFragment extends BaseFragment {
    @Override
    protected BasePresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.my_fragment;
    }
}
