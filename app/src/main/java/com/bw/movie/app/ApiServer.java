package com.bw.movie.app;

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

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * author: [Liu He]
 * data: 2019/11/11.
 * function：
 */
public interface ApiServer {
    //登录
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> login(@Field("email") String email, @Field("pwd") String pwd);

    //注册
    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<RegisterBean> register(@Field("nickName") String nickName, @Field("pwd") String pwd, @Field("email") String email, @Field("code") String code);

    //发送验证码
    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<EmailBean> email(@Field("email") String email);

    //轮播图
    @GET("tool/v2/banner")
    Observable<BannerBean> banner();

    //正在热映  http://172.17.8.100/movieApi/movie/v2/findHotMovieList
    @GET("movie/v2/findHotMovieList")
    Observable<ReYingBean> reying(@Query("page") int page, @Query("count") int count);

    //即将上映电影  http://172.17.8.100/movieApi/movie/v2/findComingSoonMovieList
    @GET("movie/v2/findComingSoonMovieList")
    Observable<JiJiangBean> jijiang(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("page") String page, @Query("count") String count);

    //热门电影  http://172.17.8.100/movieApi/movie/v2/findHotMovieList
    @GET("movie/v2/findHotMovieList")
    Observable<ReMenBean> remen(@Query("page") String page, @Query("count") String count);

    //推荐影院
    //http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TuiJianBean> tuijian(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("page") String page, @Query("count") String count);

    //附近影院
    // http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas
    @GET("cinema/v1/findNearbyCinemas")
    Observable<FuJinBean> fujin(@Query("longitude") String longitude, @Query("latitude") String latitude, @Query("page") String page, @Query("count") String count);

    //查看电影详情   http://172.17.8.100/movieApi/movie/v2/findMoviesDetail
    @GET("movie/v2/findMoviesDetail")
    Observable<XiangQingBean> xiangqing(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("movieId") String movieId);

    //电影详情介绍
    @GET("movie/v2/findMoviesDetail")
    Observable<JieShaoBean> jieshao(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("movieId") String movieId);

    //电影剧照
    @GET("movie/v2/findMoviesDetail")
    Observable<JuZhaoBean> juzhao(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("movieId") String movieId);

    //电影预告
    @GET("movie/v2/findMoviesDetail")
    Observable<YuBaoBean> yubao(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("movieId") String movieId);

    //电影影评  http://172.17.8.100/movieApi/cinema/v1/findAllCinemaComment
    @GET("cinema/v1/findAllCinemaComment")
    Observable<YingPingBean> yingping(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("cinemaId") String cinemaId, @Query("page") String page, @Query("count") String count);

    //查看影院下得电影排期  http://172.17.8.100/movieApi/cinema/v2/findCinemaScheduleList
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<ScheduleBean> paiqi(@Query("cinemaId") String cinemaId, @Query("page") String page, @Query("count") String count);

    //查看电影一周排期时间  http://172.17.8.100/movieApi/tool/v2/findDateList
    @GET("tool/v2/findDateList")
    Observable<TimeBean> time();

    //查看电影信息明细   http://172.17.8.100/movieApi/cinema/v1/findCinemaInfo
    @GET("cinema/v1/findCinemaInfo")
    Observable<MingXiBean> mingxi(@Header("sessionId") String sessionId, @Header("userId") String userId, @Query("cinemaId") String cinemaId);

    //查询区域列表  http://172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("tool/v2/findRegionList")
    Observable<QuYuBean> quyu();
    //根据电影ID和影院ID查询电影排期列表
    //接口地址：http://172.17.8.100/movieApi/movie/v2/findMovieSchedule
    @GET("movie/v2/findMovieSchedule")
    Observable<PaiQiLieBiaoBean> paiqiliebiao(@Query("movieId")String movieId,@Query("cinemaId")String cinemaId);
    //根据影厅id 查询座位信息  http://172.17.8.100/movieApi/movie/v2/findSeatInfo
    @GET("movie/v2/findSeatInfo")
    Observable<ChaXunZuoWeiBean>chaxunzuowei(@Query("hallId")String hallId);
}
