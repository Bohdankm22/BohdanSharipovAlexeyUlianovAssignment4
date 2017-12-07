package com.example.ubun.bohdansharipovalexeyulianovassignment4.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Test;

import java.util.List;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */
@Dao
public interface TestDao {
    @Query("SELECT * FROM test")
    List<Test> getAll();

    @Insert
    void insert(Test test);

    @Update
    void update(Test test);

    @Query("SELECT * FROM test where patient_id = :patientId")
    Test getTestByPatientID(int patientId);
}
