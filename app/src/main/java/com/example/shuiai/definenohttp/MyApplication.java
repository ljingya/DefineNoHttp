package com.example.shuiai.definenohttp;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2016/9/27
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);
        Logger.setDebug(true);
        Logger.setTag("DefineNohttp");
    }
}
