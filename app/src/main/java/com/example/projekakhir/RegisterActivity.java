package com.example.projekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projekakhir.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        binding.bt1.setOnClickListener(view -> {
            ProfileRegister profile = new ProfileRegister();

            profile.setUsername(binding.edtRsatu.getText().toString().trim() + " " + binding.edtRdua.getText().toString().trim());
            profile.setAddres(binding.edtRtiga.getText().toString().trim());
            profile.setCountry(binding.edtRempat.getText().toString().trim());
            profile.setEmail(binding.edtRlima.getText().toString().trim());
            profile.setPassword(binding.edtRenam.getText().toString().trim());


            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra(MainActivity.EXTRA_PROFILE, profile);
            startActivity(intent);
        });
    }
}