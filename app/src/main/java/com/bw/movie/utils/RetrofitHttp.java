package com.bw.movie.utils;


import com.bw.movie.app.ApiServer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: [Liu He]
 * data: 2019/11/11.
 * function：
 */
public class RetrofitHttp {

    public static ApiServer apiServer;
    public RetrofitHttp (){}

    public static ApiServer getApiServer(){
        if (apiServer ==null){
            apiServer = new RetrofitHttp().apiServer();
        }
        return apiServer;
    }

    public ApiServer apiServer(){
        ApiServer apiServer = initRetrofit(okHttpClient()).create(ApiServer.class);
        return apiServer;
    }

    //初始化OkHttpClient
    public OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(Constans.TIME, TimeUnit.SECONDS)
                .readTimeout(Constans.TIME,TimeUnit.SECONDS)
                .writeTimeout(Constans.TIME,TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        return chain.proceed(request);
                    }
                }).build();
    }
    //初始化retrofit
    public Retrofit initRetrofit(OkHttpClient client){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constans.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
