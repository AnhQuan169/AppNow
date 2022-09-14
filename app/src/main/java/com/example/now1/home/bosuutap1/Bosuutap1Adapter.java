package com.example.now1.home.bosuutap1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.now1.R;

import java.util.List;

public class Bosuutap1Adapter extends RecyclerView.Adapter<Bosuutap1Adapter.MyViewHolder> {

    private Context context;
    private List<ListBoSuuTap1> apps;

    public Bosuutap1Adapter(Context context, List<ListBoSuuTap1> apps) {
        this.context = context;
        this.apps = apps;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mNamebst1;
        ImageView mImagebst1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mNamebst1 = itemView.findViewById(R.id.namebst1);
            mImagebst1 = itemView.findViewById(R.id.imgbst1);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_listbosuutap1,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ListBoSuuTap1 app = apps.get(position);

        holder.mNamebst1.setText(app.getNamebst());
        holder.mImagebst1.setImageResource(app.getImagebst());

    }
    @Override
    public int getItemCount() {
        return apps.size();
    }


}