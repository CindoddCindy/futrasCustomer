package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tess.futrash.R;
import com.tess.futrash.shared_pref.SpHandle;

public class OrderDetail extends AppCompatActivity {

    private TextView textView_tanggal_order, textView_nama_customer, textView_lokasi_customer, textView_phone_cuatomer,
    textView_jenis_pengiriman, textView_nama_makanan, textView_lokasi_makanan, textView_nama_penjual, textView_phone_penjuaal,
    textView_tidak_dikonsumsi_sejak, textView_dipost_karena, textView_berat_makanan, textView_nama_toko,
    textView_harga_makanan, textView_saran_penggunaan, textView_kandungan_kimia, textView_date_item;

    private TextView textView_btn_edit, textView_btn_delete,
            textView_btn_hbngi_penjual, textView_btn_back;

    public SpHandle spHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        spHandle = new SpHandle(OrderDetail.this);

        textView_tanggal_order=findViewById(R.id.tv_detail_order_tanggal_order);
        textView_nama_customer=findViewById(R.id.tv_detail_order_nama_customer);
        textView_lokasi_customer=findViewById(R.id.tv_detail_order_lokasi_cust);
        textView_phone_cuatomer=findViewById(R.id.tv_detail_order_phone_customer);
        textView_jenis_pengiriman=findViewById(R.id.tv_detail_order_jenis_pengiriman);

        textView_nama_makanan=findViewById(R.id.tv_detail_order_nama_makanan);
        textView_lokasi_makanan=findViewById(R.id.tv_detail_order_lokasi_makanan);
        textView_nama_penjual=findViewById(R.id.tv_detail_order_nama_penjual);
        textView_phone_penjuaal=findViewById(R.id.tv_detail_order_phone_makanan);

        textView_tidak_dikonsumsi_sejak=findViewById(R.id.tv_detail_order_tidak_dikonsumsi_sejak);
        textView_dipost_karena=findViewById(R.id.tv_detail_order_di_post_karena);
        textView_berat_makanan=findViewById(R.id.tv_detail_order_berat_makanan);
        textView_nama_toko=findViewById(R.id.tv_detail_order_nama_toko);
        textView_harga_makanan=findViewById(R.id.tv_detail_order_harga_makananan);
        textView_saran_penggunaan=findViewById(R.id.tv_detail_order_saran_penggunaan);
        textView_kandungan_kimia=findViewById(R.id.tv_detail_order_kandungan_kimia);

        textView_btn_edit=findViewById(R.id.tv_detail_order_edit_order);
        textView_btn_hbngi_penjual=findViewById(R.id.tv_detail_order_hubungi_mitra);
        textView_btn_delete=findViewById(R.id.tv_detail_order_hapus_order);
        textView_btn_back=findViewById(R.id.tv_detail_order_back_btn);
    }

    public  void showItemDetail(){

    }

    public  void hubungiMitra(){

    }

    public  void deleteOrder(){

    }

    public  void editOrder(){

    }

    public  void backBtn(){

    }
}