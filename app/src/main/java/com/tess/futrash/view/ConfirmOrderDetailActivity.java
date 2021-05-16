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

public class ConfirmOrderDetailActivity extends AppCompatActivity {

    private TextView textView_tanggal_confirm, textView_nama_food, textView_location_food, textView_shipping_type,
    textView_nama_penjual, textView_phone_penjual, textView_item_date, textView_tanggal_order, textView_terima_tolak,
    textView_catatan_alasan, textView_kembali, textView_hapus;

    private SpHandle spHandle;

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

        spHandle=new SpHandle(ConfirmOrderDetailActivity.this);

        textView_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteConfirm();
            }
        });

        showConfirmDetail();
    }

    public  void showConfirmDetail(){

        if(getIntent().getExtras()!=null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            spHandle.setSpIdConfirm(SpHandle.SP_ID_CONFIRM_ORDER, bundle.getLong("id_confirm"));
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


    public void deleteConfirm(){

        Long id = spHandle.getSpIdUser();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);
        Long id_customer= spHandle.getSpIdUser();

        Long id_order=spHandle.getSpIdConfirm();


        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<String> call= methodsFactory.deleteConfirm(id, id_order,token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(ConfirmOrderDetailActivity.this,BottomNavigation.class);
                    startActivity(intent);



                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ConfirmOrderDetailActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ConfirmOrderDetailActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(ConfirmOrderDetailActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(ConfirmOrderDetailActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(ConfirmOrderDetailActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }


}