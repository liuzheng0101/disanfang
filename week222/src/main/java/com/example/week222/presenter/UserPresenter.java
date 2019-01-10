package com.example.week222.presenter;

import com.example.week222.Bean.LeftInfo;
import com.example.week222.Bean.RightInfo;
import com.example.week222.Model.UserModel;
import com.example.week222.contract.UserContract;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class UserPresenter extends UserContract.IUserPresenter{
    private UserModel userModel;
    private UserContract.IUserView view;
    public UserPresenter(UserContract.IUserView view) {
        this.userModel = new UserModel();
        this.view = view;
    }
    @Override
    public void getLeftInfo(HashMap<String, String> params) {
        userModel.getLeftInfo(params, new UserModel.ModelCallback() {
            @Override
            public void leftSuccess(String result) {
                LeftInfo info=new Gson().fromJson(result,LeftInfo.class);
                List<LeftInfo.Cls> infof=info.data;
                view.leftsuccess(infof);
            }

            @Override
            public void rightSuccess(String result) {

            }

            @Override
            public void leftFailure(String error) {

            }

            @Override
            public void rightFailure(String error) {

            }
        });
    }
    @Override
    public void getRightInfo(HashMap<String, String> params) {
        userModel.getRightInfo(params, new UserModel.ModelCallback() {
            @Override
            public void leftSuccess(String result) {

            }
            @Override
            public void rightSuccess(String result) {
                RightInfo info=new Gson().fromJson(result,RightInfo.class);
                List<RightInfo.Cls> data=info.data;
                view.rightsuccess(data);
            }

            @Override
            public void leftFailure(String error) {

            }

            @Override
            public void rightFailure(String error) {

            }
        });
    }
}
