package com.example.projekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projekakhir.databinding.ActivityMainBinding;

import java.util.BitSet;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        ProfileRegister profile = getIntent().getParcelableExtra(EXTRA_PROFILE);

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);

        binding.bt1.setOnClickListener(view -> {
            if(Objects.equals(profile, null)){
                if (binding.textEditUser.getText().toString().equals("Zafar") && binding.textEditPassword.getText().toString().equals("12345")){
                    startActivity(intent);
                }
            }
            else{
                String Username = profile.getEmail();
                String Password = profile.getPassword();

                String InputUsername = binding.textEditUser.getText().toString();
                String InputPassword = binding.textEditPassword.getText().toString();
                if(InputUsername.equals(Username) && InputPassword.equals(Password)){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Username = "+ Username + " Password = "+Password, Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.tv2.setOnClickListener(view -> {
            Intent inten = new Intent (this, RegisterActivity.class);
            startActivity(inten);
        });

    }
        public static String EXTRA_PROFILE = "extra_profile";
}