package com.bw.movie.contract;

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
import com.bw.mvp_library.base.IBaseView;

/**
 * author: [Liu He]
 * data: 2019/11/11.
 * function：
 */
public interface UserContract {
    //iview
    interface UserView extends IBaseView {
        //登录
        void UserViewLoginSuccess(LoginBean data);

        void UserViewLoginError(Throwable e);

        //注册
        void UserViewRegisterSuccess(RegisterBean data);

        void UserViewRegisterError(Throwable e);

        //发送验证码
        void UserViewEmailSuccess(EmailBean data);

        void UserViewEmailError(Throwable e);

        //轮播图
        void UserViewBannerSuccess(BannerBean data);

        void UserViewBannerError(Throwable e);

        //正在热映
        void UserViewReYingSuccess(ReYingBean reYingBean);

        void UserViewReYingError(Throwable e);

        //即将上映
        void UserViewJiJiangSuccess(JiJiangBean jiJiangBean);

        void UserViewJiJiangError(Throwable e);

        //热门电影
        void UserViewReMenSuccess(ReMenBean reMenBean);

        void UserViewReMenError(Throwable e);

        //推荐影院
        void UserViewTuiJianSuccess(TuiJianBean tuiJianBean);

        void UserViewTuiJianError(Throwable e);

        //附近影院
        void UserViewFuJinSuccess(FuJinBean fuJinBean);

        void UserViewFuJinError(Throwable e);

        //电影详情页面
        void UserViewXiangQingSuccess(XiangQingBean xiangQingBean);

        void UserViewXiangQingError(String e);

        //电影详情介绍
        void UserViewJieShaoSuccess(JieShaoBean jieShaoBean);

        void UserViewJieShaoError(String e);

        //电影剧照
        void UserViewJuZhaoSuccess(JuZhaoBean juZhaoBean);

        void UserViewJuZhaoError(String e);

        //电影预告
        void UserViewYuBaoSuccess(YuBaoBean yuBaoBean);

        void UserViewYuBaoError(String e);

        //影评
        void UserViewYingPingSuccess(YingPingBean yingPingBean);

        void UserViewYingPingError(String e);

        //电影排期
        void UserViewPaiQiSuccess(ScheduleBean scheduleBean);

        void UserViewPaiQiError(String e);

        //电影一周排期
        void UserViewTimeSuccess(TimeBean timeBean);

        void UserViewTimeError(String e);

        //查看电影信息明细
        void UserViewMingXiSuccess(MingXiBean mingXiBean);

        void UserViewMingXiErroe(String e);

        //查看区域列表
        void UserViewQuYuSuccess(QuYuBean quYuBean);

        void UserViewQuYuError(String e);

        //根据电影ID和影院ID查询电影排期列表
        void UserViewPaiQiLieBiaoSuccess(PaiQiLieBiaoBean paiQiLieBiaoBean);

        void UserViewPaiQiLieBiaoError(String e);

        //根据影厅id 查询座位信息
        void UserViewChaXunZuoWeiSuccess(ChaXunZuoWeiBean chaXunZuoWeiBean);

        void UserViewChaXunZuoWeiError(String e);

    }

    //imodel
    interface UserModel {
        void UserModelLoginData(String email, String pwd, UserModelLoginCallBack userModelLoginCallBack);

        //注册
        void UserModelRegisterData(String nickName, String pwd, String email, String code, UserModelRegisterCallBack userModelRegisterCallBack);

        //验证码
        void UserModelEmailData(String email, UserModelEmailCallBack userModelEmailCallBack);

        //轮播图
        void HomebannerModel(UserModelBannerCallBack userModelBannerCallBack);

        //正在热映
        void UserModelReYingData(int page, int count, UserModelReYingCallBack userModelReYingCallBack);

        //即将上映
        void UserModelJiJiangData(String sessionId, String userId, String page, String count, UserModelJiJiangCallBack userModelJiJiangCallBack);

        //热门电影
        void UserModelReMenData(String page, String count, UserModelReMenCallBack userModelReMenCallBack);

        //推荐影院;
        void UserModelTuiJianData(String sessionId, String userId, String page, String count, UserModelTuiJianCallBack userModelTuiJianCallBack);

        //附近影院
        void UserModelFuJinData(String longitude, String latitude, String page, String count, UserModelFuJinCallBack userModelFuJinCallBack);

        //电影详情
        void UserModelXiangQing(String sessionId, String userId, String movieId, UserModelXiangQingCallBack userModelXiangQingCallBack);

        //电影详情介绍
        void UserModelJieShaoData(String sessionId, String userId, String movieId, UserModelJieShaoCallBack userModelJieShaoCallBack);

        //电影剧照
        void UserModelJuZhaoData(String sessionId, String userId, String movieId, UserModelJuZhaoCallBack userModelJuZhaoCallBack);

        //预报
        void UserModelYuBaoData(String sessionId, String userId, String movieId, UserModelYuBaoCallBack userModelYuBaoCallBack);

        //电影影评
        void UserModelYingPingData(String sessionId, String userId, String cinemaId, String page, String count, UserModelYingPingCallBack userModelYingPingCallBack);

        //电影排期
        void UserModelPaiQiData(String cinemaId, String page, String count, UserViewPaiQiCallBack userViewPaiQiCallBack);

        //电影一周排期
        void UserModelTimeData(UserViewTimeCallBack userViewTimeCallBack);

        //查看电影信息明细
        void UserModelMingXiData(String sessionId, String userId, String cinemaId, UserViewMingXiCallBack userViewMingXiCallBack);

        //查询区域列表
        void UserModelQuYuData(UserModelQuYuCallBack userModelQuYuCallBack);

        //根据电影ID和影院ID查询电影排期列表
        void UserModelPaiQiLieBiaoData(String movieId, String cinemaId, UserModelPaiQiLieBiaoCallBack userModelPaiQiLieBiaoCallBack);

        //根据影厅id 查询座位信息
        void UserModelChaXunZuoWeiData(String hallId, UserViewChaXunZuoWeiCallBack userViewChaXunZuoWeiCallBack);

        //登录接口回调
        interface UserModelLoginCallBack {
            //登录
            void UserViewLoginSuccess(LoginBean data);

            void UserViewLoginError(Throwable e);
        }

        //注册接口
        interface UserModelRegisterCallBack {
            //注册
            void UserViewRegisterSuccess(RegisterBean data);

            void UserViewRegisterError(Throwable e);
        }

        //验证码接口
        interface UserModelEmailCallBack {
            //发送验证码
            void UserViewEmailSuccess(EmailBean data);

            void UserViewEmailError(Throwable e);
        }

        //轮播图接口
        interface UserModelBannerCallBack {
            void UserViewBannerSuccess(BannerBean data);

            void UserViewBannerError(Throwable e);
        }

        //正在热映
        interface UserModelReYingCallBack {
            //正在热映
            void UserViewReYingSuccess(ReYingBean reYingBean);

            void UserViewReYingError(Throwable e);
        }

        //即将上映
        interface UserModelJiJiangCallBack {
            //即将上映
            void UserViewJiJiangSuccess(JiJiangBean jiJiangBean);

            void UserViewJiJiangError(Throwable e);
        }

        //热门电影
        interface UserModelReMenCallBack {
            //热门电影
            void UserViewReMenSuccess(ReMenBean reMenBean);

            void UserViewReMenError(Throwable e);
        }

        //推荐影院接口回调
        interface UserModelTuiJianCallBack {
            //推荐影院
            void UserViewTuiJianSuccess(TuiJianBean tuiJianBean);

            void UserViewTuiJianError(Throwable e);
        }

        //附近影院
        interface UserModelFuJinCallBack {
            //附近影院
            void UserViewFuJinSuccess(FuJinBean fuJinBean);

            void UserViewFuJinError(Throwable e);
        }

        //电影详情接口回调
        interface UserModelXiangQingCallBack {
            //电影详情页面
            void UserViewXiangQingSuccess(XiangQingBean xiangQingBean);

            void UserViewXiangQingError(String e);
        }

        //电影详情介绍
        interface UserModelJieShaoCallBack {
            //电影详情介绍
            void UserViewJieShaoSuccess(JieShaoBean jieShaoBean);

            void UserViewJieShaoError(String e);
        }

        //电影剧照
        interface UserModelJuZhaoCallBack {
            //电影剧照
            void UserViewJuZhaoSuccess(JuZhaoBean juZhaoBean);

            void UserViewJuZhaoError(String e);
        }

        //电影预报
        interface UserModelYuBaoCallBack {
            //电影预告
            void UserViewYuBaoSuccess(YuBaoBean yuBaoBean);

            void UserViewYuBaoError(String e);
        }

        //电影评价
        interface UserModelYingPingCallBack {
            //影评
            void UserViewYingPingSuccess(YingPingBean yingPingBean);

            void UserViewYingPingError(String e);
        }

        //电影排期
        interface UserViewPaiQiCallBack {
            //电影排期
            void UserViewPaiQiSuccess(ScheduleBean scheduleBean);

            void UserViewPaiQiError(String e);
        }

        //电影一周排期
        interface UserViewTimeCallBack {
            //电影一周排期
            void UserViewTimeSuccess(TimeBean timeBean);

            void UserViewTimeError(String e);
        }

        //查看电影信息明细
        interface UserViewMingXiCallBack {
            //查看电影信息明细
            void UserViewMingXiSuccess(MingXiBean mingXiBean);

            void UserViewMingXiErroe(String e);
        }

        //查询区域列表
        interface UserModelQuYuCallBack {
            //查看区域列表
            void UserViewQuYuSuccess(QuYuBean quYuBean);

            void UserViewQuYuError(String e);
        }

        //根据电影ID和影院ID查询电影排期列表
        interface UserModelPaiQiLieBiaoCallBack {
            //根据电影ID和影院ID查询电影排期列表
            void UserViewPaiQiLieBiaoSuccess(PaiQiLieBiaoBean paiQiLieBiaoBean);

            void UserViewPaiQiLieBiaoError(String e);
        }

        //根据影厅id 查询座位信息
        interface UserViewChaXunZuoWeiCallBack {
            //根据影厅id 查询座位信息
            void UserViewChaXunZuoWeiSuccess(ChaXunZuoWeiBean chaXunZuoWeiBean);

            void UserViewChaXunZuoWeiError(String e);

        }
    }

    //ipresenter
    interface UserPresenter {
        void UserPresenterLogin(String email, String pwd);

        void UserPresenterRegister(String nickName, String pwd, String email, String code);

        void UserPresenterEmail(String email);

        void UserPresenterBanner();

        void UserPresenterReYing(int page, int count);

        void UserPresenterJiJiang(String sessionId, String userId, String page, String count);

        void UserPresenterReMen(String page, String count);

        //推荐影院
        void UserPresenterTuijian(String sessionId, String userId, String page, String count);

        //附近影院
        void UserPresenterFuJin(String longitude, String latitude, String page, String count);

        //电影详情
        void UserPresenterXiangQing(String sessionId, String userId, String movieId);

        //电影详情介绍
        void UserPresenterJieShao(String sessionId, String userId, String movieId);

        //电影剧照
        void UserPresenterJuZhao(String sessionId, String userId, String movieId);

        //电影预报
        void UserPresenterYuBao(String sessionId, String userId, String movieId);

        //影评
        void UserPresenterYingPing(String sessionId, String userId, String cinemaId, String page, String count);

        //影院排期
        void UserPresenterPaiQi(String cinemaId, String page, String count);

        //电影一周排期
        void UserPresenterTime();

        //查看电影信息明细
        void UserPresenterMingXi(String sessionId, String userId, String cinemaId);

        //查询区域信息
        void UserPresenterQuYu();

        //根据电影ID和影院ID查询电影排期列表
        void UserPresenterPaiQiLieBiao(String movieId, String cinemaId);
        //根据影厅id 查询座位信息
        void UserPresenterChaXunZuoWei(String hallId);


    }
}

