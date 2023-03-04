package com.example.projekakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.example.projekakhir.databinding.ActivityInputBinding;

import java.util.Calendar;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityInputBinding binding;
    int hitungAnak = 0;
    int hitungDewasa = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnCheckout.setOnClickListener(view -> {

            String nama = binding.inputNama.getText().toString().trim();
            String cabin = binding.spKelas.getSelectedItem().toString().trim();
            String date = binding.inputTanggal.getText().toString().trim();
            String from = binding.spBerangkat.getSelectedItem().toString();
            String tujuan = binding.spTujuan.getSelectedItem().toString();

            DataFlight data = getIntent().getParcelableExtra(EXTRA_DATA);
            DataInput dataInput = new DataInput();
            dataInput.setName(nama);
            dataInput.setCabin(cabin);
            dataInput.setDate(date);
            dataInput.setFrom(from);
            dataInput.setTo(tujuan);
            dataInput.setPrice(String.valueOf(data.getHarga()));

            Intent intent = new Intent (InputActivity.this, HistoryActivity.class);
            intent.putExtra(HistoryActivity.EXTRA_HISTORY,dataInput);
            startActivity(intent);
        });

        getSupportActionBar().setTitle("Pesan Tiket");

        binding.imageAdd1.setOnClickListener(this);
        binding.imageMinus1.setOnClickListener(this);
        binding.imageAdd2.setOnClickListener(this);
        binding.imageMinus2.setOnClickListener(this);
        binding.tvJmlAnak.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int jumlah = Integer.parseInt(binding.tvJmlAnak.getText().toString());
                if(jumlah == 0){
                    binding.imageMinus1.setEnabled(false);
                }
                else if (jumlah > 1){
                    binding.imageMinus1.setEnabled(true);
                    binding.imageMinus1.setOnClickListener(view -> {
                        hitungAnak = hitungAnak - 1 ;
                        binding.tvJmlAnak.setText(String.valueOf(hitungAnak));
                    });
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.tvJmlDewasa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int jumlah = Integer.parseInt(binding.tvJmlDewasa.getText().toString());
                if(jumlah == 1){
                    binding.imageMinus2.setEnabled(false);
                }
                else if (jumlah > 1){
                    binding.imageMinus2.setEnabled(true);
                    binding.imageMinus2.setOnClickListener(view -> {
                        hitungDewasa = hitungDewasa - 1 ;
                        binding.tvJmlDewasa.setText(String.valueOf(hitungDewasa));
                    });
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
        resouce();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.imageAdd1.getId()){
            hitungAnak = hitungAnak + 1 ;
            binding.tvJmlAnak.setText(String.valueOf(hitungAnak));
        }

        else if (view.getId() == binding.imageAdd2.getId()){
            hitungDewasa = hitungDewasa + 1 ;
            binding.tvJmlDewasa.setText(String.valueOf(hitungDewasa));
        }


    }

    private void resouce(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Country, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spBerangkat.setAdapter(adapter);
        binding.spTujuan.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spKelas.setAdapter(adapter2);

        binding.inputTanggal.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            int thn = c.get(Calendar.YEAR);
            int bln = c.get(Calendar.MONTH);
            int tgl = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(InputActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int thn, int bln, int tgl) {
                    binding.inputTanggal.setText(tgl + "-" + (bln+ 1) +"-"+ thn);
                }
            }, thn, bln, tgl);
            datePickerDialog.show();
        });


    }

    public static final String EXTRA_DATA = "extra data";
}