package com.example.dogfood.Activity;

import android.media.MediaPlayer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dogfood.R;
import com.example.dogfood.databinding.ActivitySignupBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends BaseActivity {
    ActivitySignupBinding binding;
    private FirebaseAuth mAuth;
    private String TAG = "SignupActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        setVariable();
        }

        private void setVariable() {
          binding.signupBtn.setOnClickListener((View.OnClickListener) v -> {
              String email = binding.userEdt.getText().toString();
              String password = binding.passEdt.getText().toString();

              if (password.length() < 6) {
                  Toast.makeText(SignupActivity.this, "Your password must be 6 characters", Toast.LENGTH_SHORT).show();
                  return;
              }
              mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, task -> {
                  if (task.isComplete()) {
                      Log.i(TAG, "onComplete: Account created successfully");
                      startActivity(new Intent(SignupActivity.this, MainActivity.class));
                  } else {
                      Log.i(TAG, "failure: " + task.getException());
                      Toast.makeText(SignupActivity.this, "Authenticaltion failed", Toast.LENGTH_SHORT).show();

                  }
              });
          });
    }
}