package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.adapter.XiangQingAdapter;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.ChaXunZuoWeiBean;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.FuJinBean;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.JieShaoBean;
import com.bw.movie.bean.JuZhaoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MingXiBean;
import com.bw.movie.bean.PaiQiLieBiaoBean;
import com.bw.movie.bean.QuYuBean;
import com.bw.movie.bean.ReMenBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.bean.TuiJianBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YuBaoBean;
import com.bw.movie.contract.UserContract;
import com.bw.movie.fragment.JieShaoFragment;
import com.bw.movie.fragment.JuZhaoFragment;
import com.bw.movie.fragment.YingPingFragment;
import com.bw.movie.fragment.YuGaoFragment;
import com.bw.movie.presenter.UserPresenter;
import com.bw.mvp_library.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangQiongActivity extends BaseActivity<UserPresenter> implements UserContract.UserView {


    @BindView(R.id.rec_movies)
    RecyclerView recMovies;
    @BindView(R.id.liner_up)
    LinearLayout linerUp;
    @BindView(R.id.tab_layout_movies)
    TabLayout tabLayoutMovies;
    @BindView(R.id.view_pager_movies)
    ViewPager viewPagerMovies;
    @BindView(R.id.xuanzuo)
    Button xuanzuo;
    private ArrayList<Fragment> fragments;


    @Override
    protected void initData() {
        super.initData();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        presenter.UserPresenterXiangQing("15741517482529734", "9734", id);
        presenter.UserPresenterXiangQing("15741517482529734", "9734", id);

        //添加fragmet
        fragments = new ArrayList<>();
        fragments.add(new JieShaoFragment());
        fragments.add(new YuGaoFragment());
        fragments.add(new JuZhaoFragment());
        fragments.add(new YingPingFragment());
        //添加文字
        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        };
        viewPagerMovies.setAdapter(fragmentStatePagerAdapter);
        tabLayoutMovies.setupWithViewPager(viewPagerMovies);
        tabLayoutMovies.getTabAt(0).setText("介绍");
        tabLayoutMovies.getTabAt(1).setText("预告");
        tabLayoutMovies.getTabAt(2).setText("剧照");
        tabLayoutMovies.getTabAt(3).setText("影评");
        //选择跳转


    }

    @Override
    protected UserPresenter initPresenter() {

        return new UserPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_xiang_qiong;
    }

    @Override
    public void UserViewLoginSuccess(LoginBean data) {

    }

    @Override
    public void UserViewLoginError(Throwable e) {

    }

    @Override
    public void UserViewRegisterSuccess(RegisterBean data) {

    }

    @Override
    public void UserViewRegisterError(Throwable e) {

    }

    @Override
    public void UserViewEmailSuccess(EmailBean data) {

    }

    @Override
    public void UserViewEmailError(Throwable e) {

    }

    @Override
    public void UserViewBannerSuccess(BannerBean data) {

    }

    @Override
    public void UserViewBannerError(Throwable e) {

    }

    @Override
    public void UserViewReYingSuccess(ReYingBean reYingBean) {

    }

    @Override
    public void UserViewReYingError(Throwable e) {

    }

    @Override
    public void UserViewJiJiangSuccess(JiJiangBean jiJiangBean) {

    }

    @Override
    public void UserViewJiJiangError(Throwable e) {

    }

    @Override
    public void UserViewReMenSuccess(ReMenBean reMenBean) {

    }

    @Override
    public void UserViewReMenError(Throwable e) {

    }

    @Override
    public void UserViewTuiJianSuccess(TuiJianBean tuiJianBean) {

    }

    @Override
    public void UserViewTuiJianError(Throwable e) {

    }

    @Override
    public void UserViewFuJinSuccess(FuJinBean fuJinBean) {

    }

    @Override
    public void UserViewFuJinError(Throwable e) {

    }

    @Override
    public void UserViewXiangQingSuccess(XiangQingBean xiangQingBean) {
        String movieId = xiangQingBean.getResult().getMovieId();
        //选择跳转
        xuanzuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(XiangQiongActivity.this, XuanZuoActivity.class);
                intent1.putExtra("moviewId", movieId);
                EventBus.getDefault().postSticky(movieId);
                startActivity(intent1);
            }
        });
        //设置适配器
        XiangQingAdapter xiangQingAdapter = new XiangQingAdapter(context(), xiangQingBean);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recMovies.setLayoutManager(linearLayoutManager);
        recMovies.setAdapter(xiangQingAdapter);
    }

    @Override
    public void UserViewXiangQingError(String e) {

    }

    @Override
    public void UserViewJieShaoSuccess(JieShaoBean jieShaoBean) {

    }

    @Override
    public void UserViewJieShaoError(String e) {

    }

    @Override
    public void UserViewJuZhaoSuccess(JuZhaoBean juZhaoBean) {

    }

    @Override
    public void UserViewJuZhaoError(String e) {

    }

    @Override
    public void UserViewYuBaoSuccess(YuBaoBean yuBaoBean) {

    }

    @Override
    public void UserViewYuBaoError(String e) {

    }

    @Override
    public void UserViewYingPingSuccess(YingPingBean yingPingBean) {

    }

    @Override
    public void UserViewYingPingError(String e) {

    }

    @Override
    public void UserViewPaiQiSuccess(ScheduleBean scheduleBean) {

    }

    @Override
    public void UserViewPaiQiError(String e) {

    }

    @Override
    public void UserViewTimeSuccess(TimeBean timeBean) {

    }

    @Override
    public void UserViewTimeError(String e) {

    }

    @Override
    public void UserViewMingXiSuccess(MingXiBean mingXiBean) {
    }

    @Override
    public void UserViewMingXiErroe(String e) {

    }

    @Override
    public void UserViewQuYuSuccess(QuYuBean quYuBean) {

    }

    @Override
    public void UserViewQuYuError(String e) {

    }

    @Override
    public void UserViewPaiQiLieBiaoSuccess(PaiQiLieBiaoBean paiQiLieBiaoBean) {

    }

    @Override
    public void UserViewPaiQiLieBiaoError(String e) {

    }

    @Override
    public void UserViewChaXunZuoWeiSuccess(ChaXunZuoWeiBean chaXunZuoWeiBean) {

    }

    @Override
    public void UserViewChaXunZuoWeiError(String e) {

    }




    @OnClick({R.id.rec_movies, R.id.liner_up, R.id.tab_layout_movies, R.id.view_pager_movies})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rec_movies:
                break;
            case R.id.liner_up:
                break;
            case R.id.tab_layout_movies:
                break;
            case R.id.view_pager_movies:
                break;
        }
    }
}
