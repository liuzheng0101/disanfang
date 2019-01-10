package com.example.week222.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week222.Bean.RightInfo;
import com.example.week222.R;

import java.util.ArrayList;
import java.util.List;

public class RightItemAdapter extends RecyclerView.Adapter<RightItemAdapter.ViewHolder> {
    private Context context;
    private List<RightInfo.Cls.Pcls> list;

    public RightItemAdapter(Context context, List<RightInfo.Cls.Pcls> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.right_item_two,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RightInfo.Cls.Pcls bean = list.get(i);
        viewHolder.nameTv.setText(bean.name);
        String[] spilt=bean.icon.split("!");
        Glide.with(context).load(spilt[0]).into(viewHolder.iv);
    }
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv;
        private ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
