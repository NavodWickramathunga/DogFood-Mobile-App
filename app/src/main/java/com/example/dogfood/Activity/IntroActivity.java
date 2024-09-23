package com.example.dogfood.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dogfood.databinding.ActivityIntroBinding;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dogfood.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {
    ActivityIntroBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#FFE485"));
    }

//    private void setVariable() {
//        binding.Loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> {
            if (mAuth.getCurrentUser() != null) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        });
//       binding.SignupBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(IntroActivity.this, SignupActivity.class));
//            }
//        });
//    }
//}

        binding.signupBtn.setOnClickListener(v ->
                startActivity(new Intent(IntroActivity.this, SignupActivity.class))
        );
    }
}
