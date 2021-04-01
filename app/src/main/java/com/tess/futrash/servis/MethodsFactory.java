package com.tess.futrash.servis;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MethodsFactory {
    @Headers({
            "Content-Type:application/json"
    })
    @POST("user/signin")
    Call<foodtrashGetLoginRespon.FoodTrashGetLoginRespon> isLoginValid(@Body JsonObject body);



    @Headers({
            "Content-Type:application/json"
    })
    @POST("user/signup")
    Call<String> isRegistration(@Body JsonObject body);

}
