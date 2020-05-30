package com.example.ipt_aa.ui.home;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ipt_aa.Model.Student;
import com.example.ipt_aa.RetrofitClasses.Api;
import com.example.ipt_aa.RetrofitClasses.RetrofitClient;
import com.example.ipt_aa.Room.Models.Account;
import com.example.ipt_aa.Room.Repository;
import com.example.ipt_aa.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<Account> UserAccount;
    private Repository repository;
    private SessionManager sessionManager;

    public HomeViewModel(Application application) {
        super(application);
        UserAccount = new MutableLiveData<>();
        sessionManager = new SessionManager(application);
        sessionManager.checkLogin();
        repository = new Repository(application);

    }

    public void RefreshPage() {
        final Api api = RetrofitClient.getInstance().getApi();

        final Call<Student> text = api.getUser(sessionManager.getToken());

        text.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()) {
                    Log.d(response.body().getAddress(), "Hamzaaa");
                    Log.d("Hamzaaa2", response.body().getFullName());
                    inert(response.body());
                }

            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

            }
        });
    }

    public void inert(Student student) {
        Account account = new Account();
        account.fullName = student.getFullName();
        account.roll = student.getRoll();
        account.address = student.getAddress();
        account.cnic = student.getCnic();
        account.email = student.getEmail();
        account.credits_attempted = student.getCreditsAttempted();
        account.credits_earned = student.getCreditsEarned();
        account.status = student.getStatus();
        String[] dob = student.getDob().split("T");
        account.dob = dob[0];
        account.id = student.getId();
        account.phone = student.getPhone();
        repository.updateAccount(account);
    }


    public LiveData<Account> getAccount() {
        return repository.getStudent(sessionManager.getUserId());
    }
}