package com.example.lib_core.net;

public interface OkhttpCallback {
    void failure(String msg);  //服务器请求失败,
    void success(String result);  //数据合法
}
