package com.example.shuiai.definenohttp.httpUtils;

import android.content.Context;

import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2016/9/27
 */

public class HttpResponseListener<T> implements OnResponseListener<T> {

    private Context context;
    private Request<T> response;
    private HttpListener<T> callBack;
    private Boolean canCancle;

    /**
     * @param context
     * @param response  请求对象
     * @param callBack  回调对象
     * @param canCancle 是否允许用户取消请求
     */
    public HttpResponseListener(Context context, Request<T> response, HttpListener<T> callBack, boolean canCancle) {
        this.context = context;
        this.response = response;
        this.callBack = callBack;
        this.canCancle = canCancle;
    }

    /**
     * 开始请求可以显示加载框
     *
     * @param what
     */
    @Override
    public void onStart(int what) {

    }

    /**
     * 请求成功
     * @param what
     * @param response
     */
    @Override
    public void onSucceed(int what, Response<T> response) {
        if (callBack != null) {
            callBack.onSuccess(what, response);
        }
    }

    /**
     * 请求失败
     * @param what
     * @param response
     */
    @Override
    public void onFailed(int what, Response<T> response) {
        if (callBack != null) {
            callBack.onFailed(what, response);
        }
    }

    /**
     * 请求完成加载框消失
     *
     * @param what
     */
    @Override
    public void onFinish(int what) {

    }
}
