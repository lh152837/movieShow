package com.bw.movie.model;

import android.util.Log;

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
import com.bw.movie.utils.RetrofitHttp;
import com.bw.mvp_library.util.CommonObserver;
import com.bw.mvp_library.util.CommonSchedulers;
import com.bw.mvp_library.util.Logger;

/**
 * author: [Liu He]
 * data: 2019/11/11.
 * function：
 */
public class UserModel implements UserContract.UserModel {
    public static final String TAG = "UserModel";

    //登录
    @Override
    public void UserModelLoginData(String email, String pwd, final UserModelLoginCallBack userModelLoginCallBack) {
        RetrofitHttp.getApiServer()
                .login(email, pwd)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        Logger.d("loginBean", "lo");
                        userModelLoginCallBack.UserViewLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelLoginCallBack.UserViewLoginError(e);
                    }
                });
    }

    //注册
    @Override
    public void UserModelRegisterData(String nickName, String pwd, String email, String code, final UserModelRegisterCallBack userModelRegisterCallBack) {
        RetrofitHttp.getApiServer().register(nickName, pwd, email, code)
                .compose(CommonSchedulers.<RegisterBean>io2main())
                .subscribe(new CommonObserver<RegisterBean>() {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        Logger.d("registerBean", "re");
                        userModelRegisterCallBack.UserViewRegisterSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelRegisterCallBack.UserViewRegisterError(e);
                    }
                });
    }

    //邮箱验证码
    @Override
    public void UserModelEmailData(String email, final UserModelEmailCallBack userModelEmailCallBack) {
        RetrofitHttp.getApiServer().email(email)
                .compose(CommonSchedulers.<EmailBean>io2main())
                .subscribe(new CommonObserver<EmailBean>() {
                    @Override
                    public void onNext(EmailBean emailBean) {
                        Log.d(TAG, "onNext: " + emailBean);
                        userModelEmailCallBack.UserViewEmailSuccess(emailBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelEmailCallBack.UserViewEmailError(e);
                    }
                });
    }

    //轮播图
    @Override
    public void HomebannerModel(UserModelBannerCallBack userModelBannerCallBack) {
        RetrofitHttp.getApiServer().banner()
                .compose(CommonSchedulers.<BannerBean>io2main())
                .subscribe(new CommonObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        Log.d(TAG, "onNext: " + bannerBean.getResult());
                        userModelBannerCallBack.UserViewBannerSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelBannerCallBack.UserViewBannerError(e);
                    }
                });
    }

    //热映电影
    @Override
    public void UserModelReYingData(int page, int count, UserModelReYingCallBack userModelReYingCallBack) {
        RetrofitHttp.getApiServer().reying(page, count)
                .compose(CommonSchedulers.<ReYingBean>io2main())
                .subscribe(new CommonObserver<ReYingBean>() {
                    @Override
                    public void onNext(ReYingBean reYingBean) {
                        userModelReYingCallBack.UserViewReYingSuccess(reYingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelReYingCallBack.UserViewReYingError(e);
                    }
                })

        ;
    }

    //即将上映
    @Override
    public void UserModelJiJiangData(String sessionId, String userId, String page, String count, UserModelJiJiangCallBack userModelJiJiangCallBack) {
        RetrofitHttp.getApiServer()
                .jijiang(sessionId, userId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<JiJiangBean>() {
                    @Override
                    public void onNext(JiJiangBean jiJiangBean) {
                        userModelJiJiangCallBack.UserViewJiJiangSuccess(jiJiangBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelJiJiangCallBack.UserViewJiJiangError(e);
                    }
                });
    }

    //热门电影
    @Override
    public void UserModelReMenData(String page, String count, UserModelReMenCallBack userModelReMenCallBack) {
        RetrofitHttp.getApiServer().remen(page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ReMenBean>() {
                    @Override
                    public void onNext(ReMenBean reMenBean) {
                        userModelReMenCallBack.UserViewReMenSuccess(reMenBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelReMenCallBack.UserViewReMenError(e);
                    }
                });
    }

    //推荐影院
    @Override
    public void UserModelTuiJianData(String sessionId, String userId, String page, String count, UserModelTuiJianCallBack userModelTuiJianCallBack) {
        RetrofitHttp.getApiServer().tuijian(userId, sessionId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<TuiJianBean>() {
                    @Override
                    public void onNext(TuiJianBean tuiJianBean) {
                        userModelTuiJianCallBack.UserViewTuiJianSuccess(tuiJianBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelTuiJianCallBack.UserViewTuiJianError(e);
                    }
                });
    }

    //附近影院
    @Override
    public void UserModelFuJinData(String longitude, String latitude, String page, String count, UserModelFuJinCallBack userModelFuJinCallBack) {
        RetrofitHttp.getApiServer().fujin(longitude, latitude, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FuJinBean>() {
                    @Override
                    public void onNext(FuJinBean fuJinBean) {
                        userModelFuJinCallBack.UserViewFuJinSuccess(fuJinBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelFuJinCallBack.UserViewFuJinError(e);
                    }
                });
    }

    //电影详情
    @Override
    public void UserModelXiangQing(String sessionId, String userId, String movieId, UserModelXiangQingCallBack userModelXiangQingCallBack) {
        RetrofitHttp.getApiServer().xiangqing(sessionId, userId, movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<XiangQingBean>() {
                    @Override
                    public void onNext(XiangQingBean xiangQingBean) {
                        Log.d(TAG, "onNext: " + xiangQingBean);
                        userModelXiangQingCallBack.UserViewXiangQingSuccess(xiangQingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelXiangQingCallBack.UserViewXiangQingError(e.getMessage());
                    }
                });
    }

    //电影介绍
    @Override
    public void UserModelJieShaoData(String sessionId, String userId, String movieId, UserModelJieShaoCallBack userModelJieShaoCallBack) {
        RetrofitHttp.getApiServer().jieshao(sessionId, userId, movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<JieShaoBean>() {
                    @Override
                    public void onNext(JieShaoBean jieShaoBean) {
                        userModelJieShaoCallBack.UserViewJieShaoSuccess(jieShaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelJieShaoCallBack.UserViewJieShaoError(e.getMessage());
                    }
                });
    }

    //剧照
    @Override
    public void UserModelJuZhaoData(String sessionId, String userId, String movieId, UserModelJuZhaoCallBack userModelJuZhaoCallBack) {
        RetrofitHttp.getApiServer().juzhao(sessionId, userId, movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<JuZhaoBean>() {
                    @Override
                    public void onNext(JuZhaoBean juZhaoBean) {
                        Log.d(TAG, "onNext: " + juZhaoBean.getMessage());
                        userModelJuZhaoCallBack.UserViewJuZhaoSuccess(juZhaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelJuZhaoCallBack.UserViewJuZhaoError(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelYuBaoData(String sessionId, String userId, String movieId, UserModelYuBaoCallBack userModelYuBaoCallBack) {
        RetrofitHttp.getApiServer().yubao(sessionId, userId, movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YuBaoBean>() {
                    @Override
                    public void onNext(YuBaoBean yuBaoBean) {
                        userModelYuBaoCallBack.UserViewYuBaoSuccess(yuBaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelYuBaoCallBack.UserViewYuBaoError(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelYingPingData(String sessionId, String userId, String cinemaId, String page, String count, UserModelYingPingCallBack userModelYingPingCallBack) {
        RetrofitHttp.getApiServer().yingping(sessionId, userId, cinemaId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YingPingBean>() {
                    @Override
                    public void onNext(YingPingBean yingPingBean) {
                        userModelYingPingCallBack.UserViewYingPingSuccess(yingPingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelYingPingCallBack.UserViewYingPingError(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelPaiQiData(String cinemaId, String page, String count, UserViewPaiQiCallBack userViewPaiQiCallBack) {
        RetrofitHttp.getApiServer().paiqi(cinemaId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ScheduleBean>() {
                    @Override
                    public void onNext(ScheduleBean scheduleBean) {
                        userViewPaiQiCallBack.UserViewPaiQiSuccess(scheduleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userViewPaiQiCallBack.UserViewPaiQiError(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelTimeData(UserViewTimeCallBack userViewTimeCallBack) {
        RetrofitHttp.getApiServer().time()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<TimeBean>() {
                    @Override
                    public void onNext(TimeBean timeBean) {
                        userViewTimeCallBack.UserViewTimeSuccess(timeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userViewTimeCallBack.UserViewTimeError(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelMingXiData(String sessionId, String userId, String cinemaId, UserViewMingXiCallBack userViewMingXiCallBack) {
        RetrofitHttp.getApiServer().mingxi(sessionId, userId, cinemaId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MingXiBean>() {
                    @Override
                    public void onNext(MingXiBean mingXiBean) {
                        userViewMingXiCallBack.UserViewMingXiSuccess(mingXiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userViewMingXiCallBack.UserViewMingXiErroe(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelQuYuData(UserModelQuYuCallBack userModelQuYuCallBack) {
        RetrofitHttp.getApiServer().quyu()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<QuYuBean>() {
                    @Override
                    public void onNext(QuYuBean quYuBean) {
                        userModelQuYuCallBack.UserViewQuYuSuccess(quYuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelQuYuCallBack.UserViewQuYuError(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelPaiQiLieBiaoData(String movieId, String cinemaId, UserModelPaiQiLieBiaoCallBack userModelPaiQiLieBiaoCallBack) {
        RetrofitHttp.getApiServer().paiqiliebiao(movieId, cinemaId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PaiQiLieBiaoBean>() {
                    @Override
                    public void onNext(PaiQiLieBiaoBean paiQiLieBiaoBean) {
                        userModelPaiQiLieBiaoCallBack.UserViewPaiQiLieBiaoSuccess(paiQiLieBiaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userModelPaiQiLieBiaoCallBack.UserViewPaiQiLieBiaoError(e.getMessage());
                    }
                });
    }

    @Override
    public void UserModelChaXunZuoWeiData(String hallId, UserViewChaXunZuoWeiCallBack userViewChaXunZuoWeiCallBack) {
RetrofitHttp.getApiServer().chaxunzuowei(hallId)
        .compose(CommonSchedulers.io2main())
        .subscribe(new CommonObserver<ChaXunZuoWeiBean>() {
            @Override
            public void onNext(ChaXunZuoWeiBean chaXunZuoWeiBean) {
                userViewChaXunZuoWeiCallBack.UserViewChaXunZuoWeiSuccess(chaXunZuoWeiBean);
            }

            @Override
            public void onError(Throwable e) {
                userViewChaXunZuoWeiCallBack.UserViewChaXunZuoWeiError(e.getMessage());
            }
        });
    }


}



