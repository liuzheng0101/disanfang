package com.example.week222.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week222.Bean.RightInfo;
import com.example.week222.R;

import java.util.ArrayList;
import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder>{
    private Context context;
    private List<RightInfo.Cls> list;

    public RightAdapter(Context context, List<RightInfo.Cls> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.right_item_one,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RightInfo.Cls bean = list.get(i);
        List<RightInfo.Cls.Pcls> list = bean.list;
        viewHolder.nameTv.setText(bean.name);

        viewHolder.rv.setLayoutManager(new GridLayoutManager(context,3));
        viewHolder.rv.setAdapter(new RightItemAdapter(context,list));
    }
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv;
        private RecyclerView rv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            rv = itemView.findViewById(R.id.rv);
        }
    }
}
