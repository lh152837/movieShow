package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bean.BannerBean;
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
import com.bw.movie.model.UserModel;
import com.bw.movie.utils.Constans;
import com.bw.mvp_library.base.BasePresenter;

/**
 * author: [Liu He]
 * data: 2019/11/11.
 * function：
 */
public class UserPresenter extends BasePresenter<UserContract.UserView> implements UserContract.UserPresenter {

    public static final String TAG = "UserPresenter";
    private UserModel userModel;

    //登录
    @Override
    public void UserPresenterLogin(String email, String pwd) {
        userModel.UserModelLoginData(email, pwd, new UserContract.UserModel.UserModelLoginCallBack() {
            @Override
            public void UserViewLoginSuccess(LoginBean data) {
                //判断是否挂载q
                if (isViewAttach()) {
                    if (data != null && Constans.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().UserViewLoginSuccess(data);
                    } else {
                        getView().UserViewLoginError(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void UserViewLoginError(Throwable e) {
                if (isViewAttach()) {
                    getView().UserViewLoginError(e);
                }
            }
        });
    }

    //注册
    @Override
    public void UserPresenterRegister(String nickName, String pwd, String email, String code) {
        userModel.UserModelRegisterData(nickName, pwd, email, code, new UserContract.UserModel.UserModelRegisterCallBack() {
            @Override
            public void UserViewRegisterSuccess(RegisterBean data) {
                if (isViewAttach()) {
                    if (data != null && Constans.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().UserViewRegisterSuccess(data);
                    } else {
                        getView().UserViewRegisterError(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void UserViewRegisterError(Throwable e) {
                if (isViewAttach()) {
                    getView().UserViewRegisterError(e);
                }
            }
        });
    }

    //发送邮件
    @Override
    public void UserPresenterEmail(String email) {
        userModel.UserModelEmailData(email, new UserContract.UserModel.UserModelEmailCallBack() {
            @Override
            public void UserViewEmailSuccess(EmailBean data) {
                if (isViewAttach()) {
                    if (data != null && Constans.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().UserViewEmailSuccess(data);
                    } else {
                        getView().UserViewEmailError(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void UserViewEmailError(Throwable e) {
                if (isViewAttach()) {
                    getView().UserViewEmailError(e);
                }
            }
        });
    }

    @Override
    public void UserPresenterBanner() {
        userModel.HomebannerModel(new UserContract.UserModel.UserModelBannerCallBack() {
            @Override
            public void UserViewBannerSuccess(BannerBean data) {
                Log.d(TAG, "UserViewBannerSuccess: " + data.getResult());
                getView().UserViewBannerSuccess(data);
            }

            @Override
            public void UserViewBannerError(Throwable e) {
                getView().UserViewBannerError(e);
            }
        });
    }

    @Override
    public void UserPresenterReYing(int page, int count) {
        userModel.UserModelReYingData(page, count, new UserContract.UserModel.UserModelReYingCallBack() {
            @Override
            public void UserViewReYingSuccess(ReYingBean reYingBean) {
                getView().UserViewReYingSuccess(reYingBean);
            }

            @Override
            public void UserViewReYingError(Throwable e) {
                if (isViewAttach()) {
                    getView().UserViewReYingError(e);
                }
            }
        });
    }

    @Override
    public void UserPresenterJiJiang(String sessionId, String userId, String page, String count) {
        userModel.UserModelJiJiangData(sessionId, userId, page, count, new UserContract.UserModel.UserModelJiJiangCallBack() {
            @Override
            public void UserViewJiJiangSuccess(JiJiangBean jiJiangBean) {
                getView().UserViewJiJiangSuccess(jiJiangBean);
            }

            @Override
            public void UserViewJiJiangError(Throwable e) {
            getView().UserViewJiJiangError(e);
            }
        });
    }

    @Override
    public void UserPresenterReMen(String page, String count) {
        userModel.UserModelReMenData(page, count, new UserContract.UserModel.UserModelReMenCallBack() {
            @Override
            public void UserViewReMenSuccess(ReMenBean reMenBean) {
                getView().UserViewReMenSuccess(reMenBean);
            }

            @Override
            public void UserViewReMenError(Throwable e) {
                getView().UserViewReMenError(e);
            }
        });
    }

    @Override
    public void UserPresenterTuijian(String sessionId, String userId, String page, String count) {
        userModel.UserModelTuiJianData(sessionId, userId, page, count, new UserContract.UserModel.UserModelTuiJianCallBack() {
            @Override
            public void UserViewTuiJianSuccess(TuiJianBean tuiJianBean) {
                getView().UserViewTuiJianSuccess(tuiJianBean);
            }

            @Override
            public void UserViewTuiJianError(Throwable e) {
                getView().UserViewTuiJianError(e);
            }
        });
    }

    @Override
    public void UserPresenterFuJin(String longitude, String latitude, String page, String count) {
        userModel.UserModelFuJinData(longitude, latitude, page, count, new UserContract.UserModel.UserModelFuJinCallBack() {
            @Override
            public void UserViewFuJinSuccess(FuJinBean fuJinBean) {
                getView().UserViewFuJinSuccess(fuJinBean);
            }

            @Override
            public void UserViewFuJinError(Throwable e) {
                getView().UserViewFuJinError(e);
            }
        });
    }

    @Override
    public void UserPresenterXiangQing(String sessionId, String userId, String movieId) {
        userModel.UserModelXiangQing(sessionId, userId, movieId, new UserContract.UserModel.UserModelXiangQingCallBack() {
            @Override
            public void UserViewXiangQingSuccess(XiangQingBean xiangQingBean) {
                Log.d(TAG, "UserViewXiangQingSuccess: "+xiangQingBean);
                getView().UserViewXiangQingSuccess(xiangQingBean);
            }

            @Override
            public void UserViewXiangQingError(String e) {
                getView().UserViewXiangQingError(e);
            }
        });
    }

    @Override
    public void UserPresenterJieShao(String sessionId, String userId, String movieId) {
        userModel.UserModelJieShaoData(sessionId, userId, movieId, new UserContract.UserModel.UserModelJieShaoCallBack() {
            @Override
            public void UserViewJieShaoSuccess(JieShaoBean jieShaoBean) {
                getView().UserViewJieShaoSuccess(jieShaoBean);
            }

            @Override
            public void UserViewJieShaoError(String e) {
            getView().UserViewJieShaoError(e);
            }
        });
    }

    @Override
    public void UserPresenterJuZhao(String sessionId, String userId, String movieId) {
        userModel.UserModelJuZhaoData(sessionId, userId, movieId, new UserContract.UserModel.UserModelJuZhaoCallBack() {
            @Override
            public void UserViewJuZhaoSuccess(JuZhaoBean juZhaoBean) {
                Log.d(TAG, "UserViewJuZhaoSuccess: "+juZhaoBean.getMessage());
                getView().UserViewJuZhaoSuccess(juZhaoBean);
            }

            @Override
            public void UserViewJuZhaoError(String e) {
                getView().UserViewJuZhaoError(e);
            }
        });
    }

    @Override
    public void UserPresenterYuBao(String sessionId, String userId, String movieId) {
        userModel.UserModelYuBaoData(sessionId, userId, movieId, new UserContract.UserModel.UserModelYuBaoCallBack() {
            @Override
            public void UserViewYuBaoSuccess(YuBaoBean yuBaoBean) {
                getView().UserViewYuBaoSuccess(yuBaoBean);
            }

            @Override
            public void UserViewYuBaoError(String e) {
                getView().UserViewYuBaoError(e);
            }
        });
    }

    @Override
    public void UserPresenterYingPing(String sessionId, String userId, String cinemaId, String page, String count) {
        userModel.UserModelYingPingData(sessionId, userId, cinemaId, page, count, new UserContract.UserModel.UserModelYingPingCallBack() {
            @Override
            public void UserViewYingPingSuccess(YingPingBean yingPingBean) {
                getView().UserViewYingPingSuccess(yingPingBean);
            }

            @Override
            public void UserViewYingPingError(String e) {
                getView().UserViewYingPingError(e);
            }
        });
    }

    //电影排期
    @Override
    public void UserPresenterPaiQi(String cinemaId, String page, String count) {
        userModel.UserModelPaiQiData(cinemaId, page, count, new UserContract.UserModel.UserViewPaiQiCallBack() {
            @Override
            public void UserViewPaiQiSuccess(ScheduleBean scheduleBean) {
                getView().UserViewPaiQiSuccess(scheduleBean);
            }

            @Override
            public void UserViewPaiQiError(String e) {
            getView().UserViewPaiQiError(e);
            }
        });

    }

    //一周排期
    @Override
    public void UserPresenterTime() {
        userModel.UserModelTimeData(new UserContract.UserModel.UserViewTimeCallBack() {
            @Override
            public void UserViewTimeSuccess(TimeBean timeBean) {
                getView().UserViewTimeSuccess(timeBean);
            }

            @Override
            public void UserViewTimeError(String e) {
                getView().UserViewTimeError(e);
            }
        });
    }

    @Override
    public void UserPresenterMingXi(String sessionId, String userId, String cinemaId) {
        userModel.UserModelMingXiData(sessionId, userId, cinemaId, new UserContract.UserModel.UserViewMingXiCallBack() {
            @Override
            public void UserViewMingXiSuccess(MingXiBean mingXiBean) {
                getView().UserViewMingXiSuccess(mingXiBean);
            }

            @Override
            public void UserViewMingXiErroe(String e) {
                getView().UserViewMingXiErroe(e);
            }
        });
    }

    @Override
    public void UserPresenterQuYu() {
        userModel.UserModelQuYuData(new UserContract.UserModel.UserModelQuYuCallBack() {
            @Override
            public void UserViewQuYuSuccess(QuYuBean quYuBean) {
                Log.d(TAG, "UserViewQuYuSuccess: "+quYuBean.getMessage());
                getView().UserViewQuYuSuccess(quYuBean);
            }

            @Override
            public void UserViewQuYuError(String e) {
            getView().UserViewQuYuError(e);
            }
        });
    }

    @Override
    public void UserPresenterPaiQiLieBiao(String movieId, String cinemaId) {
        userModel.UserModelPaiQiLieBiaoData(movieId, cinemaId, new UserContract.UserModel.UserModelPaiQiLieBiaoCallBack() {
            @Override
            public void UserViewPaiQiLieBiaoSuccess(PaiQiLieBiaoBean paiQiLieBiaoBean) {
                getView().UserViewPaiQiLieBiaoSuccess(paiQiLieBiaoBean);
            }

            @Override
            public void UserViewPaiQiLieBiaoError(String e) {
                getView().UserViewPaiQiLieBiaoError(e);
            }
        });
    }

    @Override
    public void UserPresenterChaXunZuoWei(String hallId) {

    }


    @Override
    protected void initModel() {
        userModel = new UserModel();
    }
}
