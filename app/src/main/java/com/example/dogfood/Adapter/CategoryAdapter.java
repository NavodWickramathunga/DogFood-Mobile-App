//package com.example.dogfood.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.RoundedCorner;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.dogfood.Domain.Foods;
//import com.example.dogfood.R;
//
//import java.util.ArrayList;
//
//public class BestFoodAdapter extends RecyclerView.Adapter<BestFoodAdapter.viewholder> {
//    ArrayList<Foods> Items;
//    Context context;
//
//    public BestFoodAdapter(ArrayList<Foods> items) {
//        Items = items;
//    }
//
//    @NonNull
//    @Override
//    public BestFoodAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//        context= parent.getContext();
//        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal, parent, false);
//
//        return new viewholder(inflate);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull BestFoodAdapter.viewholder holder, int position) {
//holder.titleTxt.setText(items.get(position).getTitle());
//holder.pricetxt.setText("$"+items.get(position).getPrice());
//holder.timeTxt.setText(""+items.get(position).getTimeValue()+"min");
//holder.starTxt.setText(""+items.get(position).getStar());
//
//Glide.with(context)
//        .load(items.get(position).getImagePath())
//        .transform(new CenterCrop(),new RoundedCorner(30))
//        .into(holder.pic);
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//    public class viewholder extends RecyclerView.ViewHolder {
//        TextView titleTxt,pricetxt,starTxt,timeTxt;
//        ImageView pic;
//        public viewholder(@NonNull View itemView) {
//            super(itemView);
//            titleTxt=itemView.findViewById(R.id.titleTxt);
//            pricetxt=itemView.findViewById(R.id.priceTxt);
//            starTxt=itemView.findViewById(R.id.starTxt);
//            timeTxt=itemView.findViewById(R.id.timeTxt);
//            pic=itemView.findViewById(R.id.pic);
//
//        }
//    }
//}

package com.example.dogfood.Adapter;

import android.content.Context;
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
import com.example.dogfood.Domain.Category;
import com.example.dogfood.Domain.Foods;
import com.example.dogfood.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<Category> items;  // Fix variable name to match in onBindViewHolder
    private Context context;

    // Constructor
    public CategoryAdapter(ArrayList<Category> items) {
        this.items = items;  // Correct capitalization of "items"
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Context should be set before inflating the view
        context = parent.getContext();

        // Inflate the view for the individual item in the RecyclerView
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_category, parent, false);

        // Return the ViewHolder with the inflated view
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        // Set values for the views in each list item
        holder.titleTxt.setText(items.get(position).getName());
        //holder.priceTxt.setText("$" + items.get(position).getPrice());
        //holder.timeTxt.setText(items.get(position).getTimeValue() + "min");
        //holder.starTxt.setText("" + items.get(position).getStar());

        switch (position) {
            case 0: {
                holder.pic.setBackgroundResource(R.drawable.cat_0_background);
                break;
            }
            case 1: {
                holder.pic.setBackgroundResource(R.drawable.cat_1_background);
                break;
            }
            case 3: {
                holder.pic.setBackgroundResource(R.drawable.cat_3_background);
                break;
            }
            case 4: {
                holder.pic.setBackgroundResource(R.drawable.cat_4_background);
                break;
            }
            case 5: {
                holder.pic.setBackgroundResource(R.drawable.cat_5_background);
                break;
            }
            case 6: {
                holder.pic.setBackgroundResource(R.drawable.cat_6_background);
                break;
            }
            case 7: {
                holder.pic.setBackgroundResource(R.drawable.cat_7_background);
                break;
            }
        }

int drawableResourceId=context.getResources().getIdentifier(items.get(position).getImagePath(),"drawable",holder.itemView.getContext().getPackageName());

        // Use Glide to load the image with rounded corners
        Glide.with(context)
                .load(drawableResourceId)

                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // ViewHolder class to manage the views in each list item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the views
            titleTxt = itemView.findViewById(R.id.catNameTxt);

            pic = itemView.findViewById(R.id.imgCat);
        }
    }
}

