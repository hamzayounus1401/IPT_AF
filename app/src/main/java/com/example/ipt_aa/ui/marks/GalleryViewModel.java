package com.example.ipt_aa.ui.marks;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ipt_aa.Room.Models.Account;
import com.example.ipt_aa.Room.Repository;
import com.example.ipt_aa.SessionManager;

import java.util.HashMap;

public class GalleryViewModel extends AndroidViewModel {
    Repository repository;
    SessionManager sessionManager;

    MutableLiveData<HashMap<String, String>> hashMapMutableLiveData = new MutableLiveData<>();

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        sessionManager = new SessionManager(application);
    }

    public LiveData<Account> getAccount() {
        return repository.getStudent(sessionManager.getUserId());
    }
}