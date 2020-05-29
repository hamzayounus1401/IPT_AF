package com.example.ipt_aa.Room.DAOs;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ipt_aa.Room.Models.Account;

import java.util.List;

@Dao
public interface AccountDao {
    @Query("SELECT * FROM Account")
    List<Account> getAll();


    @Query("SELECT * FROM Account  s WHERE s.id LIKE :id  LIMIT 1")
    LiveData<Account> getById(String id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Account account);

    @Delete
    void delete(Account account);

    @Update
    void update(Account account);

    @Query("DELETE FROM Account")
    public void deleteAccount();
}