package com.bw.movie.fragment;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.adapter.ReYingAdapter;
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
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * author: [Liu He]
 * data: 2019/11/12.
 * function：
 */
public class MovieFragment extends BaseFragment<UserPresenter> implements UserContract.UserView {

    public static final String TAG = "MovieFragment";
    @BindView(R.id.xrecycler)
    XRecyclerView xrecycler;


    private List<BannerBean.ResultBean> lunbp;
    private List<ReYingBean.ResultBean> reying;
    private List<JiJiangBean.ResultBean> jijiang;
    private List<ReMenBean.ResultBean> remen;
    private ReYingAdapter reYingAdapter;


    @Override
    protected UserPresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String a = intent.getStringExtra("a");
        String b = intent.getStringExtra("b");
        mPresenter.UserPresenterBanner();
        mPresenter.UserPresenterReYing(1, 8);
        mPresenter.UserPresenterReMen("1", "6");
        mPresenter.UserPresenterJiJiang(b, a, "1", "7");
        xrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
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
        Log.d(TAG, "HomeViewBannerSuccess: " + data.getMessage());
        lunbp = data.getResult();
     /*   xbanner.setBannerData(R.layout.movie_fragment, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int i) {
                return null;
            }

            @Override
            public int size() {
                return result.size();
            }
        });*/

        //xbanner.setBannerData(result);
     /*   xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                SimpleDraweeView simpleDraweeView = view.findViewById(R.id.my_image_view);
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(result.get(position).getImageUrl())
                        .setAutoPlayAnimations(true)
                        .build();
                simpleDraweeView.setController(controller);
            }
        });*/
    }

    @Override
    public void UserViewBannerError(Throwable e) {

    }

    //正在热映展示
    @Override
    public void UserViewReYingSuccess(ReYingBean reYingBean) {
        reying = reYingBean.getResult();

    }

    @Override
    public void UserViewReYingError(Throwable e) {

    }

    //即将上映
    @Override
    public void UserViewJiJiangSuccess(JiJiangBean jiJiangBean) {
        jijiang = jiJiangBean.getResult();
        if (remen != null) {
            reYingAdapter = new ReYingAdapter(getActivity(), lunbp, jijiang, reying, remen);
            xrecycler.setAdapter(reYingAdapter);
        }
    }

    @Override
    public void UserViewJiJiangError(Throwable e) {

    }

    //热门
    @Override
    public void UserViewReMenSuccess(ReMenBean reMenBean) {
        remen = reMenBean.getResult();
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



    @Override
    protected int provideLayoutId() {
        return R.layout.movie_fragment;
    }

}
