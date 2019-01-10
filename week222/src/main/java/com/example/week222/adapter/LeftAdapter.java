package com.example.week222.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.week222.Bean.LeftInfo;
import com.example.week222.R;

import java.util.ArrayList;
import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    private Context context;
    private List<LeftInfo.Cls> list;
    public LeftAdapter(Context context) {
        this.context = context;
        this.list=new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_main,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final LeftInfo.Cls cls=list.get(i);
        viewHolder.nameTv.setText(cls.name);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    public void setData(List<LeftInfo.Cls> data) {
        this.list= (List<LeftInfo.Cls>) data;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv=itemView.findViewById(R.id.name);
        }
    }
}
