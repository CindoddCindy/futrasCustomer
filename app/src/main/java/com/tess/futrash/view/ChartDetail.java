package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tess.futrash.R;

public class ChartDetail extends AppCompatActivity {

    private TextView textView_jenis_makanan, textView_tidak_dikonsumsi_sejak,
    textView_dijual_karena, textView_berat_makanan, textView_nama_toko,
    textView_nama_penjual, textView_lokasi_makanan, textView_harga_makanan,
    textView_saran_penggunaan, textView_kandungan_kimia, textView_phone_number, textView_date_item,
    textView_hapus_chart, textView_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_detail);

        textView_jenis_makanan=findViewById(R.id.tv_chart_detail_nama_makanan);
        textView_tidak_dikonsumsi_sejak=findViewById(R.id.tv_chart_detail_tidak_di_konsumsi_sejak);
        textView_dijual_karena=findViewById(R.id.tv_chart_detail_di_posting_karena);
        textView_berat_makanan=findViewById(R.id.tv_chart_detail_berat_makanan);
        textView_nama_toko=findViewById(R.id.tv_chart_detail_nama_toko);
        textView_nama_penjual=findViewById(R.id.tv_chart_detail_nama_penjual);
        textView_lokasi_makanan=findViewById(R.id.tv_chart_detail_lokasi_makanan);
        textView_harga_makanan=findViewById(R.id.tv_chart_detail_harga_makanan);
        textView_saran_penggunaan=findViewById(R.id.tv_chart_detail_saran_penggunaan);
        textView_kandungan_kimia=findViewById(R.id.tv_chart_detail_kandungan_kimia);
        textView_phone_number=findViewById(R.id.tv_chart_detail_nomor_telepon);
        textView_date_item=findViewById(R.id.tv_chart_detail_tanggal_item_dipost);
        textView_hapus_chart=findViewById(R.id.tv_chart_detail_btn_hapus_chart);
        textView_order=findViewById(R.id.tv_chart_detail_btn_order);
    }

    public void showChartDetail(){

    }

    public  void deleteChart(){

    }

    public void orderItemFromChart(){

    }
}