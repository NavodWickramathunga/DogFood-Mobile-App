package com.example.dogfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.dogfood.Activity.DetailActivity;
import com.example.dogfood.Domain.Foods;
import com.example.dogfood.R;

import java.util.ArrayList;

public class BestFoodAdapter extends RecyclerView.Adapter<BestFoodAdapter.ViewHolder> {
    private ArrayList<Foods> items;
    private Context context;

    public BestFoodAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BestFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_best_deal, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodAdapter.ViewHolder holder, int position) {
        Foods food = items.get(position);
        holder.titleTxt.setText(food.getTitle());
        holder.priceTxt.setText("$" + food.getPrice());
        holder.timeTxt.setText(food.getTimeValue() + "min");
        holder.starTxt.setText("" + food.getStar());

        Glide.with(context)
                .load(food.getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", food);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, priceTxt, starTxt, timeTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            starTxt = itemView.findViewById(R.id.starTxt);
            timeTxt = itemView.findViewById(R.id.timeTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}