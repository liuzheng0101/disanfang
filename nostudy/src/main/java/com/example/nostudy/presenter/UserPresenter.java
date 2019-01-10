package com.example.nostudy.presenter;

import com.example.nostudy.bean.LeftInfo;
import com.example.nostudy.bean.RightInfo;
import com.example.nostudy.contract.UserContract;
import com.example.nostudy.model.UserModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class UserPresenter extends UserContract.getUseInfo {
    private UserModel userModel;
    private UserContract.IUserView iUserView;
    public UserPresenter(UserContract.IUserView iUserView) {
        this.iUserView = iUserView;
        this.userModel=new UserModel();
    }
    @Override
    public void getLeftInfo(HashMap<String, String> params) {
        userModel.getLeftInfo(params, new UserModel.ModelCallback() {
            @Override
            public void leftsuccess(String result) {
                LeftInfo info=new Gson().fromJson(result,LeftInfo.class);
                List<LeftInfo.Left> data=info.data;
                iUserView.leftsuccess(data);
            }
            @Override
            public void leftfailure(String error) {

            }
            @Override
            public void rightsuccess(String result) {

            }
            @Override
            public void rightfailure(String error) {

            }
        });
    }
    @Override
    public void getRightInfo(HashMap<String, String> params) {
        userModel.getRightInfo(params, new UserModel.ModelCallback() {
            @Override
            public void leftsuccess(String result) {

            }
            @Override
            public void leftfailure(String error) {

            }
            @Override
            public void rightsuccess(String result) {
                RightInfo info=new Gson().fromJson(result,RightInfo.class);
                List<RightInfo.Right> data=info.data;
                iUserView.Rightsuccess(data);
            }
            @Override
            public void rightfailure(String error) {

            }
        });
    }
}
