package com.tess.futrash.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tess.futrash.R;

public class ConfirmOrderAdapter extends RecyclerView.Adapter<ConfirmOrderAdapter.ConfirmOrderChild> {

    @NonNull
    @Override
    public ConfirmOrderChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmOrderChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ConfirmOrderChild extends RecyclerView.ViewHolder{
        private CardView cardView_confirm;
        private TextView textView_nama_penjual, textView_order_status, textView_catatn_mitra,
        textView_tanggal_confirm, textView_nama_makanan, textView_lokasi_makanan, textView_phone_penjual,
        textView_harga_makanan;

        public ConfirmOrderChild(@NonNull View itemView) {
            super(itemView);
            cardView_confirm=itemView.findViewById(R.id.cv_confirm_confirm);
            textView_nama_penjual=itemView.findViewById(R.id.tv_confirm_nama_penjual);
            textView_order_status=itemView.findViewById(R.id.tv_confirm_satatus_order);
            textView_catatn_mitra=itemView.findViewById(R.id.tv_confirm_catatan_mitra);
            textView_tanggal_confirm=itemView.findViewById(R.id.tv_confirm_tanggal_confirm);
            textView_nama_makanan=itemView.findViewById(R.id.tv_confirm_jenis_makanan);
            textView_lokasi_makanan=itemView.findViewById(R.id.tv_confirm_lokasi_makanan);
            textView_phone_penjual=itemView.findViewById(R.id.tv_confirm_phone_makanan);
            textView_harga_makanan=itemView.findViewById(R.id.tv_confirm_harga_makanan);
        }
    }
}
