package com.tess.futrash.servis;

import com.google.gson.JsonObject;
import com.tess.futrash.model.pojo_login.LoginCustomerRespon;
import com.tess.futrash.model.pojo_regis.RegisCustomerRespon;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MethodsFactory {
    @Headers({
            "Content-Type:application/json"
    })
    @POST("user/signin")
    Call<LoginCustomerRespon> isLoginValid(@Body JsonObject body);



    @Headers({
            "Content-Type:application/json"
    })
    @POST("user/signup")
    Call<RegisCustomerRespon> isRegistration(@Body JsonObject body);

}
