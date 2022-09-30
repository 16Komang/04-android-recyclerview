package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MotorListAdapter extends RecyclerView.Adapter<MotorListAdapter.MotorViewHolder>{
    private ArrayList<MotorData> MotorList;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnItemClickListener;

    public MotorListAdapter(Context context, ArrayList<MotorData> MotorList){
        mInflater = LayoutInflater.from(context);
        this.MotorList = MotorList;
    }

    @NonNull
    @Override
    public MotorListAdapter.MotorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.item_list, viewGroup, false);
        return new MotorViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MotorListAdapter.MotorViewHolder MotorViewHolder, int position) {
        MotorViewHolder.name.setText((MotorList.get(position)).getName());
        MotorViewHolder.description.setText((MotorList.get(position)).getDescription());
        Glide.with(MotorViewHolder.itemView)
                .load(MotorList.get(position).getImage())
                .override(100, 150)
                .into(MotorViewHolder.image);
    }


    @Override
    public int getItemCount() {
        return MotorList.size();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    class MotorViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;


        public MotorViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.Motor_name);
            description = itemView.findViewById(R.id.Motor_description);
            image = itemView.findViewById(R.id.Motor_image);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}
