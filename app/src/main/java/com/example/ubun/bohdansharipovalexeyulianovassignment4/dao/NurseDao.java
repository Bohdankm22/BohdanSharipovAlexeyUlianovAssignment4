package com.example.ubun.bohdansharipovalexeyulianovassignment4.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Doctor;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Nurse;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Test;

import java.util.List;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */
@Dao
public interface NurseDao {
    @Query("SELECT * FROM nurse")
    List<Nurse> getAll();

    @Insert
    void insert(Nurse nurse);

    @Update
    void update(Nurse nurse);
}
