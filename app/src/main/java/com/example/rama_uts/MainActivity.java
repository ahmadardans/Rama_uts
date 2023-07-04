package com.example.rama_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rama_uts.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // mengambil data yang ada di intent
        Intent login = getIntent();
        String nama = login.getStringExtra("Nama");
        String email= login.getStringExtra("Email");
        String password = login.getStringExtra("Password");

        // menampilkan data yg ada di intent sesuai dgn layout
        binding.TvDatanama.setText(nama);
        binding.TvDataemail.setText(email);
        binding.TvDatapassword.setText(password);

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // jika tombol logout di klik akan kembali ke layouot login dan mengirim kembali data yg ada di intent
                // untuk bisa login kembali
                Toast.makeText(MainActivity.this, "Anda berhasil Logout", Toast.LENGTH_SHORT).show();
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                logout.putExtra("Nama", nama);
                logout.putExtra("Email", email);
                logout.putExtra("Password", password);
                startActivity(logout);
                finishAffinity();
            }
        });
    }
}