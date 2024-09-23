package com.example.dogfood.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogfood.Adapter.BestFoodAdapter;
// Ensure you have this class
import com.example.dogfood.Adapter.CategoryAdapter;
import com.example.dogfood.Domain.Category;
import com.example.dogfood.Domain.Foods;
import com.example.dogfood.Domain.Location;
import com.example.dogfood.Domain.Price;
import com.example.dogfood.R;
import com.example.dogfood.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase Database instance
        database = FirebaseDatabase.getInstance();

        // Initialize data
        initLocation();
        initTime();
        initPrice();
        initBestFood();
        initCategory();
    }

    private void initTime() {
    }

    private void initBestFood() {
        DatabaseReference myRef = database.getReference("Food");
        binding.progressBarBestfood.setVisibility(View.VISIBLE);
        ArrayList<Foods> list = new ArrayList<>();
        Query query=myRef.orderByChild("BestFood").equalTo(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue: snapshot.getChildren()){
                        list.add(issue.getValue(Foods.class));
                    }
                    if (list.size()>0){
                        binding.bestFoodView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                        RecyclerView.Adapter adapter = new BestFoodAdapter(list);
                        binding.bestFoodView.setAdapter(adapter);
                    }
                    binding.progressBarBestfood.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                binding.progressBarBestfood.setVisibility(View.GONE);

            }
        });
    }

    private void initCategory() {
        DatabaseReference myRef = database.getReference("Category");
        binding.progressBarBestfood.setVisibility(View.VISIBLE);
        ArrayList<Category> list = new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue: snapshot.getChildren()){
                        list.add(issue.getValue(Category.class));
                    }
                    if (list.size()>0){
                        binding.categoryView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
                        RecyclerView.Adapter adapter = new CategoryAdapter(list);
                        binding.categoryView.setAdapter(adapter);
                    }
                    binding.progressBarBestfood.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                binding.progressBarCategory.setVisibility(View.GONE);

            }
        });
    }

    private void initLocation() {
        DatabaseReference myRef = database.getReference("Location");
        ArrayList<Location> list = new ArrayList<>();  // Changed from "List" to "list"
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        list.add(issue.getValue(Location.class));
                    }
                    ArrayAdapter<Location> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.locationSp.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }

    private void initPrice() {
        DatabaseReference myRef = database.getReference("Price");
        ArrayList<Price> list = new ArrayList<>();  // Changed from "List" to "list"
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        list.add(issue.getValue(Price.class));
                    }
                    ArrayAdapter<Price> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.PriceSp.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }
}

//    private void initBestFood() {
//        binding.progressBarBestfood.setVisibility(View.VISIBLE);
//        DatabaseReference myRef = database.getReference("Food");
//        ArrayList<Foods> list = new ArrayList<>();
//
//        Query query = myRef.orderByChild("BestFood").equalTo(true);
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                binding.progressBarBestfood.setVisibility(View.GONE);
//                if (snapshot.exists()) {
//                    for (DataSnapshot issue : snapshot.getChildren()) {
//                        list.add(issue.getValue(Foods.class));
//                    }
//                    // Use foodList to update your RecyclerView or UI
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                binding.progressBarBestfood.setVisibility(View.GONE);
//                // Handle error
//            }
//        });
//    }
//
//    private void initLocation() {
//        DatabaseReference myRef = database.getReference("Location");
//        ArrayList<Location> list = new ArrayList<>();
//
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    for (DataSnapshot issue : snapshot.getChildren()) {
//                        list.add(issue.getValue(Location.class));
//                    }
//                    ArrayAdapter<Location> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    binding.locationSp.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Handle error
//            }
//        });
//    }
//
//    private void initTime() {
//        DatabaseReference myRef = database.getReference("Time");
//        ArrayList<Time> list = new ArrayList<>();
//
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    for (DataSnapshot issue : snapshot.getChildren()) {
//                        list.add(issue.getValue(Time.class));
//                    }
//                    ArrayAdapter<Time> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    binding.timeSp.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Handle error
//            }
//        });
//    }
//
//    private void initPrice() {
//        DatabaseReference myRef = database.getReference("Price");
//        ArrayList<Price> list = new ArrayList<>();
//
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    for (DataSnapshot issue : snapshot.getChildren()) {
//                        list.add(issue.getValue(Price.class));
//                    }
//                    ArrayAdapter<Price> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    binding.PriceSp.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Handle error
//            }
//        });
//    }
//}


