package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.tess.futrash.R;
import com.tess.futrash.servis.MethodsFactory;
import com.tess.futrash.servis.RetrofitHandle;
import com.tess.futrash.shared_pref.SpHandle;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        textView_date_item=findViewById(R.id.tv_detail_order_date_item_post);

        textView_btn_edit=findViewById(R.id.tv_detail_order_edit_order);
        textView_btn_hbngi_penjual=findViewById(R.id.tv_detail_order_hubungi_mitra);
        textView_btn_delete=findViewById(R.id.tv_detail_order_hapus_order);
        textView_btn_back=findViewById(R.id.tv_detail_order_back_btn);

        showItemDetail();

    }

    public  void showItemDetail(){

        if(getIntent().getExtras()!=null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            //textView_jenis_makanan.setText(bundle.getString("jm"));
            spHandle.setSpIdOrder(SpHandle.SP_ID_ORDER,bundle.getLong("id_order"));

            textView_nama_customer.setText(bundle.getString("cn"));
            textView_lokasi_customer.setText(bundle.getString("cl"));
            textView_phone_cuatomer.setText(bundle.getString("cp"));
            textView_jenis_pengiriman.setText(bundle.getString("jp"));
            textView_tanggal_order.setText(bundle.getString("ca"));

            textView_nama_makanan.setText(bundle.getString("jm"));
            textView_tidak_dikonsumsi_sejak.setText(bundle.getString("tds"));
            textView_dipost_karena.setText(bundle.getString("dk"));
            textView_berat_makanan.setText(bundle.getString("bm"));
            textView_nama_toko.setText(bundle.getString("nt"));
            textView_nama_penjual.setText(bundle.getString("np"));
            textView_lokasi_makanan.setText(bundle.getString("lm"));
            textView_harga_makanan.setText(bundle.getString("hm"));
            textView_saran_penggunaan.setText(bundle.getString("sp"));
            textView_kandungan_kimia.setText(bundle.getString("kk"));
            textView_phone_penjuaal.setText(bundle.getString("pn"));
            textView_date_item.setText(bundle.getString("di"));
        }

    }

    public  void hubungiMitra(){

    }

    public  void deleteOrder(){

    }

    public  void editOrder(){

        Bundle bundle = new Bundle();
        bundle.putLong("id_order",spHandle.getSpIdOrder());
        bundle.putString("cn",textView_nama_customer.getText().toString());
        bundle.putString("cl",textView_lokasi_customer.getText().toString());
        bundle.putString("cp",textView_phone_cuatomer.getText().toString());
        bundle.putString("jp",textView_jenis_pengiriman.getText().toString());
        bundle.putString("jm", textView_nama_makanan.getText().toString());
        bundle.putString("tds",textView_tidak_dikonsumsi_sejak.getText().toString());
        bundle.putString("dk",textView_dipost_karena.getText().toString());
        bundle.putString("bm",textView_berat_makanan.getText().toString());
        bundle.putString("nt",textView_nama_toko.getText().toString());
        bundle.putString("np",textView_nama_penjual.getText().toString());
        bundle.putString("lm",textView_lokasi_makanan.getText().toString());
        bundle.putString("hm",textView_harga_makanan.getText().toString());
        bundle.putString("sp",textView_saran_penggunaan.getText().toString());
        bundle.putString("kk",textView_kandungan_kimia.getText().toString());
        bundle.putString("pn",textView_phone_penjuaal.getText().toString());
        bundle.putString("di",textView_date_item.getText().toString());
        bundle.putString("ca",textView_tanggal_order.getText().toString());

        Intent intent = new Intent(OrderDetail.this, EditOrderFromItem.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public  void backBtn(){

    }


    //delete order

    //send to seller id
    //get id from mitra id sp
    public void orderToSeller(){

        Long id = spHandle.getIdMitra();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);
        Long id_customer= spHandle.getSpIdUser();

        Long id_order=spHandle.getSpIdOrder();


        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<String> call= methodsFactory.deleteOrderToSeller(id, id_order,token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(OrderDetail.this,BottomNavigation.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(OrderDetail.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(OrderDetail.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(OrderDetail.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(OrderDetail.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(OrderDetail.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }

    //get id from id when regis
    public void deleteToOwnSelf(){

        Long id = spHandle.getSpIdUser();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);

        Long id_order= spHandle.getSpIdOrder();

        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<String> call= methodsFactory.deleteOrderToMe(id,id_order, token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(OrderDetail.this,BottomNavigation.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(OrderDetail.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(OrderDetail.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(OrderDetail.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(OrderDetail.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(OrderDetail.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });


    }
}