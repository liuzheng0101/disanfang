package com.example.lib_core.net;

import android.os.Handler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtils {
    private Handler hanlder=new Handler();
    private OkHttpClient okHttpClient;
    private OkhttpUtils instance;

    public OkhttpUtils getInstance() {
        if (instance==null){
            synchronized (OkhttpUtils.class){
                if (instance==null){
                    instance=new OkhttpUtils();
                }
            }
        }
        return instance;
    }

    private OkhttpUtils(){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)  //拦截器
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();   //构建者模式
    }
    /**
     * get 请求
     */
    public void doGet(String url, HashMap<String,String> params, final OkhttpCallback callback){
        StringBuilder p=new StringBuilder();
        if (params!=null&&params.size()>0){
            for (Map.Entry<String,String> map:params.entrySet()){
                p.append(map.getKey()).append("=").append(map.getValue()).append("&");
            }
            System.out.println("ppppppp============"+p.toString());
        }
        Request request=new Request.Builder().url(url+"?"+p.toString()).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback!=null){
                    hanlder.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络有问题,请稍后重试");
                        }
                    });
                }
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                if (callback!=null){
                    callback.success(result);
                }
            }
        });
    }
    /**
     * post 请求
     */
    public void doPost(String url, HashMap<String,String> params, final OkhttpCallback callback){
        FormBody.Builder builder=new FormBody.Builder();
        for (Map.Entry<String,String> p:params.entrySet()){
            builder.add(p.getKey(),p.getValue());
        }
        final Request request=new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
                if (callback!=null){
                    hanlder.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络有问题,请稍后重试");
                        }
                    });
                }
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback!=null){
                    if (response.code()==200){
                        final String result=response.body().string();
                        hanlder.post(new Runnable() {
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
    /**
     * 上传头像 ,文件
     */
    public void uploadFile(String url, HashMap<String,Object> params, final OkhttpCallback callback){
        MultipartBody.Builder builder=new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (Map.Entry<String,Object> map:params.entrySet()){
            String key=map.getKey();
            Object value=map.getValue();
            if (value instanceof File){
                File file= (File) value;
                builder.addFormDataPart(key,file.getName(),RequestBody.create(MediaType.parse("image/*"),file));
            }else{
                builder.addFormDataPart(key,value.toString());
            }
        }
        Request request=new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback!=null){
                    hanlder.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络有问题,请稍后重试");
                        }
                    });
                }
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback!=null){
                    final String result=response.body().string();
                    hanlder.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(result);
                        }
                    });
                }
            }
        });
    }
    /**
     * 取消所有请求, 节省开销
     */
    public void cancelAllTask(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
    }
}
