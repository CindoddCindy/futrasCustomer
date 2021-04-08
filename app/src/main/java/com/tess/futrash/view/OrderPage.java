package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.tess.futrash.R;
import com.tess.futrash.shared_pref.SpHandle;

public class OrderPage extends AppCompatActivity {

    private TextView textView_jenis_makanan, textView_tidak_dikonsumsi_sejak,
    textView_dijual_karena, textView_berat_makanan, textView_nama_toko,
    textView_nama_penjual, textView_lokasi_makanan, textView_harga_makanan,
    textView_saran_penggunaan, textView_kandungan_kimia, textView_phone_number,
    textView_date_item;

    private TextView textView_btn_order;

    private EditText editText_nama_customer, editText_lokasi_customer, editText_phone_customer,
    editText_shipping_type;

    private SpHandle spHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        spHandle= new SpHandle(OrderPage.this);
        textView_jenis_makanan=findViewById(R.id.tv_order_page_nama_makanan);
        textView_tidak_dikonsumsi_sejak=findViewById(R.id.tv_order_page_tidak_dikonsumsi_sejak);
        textView_dijual_karena=findViewById(R.id.tv_order_page_diposting_karena);
        textView_berat_makanan=findViewById(R.id.tv_order_page_berat_makanan);
        textView_nama_toko=findViewById(R.id.tv_order_page_nama_toko);
        textView_nama_penjual=findViewById(R.id.tv_order_page_nama_penjual);
        textView_lokasi_makanan=findViewById(R.id.tv_order_page_lokasi_makanan);
        textView_harga_makanan=findViewById(R.id.tv_order_page_harga_food);
        textView_saran_penggunaan=findViewById(R.id.tv_order_page_saran_penggunaan);
        textView_kandungan_kimia=findViewById(R.id.tv_order_page_kandungan_kimia);
        textView_phone_number=findViewById(R.id.tv_order_page_phone_makanan);
        textView_date_item=findViewById(R.id.tv_order_page_tanggal_dipost);

        textView_btn_order=findViewById(R.id.tv_order_page_btn_order_item);

        editText_nama_customer=findViewById(R.id.et_order_page_customer_name);
        editText_phone_customer=findViewById(R.id.et_order_page_customer_phone);
        editText_lokasi_customer=findViewById(R.id.et_order_page_lokasi_customer);
        editText_shipping_type=findViewById(R.id.et_order_page_jenis_pengiriman);
    }

    //send to seller id
    //get id from mitra id sp
    public void orderToSeller(){

    }

    //get id from id when regis
    public void orderToBuyer(){

    }
}