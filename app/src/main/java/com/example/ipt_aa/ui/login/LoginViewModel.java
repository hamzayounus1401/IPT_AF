package com.example.ipt_aa.ui.login;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ipt_aa.Model.LoginResponse;
import com.example.ipt_aa.Model.Student;
import com.example.ipt_aa.RetrofitClasses.Api;
import com.example.ipt_aa.RetrofitClasses.RetrofitClient;
import com.example.ipt_aa.Room.Models.Account;
import com.example.ipt_aa.Room.Repository;
import com.example.ipt_aa.SessionManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LoginViewModel extends AndroidViewModel {

    private final Api api = RetrofitClient.getInstance().getApi();
    private MutableLiveData<Student> account = new MutableLiveData<>();
    private Repository mRepository;
    private SessionManager sessionManager;
    private Account profile;
    private MutableLiveData<String> ErrorMessage = new MutableLiveData<>();

    public LoginViewModel(Application application) {
        super(application);
        profile = new Account();
        mRepository = new Repository(application);
        sessionManager = new SessionManager(application);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public LiveData<String> ErrorMessage() {
        return ErrorMessage;
    }

    LiveData<Student> getLoginResult() {
        return account;
    }


    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        Call<LoginResponse> loginResponse = api.userLogin(username, password, "password");
        loginResponse.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    AccountResource(response.body());
                    Log.d("Hamza2", response.body().getAccess_token());
                    sessionManager.createLoginSession(username, response.body().getToken_type() + " " + response.body().getAccess_token());
                } else {

                    ErrorMessage.setValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ErrorMessage.setValue(t.getLocalizedMessage());
            }
        });

    }

    public void AccountResource(LoginResponse response) {
        final MutableLiveData<Student> value = new MutableLiveData<>();

        final Call<Student> text = api.getUser(response.getToken_type() + " " + response.getAccess_token());

        text.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()) {
                    account.setValue(response.body());
                    Log.d(account.getValue().getFullName(), "Hamzaaa");
                    Log.d("Hamzaaa2", response.body().getFullName());
                    inert(response.body());
                    getFirebaseToken();
                }
                ErrorMessage.setValue(response.message());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                ErrorMessage.setValue(t.getMessage());
            }
        });
    }

    public void inert(Student student) {
        Account account = new Account();
        account.fullName = student.getFullName();
        account.id = student.getRoll();
        account.address = student.getAddress();
        account.cnic = student.getCnic();
        account.email = student.getEmail();
        account.credits_attempted = student.getCreditsAttempted();
        account.credits_earned = student.getCreditsEarned();
        account.status = student.getStatus();
        String[] dob = student.getDob().split("T");
        account.dob = dob[0];
        account.phone = student.getPhone();
        mRepository.insert(account);

    }

    public void getFirebaseToken() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken().toString();
                        Log.d("notification", token);
                        sendRegistrationToServer(token);
                        // Log and toast

                    }
                });
    }

    public void sendRegistrationToServer(String token) {
        Log.d("token,,", token);
        Call<String> setNotification = api.registerForNotification(sessionManager.getToken(), token);
        setNotification.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("notification", response.message());
                Toast.makeText(getApplication().getApplicationContext(), "Notification" + response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

}
