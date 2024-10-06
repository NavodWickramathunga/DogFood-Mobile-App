package com.example.dogfood.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogfood.Domain.Foods;
import com.example.dogfood.Helper.ChangeNumberItemsListener;
import com.example.dogfood.Helper.ManagmentCart;

import java.util.ArrayList;



public class CartAdapter extends  RecyclerView.Adapter<CartAdapter.viewholder> {
    ArrayList<Foods> list;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(ArrayList<Foods> list, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;

    }

    @NonNull
    @Override
    public CartAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewholder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.feeEachItem.setText("$"+list.get(position).getPrice());
        holder.totalEachItem.setText(list.get(position).getNumberInCart()+" * $"+list.get(position).getPrice();
        holder.num.setText(list.get(position).getNumberInCart()*list.get(position).getNumberInCart ()+"");

        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);

        holder.plusItem.setOnClickListener(new View OnClicklistener() {
            @Override
            public void onClick (View v){
                managmentCart.plusNumberFood(list, position, new ChangeNumberItemsListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.change();
                    }
                });
            }
        });

        holder.minuItem.setOnClickListener(new View OnClicklistener() {
            @Override
                    public void onClick(View v){
                managmentCart.minusNumberItem(list,position, () -> {
                    notifyDataSetChanged();
                    changeNumberItemsListener.change();
                });
            }
        }



    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt, feeEachItem, plusitem, minusitem;
        ImageView pic;
        TextView totalEachItem,num;
    }
    
    public viewholder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.titleTxt);
        pic = itemView.findViewById(R.id.pic);
        feeEachItem = itemView.findViewById(R.id.feeEachItem);
        plusItem = itemView.findViewById(R.id.plusItem);
        minuItem = itemView.findViewById(R.id.minuItem);
        totalEachItem = itemView.findViewById(R.id.totalEachItem);
        num = itemView.findViewById(R.id.numTxt);
        }
    }
}
