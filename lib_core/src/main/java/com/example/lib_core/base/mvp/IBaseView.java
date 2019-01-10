package com.example.lib_core.base.mvp;

public interface IBaseView {
    BasePresenter initPresenter();//初始化presenter方法
    void hideLoading();  //隐藏加载框
    void showLoading();  //显示加载框
    void failure(String msg);   //请求失败
}
