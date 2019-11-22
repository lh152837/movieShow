package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.TuiJianAdapter;
import com.bw.movie.adapter.XuanZuoAdapter;
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
import com.bw.movie.presenter.UserPresenter;
import com.bw.mvp_library.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class XuanZuoActivity extends BaseActivity<UserPresenter> implements UserContract.UserView {


    @BindView(R.id.xz_video_play)
    JCVideoPlayerStandard xzVideoPlay;
    @BindView(R.id.xz_tv_name)
    TextView xzTvName;
    @BindView(R.id.xz_tv_time)
    TextView xzTvTime;
    @BindView(R.id.xz_tv_pf)
    TextView xzTvPf;
    @BindView(R.id.xz_tv_dy)
    TextView xzTvDy;
    @BindView(R.id.xz_tv_address)
    TextView xzTvAddress;
    @BindView(R.id.xz_tv_day)
    TextView xzTvDay;
    @BindView(R.id.xz_tv_price)
    TextView xzTvPrice;
    @BindView(R.id.xz_recycler_address)
    RecyclerView xzRecyclerAddress;
    @BindView(R.id.xz_recycler)
    RecyclerView xzRecycler;
    private String id1;
    private String moviewId;

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_xuan_zuo;
    }


    //嘻嘻嘻嘻
    @Override
    protected void initData() {

        super.initData();
        presenter.UserPresenterMingXi("157425413842113692", "13692", "5");
        moviewId = getIntent().getStringExtra("moviewId");
        presenter.UserPresenterXiangQing("157425413842113692", "13692", moviewId);
        Intent intent = getIntent();
        id1 = intent.getStringExtra("id");
        presenter.UserPresenterTuijian("157430802139713692", "13692", "1", "5");
        presenter.UserPresenterQuYu();
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
        List<TuiJianBean.ResultBean> result = tuiJianBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xzRecyclerAddress.setLayoutManager(linearLayoutManager);
        //设置适配器
        TuiJianAdapter tuiJianAdapter = new TuiJianAdapter(this, result);
        xzRecyclerAddress.setAdapter(tuiJianAdapter);


        tuiJianAdapter.getOnClick(new TuiJianAdapter.setOnItemClick() {
            @Override
            public void setItem(String id) {
                Intent intent = new Intent(XuanZuoActivity.this, ZuoWeiActivity.class);
                intent.putExtra("id", moviewId);
                startActivity(intent);

            }
        });


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
        String name = xiangQingBean.getResult().getName();
        String score = xiangQingBean.getResult().getScore();
        String direct = xiangQingBean.getResult().getMovieDirector().get(0).getName();
        String duration = xiangQingBean.getResult().getDuration();
        String imageUrl = xiangQingBean.getResult().getShortFilmList().get(0).getImageUrl();
        String videoUrl = xiangQingBean.getResult().getShortFilmList().get(0).getVideoUrl();
        xzTvName.setText(name);
        xzTvTime.setText(duration + "分钟");
        xzTvPf.setText(score + "评分");
        xzTvDy.setText(direct);
        xzVideoPlay.setUp(videoUrl, JCVideoPlayer.SCREEN_LAYOUT_NORMAL, name);
        Glide.with(this).load(imageUrl).into(xzVideoPlay.thumbImageView);

 /*
        //传递值
        movieId = xiangQingBean.getResult().getMovieId();
        EventBus.getDefault().postSticky(movieId);*/
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
        List<QuYuBean.ResultBean> result = quYuBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xzRecycler.setLayoutManager(linearLayoutManager);
        //设置适配器
        XuanZuoAdapter xuanZuoAdapter = new XuanZuoAdapter(this, result);
        xzRecycler.setAdapter(xuanZuoAdapter);
        xuanZuoAdapter.getOnClick(new XuanZuoAdapter.setonItemClick() {
            @Override
            public void setItemClick(String id) {

                presenter.UserPresenterTuijian(id1, id, "1", "5");
                xzRecycler.setVisibility(View.INVISIBLE);

            }
        });
        xuanZuoAdapter.notifyDataSetChanged();

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




    @OnClick({R.id.xz_video_play, R.id.xz_tv_name, R.id.xz_tv_time, R.id.xz_tv_pf, R.id.xz_tv_dy, R.id.xz_tv_address, R.id.xz_tv_day, R.id.xz_tv_price, R.id.xz_recycler_address, R.id.xz_recycler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xz_video_play:
                break;
            case R.id.xz_tv_name:
                break;
            case R.id.xz_tv_time:
                break;
            case R.id.xz_tv_pf:
                break;
            case R.id.xz_tv_dy:
                break;
            case R.id.xz_tv_address:
                xzRecycler.setVisibility(View.VISIBLE);
                break;
            case R.id.xz_tv_day:
                break;
            case R.id.xz_tv_price:
                break;
            case R.id.xz_recycler_address:
                break;
            case R.id.xz_recycler:
                break;
        }
    }
}
