package com.example.nostudy.contract;

import com.example.nostudy.bean.LeftInfo;
import com.example.nostudy.bean.RightInfo;
import com.example.nostudy.model.UserModel;

import java.util.HashMap;
import java.util.List;

public interface UserContract {
    //P 层
    public abstract class getUseInfo{
        public abstract void getLeftInfo(HashMap<String,String> params);
        public abstract void getRightInfo(HashMap<String,String> params);
    }
    //model 层
    public interface IUserModel{
        void getLeftInfo(HashMap<String,String> params, UserModel.ModelCallback callback);
        void getRightInfo(HashMap<String,String> params, UserModel.ModelCallback callback);
    }
    //V 层
    public interface IUserView{
        void leftsuccess(List<LeftInfo.Left> info);
        void Rightsuccess(List<RightInfo.Right> info);

        void Leftfailure(String msg);
        void Rightfailure(String msg);
    }
}
