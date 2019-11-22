package com.bw.movie.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.PaiQiLieBiaoAdapter;
import com.bw.movie.adapter.ScreenChoseAdapter;
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
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ZuoWeiActivity extends BaseActivity<UserPresenter> implements UserContract.UserView {

    @BindView(R.id.zuo_name)
    TextView zuoName;
    @BindView(R.id.zuo_pin)
    JCVideoPlayerStandard zuoPin;
    @BindView(R.id.zuo_xuan)
    RecyclerView zuoXuan;
    @BindView(R.id.zuo_ying)
    TextView zuoYing;
    @BindView(R.id.zuo_recy_ying)
    RecyclerView zuoRecyYing;
    @BindView(R.id.zuo_jia)
    TextView zuoJia;

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_zuo_wei;
    }


    @Override
    protected void initData() {
        super.initData();
        //String id = getIntent().getStringExtra("id");
        presenter.UserPresenterPaiQiLieBiao("9","16");

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void modelss(String movieId){
        presenter.UserPresenterXiangQing("157430802139713692","13692",movieId);
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
        String name = xiangQingBean.getResult().getName();
        String imageUrl = xiangQingBean.getResult().getShortFilmList().get(1).getImageUrl();
        String videoUrl = xiangQingBean.getResult().getShortFilmList().get(1).getVideoUrl();
        zuoPin.setUp(videoUrl,JCVideoPlayer.SCREEN_LAYOUT_NORMAL,name);
        Glide.with(this).load(imageUrl).into(zuoPin.thumbImageView);
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
        List<PaiQiLieBiaoBean.ResultBean> result = paiQiLieBiaoBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        zuoRecyYing.setLayoutManager(linearLayoutManager);
        //设置适配器
        PaiQiLieBiaoAdapter paiQiLieBiaoAdapter = new PaiQiLieBiaoAdapter(this, result);
        zuoRecyYing.setAdapter(paiQiLieBiaoAdapter);

    }

    @Override
    public void UserViewPaiQiLieBiaoError(String e) {

    }

    @Override
    public void UserViewChaXunZuoWeiSuccess(ChaXunZuoWeiBean chaXunZuoWeiBean) {
        List<ChaXunZuoWeiBean.ResultBean> result = chaXunZuoWeiBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ZuoWeiActivity.this);
        zuoXuan.setLayoutManager(linearLayoutManager);
        ScreenChoseAdapter screenChoseAdapter = new ScreenChoseAdapter(this, result);
        zuoXuan.setAdapter(screenChoseAdapter);
    }

    @Override
    public void UserViewChaXunZuoWeiError(String e) {

    }
    @OnClick({R.id.zuo_name, R.id.zuo_pin, R.id.zuo_xuan, R.id.zuo_ying, R.id.zuo_recy_ying, R.id.zuo_jia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zuo_name:
                break;
            case R.id.zuo_pin:
                break;
            case R.id.zuo_xuan:
                break;
            case R.id.zuo_ying:
                break;
            case R.id.zuo_recy_ying:
                break;
            case R.id.zuo_jia:
                break;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
