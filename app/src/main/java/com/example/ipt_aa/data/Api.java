package com.example.ipt_aa.data;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    //define all api calls
    @FormUrlEncoded
    @POST("/token")
    Call<LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("grant_type") String grant_type
    );


    @GET("api/test/resource1")
    Call<String> getUser(@Header("Authorization") String authorization);


}