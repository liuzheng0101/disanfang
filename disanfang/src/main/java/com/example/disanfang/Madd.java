package com.example.disanfang;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class Madd extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5c3738abb465f58e9f000f62","小米",UMConfigure.DEVICE_TYPE_PHONE,"");
        /**
        * 设置组件化的Log开关
        * 参数: boolean 默认为false，如需查看LOG设置为true
        */
        UMConfigure.setLogEnabled(true);
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
