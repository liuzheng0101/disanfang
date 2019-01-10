package com.example.week222.net;
import android.os.Handler;

import com.example.week222.contract.OkhttpCallback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
public class OKhttpUtils {
    private Handler handler=new Handler();
    private OkHttpClient okHttpClient;
    private static OKhttpUtils instance;

    public static OKhttpUtils getInstance() {
        if (instance==null){
            synchronized (OKhttpUtils.class){
                if (instance==null){
                    instance=new OKhttpUtils();
                }
            }
        }
        return instance;
    }
     public OKhttpUtils(){
         HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
         loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
         okHttpClient=new OkHttpClient.Builder()
                 .addInterceptor(loggingInterceptor)
                 .writeTimeout(5,TimeUnit.SECONDS)
                 .readTimeout(5,TimeUnit.SECONDS)
                 .connectTimeout(5,TimeUnit.SECONDS)
                 .build();
     }

     public void doPost(String url, HashMap<String,String> params, final OkhttpCallback callback){
         FormBody.Builder builder=new FormBody.Builder();
         for (Map.Entry<String,String> p:params.entrySet()){
             builder.add(p.getKey(),p.getValue());
         }
         Request request=new Request.Builder().url(url).post(builder.build()).build();
         okHttpClient.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(final Call call, IOException e) {
                 if (callback!=null){
                     handler.post(new Runnable() {
                         @Override
                         public void run() {
                             callback.failure("网络异常");
                         }
                     });
                 }
             }
             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 final String result = response.body().string();
                 if (callback != null) {
                     if (response.code() == 200) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.success(result);
                            }
                        });
                     }
                 }
             }
         });
     }
     public void cancelAllTask(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
     }
}
