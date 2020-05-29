package com.example.ipt_aa;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.ipt_aa.RetrofitClasses.Api;
import com.example.ipt_aa.RetrofitClasses.RetrofitClient;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "MyFirebaseMessagingService";
    Api api = RetrofitClient.getInstance().getApi();

    interface marks {
        void onEvent(boolean is);
    }

    static marks listener;

    public static void setOnEventListener(marks li) {
        listener = li;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            if (listener != null)
                listener.onEvent(true);
            //            if (/* Check if data needs to be processed by long running job */ true) {
//                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
//                scheduleJob();
//            } else {
//                // Handle message within 10 seconds
//                handleNow();
//            }

        }

    }

    @SuppressLint("LongLogTag")
    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        sendRegistrationToServer(token);
    }


    public void sendRegistrationToServer(String token) {
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        Call<String> setNotification = api.registerForNotification(sessionManager.getToken(), token);
        setNotification.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("notification", response.message());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


}