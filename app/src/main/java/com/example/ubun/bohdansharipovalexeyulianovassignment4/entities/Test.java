package com.example.ubun.bohdansharipovalexeyulianovassignment4.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */

@Entity
public class Test {
    @PrimaryKey
    private int testId;

    @ColumnInfo(name = "patient_id")
    private int patientId;

    @ColumnInfo(name = "nurse_id")
    private int nurseId;

    @ColumnInfo(name = "test_bpl")
    private int bpl;

    @ColumnInfo(name = "test_bph")
    private int bph;

    @ColumnInfo(name = "test_temperature")
    private int temperature;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getBpl() {
        return bpl;
    }

    public void setBpl(int bpl) {
        this.bpl = bpl;
    }

    public int getBph() {
        return bph;
    }

    public void setBph(int bph) {
        this.bph = bph;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
