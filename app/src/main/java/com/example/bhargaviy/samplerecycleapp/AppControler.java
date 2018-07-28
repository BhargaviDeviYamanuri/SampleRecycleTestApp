package com.example.bhargaviy.samplerecycleapp;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Bhargavi Y on 7/28/2018.
 */

public class AppControler extends Application{
    private static AppControler mInstance;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized AppControler getInstance(){
        return mInstance;
    }
    public RequestQueue getmRequestQueue(){
        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req){
        getmRequestQueue().add(req);
    }

    public void setTitleLable(GetTiltleLableInterface.lableList titleLableListener){
        GetTiltleLableInterface.lableListListener = titleLableListener;
    }
}
