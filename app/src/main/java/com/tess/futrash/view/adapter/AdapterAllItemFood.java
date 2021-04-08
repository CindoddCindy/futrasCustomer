package com.tess.futrash.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tess.futrash.R;
import com.tess.futrash.model.pojo_all_item.Content;

import java.util.List;

public class AdapterAllItemFood extends RecyclerView.Adapter<AdapterAllItemFood.AllFoodChild> {

    public Context context;
    public List<Content> contentList;

    public AdapterAllItemFood(Context context, List<Content> contentList){
        this.context=context;
        this.contentList=contentList;
    }

    @NonNull
    @Override
    public AllFoodChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_food_layout, parent, false);
        AllFoodChild allFoodChild = new AllFoodChild(mView);

        return allFoodChild;
    }

    @Override
    public void onBindViewHolder(@NonNull AllFoodChild holder, int position) {
        final Content content = contentList.get(position);
        holder.textView_nama_penjual.setText(content.getNamaPenjual());
        holder.textView_tanggal_posting.setText(content.getCreatedAt());
        holder.textView_nama_makanan.setText(content.getJenisMakanan());
        holder.textView_lokasi_makanan.setText(content.getLokasiMakanan());
        holder.textView_no_telp_makanan.setText(content.getPhoneNumber());
        holder.textView_harga.setText(content.getHargaMakanan());

        holder.cardView_all_item_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return contentList.size();
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
