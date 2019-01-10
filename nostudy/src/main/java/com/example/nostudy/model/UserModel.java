package com.example.nostudy.model;

import com.example.nostudy.Api.UserApi;
import com.example.nostudy.contract.OkhttpCallback;
import com.example.nostudy.contract.UserContract;
import com.example.nostudy.net.OkhttpUtils;

import java.util.HashMap;

public class UserModel implements UserContract.IUserModel {
    @Override
    public void getLeftInfo(HashMap<String, String> params, final ModelCallback callback) {
        OkhttpUtils.getInstance().doPost(UserApi.LEFT_API, params, new OkhttpCallback() {
            @Override
            public void success(String result) {
                if (callback!=null){
                    callback.leftsuccess(result);
                }
            }
            @Override
            public void failure(String error) {
                if (callback!=null){
                    callback.leftfailure(error);
                }
            }
        });
    }

    @Override
    public void getRightInfo(HashMap<String, String> params, final ModelCallback callback) {
        OkhttpUtils.getInstance().doPost(UserApi.RIGHT_API, params, new OkhttpCallback() {
            @Override
            public void success(String result) {
                if (callback!=null){
                    callback.rightsuccess(result);
                }
            }
            @Override
            public void failure(String error) {
                if (callback!=null){
                    callback.rightfailure(error);
                }
            }
        });
    }

    public interface ModelCallback{
        void leftsuccess(String result);
        void leftfailure(String error);
        void rightsuccess(String result);
        void rightfailure(String error);
    }
}
