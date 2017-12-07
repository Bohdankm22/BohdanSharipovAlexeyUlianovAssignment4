package com.example.ubun.bohdansharipovalexeyulianovassignment4.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.R;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.dao.DoctorDao;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.database.MyDatabase;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Doctor;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Nurse;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public MyDatabase db;
    EditText loginET;
    EditText passwordET;
    public static final String SHARED_PREFS = "SHARED_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class, "database-name").allowMainThreadQueries().build();

        if (db == null) {
            Doctor doctor = new Doctor();
            doctor.setDoctorId(2);
            doctor.setFirstName("Doc");
            doctor.setLastName("doc");
            doctor.setDepartment("Surgery");
            doctor.setPassword("2");
            db.doctorDao().insert(doctor);
            Nurse nurse = new Nurse();
            nurse.setNurseId(3);
            nurse.setFirstName("Nurse");
            nurse.setLastName("Nursovna");
            nurse.setDepartment("Surgery");
            nurse.setPassword("3");
            db.nurseDao().insert(nurse);
            Patient patient = new Patient();
            patient.setFirstName("Ivan");
            patient.setLastName("Ivanov");
            patient.setDepartment("Surgery");
            patient.setDoctorId(2);
            patient.setRoom(123);
            db.patientDao().insert(patient);
        }

        loginET = (EditText) findViewById(R.id.loginEditText);
        passwordET = (EditText) findViewById(R.id.passEditText);
        final Button button = findViewById(R.id.btnLogin);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if (checkCredentials(loginET.getText().toString(), passwordET.getText().toString())
                        && checkInDB(loginET.getText().toString(), passwordET.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this, PatientListActivity.class);
                    startActivity(intent);
                }
            }
        });



    }

    private boolean checkInDB(final String s, final String s1) {
        final SharedPreferences.Editor editor = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE).edit();
        boolean result = false;
        Doctor doctor = db.doctorDao().getByIdAndPassword(s, s1);
        Nurse nurse = db.nurseDao().getByIdAndPassword(s, s1);
        if (doctor != null) {
            editor.putBoolean("isDoctor", true);
            editor.apply();
            return true;
        } else if (nurse != null) {
            editor.putBoolean("isDoctor", false);
            editor.apply();
            return true;
        }
        return false;
    }


    public boolean checkCredentials(String login, String password) {
        if ((login != null && !login.equals("")) && (password != null && !password.equals("")) ) {
            return true;
        } else {
            return false;
        }
    }

}
