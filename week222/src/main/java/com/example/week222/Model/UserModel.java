package com.example.week222.Model;
import com.example.week222.contract.OkhttpCallback;
import com.example.week222.api.UserApi;
import com.example.week222.contract.UserContract;
import com.example.week222.net.OKhttpUtils;

import java.util.HashMap;

public class UserModel implements UserContract.IUserModel {
    @Override
    public void getLeftInfo(HashMap<String, String> params, final ModelCallback callback) {
        OKhttpUtils.getInstance().doPost(UserApi.LEFT_API, params, new OkhttpCallback() {
            @Override
            public void success(String result) {
                if (callback!=null){
                    callback.leftSuccess(result);
                }
            }
            @Override
            public void failure(String msg) {
                if (callback!=null){
                    callback.leftFailure(msg);
                }
            }
        });
    }

    @Override
    public void getRightInfo(HashMap<String, String> params, final ModelCallback callback) {
        OKhttpUtils.getInstance().doPost(UserApi.RIGHT_API, params, new OkhttpCallback() {
            @Override
            public void success(String result) {
                if (callback!=null){
                    callback.rightSuccess(result);
                }
            }
            @Override
            public void failure(String msg) {
                if (callback!=null){
                    callback.rightFailure(msg);
                }
            }
        });
    }
    public interface ModelCallback{
        void leftSuccess(String result);
        void rightSuccess(String result);
        void leftFailure(String error);
        void rightFailure(String error);
    }
}
