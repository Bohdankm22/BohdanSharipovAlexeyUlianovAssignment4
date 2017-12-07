package com.example.ubun.bohdansharipovalexeyulianovassignment4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.R;

public class PatientInfoActivity extends AppCompatActivity {
    EditText patientIdET;
    EditText firstNameET;
    EditText lastNameET;
    EditText departmentET;
    EditText doctorIdET;
    EditText roomET;
    Button editPatientsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        final EditText patientIdET = (EditText) findViewById(R.id.idEditText);
        final EditText firstNameET = (EditText) findViewById(R.id.firstnameEditText);;
        final EditText lastNameET = (EditText) findViewById(R.id.lastnameEditText);;
        final EditText departmentET = (EditText) findViewById(R.id.departmentEditText);;
        final EditText doctorIdET = (EditText) findViewById(R.id.doctorIdEditText);;
        final EditText roomET = (EditText) findViewById(R.id.roomEditText);;

        patientIdET.setEnabled(false);
        firstNameET.setEnabled(false);
        lastNameET.setEnabled(false);
        departmentET.setEnabled(false);
        doctorIdET.setEnabled(false);
        roomET.setEnabled(false);

        Button editPatientsInfo = (Button) findViewById(R.id.btnEditPatient);
        editPatientsInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                patientIdET.setEnabled(true);
                firstNameET.setEnabled(true);
                lastNameET.setEnabled(true);
                departmentET.setEnabled(true);
                doctorIdET.setEnabled(true);
                roomET.setEnabled(true);
            }
        });
    }

}
