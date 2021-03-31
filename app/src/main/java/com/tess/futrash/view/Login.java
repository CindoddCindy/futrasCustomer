package com.tess.futrash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tess.futrash.R;

public class Login extends AppCompatActivity {
    private EditText editText_name, editText_password;
    private TextView textView_login_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_name=findViewById(R.id.et_login_name);
        editText_password=findViewById(R.id.et_login_password);
        textView_login_btn=findViewById(R.id.tv_btn_login);

        textView_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText_name.getText().toString().isEmpty()&&editText_password.getText().toString().isEmpty()){
                    editText_name.setError("nama belum diisi");
                    editText_password.setError("password belum diisi");


                }else {
                    btnLogin();


                }

            }
        });
    }

    private void btnLogin(){

    }
}