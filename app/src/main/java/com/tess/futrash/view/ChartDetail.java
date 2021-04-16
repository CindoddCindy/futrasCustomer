package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tess.futrash.R;
import com.tess.futrash.servis.MethodsFactory;
import com.tess.futrash.servis.RetrofitHandle;
import com.tess.futrash.shared_pref.SpHandle;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        textView_hapus_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToOrderPage();

            }
        });

        showChartDetail();
    }

    public void showChartDetail(){

        if(getIntent().getExtras()!=null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            //textView_jenis_makanan.setText(bundle.getString("jm"));

            spHandle.setIdMitraItem(SpHandle.SP_CHART_TO_ORDER_ID,bundle.getLong(("id_user"))); // pakai id ini jika mau order dr chart ke order page
            spHandle.setSpIdChart(SpHandle.SP_ID_CHART,bundle.getLong("id_chart"));
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

    public void sendToOrderPage(){

            Bundle bundle = new Bundle();
            //bundle.putLong("id_user",content.getUser().getId());

            bundle.putString("jm", textView_jenis_makanan.getText().toString());
            bundle.putString("tds",textView_tidak_dikonsumsi_sejak.getText().toString());
            bundle.putString("dk",textView_dijual_karena.getText().toString());
            bundle.putString("bm",textView_berat_makanan.getText().toString());
            bundle.putString("nt",textView_nama_toko.getText().toString());
            bundle.putString("np",textView_nama_penjual.getText().toString());
            bundle.putString("lm",textView_lokasi_makanan.getText().toString());
            bundle.putString("hm",textView_harga_makanan.getText().toString());
            bundle.putString("sp",textView_saran_penggunaan.getText().toString());
            bundle.putString("kk",textView_kandungan_kimia.getText().toString());
            bundle.putString("pn",textView_phone_number.getText().toString());
            bundle.putString("ca",textView_date_item.getText().toString());

            Intent intent = new Intent(ChartDetail.this, OrderFromChart.class);
            intent.putExtras(bundle);
            startActivity(intent);




    }


    public void deleteCart(){

        Long id = spHandle.getIdMitra();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);
        Long id_customer= spHandle.getSpIdUser();

        Long id_order=spHandle.getSpIdChart();


        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<String> call= methodsFactory.deleteCart(id, id_order,token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(ChartDetail.this,BottomNavigation.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ChartDetail.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ChartDetail.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(ChartDetail.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(ChartDetail.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(ChartDetail.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }

}