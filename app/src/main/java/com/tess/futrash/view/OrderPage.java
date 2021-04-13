package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.tess.futrash.R;
import com.tess.futrash.model.pojo_chart.post_chart.ChartPostRespon;
import com.tess.futrash.model.pojo_order.post_order.CustomerPostOrderRespon;
import com.tess.futrash.servis.MethodsFactory;
import com.tess.futrash.servis.RetrofitHandle;
import com.tess.futrash.shared_pref.SpHandle;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        textView_btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_nama_customer.getText().toString().isEmpty()&&editText_phone_customer.getText().toString().isEmpty()&& editText_lokasi_customer.getText().toString().isEmpty()&&editText_shipping_type.getText().toString().isEmpty()){
                    editText_nama_customer.setError("field kosong");
                    editText_phone_customer.setError("field kosong");
                    editText_lokasi_customer.setError("field kosong");
                    editText_shipping_type.setError("field kosong");


                }else {
                    metodKirim();


                }

            }
        });

        detailOrderFromItem();


    }

    //send to seller id
    //get id from mitra id sp
    public void orderToSeller(){

        Long id = spHandle.getIdMitra();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);

        String jenis_food=textView_jenis_makanan.getText().toString();
        String tdk_dknsumsi_sejak=textView_tidak_dikonsumsi_sejak.getText().toString();
        String dijual_karena=textView_dijual_karena.getText().toString();
        String berat_makanan=textView_berat_makanan.getText().toString();
        String nama_toko=textView_nama_toko.getText().toString();
        String nama_penjual=textView_nama_penjual.getText().toString();
        String lokasi_makanan=textView_lokasi_makanan.getText().toString();
        String harga_makanan=textView_harga_makanan.getText().toString();
        String saran_penggunann=textView_saran_penggunaan.getText().toString();
        String kandungan_kimia=textView_kandungan_kimia.getText().toString();
        String nomor_telepon=textView_phone_number.getText().toString();
        String date_item=textView_date_item.getText().toString();
        String image_url= "image_url";

        String nama_customer=editText_nama_customer.getText().toString();
        String phone_customer=editText_phone_customer.getText().toString();
        String lokasi_customer=editText_lokasi_customer.getText().toString();
        String shipping_type=editText_shipping_type.getText().toString();


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

        jsonObject.addProperty("customer_name",nama_customer );
        jsonObject.addProperty("customer_location", lokasi_customer);
        jsonObject.addProperty("customer_phone", phone_customer);
        jsonObject.addProperty("shipping_type",shipping_type );


        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<CustomerPostOrderRespon> call= methodsFactory.orderItemToBuyer(id, token,jsonObject);
        call.enqueue(new Callback<CustomerPostOrderRespon>() {
            @Override
            public void onResponse(Call<CustomerPostOrderRespon> call, Response<CustomerPostOrderRespon> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(OrderPage.this,BottomNavigation.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(OrderPage.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(OrderPage.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(OrderPage.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(OrderPage.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<CustomerPostOrderRespon> call, Throwable t) {
                Toast.makeText(OrderPage.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }

    //get id from id when regis
    public void orderToOwnSelf(){

        Long id = spHandle.getSpIdUser();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);

        String jenis_food=textView_jenis_makanan.getText().toString();
        String tdk_dknsumsi_sejak=textView_tidak_dikonsumsi_sejak.getText().toString();
        String dijual_karena=textView_dijual_karena.getText().toString();
        String berat_makanan=textView_berat_makanan.getText().toString();
        String nama_toko=textView_nama_toko.getText().toString();
        String nama_penjual=textView_nama_penjual.getText().toString();
        String lokasi_makanan=textView_lokasi_makanan.getText().toString();
        String harga_makanan=textView_harga_makanan.getText().toString();
        String saran_penggunann=textView_saran_penggunaan.getText().toString();
        String kandungan_kimia=textView_kandungan_kimia.getText().toString();
        String nomor_telepon=textView_phone_number.getText().toString();
        String date_item=textView_date_item.getText().toString();
        String image_url= "image_url";

        String nama_customer=editText_nama_customer.getText().toString();
        String phone_customer=editText_phone_customer.getText().toString();
        String lokasi_customer=editText_lokasi_customer.getText().toString();
        String shipping_type=editText_shipping_type.getText().toString();




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

        jsonObject.addProperty("customer_name",nama_customer );
        jsonObject.addProperty("customer_location", lokasi_customer);
        jsonObject.addProperty("customer_phone", phone_customer);
        jsonObject.addProperty("shipping_type",shipping_type );






        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<CustomerPostOrderRespon> call= methodsFactory.orderItemToMe(id, token,jsonObject);
        call.enqueue(new Callback<CustomerPostOrderRespon>() {
            @Override
            public void onResponse(Call<CustomerPostOrderRespon> call, Response<CustomerPostOrderRespon> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(OrderPage.this,BottomNavigation.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(OrderPage.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(OrderPage.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(OrderPage.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(OrderPage.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<CustomerPostOrderRespon> call, Throwable t) {
                Toast.makeText(OrderPage.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });


    }



    public void detailOrderFromItem(){
        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            //textView_jenis_makanan.setText(bundle.getString("jm"));

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
            textView_date_item.setText(bundle.getString("ca"));

            //pake id ini untuk order link(dinamis id)
            spHandle.setIdMitraItem(SpHandle.SP_ID_MITRA_ITEM,bundle.getLong(("id_user")));

            //utk save ke table chart (statis id, ambilnya nnti dri data chart)
            spHandle.setSpIdUserForChart(SpHandle.SP_ID_USER_FOR_CHART,bundle.getLong("id_user"));

        }
        
    }

    public  void metodKirim(){
        orderToOwnSelf();
        orderToSeller();
    }
}