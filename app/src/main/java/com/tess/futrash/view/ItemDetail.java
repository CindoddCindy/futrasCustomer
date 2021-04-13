package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tess.futrash.R;
import com.tess.futrash.model.pojo_chart.post_chart.ChartPostRespon;
import com.tess.futrash.model.pojo_regis.RegisCustomerRespon;
import com.tess.futrash.servis.MethodsFactory;
import com.tess.futrash.servis.RetrofitHandle;
import com.tess.futrash.shared_pref.SpHandle;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDetail extends AppCompatActivity {

    private TextView textView_nama_makanan, textView_tidak_dikonsumsi_sejak, textView_dijual_karena,
    textView_berat_makanan, textView_nama_toko, textView_nama_penjual,
    textView_lokasi_makanan, textView_harga_makanan, textView_saran_penggunaan,
    textView_kandungan_kimia, textView_phone_num, textView_date_item;

    private TextView textView_btn_add_to_chart;
    private TextView textView_btn_add_to_order;

    public SpHandle spHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        spHandle= new SpHandle(ItemDetail.this);

        textView_nama_makanan=findViewById(R.id.item_detail_nama_food);
        textView_tidak_dikonsumsi_sejak=findViewById(R.id.item_detail_tidak_dikonsumsi_sejak);
        textView_dijual_karena=findViewById(R.id.tv_item_detail_di_post_karena);
        textView_berat_makanan=findViewById(R.id.tv_item_detail_berat_makanan);
        textView_nama_toko=findViewById(R.id.tv_item_detail_nama_toko);
        textView_nama_penjual=findViewById(R.id.item_detail_nama_merchant);
        textView_lokasi_makanan=findViewById(R.id.item_detail_lokasi_makanan);
        textView_harga_makanan=findViewById(R.id.tv_item_detail_harga);
        textView_saran_penggunaan=findViewById(R.id.item_detail_saran_penggunaan);
        textView_kandungan_kimia=findViewById(R.id.item_detail_kandungan_kimia);
        textView_phone_num=findViewById(R.id.item_detail_phone);
        textView_date_item=findViewById(R.id.item_detail_tanggal_item_post);
        textView_btn_add_to_chart=findViewById(R.id.item_detail_btn_add_to_chart);
        textView_btn_add_to_order=findViewById(R.id.btn_item_detail_order);

        textView_btn_add_to_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToChart();

            }
        });

        textView_btn_add_to_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToOrder();

            }
        });

        dataFromAdapter();



    }
    //post data
    public void addToChart(){

        //ke user id krna chart cuma utk d liat buyer(customer)
        Long id = spHandle.getSpIdUser();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);

        String jenis_food=textView_nama_makanan.getText().toString();
        String tdk_dknsumsi_sejak=textView_tidak_dikonsumsi_sejak.getText().toString();
        String dijual_karena=textView_dijual_karena.getText().toString();
        String berat_makanan=textView_berat_makanan.getText().toString();
        String nama_toko=textView_nama_toko.getText().toString();
        String nama_penjual=textView_nama_penjual.getText().toString();
        String lokasi_makanan=textView_lokasi_makanan.getText().toString();
        String harga_makanan=textView_harga_makanan.getText().toString();
        String saran_penggunann=textView_saran_penggunaan.getText().toString();
        String kandungan_kimia=textView_kandungan_kimia.getText().toString();
        String nomor_telepon=textView_phone_num.getText().toString();
        String date_item=textView_date_item.getText().toString();
        Long id_user_item=spHandle.getIdMitraForChart();
        String image_url= "image_url";


        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("image_url", image_url);
        jsonObject.addProperty("jenis_makanan",jenis_food);
        jsonObject.addProperty("tidak_dikonsumsi_sejak", tdk_dknsumsi_sejak);
        jsonObject.addProperty("dijual_karena", dijual_karena);
        jsonObject.addProperty("berat_makanan", berat_makanan);
        jsonObject.addProperty("nama_toko",nama_toko );
        jsonObject.addProperty("nama_penjual", nama_penjual);
        jsonObject.addProperty("lokasi_makanan", lokasi_makanan);
        jsonObject.addProperty("harga_makanan", harga_makanan);
        jsonObject.addProperty("saran_penggunaan",saran_penggunann );
        jsonObject.addProperty("kandungan_kimia", kandungan_kimia);
        jsonObject.addProperty("phone_number", nomor_telepon);
        jsonObject.addProperty("item_date",date_item );
        jsonObject.addProperty("id_mitra",id_user_item);





        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<ChartPostRespon> call= methodsFactory.addToChart(id, token,jsonObject);
        call.enqueue(new Callback<ChartPostRespon>() {
            @Override
            public void onResponse(Call<ChartPostRespon> call, Response<ChartPostRespon> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(ItemDetail.this,BottomNavigation.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ItemDetail.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ItemDetail.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(ItemDetail.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(ItemDetail.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<ChartPostRespon> call, Throwable t) {
                Toast.makeText(ItemDetail.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }

    //send pake bundle
    public void addToOrder(){

        Bundle bundle = new Bundle();
        //bundle.putLong("id_user",content.getUser().getId());
        bundle.putLong("id_user", spHandle.getIdMitra());
        bundle.putString("jm", textView_nama_makanan.getText().toString());
        bundle.putString("tds",textView_tidak_dikonsumsi_sejak.getText().toString());
        bundle.putString("dk",textView_dijual_karena.getText().toString());
        bundle.putString("bm",textView_berat_makanan.getText().toString());
        bundle.putString("nt",textView_nama_toko.getText().toString());
        bundle.putString("np",textView_nama_penjual.getText().toString());
        bundle.putString("lm",textView_lokasi_makanan.getText().toString());
        bundle.putString("hm",textView_harga_makanan.getText().toString());
        bundle.putString("sp",textView_saran_penggunaan.getText().toString());
        bundle.putString("kk",textView_kandungan_kimia.getText().toString());
        bundle.putString("pn",textView_phone_num.getText().toString());
        bundle.putString("ca",textView_date_item.getText().toString());

        Intent intent = new Intent(ItemDetail.this, OrderPage.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public  void dataFromAdapter(){

        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            //textView_jenis_makanan.setText(bundle.getString("jm"));

            textView_nama_makanan.setText(bundle.getString("jm"));
            textView_tidak_dikonsumsi_sejak.setText(bundle.getString("tds"));
            textView_dijual_karena.setText(bundle.getString("dk"));
            textView_berat_makanan.setText(bundle.getString("bm"));
            textView_nama_toko.setText(bundle.getString("nt"));
            textView_nama_penjual.setText(bundle.getString("np"));
            textView_lokasi_makanan.setText(bundle.getString("lm"));
            textView_harga_makanan.setText(bundle.getString("hm"));
            textView_saran_penggunaan.setText(bundle.getString("sp"));
            textView_kandungan_kimia.setText(bundle.getString("kk"));
            textView_phone_num.setText(bundle.getString("pn"));
            textView_date_item.setText(bundle.getString("ca"));

            //pake id ini untuk order link(dinamis id)
            spHandle.setIdMitraItem(SpHandle.SP_ID_MITRA_ITEM,bundle.getLong(("id_user")));

            //utk save ke table chart (statis id, ambilnya nnti dri data chart)
            spHandle.setSpIdUserForChart(SpHandle.SP_ID_USER_FOR_CHART,bundle.getLong("id_user"));

        }

    }

}