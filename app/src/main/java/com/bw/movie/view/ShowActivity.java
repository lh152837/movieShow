package com.bw.movie.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.bw.movie.R;
import com.bw.movie.fragment.CinemaFragment;
import com.bw.movie.fragment.MovieFragment;
import com.bw.movie.fragment.MyFragment;
import com.bw.mvp_library.base.BaseActivity;
import com.bw.mvp_library.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @describe(描述)：ShowActivity 显示activity
 * @data（日期）: 2019/11/12
 * @time（时间）: 14:35
 * @author（作者）: Liuhe
 **/
public class ShowActivity extends BaseActivity {


    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.text_dianying)
    TextView textDianying;
    @BindView(R.id.radio_dianying)
    RadioButton radioDianying;
    @BindView(R.id.text_yingyuan)
    TextView textYingyuan;
    @BindView(R.id.radio_yingyuan)
    RadioButton radioYingyuan;
    @BindView(R.id.text_wode)
    TextView textWode;
    @BindView(R.id.radio_wode)
    RadioButton radioWode;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private MovieFragment movieFragment;
    private CinemaFragment cinemaFragment;
    private MyFragment myFragment;
    private FragmentManager supportFragmentManager;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_show;
    }

    @Override
    protected void initData() {
        super.initData();
        movieFragment = new MovieFragment();
        cinemaFragment = new CinemaFragment();
        myFragment = new MyFragment();
        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .add(R.id.frame, movieFragment)
                .add(R.id.frame, cinemaFragment)
                .add(R.id.frame, myFragment)
                .show(myFragment)
                .hide(cinemaFragment)
                .hide(myFragment)
                .commit();
    }

    @OnClick({R.id.frame, R.id.text_dianying, R.id.radio_dianying, R.id.text_yingyuan, R.id.radio_yingyuan, R.id.text_wode, R.id.radio_wode, R.id.radio_group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.frame:
                break;
            case R.id.text_dianying:
                break;
            case R.id.radio_dianying:
                radioDianying.setVisibility(View.INVISIBLE);
                radioYingyuan.setVisibility(View.VISIBLE);
                radioWode.setVisibility(View.VISIBLE);
                textDianying.setVisibility(View.VISIBLE);
                textYingyuan.setVisibility(View.INVISIBLE);
                textWode.setVisibility(View.INVISIBLE);
                radioDianying.setChecked(true);
                radioYingyuan.setChecked(false);
                radioWode.setChecked(false);

                supportFragmentManager.beginTransaction()
                        .show(movieFragment)
                        .hide(cinemaFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.text_yingyuan:
                break;
            case R.id.radio_yingyuan:
                radioDianying.setVisibility(View.VISIBLE);
                radioYingyuan.setVisibility(View.INVISIBLE);
                radioWode.setVisibility(View.VISIBLE);

                textYingyuan.setVisibility(View.VISIBLE);
                textDianying.setVisibility(View.INVISIBLE);
                textWode.setVisibility(View.INVISIBLE);

                radioYingyuan.setChecked(true);
                radioDianying.setChecked(false);
                radioWode.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(cinemaFragment)
                        .hide(movieFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.text_wode:
                break;
            case R.id.radio_wode:
                radioDianying.setVisibility(View.VISIBLE);
                radioYingyuan.setVisibility(View.VISIBLE);
                radioWode.setVisibility(View.INVISIBLE);

                textDianying.setVisibility(View.INVISIBLE);
                textYingyuan.setVisibility(View.INVISIBLE);
                textWode.setVisibility(View.VISIBLE);

                radioWode.setChecked(true);
                radioYingyuan.setChecked(false);
                radioDianying.setChecked(false);
                supportFragmentManager.beginTransaction()
                        .show(myFragment)
                        .hide(movieFragment)
                        .hide(cinemaFragment)
                        .commit();
                break;
            case R.id.radio_group:
                break;
        }
    }
}
