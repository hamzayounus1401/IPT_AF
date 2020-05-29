package com.example.ipt_aa.Room;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.ipt_aa.Room.DAOs.AccountDao;
import com.example.ipt_aa.Room.Models.Account;


public class Repository {

    private AccountDao mAccountDto;
    private LiveData<Account> mAccount;

    public Repository(Application application) {
        RoomDatabase db = RoomDatabase.getDatabase(application);
        mAccountDto = db.accountDao();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<Account> getStudent(String id) {
        return mAccountDto.getById(id);
    }

    public void deleteAccount() {
        RoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    mAccountDto.deleteAccount();
                } catch (RuntimeException e) {
                    Log.d("Error AccountDto l 33", e.getMessage());
                }

            }
        });

    }

    public void updateAccount(Account account) {
        RoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    mAccountDto.update(account);
                } catch (RuntimeException e) {
                    Log.d("Error AccountDto l 33", e.getMessage());
                }

            }
        });
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(final Account account) {
        RoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAccountDto.insert(account);
                } catch (RuntimeException e) {
                    Log.d("Error AccountDto l 33", e.getMessage());
                }

            }
        });
    }
}

