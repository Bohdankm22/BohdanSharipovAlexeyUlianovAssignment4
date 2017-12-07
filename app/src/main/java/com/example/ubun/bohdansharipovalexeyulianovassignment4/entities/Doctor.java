package com.example.ubun.bohdansharipovalexeyulianovassignment4.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */

@Entity
public class Doctor {
    @PrimaryKey
    private int doctorId;

    @ColumnInfo(name = "doctor_name")
    private String firstName;

    @ColumnInfo(name = "doctor_lastname")
    private String lastName;

    @ColumnInfo(name = "doctor_department")
    private String department;

    @ColumnInfo(name = "doctor_password")
    private String password;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}