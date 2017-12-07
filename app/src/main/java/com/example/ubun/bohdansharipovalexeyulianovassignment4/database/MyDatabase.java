package com.example.ubun.bohdansharipovalexeyulianovassignment4.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.dao.DoctorDao;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.dao.NurseDao;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.dao.PatientDao;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.dao.TestDao;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Doctor;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Nurse;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Patient;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Test;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */

@Database(entities = {Doctor.class, Nurse.class, Patient.class, Test.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DoctorDao doctorDao();
    public abstract NurseDao nurseDao();
    public abstract TestDao testDao();
    public abstract PatientDao patientDao();
}
