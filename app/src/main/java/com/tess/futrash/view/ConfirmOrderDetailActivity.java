package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tess.futrash.R;

public class ConfirmOrderDetailActivity extends AppCompatActivity {

    private TextView textView_tanggal_confirm, textView_nama_food, textView_location_food, textView_shipping_type,
    textView_nama_penjual, textView_phone_penjual, textView_item_date, textView_tanggal_order, textView_terima_tolak,
    textView_catatan_alasan, textView_kembali, textView_hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order_detail);
        textView_tanggal_confirm=findViewById(R.id.tv_confirm_detail_tanggal_confirm);
        textView_nama_food=findViewById(R.id.tv_confirm_detail_jenis_makanan);
        textView_location_food=findViewById(R.id.tv_confirm_detail_location_food);
        textView_shipping_type=findViewById(R.id.tv_confirm_detail_shipping_type);
        textView_nama_penjual=findViewById(R.id.tv_confirm_detail_nama_penjual);
        textView_phone_penjual=findViewById(R.id.tv_confirm_detail_phone_penjual);
        textView_item_date=findViewById(R.id.tv_confirm_detail_date_item);
        textView_tanggal_order=findViewById(R.id.tv_confirm_detail_tanggal_order);
        textView_terima_tolak=findViewById(R.id.tv_confirm_detail_terima_tolak);
        textView_catatan_alasan=findViewById(R.id.tv_confirm_detail_catatan_alasan);
        textView_kembali=findViewById(R.id.tv_confirm_detail_btn_kembali);
        textView_hapus=findViewById(R.id.tv_confirm_detail_btn_hapus);

        textView_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public  void showConfirmDetail(){

        if(getIntent().getExtras()!=null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            textView_tanggal_confirm.setText(bundle.getString("dc"));
            textView_nama_food.setText(bundle.getString("jm"));
            textView_location_food.setText(bundle.getString("lm"));
            textView_shipping_type.setText(bundle.getString("st"));
            textView_nama_penjual.setText(bundle.getString("np"));
            textView_phone_penjual.setText(bundle.getString("pm"));
            textView_item_date.setText(bundle.getString("di"));
            textView_tanggal_order.setText(bundle.getString("do"));
            textView_terima_tolak.setText(bundle.getString("tt"));
            textView_catatan_alasan.setText(bundle.getString("cm"));






        }
    }

}