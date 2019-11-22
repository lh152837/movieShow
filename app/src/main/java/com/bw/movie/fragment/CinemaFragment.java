package com.bw.movie.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.presenter.UserPresenter;
import com.bw.mvp_library.base.BaseFragment;
import com.bw.mvp_library.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: [Liu He]
 * data: 2019/11/12.
 * function：
 */
public class CinemaFragment extends BaseFragment {
    @BindView(R.id.tables)
    TabLayout tables;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;

    @Override
    protected BasePresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        //添加页面
        fragments = new ArrayList<>();
        fragments.add(new TuiJianFragment());
        fragments.add(new FuJinFragment());
        fragments.add(new HaiDianFragment());
        //添加文字
        strings = new ArrayList<>();
        strings.add("推荐影院");
        strings.add("附近影院");
        strings.add("海淀区");
        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        tables.setupWithViewPager(vp);

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.cinema_fragment;
    }

    @OnClick({R.id.tables, R.id.vp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tables:
                break;
            case R.id.vp:
                break;
        }
    }
}
