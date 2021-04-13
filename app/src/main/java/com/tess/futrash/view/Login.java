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
import com.tess.futrash.model.pojo_login.LoginCustomerRespon;
import com.tess.futrash.servis.MethodsFactory;
import com.tess.futrash.servis.RetrofitHandle;
import com.tess.futrash.shared_pref.SpHandle;
import com.tess.futrash.view.fragment.LandingPageFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText editText_name, editText_password;
    private TextView textView_login_btn;
    private SpHandle spHandle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_name=findViewById(R.id.et_login_name);
        editText_password=findViewById(R.id.et_login_password);
        textView_login_btn=findViewById(R.id.tv_btn_login);

        spHandle = new SpHandle(Login.this);

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

        if (spHandle.getHaveLogin()){
            startActivity(new Intent(Login.this, BottomNavigation.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    private void btnLogin(){

        String name = editText_name.getText().toString();
        String password = editText_password.getText().toString();

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("password", password);



        MethodsFactory methodsFactory =  RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<LoginCustomerRespon> call= methodsFactory.isLoginValid(jsonObject);
        call.enqueue(new Callback<LoginCustomerRespon>() {
            @Override
            public void onResponse(Call<LoginCustomerRespon> call, Response<LoginCustomerRespon> response) {
                if(response.isSuccessful()){

                    LoginCustomerRespon loginCustomerRespon= response.body();


                    spHandle.setSpIdUser(SpHandle.SP_ID_USER, loginCustomerRespon.getId());
                    spHandle.setSpTokenUser(SpHandle.SP_TOKEN_USER,loginCustomerRespon.getAccessToken());
                    spHandle.setSpNamaCust(SpHandle.SP_NAMA_CUST,editText_name.getText().toString());
                    spHandle.setSpEmailCust(SpHandle.SP_EMAIL_CUST,loginCustomerRespon.getEmail());
                    spHandle.setSpPhoneCust(SpHandle.SP_PHONE_CUST,loginCustomerRespon.getPhone());
                    // Shared Pref ini berfungsi untuk menjadi trigger session login
                    spHandle.saveSPBoolean(SpHandle.SP_HAVE_LOGIN, true);
                    startActivity(new Intent(Login.this, BottomNavigation.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();


                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(Login.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(Login.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(Login.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(Login.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<LoginCustomerRespon> call, Throwable t) {
                Toast.makeText(Login.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });





    }
}