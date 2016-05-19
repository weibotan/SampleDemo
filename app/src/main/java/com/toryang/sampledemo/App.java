package com.toryang.sampledemo;

import android.app.Application;
import android.net.Uri;

import com.squareup.picasso.Picasso;
import com.toryang.sampledemo.common.OkHttp3Downloader;
import com.toryang.sampledemo.utils.Log;

import okhttp3.OkHttpClient;

/**
 * Created by toryang on 16/4/28.
 */
public class App extends Application {

    private static App instace;

    public static App getInstace(){
        return instace;
    }

    public static Picasso mPicasso;
    @Override
    public void onCreate() {
        super.onCreate();
        instace = this;
        setUpPicasso();
    }

    public void setUpPicasso(){

        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(new OkHttpClient()))
                .build();
        Picasso.setSingletonInstance(picasso);
        mPicasso = picasso;
    }

    public static Picasso getPicasso(){
        return mPicasso;
    }

}
