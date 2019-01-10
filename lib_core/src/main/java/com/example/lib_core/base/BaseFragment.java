package com.example.lib_core.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =LayoutInflater.from(getActivity()).inflate(bindLayoutId(),container,false);
        initView();
        initData();
        return view;
    }

    protected abstract void initData();
    protected abstract void initView();
    protected abstract int bindLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind(); //解绑
        }
    }
}
