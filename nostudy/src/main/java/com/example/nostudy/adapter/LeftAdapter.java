package com.example.nostudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.nostudy.R;
import com.example.nostudy.bean.LeftInfo;

import java.util.ArrayList;
import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    private Context context;
    private List<LeftInfo.Left> list=new ArrayList<>();
    public LeftAdapter(Context context, List<LeftInfo.Left> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.left_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(list.get(i).name);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener!=null){
                    clickListener.click(list.get(i).cid);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
    private ClickListener clickListener;
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public interface ClickListener{
        void click(String cid);
    }
}
