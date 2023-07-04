package com.example.rama_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rama_uts.databinding.ActivityRegisterSuccessBinding;

public class RegisterSuccessActivity extends AppCompatActivity {
    ActivityRegisterSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // mengambil data yg ada di intent
        Intent registersukses = getIntent();
        String nama = registersukses.getStringExtra("Nama");
        String email = registersukses.getStringExtra("Email");
        String password = registersukses.getStringExtra("Password");


        binding.btnLoginRegisterSukses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registersukses = new Intent(RegisterSuccessActivity.this,LoginActivity.class);
                registersukses.putExtra("Nama",nama);
                registersukses.putExtra("Email",email);
                registersukses.putExtra("Password",password);
                startActivity(registersukses);
                finishAffinity();
            }
        });
    }
}