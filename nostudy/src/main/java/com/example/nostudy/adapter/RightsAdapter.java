package com.example.nostudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nostudy.R;
import com.example.nostudy.bean.RightInfo;

import org.w3c.dom.Text;

import java.util.List;

public class RightsAdapter extends RecyclerView.Adapter<RightsAdapter.ViewHolder> {
    private Context context;
    private List<RightInfo.Right.Rights> list;
    public RightsAdapter(Context context, List<RightInfo.Right.Rights> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.right_two,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).name);
        RightInfo.Right.Rights bean=list.get(i);
        String[] spilt=bean.icon.split("!");
        Glide.with(context).load(spilt[0]).into(viewHolder.icon);
    }
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            icon=itemView.findViewById(R.id.icon);
        }
    }
}
