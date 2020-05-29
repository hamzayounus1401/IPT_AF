package com.example.ipt_aa.Room.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mark {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "code")
    public String code;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "ttl")
    public int total;

    @ColumnInfo(name = "obt")
    public int obtain;

    @ColumnInfo(name = "wtg")
    public int weightage;

    @ColumnInfo(name = "avg")
    public int average;

    @ColumnInfo(name = "std")
    public int standardDeviation;

    @ColumnInfo(name = "min")
    public int minimuin;

    @ColumnInfo(name = "max")
    public int maximum;


}
