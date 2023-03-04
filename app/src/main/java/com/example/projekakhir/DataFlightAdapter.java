package com.example.projekakhir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataFlightAdapter extends RecyclerView.Adapter<DataFlightAdapter.ListViewHolder> {
    private ArrayList<DataFlight> listFlight;
    public DataFlightAdapter(ArrayList<DataFlight> list){
        this.listFlight = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        DataFlight dataFlight = listFlight.get(position);
        holder.imgFlight.setImageResource(dataFlight.getFlImg());
        holder.TvCountry.setText(dataFlight.getFlName());
        holder.TvPrice.setText(dataFlight.getFlPrc());


        holder.itemView.setOnClickListener(view -> {
            onItemClickCallback.onItemClicked(listFlight.get(holder.getAdapterPosition()));
        });

    }

    @Override
    public int getItemCount() {
        return listFlight.size();

    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgFlight;
        TextView TvCountry;
        TextView TvPrice;
        public ListViewHolder(View view) {
            super(view);
            imgFlight = view.findViewById(R.id.ImgFlight);
            TvCountry = view.findViewById(R.id.TvCountry);
            TvPrice = view.findViewById(R.id.TvPrice);
        }
    }
    public interface OnItemClickCallback{
        void onItemClicked(DataFlight data);
    }
}
