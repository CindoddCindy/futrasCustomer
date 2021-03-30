package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tess.futrash.R;

public class Regis extends AppCompatActivity {
    private EditText editText_name, editText_email, editText_phone, editText_password;
    private TextView textView_btn_regis_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        editText_name=findViewById(R.id.et_regis_name);
        editText_email=findViewById(R.id.et_regis_email);
        editText_phone=findViewById(R.id.et_regis_phone);
        editText_password=findViewById(R.id.et_regis_pass);

        textView_btn_regis_submit=findViewById(R.id.tv_btn_regis);

        textView_btn_regis_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_name.getText().toString().isEmpty()&&editText_email.getText().toString().isEmpty()&& editText_phone.getText().toString().isEmpty()&&editText_password.getText().toString().isEmpty()){
                    editText_name.setError("nama belum diisi");
                    editText_email.setError("email belum diisi");
                    editText_phone.setError("nomor telepon belum diisi");
                    editText_password.setError("password belum diisi");


                }else {
                    regisCustomer();


                }

            }
        });
    }

    public void regisCustomer(){

    }
}