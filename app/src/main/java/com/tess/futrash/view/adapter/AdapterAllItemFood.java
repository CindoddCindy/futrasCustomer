package com.tess.futrash.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tess.futrash.R;

public class AdapterAllItemFood extends RecyclerView.Adapter<AdapterAllItemFood.AllFoodChild> {

    @NonNull
    @Override
    public AllFoodChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AllFoodChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AllFoodChild extends RecyclerView.ViewHolder{

        private TextView textView_nama_penjual, textView_tanggal_posting, textView_nama_makanan,
        textView_lokasi_makanan, textView_no_telp_makanan, textView_harga;

        private CardView cardView_all_item_food;

        public AllFoodChild(@NonNull View itemView) {
            super(itemView);

            textView_nama_penjual=itemView.findViewById(R.id.tv_all_food_nama_penjual);
            textView_tanggal_posting=itemView.findViewById(R.id.tv_all_food_date);
            textView_nama_makanan=itemView.findViewById(R.id.tv_all_food_jenis_makanan);
            textView_lokasi_makanan=itemView.findViewById(R.id.tv_all_food_lokasi_makanan);
            textView_no_telp_makanan=itemView.findViewById(R.id.tv_all_food_phone);
            textView_harga=itemView.findViewById(R.id.tv_all_food_price);
            cardView_all_item_food=itemView.findViewById(R.id.cv_all_food_item);
        }
    }
}
