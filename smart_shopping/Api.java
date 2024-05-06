package com.example.hemapriya.smart_shopping;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hema priya on 12-09-2022.
 */
public interface Api {
    String BASE_URL = "https://viable-goggles.000webhostapp.com/APIS/";


    @POST("Insert_smart.php")
    Call<IsExit> Signup_page(
            @Query("f1") String usr_name,
            @Query("f2") String usr_pass,
            @Query("f3") String usr_email,
            @Query("f4") String usr_mno,
            @Query("f5") String usr_city,
            @Query("f6") String usr_postal

    );

    @GET("https://viable-goggles.000webhostapp.com/APIS/get_user_profile.php")
    Call<List<User_account_array>> getUserDetails(@Query("f1") String str_shr_umno);

    @POST("get_user_profile.php")
    Call<IsExit> Update_page(
            @Query("f1") String usr_name,
            @Query("f2") String usr_pass,
            @Query("f3") String usr_city,
            @Query("f4") String usr_postal,
            @Query("f5") String usr_email,
            @Query("f6") String usr_number
    );
    @GET("https://viable-goggles.000webhostapp.com/APIS/get_product.php")
    Call<List<Get_product_array>> getProduct(@Query("f5") String str_val);

    @GET("https://viable-goggles.000webhostapp.com/APIS/get_order_pid.php")
    Call<List<OrderArray>> Order_pid(@Query("f5") String str_mno);

    @POST("https://viable-goggles.000webhostapp.com/APIS/Insert_order.php")
    Call<IsExit> Product_page(
            @Query("f1") String str_user_mno,
            @Query("f2") String str_name,
            @Query("f3") String str_product_id,
            @Query("f4") String str_qrcode
    );
    @GET("https://viable-goggles.000webhostapp.com/APIS/get_product_details.php")
    Call<List<ProductArray>>getproductDetails(@Query("f1") String str_pid);



}



