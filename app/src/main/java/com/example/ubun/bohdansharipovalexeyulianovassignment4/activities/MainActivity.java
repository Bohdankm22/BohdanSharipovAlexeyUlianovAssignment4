package com.example.ubun.bohdansharipovalexeyulianovassignment4.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public MyDatabase db;
    EditText loginET;
    EditText passwordET;
    String login;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (db == null) {

            db = Room.databaseBuilder(getApplicationContext(),
                    MyDatabase.class, "database-name").build();

        }
        final Doctor doctor = new Doctor();
        doctor.setDoctorId(1);
        doctor.setFirstName("Ivan");
        doctor.setLastName("IVa");
        doctor.setDepartment("Lalal");
        DoctorDao doctorDao = db.doctorDao();
        final List<Doctor> list = new ArrayList<>();
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... params) {
                list.add(db.doctorDao().getById(1));
                return 1;
            }
        }.execute();

        System.out.println();

        //Log in happens here
        //TODO error message if wrong/empty credentials
        loginET = (EditText) findViewById(R.id.loginEditText);
        passwordET = (EditText) findViewById(R.id.passEditText);
        final Button button = findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO login and put to shared prefs
                Intent intent = new Intent(MainActivity.this, PatientListActivity.class);
                startActivity(intent);
            }
        });

    }


    public boolean checkCredentials(View view) {
        login = loginET.getText().toString();
        password = passwordET.getText().toString();

        if ((login != null && !login.equals("")) && (password != null && !password.equals("")) ) {
            return true;
        } else {
            return false;
        }
    }

}
