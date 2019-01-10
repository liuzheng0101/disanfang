package com.example.nostudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nostudy.R;
import com.example.nostudy.bean.RightInfo;
import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private Context context;
    private List<RightInfo.Right> list;
    public RightAdapter(Context context, List<RightInfo.Right> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.right_one,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).name);
        RightInfo.Right bean=list.get(i);
        List<RightInfo.Right.Rights> lists=bean.list;

        viewHolder.rv.setLayoutManager(new GridLayoutManager(context,3));
        viewHolder.rv.setAdapter(new RightsAdapter(context,lists));
    }
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            rv=itemView.findViewById(R.id.rv);
        }
    }
}
