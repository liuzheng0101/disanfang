package com.example.week222.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week222.Bean.LeftInfo;
import com.example.week222.Bean.RightInfo;
import com.example.week222.R;
import com.example.week222.adapter.LeftAdapter;
import com.example.week222.adapter.RightAdapter;
import com.example.week222.contract.UserContract;
import com.example.week222.presenter.UserPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_Main extends Fragment implements UserContract.IUserView {
    private UserPresenter userPresenter;
    private LeftAdapter adapter;
    @BindView(R.id.rv_left)
    RecyclerView leftRv;
    @BindView(R.id.rv_right)
    RecyclerView rightRv;
    private String cid="1";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_main,container,false);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }
    private void initData() {
        leftRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        userPresenter=new UserPresenter(this);
        getsData();
        userPresenter.getLeftInfo(new HashMap<String, String>());
    }
    private void getsData() {
        HashMap<String,String> p2=new HashMap<>();
        p2.put("cid",cid);
        userPresenter.getRightInfo(p2);
    }
    @Override
    public void leftsuccess(List<LeftInfo.Cls> info) {
        adapter=new LeftAdapter(getActivity());
        leftRv.setAdapter(adapter);
        adapter.setData(info);
    }
    @Override
    public void rightsuccess(List<RightInfo.Cls> info) {
        rightRv.setAdapter(new RightAdapter(getActivity(),info));
    }
    @Override
    public void leftfailure(String msg) {

    }
    @Override
    public void rightfailure(String msg) {

    }
}