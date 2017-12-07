package com.example.ubun.bohdansharipovalexeyulianovassignment4.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Doctor;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Nurse;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Patient;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Test;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */

@Database(entities = {Doctor.class, Nurse.class, Patient.class, Test.class}, version = 1)
public class MyDatabase extends RoomDatabase {

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
