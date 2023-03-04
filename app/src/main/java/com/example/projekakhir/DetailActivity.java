package com.example.projekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projekakhir.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DataFlight dataFlight = getIntent().getParcelableExtra(EXTRA_DATA);
        binding.ImgFlight.setImageResource(dataFlight.getDetailImg());
        binding.TvDetail1.setText(dataFlight.getFlName());
        binding.TvDetail2.setText(dataFlight.getFlPrc());
        binding.TVDetail3.setText(dataFlight.getFlDescription());
        int harga = dataFlight.getHarga();
        DataFlight data = new DataFlight();
        data.setHarga(harga);
        binding.btnDetail.setOnClickListener(view -> {
            Intent intent = new Intent(this, InputActivity.class);
            intent.putExtra(InputActivity.EXTRA_DATA, data);
            startActivity(intent);
        });
    }

}