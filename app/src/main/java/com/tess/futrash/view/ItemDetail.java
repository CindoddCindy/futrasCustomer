package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tess.futrash.R;
import com.tess.futrash.shared_pref.SpHandle;

public class ItemDetail extends AppCompatActivity {

    public SpHandle spHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        spHandle= new SpHandle(ItemDetail.this);


        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            //textView_jenis_makanan.setText(bundle.getString("jm"));
            spHandle.setIdMitraItem(SpHandle.SP_ID_MITRA_ITEM,bundle.getLong(("id_user")));
            spHandle.setSpIdUserForChart(SpHandle.SP_ID_USER_FOR_CHART,bundle.getLong("id_user"));

        }
    }

}