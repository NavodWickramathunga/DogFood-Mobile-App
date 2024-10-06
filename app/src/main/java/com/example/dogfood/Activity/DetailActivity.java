package com.example.dogfood.Activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.dogfood.Helper.ManagmentCart;
import com.example.dogfood.R;
import com.example.dogfood.databinding.ActivityDetailBinding;
import com.example.dogfood.Domain.Foods;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private Foods object;
    private int num = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart = new ManagmentCart(this);

        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(this).load(object.getImagePath()).into(binding.pic);

        binding.priceTxt.setText(String.format("$%.2f", object.getPrice()));
        binding.titelTxt.setText(object.getTitle());
        binding.discriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(String.format("%.1f Ratings", object.getStar()));
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText(String.format("$%.2f", num * object.getPrice()));

        binding.plusBtn.setOnClickListener(v -> {
            num = num + 1;
            binding.numTxt.setText(String.valueOf(num));
            binding.totalTxt.setText(String.format("$%.2f", num * object.getPrice()));
        });

        binding.minusBtn.setOnClickListener(v -> {
            if (num > 1) {
                num = num - 1;
                binding.numTxt.setText(String.valueOf(num));
                binding.totalTxt.setText(String.format("$%.2f", num * object.getPrice()));
            }
        });

        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertFood(object);
        });
    }

    private void getIntentExtra() {
        object = (Foods) getIntent().getSerializableExtra("object");
    }
}