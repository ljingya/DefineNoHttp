package com.example.shuiai.definenohttp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.shuiai.definenohttp.httpUtils.CallServer;
import com.example.shuiai.definenohttp.httpUtils.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.CacheMode;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;


public class MainActivity extends AppCompatActivity implements HttpListener<Bitmap> {
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
        starTask();
    }

    private void starTask() {
        String url = "http://pic47.nipic.com/20140904/18981839_095218870000_2.jpg";
        Request<Bitmap> request = NoHttp.createImageRequest(url, RequestMethod.GET);
//        Map<String, String> map = new HashMap<>();
//        map.put("pageType", "");//专题类型，1：分销
//        map.put("pageName", "");//专题名，可模糊查询
//        map.put("brandId", "10005");
//        map.put("pageSize", "1");
//        map.put("pageNum", "1");
//        request.add(map);
        request.setCacheMode(CacheMode.ONLY_READ_CACHE);
        CallServer.getInstance().add(this, 0, request, this, true);
    }


    @Override
    public void onSuccess(int what, Response<Bitmap> response) {
        Bitmap data = response.get();
        img.setImageBitmap(data);
//        Toast.makeText(this,""+data,Toast.LENGTH_SHORT).show();
//        Logger.d(data);
    }

    @Override
    public void onFailed(int what, Response<Bitmap> response) {
//        Logger.d(data);
    }
}
