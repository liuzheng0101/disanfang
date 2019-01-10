package com.example.nostudy.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nostudy.R;
import com.example.nostudy.adapter.LeftAdapter;
import com.example.nostudy.adapter.RightAdapter;
import com.example.nostudy.bean.LeftInfo;
import com.example.nostudy.bean.RightInfo;
import com.example.nostudy.contract.UserContract;
import com.example.nostudy.presenter.UserPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_Main extends Fragment implements UserContract.IUserView,LeftAdapter.ClickListener {
    @BindView(R.id.rv_left)
    RecyclerView leftrv;
    @BindView(R.id.rv_right)
    RecyclerView rightrv;

    private UserPresenter userPresenter;
    private LeftAdapter leftAdapter;
    private String cid="1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main,container,false);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }
    private void initData() {
        leftrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        userPresenter=new UserPresenter(this);
        getDatas(cid);
        userPresenter.getLeftInfo(new HashMap<String, String>());
    }
    private void getDatas(String cid) {
        HashMap<String,String> params=new HashMap<>();
        params.put("cid",cid);
        userPresenter.getRightInfo(params);
    }
    @Override
    public void leftsuccess(List<LeftInfo.Left> info) {
        if (leftAdapter == null) {
            leftAdapter=new LeftAdapter(getActivity(),info);
            leftrv.setAdapter(leftAdapter);
            leftAdapter.setClickListener(this);
        }else{
            leftAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void Rightsuccess(List<RightInfo.Right> info) {
        rightrv.setAdapter(new RightAdapter(getActivity(),info));
    }
    @Override
    public void Leftfailure(String msg) {

    }
    @Override
    public void Rightfailure(String msg) {

    }

    @Override
    public void click(String cid) {
        getDatas(cid);
    }
}
