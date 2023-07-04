package com.example.rama_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.rama_uts.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // mengambil data yg kita ketik di layout
                String nama = binding.etNamaRegister.getText().toString();
                String email = binding.etEmailRegister.getText().toString();
                String password = binding.etPasswordRegister.getText().toString();

                if (TextUtils.isEmpty(nama)){
                    binding.etNamaRegister.setError("Nama harus di isi");
                } else if (TextUtils.isEmpty(email)){
                    binding.etEmailRegister.setError("Email harus di isi");
                } else if(TextUtils.isEmpty(password)){
                    binding.etPasswordRegister.setError("password harus di isi");
                } else {
                    Intent register = new Intent(RegisterActivity.this,RegisterSuccessActivity.class);
                    register.putExtra("Nama",nama);
                    register.putExtra("Email",email);
                    register.putExtra("Password",password);
                    startActivity(register);
                    finishAffinity();
                }

            }
        });

        binding.TvSudahPunyaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "fitur ini belum tersedia", Toast.LENGTH_SHORT).show();
            }
        });
    }
}