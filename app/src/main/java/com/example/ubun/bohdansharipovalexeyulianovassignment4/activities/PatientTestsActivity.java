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
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Test;

import static com.example.ubun.bohdansharipovalexeyulianovassignment4.activities.MainActivity.SHARED_PREFS;

public class PatientTestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_tests);

        final int patientID = getIntent().getIntExtra(getString(R.string.patient_id), 0);
        final MyDatabase db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class, "database-name").allowMainThreadQueries().build();
        final Patient patient = db.patientDao().getById(patientID);
        final Test test = db.testDao().getTestByPatientID(patient.getPatientId());
        final SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        boolean isDoctor = prefs.getBoolean("isDoctor", false);

        final EditText patientName = (EditText) findViewById(R.id.patientIdTestEditText);
        final EditText nurseId = (EditText) findViewById(R.id.nurseIdTestEditText);
        final EditText bpl = (EditText) findViewById(R.id.bplEditText);
        final EditText bph = (EditText) findViewById(R.id.bphEditText);
        final EditText temp = (EditText) findViewById(R.id.tempEditText);

        patientName.setEnabled(false);
        nurseId.setEnabled(false);

        patientName.setText(patient.getFirstName() + " " + patient.getLastName());
        if (test != null) {
            nurseId.setText(Integer.toString(test.getTestId()));
            bpl.setText(Integer.toString(test.getBpl()));
            bph.setText(Integer.toString(test.getBph()));
            temp.setText(Integer.toString(test.getTemperature()));
        }

        if (isDoctor) {
            ((Button) findViewById(R.id.button)).setVisibility(View.INVISIBLE);
            bpl.setEnabled(false);
            bph.setEnabled(false);
            temp.setEnabled(false);
        } else {
            nurseId.setText(Integer.toString(prefs.getInt("nurseId", 1)));
        }

        Button testBut = (Button) findViewById(R.id.button);
        testBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (test != null) {
                    test.setBpl(Integer.parseInt(bpl.getText().toString()));
                    test.setBph(Integer.parseInt(bph.getText().toString()));
                    test.setTemperature(Integer.parseInt(temp.getText().toString()));
                    db.testDao().update(test);
                } else {
                    Test nTest = new Test();
                    nTest.setPatientId(patientID);
                    nTest.setNurseId(prefs.getInt("nurseId", 1));
                    nTest.setBpl(Integer.parseInt(bpl.getText().toString()));
                    nTest.setBph(Integer.parseInt(bph.getText().toString()));
                    nTest.setTemperature(Integer.parseInt(temp.getText().toString()));
                    db.testDao().insert(nTest);
                }
                Intent intent = new Intent(PatientTestsActivity.this, PatientInfoActivity.class);
                intent.putExtra(getString(R.string.patient_id), patientID);
                startActivity(intent);
            }

        });
    }
}
