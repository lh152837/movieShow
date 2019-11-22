package com.bw.movie.fragment;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.YuBaoAdapter;
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
import com.bw.mvp_library.base.BaseFragment;

import butterknife.BindView;

/**
 * author: [Liu He]
 * data: 2019/11/18.
 * function：
 */
public class YuGaoFragment extends BaseFragment<UserPresenter> implements UserContract.UserView {
    @BindView(R.id.yubao_recycler)
    RecyclerView yubaoRecycler;

    @Override
    protected UserPresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.yugao_layout;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        mPresenter.UserPresenterYuBao("15741517482529734", "9734", id);
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
        String message = yuBaoBean.getMessage();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yubaoRecycler.setLayoutManager(linearLayoutManager);
        //设置适配器
        YuBaoAdapter yuBaoAdapter = new YuBaoAdapter(getActivity(), yuBaoBean);
        yubaoRecycler.setAdapter(yuBaoAdapter);


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


}
