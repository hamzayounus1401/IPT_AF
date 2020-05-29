package com.example.ipt_aa.Room.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ipt_aa.Room.Models.Mark;

import java.util.List;

@Dao
public interface MarkDao {
    @Query("SELECT * FROM Mark")
    List<Mark> getMarks();

    @Insert()
    void insert(Mark mark);

    @Delete
    void delete(Mark mark);

    @Update
    void update(Mark mark);

}