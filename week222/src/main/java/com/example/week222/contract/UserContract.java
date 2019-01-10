package com.example.week222.contract;

import com.example.week222.Bean.LeftInfo;
import com.example.week222.Bean.RightInfo;
import com.example.week222.Model.UserModel;

import java.util.HashMap;
import java.util.List;

public interface UserContract {
    abstract class IUserPresenter{
        public abstract void getLeftInfo(HashMap<String,String> params);
        public abstract void getRightInfo(HashMap<String,String> params);
    }
    public interface IUserModel{
        void getLeftInfo(HashMap<String,String> params,UserModel.ModelCallback callback);
        void getRightInfo(HashMap<String,String> params,UserModel.ModelCallback callback);
    }
    public interface IUserView{
        void leftsuccess(List<LeftInfo.Cls> info);
        void rightsuccess(List<RightInfo.Cls> info);
        void leftfailure(String msg);
        void rightfailure(String msg);
    }
}
