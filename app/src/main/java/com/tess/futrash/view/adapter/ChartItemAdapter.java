package com.tess.futrash.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tess.futrash.R;
import com.tess.futrash.model.pojo_chart.get_chart.Content;
import com.tess.futrash.view.ItemDetail;

import java.util.List;

public class ChartItemAdapter extends RecyclerView.Adapter<ChartItemAdapter.ChartItemChild> {

    public Context context;
    public List<Content> contentList;

    public ChartItemAdapter(Context context, List<Content> contentList){
        this.context=context;
        this.contentList=contentList;
    }

    @NonNull
    @Override
    public ChartItemChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chart, parent, false);
        ChartItemChild chartItemChild = new ChartItemChild(mView);

        return chartItemChild;
    }

    @Override
    public void onBindViewHolder(@NonNull ChartItemChild holder, int position) {
        final Content content= contentList.get(position);
        holder.textView_nama_penjual.setText(content.getNamaPenjual());
        holder.textView_tanggal_di_post.setText(content.getItemDate());
        holder.textView_nama_makanan.setText(content.getJenisMakanan());
        holder.textView_lokasi_makanan.setText(content.getLokasiMakanan());
        holder.textView_phone_makanan.setText(content.getPhoneNumber());
        holder.textView_harga_makanan.setText(content.getHargaMakanan());

        holder.cardView_chart_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("id_user",content.getIdMitra());//id ini di simpan ketika dpat detail, setiap sv dr item detail save id mitra
                bundle.putString("jm", content.getJenisMakanan());
                bundle.putString("tds",content.getTidakDikonsumsiSejak());
                bundle.putString("dk",content.getDijualKarena());
                bundle.putString("bm",content.getBeratMakanan());
                bundle.putString("nt",content.getNamaToko());
                bundle.putString("np",content.getNamaPenjual());
                bundle.putString("lm",content.getLokasiMakanan());
                bundle.putString("hm",content.getHargaMakanan());
                bundle.putString("sp",content.getSaranPenggunaan());
                bundle.putString("kk",content.getKandunganKimia());
                bundle.putString("pn",content.getPhoneNumber());
                bundle.putString("di",content.getItemDate());

                Intent intent = new Intent(context, ItemDetail.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contentList.size();
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
