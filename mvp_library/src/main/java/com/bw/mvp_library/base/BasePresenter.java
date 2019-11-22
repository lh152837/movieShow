package com.bw.mvp_library.base;

import android.content.Context;


import com.bw.mvp_library.ap.App;

import java.lang.ref.WeakReference;

/**
 * describe:BasePresenter
 * date:2019/11/5
 * author:任(Lenovo)
 * function:
 */
public abstract class BasePresenter <V extends IBaseView>{
    private WeakReference<V> weakReference;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    protected void attachView(V v){
        weakReference = new WeakReference<>(v);
    }

    protected void  detachView(){
        if (weakReference!=null) {
            weakReference.clear();
            weakReference=null;
        }
    }

    protected boolean isViewAttach(){
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return true;
    }

    protected V getView(){
        return weakReference.get();
    }

    protected Context context(){
        if (isViewAttach() && getView().context() !=null) {
            return getView().context();
        }
        return App.getAppContext();
    }
}
