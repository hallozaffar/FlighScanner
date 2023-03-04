package com.example.projekakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.projekakhir.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    protected ArrayList<DataFlight> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        list.addAll(getListFlight());
        showRecycleList();

    }
    public ArrayList<DataFlight> getListFlight(){
        TypedArray FlImg = getResources().obtainTypedArray(R.array.FlImg);
        String[] FlName = getResources().getStringArray(R.array.FlName);
        String[] FlPrc = getResources().getStringArray(R.array.FlPrc);
        TypedArray DetailImg = getResources().obtainTypedArray(R.array.detailimg);
        int[] harga = getResources().getIntArray(R.array.harga);
        String[] FlDescripton = getResources().getStringArray(R.array.FlDescription);

        ArrayList<DataFlight> listFlight = new ArrayList<>();
        for (int i = 0; i < FlName.length; i++){
            DataFlight dataFlight = new DataFlight();
            dataFlight.setFlImg(FlImg.getResourceId(i,-1));
            dataFlight.setFlName(FlName[i]);
            dataFlight.setFlPrc(FlPrc[i]);
            dataFlight.setDetailImg(DetailImg.getResourceId(i,-1));
            dataFlight.setHarga(harga[i]);
            dataFlight.setFlDescription(FlDescripton[i]);
            listFlight.add(dataFlight);
        }
        return listFlight;
    }
    private void showRecycleList(){
        binding.rvContent.setLayoutManager(new LinearLayoutManager(this));

        DataFlightAdapter dataFlightAdapter = new DataFlightAdapter(list);
        binding.rvContent.setAdapter(dataFlightAdapter);

        dataFlightAdapter.setOnItemClickCallback(data -> {
            Intent inten = new Intent(this, DetailActivity.class);
            inten.putExtra(DetailActivity.EXTRA_DATA, data);
            startActivity(inten);
        });
    }

}