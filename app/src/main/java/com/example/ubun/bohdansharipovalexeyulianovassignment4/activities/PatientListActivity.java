package com.example.ubun.bohdansharipovalexeyulianovassignment4.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.R;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.database.MyDatabase;
import com.example.ubun.bohdansharipovalexeyulianovassignment4.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        MyDatabase db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class, "database-name").allowMainThreadQueries().build();
        final List<Patient> patients = db.patientDao().getAll();

        for (int i = 0; i < patients.size(); i++) {
            final int j = i;
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            btn.setId(i);
            btn.setText(patients.get(i).getFirstName());

            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(PatientListActivity.this, "Button " + v.getId() + " clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PatientListActivity.this, PatientInfoActivity.class);
                    intent.putExtra(getString(R.string.patient_id), patients.get(j).getPatientId());
                    startActivity(intent);
                }
            });

            ll.addView(btn);

        }
    }
}
