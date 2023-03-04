package com.example.projekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projekakhir.databinding.ActivityHistoryBinding;

public class HistoryActivity extends AppCompatActivity {


    ActivityHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DataInput datainput = getIntent().getParcelableExtra(EXTRA_HISTORY);
        binding.tvNama.setText(datainput.getName());
        binding.tvKelas.setText(datainput.getCabin());
        binding.tvKeberangkatan.setText(datainput.getFrom());
        binding.tvTujuan.setText(datainput.getTo());
        binding.tvDate.setText(datainput.getDate());
        binding.tvHargaTiket.setText(datainput.getPrice());

    }
    public static String EXTRA_HISTORY = "extra_history";
}