package com.example.ubun.bohdansharipovalexeyulianovassignment4.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.R;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.database.MyDatabase;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Doctor;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Patient;

import static com.example.ubun.bohdansharipovalexeyulianovassignment4.activities.MainActivity.SHARED_PREFS;

public class PatientInfoActivity extends AppCompatActivity {
    EditText patientIdET;
    EditText firstNameET;
    EditText lastNameET;
    EditText departmentET;
    EditText doctorIdET;
    EditText roomET;
    Button editPatientsInfo;
    Boolean isDoctor;
    String patientId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        final int patientID = getIntent().getIntExtra(getString(R.string.patient_id), 0);
        final MyDatabase db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class, "database-name").allowMainThreadQueries().build();
        final Patient patient = db.patientDao().getById(patientID);
        Doctor doctor = db.doctorDao().getById(patient.getDoctorId());

        final EditText patientIdET = (EditText) findViewById(R.id.idEditText);
        final EditText firstNameET = (EditText) findViewById(R.id.firstnameEditText);
        final EditText lastNameET = (EditText) findViewById(R.id.lastnameEditText);
        final EditText departmentET = (EditText) findViewById(R.id.departmentEditText);
        final EditText doctorIdET = (EditText) findViewById(R.id.doctorIdEditText);
        final EditText roomET = (EditText) findViewById(R.id.roomEditText);
        patientIdET.setText(Integer.toString(patient.getPatientId()));
        firstNameET.setText(patient.getFirstName());
        lastNameET.setText(patient.getLastName());
        departmentET.setText(patient.getDepartment());
        roomET.setText(Integer.toString(patient.getRoom()));
        doctorIdET.setText(doctor.getFirstName() + " " + doctor.getLastName());

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        isDoctor = prefs.getBoolean("isDoctor", false);
        patientIdET.setEnabled(false);
        firstNameET.setEnabled(false);
        lastNameET.setEnabled(false);
        departmentET.setEnabled(false);
        doctorIdET.setEnabled(false);
        roomET.setEnabled(false);

        final Button editPatientsInfo = (Button) findViewById(R.id.btnEditPatient);
        editPatientsInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                if (!isDoctor) {
//                    return;
//                }

                if (editPatientsInfo.getText().toString().equals("Edit")) {

                }
                firstNameET.setEnabled(true);
                lastNameET.setEnabled(true);
                departmentET.setEnabled(true);
                roomET.setEnabled(true);

                editPatientsInfo.setText("Submit");
                editPatientsInfo.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        patient.setRoom(Integer.parseInt(roomET.getText().toString()));
                        patient.setFirstName(firstNameET.getText().toString());
                        patient.setLastName(lastNameET.getText().toString());
                        patient.setDepartment(departmentET.getText().toString());
                        db.patientDao().update(patient);
                        patientIdET.setEnabled(false);
                        firstNameET.setEnabled(false);
                        lastNameET.setEnabled(false);
                        departmentET.setEnabled(false);
                        doctorIdET.setEnabled(false);
                        roomET.setEnabled(false);
                        editPatientsInfo.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });


        Button checkTest = (Button) findViewById(R.id.btnCheckTest);
        if (!isDoctor) {
            checkTest.setText("Add test results");
        }
        checkTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientInfoActivity.this, PatientTestsActivity.class);
                intent.putExtra(getString(R.string.patient_id), patientID);
                startActivity(intent);
            }

        });

    }

}
