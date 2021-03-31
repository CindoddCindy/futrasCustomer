package com.tess.futrash.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tess.futrash.R;

public class ChartItemAdapter extends RecyclerView.Adapter<ChartItemAdapter.ChartItemChild> {

    @NonNull
    @Override
    public ChartItemChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ChartItemChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ChartItemChild extends RecyclerView.ViewHolder{
        private CardView cardView_chart_;
        private TextView textView_nama_penjual, textView_hapus_chart, textView_tanggal_di_post, textView_nama_makanan,
        textView_lokasi_makanan, textView_phone_makanan, textView_harga_makanan;

        public ChartItemChild(@NonNull View itemView) {
            super(itemView);
            cardView_chart_=itemView.findViewById(R.id.cv_chart_item);
            textView_nama_penjual=itemView.findViewById(R.id.tv_chart_nama_penjual);
            textView_hapus_chart=itemView.findViewById(R.id.tv_chart_delete_chart);
            textView_tanggal_di_post=itemView.findViewById(R.id.tv_chart_tanggal_post);
            textView_nama_makanan=itemView.findViewById(R.id.tv_chart_jenis_makanan);
            textView_lokasi_makanan=itemView.findViewById(R.id.tv_chart_lokasi_makanan);
            textView_phone_makanan=itemView.findViewById(R.id.tv_chart_phone);
            textView_harga_makanan=itemView.findViewById(R.id.tv_chart_harga);

        }
    }
}
