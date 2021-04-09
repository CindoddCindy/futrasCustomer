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
import com.tess.futrash.model.pojo_order.get_order.Content;

import java.util.List;
import java.util.PrimitiveIterator;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderItemChild> {

    public Context context;
    public List<Content> contentList;

    public OrderItemAdapter(Context context, List<Content>contentList){
        this.context=context;
        this.contentList=contentList;

    }

    @NonNull
    @Override
    public OrderItemChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        OrderItemChild orderItemChild = new OrderItemChild(mView);

        return orderItemChild;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemChild holder, int position) {
        final Content content = contentList.get(position);
        holder.textView_nama_penjual.setText(content.getNamaPenjual());
        holder.textView_nama_makanan.setText(content.getJenisMakanan());
        holder.textView_lokasi_makakan.setText(content.getLokasiMakanan());
        holder.textView_phone.setText(content.getPhoneNumber());
        holder.textView_shipping_type.setText(content.getShippingType());
        holder.textView_tanggal.setText(content.getCreatedAt());

        holder.cardView_order_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderItemChild extends RecyclerView.ViewHolder{

        public CardView cardView_order_item;
        public TextView textView_hapus, textView_tanggal, textView_nama_penjual, textView_nama_makanan,
        textView_lokasi_makakan, textView_phone, textView_shipping_type;

        public OrderItemChild(@NonNull View itemView) {
            super(itemView);
            cardView_order_item=itemView.findViewById(R.id.cv_order_item);
            textView_tanggal=itemView.findViewById(R.id.tv_order_item_tanggal_order);
            textView_shipping_type=itemView.findViewById(R.id.tv_order_item_jenis_pengiriman);
            textView_phone=itemView.findViewById(R.id.tv_order_item_phone_makanan);
            textView_lokasi_makakan=itemView.findViewById(R.id.tv_order_item_lokasi_makanan);
            textView_nama_makanan=itemView.findViewById(R.id.tv_order_page_nama_makanan);
            textView_nama_penjual=itemView.findViewById(R.id.tv_order_item_nama_penjual);
            textView_hapus=itemView.findViewById(R.id.tv_order_item_hapus);

        }
    }
}
