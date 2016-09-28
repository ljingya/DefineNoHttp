package com.example.shuiai.definenohttp.httpUtils;

import android.content.Context;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2016/9/27
 */

public class CallServer {
    private RequestQueue requestQueue;
    private static CallServer callServer;

    /**
     * 请求队列
     */
    private CallServer() {
        requestQueue = NoHttp.newRequestQueue();
    }

    public synchronized static CallServer getInstance() {
        if (callServer == null) {
            callServer = new CallServer();
        }
        return callServer;
    }

    public <T> void add(Context context, int what, Request<T> request, HttpListener<T> callBack, boolean canCancle) {
        requestQueue.add(what, request, new HttpResponseListener<T>(context, request, callBack, canCancle));
    }

    /**
     * 取消指定标记的请求
     *
     * @param sign
     */
    public void cancleBySign(Object sign) {
        requestQueue.cancelBySign(sign);
    }

    /**
     * 取消所有请求
     */
    public void cancleAll() {
        requestQueue.cancelAll();
    }

    /**
     * 退出时取消所有请求
     */
    public void stopAll() {
        requestQueue.stop();
    }

}
