package com.bw.mvp_library.ap;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * describe:App4
 * date:2019/11/5
 * author:任(Lenovo)
 * function:
 */
public class App extends Application {
    private static App context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Fresco.initialize(this);
    }

    public static App getAppContext(){
        return context;
    }
}
