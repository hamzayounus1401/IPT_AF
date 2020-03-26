package com.example.ipt_aa;

import androidx.lifecycle.MutableLiveData;

import com.example.ipt_aa.data.Api;
import com.example.ipt_aa.data.LoginResponse;
import com.example.ipt_aa.data.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginDataSource {
    MutableLiveData<LoginResponse> mutableLiveData = new MutableLiveData<LoginResponse>();
    MutableLiveData<String> token = new MutableLiveData<String>();
    MutableLiveData<String> name = new MutableLiveData<>();

    public MutableLiveData<String> getLoginResponse(String u, String p) {
        final Api api = RetrofitClient.getInstance().getApi();


        Call<LoginResponse> loginResponseCall = api.userLogin(u, p, "password");
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    String tokenn = response.body().getAccess_token();
                    String type = response.body().getToken_type();
                    token.setValue(type + " " + tokenn);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mutableLiveData.setValue(new LoginResponse(null, null, null));
            }
        });
        return token;

    }

    public MutableLiveData<String> getUserAccount(String token) {
        Api api = RetrofitClient.getInstance().getApi();
        Call<String> stringCall = api.getUser(token);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String value = response.body();
                    name.setValue(value);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return name;
    }
}
