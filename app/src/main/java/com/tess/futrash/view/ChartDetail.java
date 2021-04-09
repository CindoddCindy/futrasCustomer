package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.tess.futrash.R;
import com.tess.futrash.shared_pref.SpHandle;

public class ChartDetail extends AppCompatActivity {

    private TextView textView_jenis_makanan, textView_tidak_dikonsumsi_sejak,
    textView_dijual_karena, textView_berat_makanan, textView_nama_toko,
    textView_nama_penjual, textView_lokasi_makanan, textView_harga_makanan,
    textView_saran_penggunaan, textView_kandungan_kimia, textView_phone_number, textView_date_item,
    textView_hapus_chart, textView_order;

    public Long id_order_dari_chart ;

    private SpHandle spHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_detail);

        spHandle= new SpHandle(ChartDetail.this);

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

        if(getIntent().getExtras()!=null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            //textView_jenis_makanan.setText(bundle.getString("jm"));

            spHandle.setIdMitraItem(SpHandle.SP_CHART_TO_ORDER_ID,bundle.getLong(("id_user"))); // pakai id ini jika mau order dr chart ke order page

            textView_jenis_makanan.setText(bundle.getString("jm"));
            textView_tidak_dikonsumsi_sejak.setText(bundle.getString("tds"));
            textView_dijual_karena.setText(bundle.getString("dk"));
            textView_berat_makanan.setText(bundle.getString("bm"));
            textView_nama_toko.setText(bundle.getString("nt"));
            textView_nama_penjual.setText(bundle.getString("np"));
            textView_lokasi_makanan.setText(bundle.getString("lm"));
            textView_harga_makanan.setText(bundle.getString("hm"));
            textView_saran_penggunaan.setText(bundle.getString("sp"));
            textView_kandungan_kimia.setText(bundle.getString("kk"));
            textView_phone_number.setText(bundle.getString("pn"));
            textView_date_item.setText(bundle.getString("di"));
        }


    }

    public  void deleteChart(){

    }

    public void orderItemFromChart(){
        Intent intent = new Intent(ChartDetail.this, OrderFromChart.class);
        startActivity(intent);
        finish();

    }
}