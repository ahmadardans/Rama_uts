package com.example.rama_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.rama_uts.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
 ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // mengambil data yg ada di intent
        Intent registersukses = getIntent();
        String nama  = registersukses.getStringExtra("Nama");
        String email = registersukses.getStringExtra("Email");
        String password = registersukses.getStringExtra("Password");

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = binding.etNamaLogin.getText().toString().trim();
                String Password  = binding.etPasswordLogin.getText().toString().trim();

                if (TextUtils.isEmpty(Nama)) {
                    binding.etNamaLogin.setError("Nama harus di isi");
                } else if (TextUtils.isEmpty(Password)) {
                    binding.etPasswordLogin.setError("Password harus di isi");
                }else {
                    // mengecek apabila nama yg diketik sesaui dengan nama yang ada di data intent
                    // dan menecek pula password yg diketik apakah sesuai dengan password yg ada di data intent
                    // jika semua nya sesuai dia akan pindah ke layout main dan mengirim data intent
                    if(TextUtils.equals(nama, Nama) && TextUtils.equals(password, Password)) {
                        Toast.makeText(LoginActivity.this, "Anda berhasil Login", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(LoginActivity.this,MainActivity.class);
                        login.putExtra("Nama",Nama);
                        login.putExtra("Password",Password);
                        login.putExtra("Email",email);
                        startActivity(login);
                        finishAffinity();
                    } else {
                        // jika tidak sesaui dia akan menampilkan text berikut
                        Toast.makeText(LoginActivity.this, "Nama & Password tidak sesuai!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(menu);
            }
        });

        binding.TvLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Fitur ini belum ada", Toast.LENGTH_SHORT).show();
            }
        });

    }
}