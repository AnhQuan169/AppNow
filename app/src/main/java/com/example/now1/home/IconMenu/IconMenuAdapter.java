package com.example.now1.home.IconMenu;

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

public class IconMenuAdapter extends RecyclerView.Adapter<IconMenuAdapter.MyViewHolder> {

    private Context context;
    private List<ListIcon> apps;
    OnClickItemIcon onClickItemIcon;

    public IconMenuAdapter(Context context, List<ListIcon> apps) {
        this.context = context;
        this.apps = apps;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.nameicon);
            mImage = itemView.findViewById(R.id.imgicon);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_listicon,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ListIcon app = apps.get(position);

        holder.mName.setText(app.getNameicon());
        holder.mImage.setImageResource(app.getImageicon());


    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

}
