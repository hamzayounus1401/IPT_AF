package com.example.ipt_aa.ui.login;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ipt_aa.LoginDataSource;
import com.example.ipt_aa.data.Api;
import com.example.ipt_aa.data.LoginResponse;

import java.util.regex.Pattern;

public class LoginViewModel extends ViewModel {
    SharedPreferences sharedPreferences;
    Api api;
    Context context;
    LoginDataSource loginDataSource = new LoginDataSource();
    MutableLiveData<LoginResponse> response = new MutableLiveData<>();
    // MutableLiveData<String> token = new MutableLiveData<>();
    private MutableLiveData<String> token;

    public MutableLiveData<String> getCurrentName() {
        if (token == null) {
            token = new MutableLiveData<String>();
        }
        return token;
    }

// Rest of the ViewModel...


    public LiveData<String> login(String username, String password, Context context) {
        // can be launched in a separate asynchronous job
        this.context = context;

        sharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // editor.remove("user_token");
        //editor.commit();
        if (sharedPreferences.getString("user_token", null) == null) {

            token = loginDataSource.getLoginResponse(username, password);
            String value = token.getValue();
            if (value != null) {
                editor.putString("user_token", value);
                editor.commit();
            }

            return token;
        } else {
            return loginDataSource.getUserAccount(sharedPreferences.getString("user_token", null));
        }
    }

    public void checkTokenAvailable() {

    }

    public void logout() {
        SharedPreferences pref = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }


    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.length() == 7) {
            return Pattern.matches("\\D\\d{6}", username);
        } else {
            return false;
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 3;
    }
}
