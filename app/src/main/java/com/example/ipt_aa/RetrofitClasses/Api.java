package com.example.ipt_aa.RetrofitClasses;

import com.example.ipt_aa.Model.LoginResponse;
import com.example.ipt_aa.Model.Student;
import com.example.ipt_aa.Model.Transcript;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    //define all api calls
    @FormUrlEncoded
    @POST("/token")
    Call<LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("grant_type") String grant_type
    );

    @GET("api/fast-student/account")
    Call<Student> getUser(@Header("Authorization") String authorization);

    //define all api calls
    @FormUrlEncoded
    @POST("api/fast-student/notification/token")
    Call<String> registerForNotification(
            @Header("Authorization") String authorization,
            @Field("token") String token
    );

    @GET("api/transcript")
    Call<List<Transcript>> getTranscript(@Query("id") int id);








}