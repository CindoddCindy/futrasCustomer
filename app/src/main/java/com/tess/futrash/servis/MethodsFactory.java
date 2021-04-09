package com.tess.futrash.servis;

import com.google.gson.JsonObject;
import com.tess.futrash.model.pojo_all_item.AllItemRespon;
import com.tess.futrash.model.pojo_chart.get_chart.ChartGetRespon;
import com.tess.futrash.model.pojo_chart.post_chart.ChartPostRespon;
import com.tess.futrash.model.pojo_confirmation.get_confirm.GetConfirmRespon;
import com.tess.futrash.model.pojo_login.LoginCustomerRespon;
import com.tess.futrash.model.pojo_order.get_order.GetOrderRespon;
import com.tess.futrash.model.pojo_order.post_order.CustomerPostOrderRespon;
import com.tess.futrash.model.pojo_regis.RegisCustomerRespon;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

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


    @Headers({
            "Content-Type:application/json"
    })
    @GET("item/AllItems")
    Call<AllItemRespon> getAllItem(@HeaderMap Map<String,String > Map);



    @Headers({
            "Content-Type:application/json"
    })
    @POST("charts/users/{id}/charts")
    Call<ChartPostRespon> addToChart(@Path("id") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject object);



    @Headers({
            "Content-Type:application/json"
    })
    @POST("order/users/{id}/orders")
    Call<CustomerPostOrderRespon> orderItem(@Path("id") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject object);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("order/users/{id}/orders")
    Call<CustomerPostOrderRespon> orderItemToBuyer(@Path("id") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject object);


    @Headers({
            "Content-Type:application/json"
    })
    @GET("confirm/users/{id}/confirm")
    Call<GetConfirmRespon> getConfirm(@Path("id") Long id, @HeaderMap Map<String,String > Map);


    @Headers({
            "Content-Type:application/json"
    })
    @GET("charts/users/{id}/charts")
    Call<ChartGetRespon> getChart(@Path("id") Long id, @HeaderMap Map<String,String > Map);

    @Headers({
            "Content-Type:application/json"
    })
    @GET("order/users/{id}/orders")
    Call<GetOrderRespon> getOrder(@Path("id") Long id, @HeaderMap Map<String,String > Map);



}
