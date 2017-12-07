package com.example.ubun.bohdansharipovalexeyulianovassignment4.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Bohdan Sharipov and Alexey Ulianov
 */

@Entity
public class Patient {
    @PrimaryKey
    private int patientId;

    @ColumnInfo(name = "patient_name")
    private String firstName;

    @ColumnInfo(name = "patient_lastname")
    private String lastName;

    @ColumnInfo(name = "patient_department")
    private String department;

    @ColumnInfo(name = "patient_doctor")
    private int doctorId;

    @ColumnInfo(name = "patient_room")
    private int room;


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}