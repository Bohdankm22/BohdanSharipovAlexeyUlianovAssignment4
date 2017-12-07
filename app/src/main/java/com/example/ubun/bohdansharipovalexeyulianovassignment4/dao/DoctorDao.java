package com.example.ubun.bohdansharipovalexeyulianovassignment4.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Doctor;

import java.util.List;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */
@Dao
public interface DoctorDao {
    @Query("SELECT * FROM doctor")
    List<Doctor> getAll();

    @Insert
    void insert(Doctor doctor);

    @Update
    void update(Doctor doctor);

}
