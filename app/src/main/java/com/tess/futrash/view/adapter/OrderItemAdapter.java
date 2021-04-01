package com.tess.futrash.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tess.futrash.R;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderItemChild> {

    @NonNull
    @Override
    public OrderItemChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderItemChild extends RecyclerView.ViewHolder{

        public CardView cardView_order_item;
        public TextView textView_hapus, textView_tanggal, textView_nama_penjual, textView_nama_makanan,
        textView_lokasi_makakan, textView_phone, textView_harga;

        public OrderItemChild(@NonNull View itemView) {
            super(itemView);

        }
    }
}
