package com.example.ipt_aa.Room.Models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Account {
    @NonNull
    @PrimaryKey
    public String id;
    @ColumnInfo(name = "fullName")
    public String fullName;

    @ColumnInfo(name = "cnic")
    public String cnic;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "credits_attempted")
    public int credits_attempted;

    @ColumnInfo(name = "credits_earned")
    public int credits_earned;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "status")
    public String status;

    @ColumnInfo(name = "dob")
    public String dob;


}