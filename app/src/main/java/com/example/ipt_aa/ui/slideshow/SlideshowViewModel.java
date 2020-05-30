package com.example.ipt_aa.ui.slideshow;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ipt_aa.Model.Transcript;
import com.example.ipt_aa.RetrofitClasses.Api;
import com.example.ipt_aa.RetrofitClasses.RetrofitClient;
import com.example.ipt_aa.Room.Repository;
import com.example.ipt_aa.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowViewModel extends AndroidViewModel {

    private Repository mRepository;
    private Api api;
    private MutableLiveData<List<Transcript>> transcriptMutableLiveData = new MutableLiveData<>();
    SessionManager sessionManager;

    public SlideshowViewModel(Application application) {
        super(application);
        sessionManager = new SessionManager(application);
    }

    public LiveData<List<Transcript>> getTranscript() {
        api = RetrofitClient.getInstance().getApi();

        int id = sessionManager.getUserId();
        Log.d("aaaab", String.valueOf(id));
        Call<List<Transcript>> transcriptCall = api.getTranscript(id);
        transcriptCall.enqueue(new Callback<List<Transcript>>() {
            @Override
            public void onResponse(Call<List<Transcript>> call, Response<List<Transcript>> response) {
                if (response.isSuccessful()) {
                    transcriptMutableLiveData.setValue(response.body());
                    Toast.makeText(getApplication(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Transcript>> call, Throwable t) {

            }
        });
        return transcriptMutableLiveData;
    }


};