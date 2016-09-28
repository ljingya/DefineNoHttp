package com.example.shuiai.definenohttp.httpUtils;

import com.yolanda.nohttp.rest.Response;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2016/9/27
 */
public interface HttpListener<T> {
    /**
     * 请求成功
     *
     * @param what
     * @param response
     */
    void onSuccess(int what, Response<T> response);

    /**
     * 请求失败
     *
     * @param what
     * @param response
     */
    void onFailed(int what, Response<T> response);
}
