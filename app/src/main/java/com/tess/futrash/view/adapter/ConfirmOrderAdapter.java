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
import com.tess.futrash.model.pojo_confirmation.get_confirm.Content;
import com.tess.futrash.view.ConfirmOrderDetailActivity;
import com.tess.futrash.view.ItemDetail;

import java.util.List;

public class ConfirmOrderAdapter extends RecyclerView.Adapter<ConfirmOrderAdapter.ConfirmOrderChild> {

    public Context context;

    public List<Content> contentList;

    public ConfirmOrderAdapter(Context context, List<Content> contentList){
        this.context=context;
        this.contentList=contentList;
    }



    @NonNull
    @Override
    public ConfirmOrderChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_confirmation_item, parent, false);
        ConfirmOrderChild confirmOrderChild = new ConfirmOrderChild(mView);


        return confirmOrderChild;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmOrderChild holder, int position) {
        final Content content= contentList.get(position);
        holder.textView_nama_penjual.setText(content.getNamaMitra());
        holder.textView_order_status.setText(content.getTerimaTolak());
        holder.textView_catatn_mitra.setText(content.getCatatanAlasan());
        holder.textView_tanggal_confirm.setText(content.getCreatedAt());
        holder.textView_nama_makanan.setText(content.getJenisMakanan());
        holder.textView_lokasi_makanan.setText(content.getLokasiMitra());
        holder.textView_phone_penjual.setText(content.getPhoneMitra());
        holder.textView_shipping_type.setText(content.getShippingType());

        holder.cardView_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putLong("id_confirm",content.getId());
                bundle.putString("dc",content.getCreatedAt());
                bundle.putString("jm",content.getJenisMakanan());
                bundle.putString("lm",content.getLokasiMitra());
                bundle.putString("st",content.getShippingType());
                bundle.putString("np",content.getNamaMitra());
                bundle.putString("pm",content.getPhoneMitra());
                bundle.putString("di",content.getItemDate());
                bundle.putString("do",content.getOrderDate());
                bundle.putString("tt",content.getTerimaTolak());
                bundle.putString("cm",content.getCatatanAlasan());


                Intent intent = new Intent(context, ConfirmOrderDetailActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class ConfirmOrderChild extends RecyclerView.ViewHolder{
        private CardView cardView_confirm;
        private TextView textView_nama_penjual, textView_order_status, textView_catatn_mitra,
        textView_tanggal_confirm, textView_nama_makanan, textView_lokasi_makanan, textView_phone_penjual,
        textView_shipping_type;

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
            textView_shipping_type=itemView.findViewById(R.id.tv_confirm_shipping_type);
        }
    }
}
