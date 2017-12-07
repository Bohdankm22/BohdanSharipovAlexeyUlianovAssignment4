package com.example.ubun.bohdansharipovalexeyulianovassignment4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ubun.bohdansharipovalexeyulianovassignment4.R;

import java.util.ArrayList;
import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        //TODO List of patients needs to be retrieved here;
        //Sample patient list
        List<String> patients = new ArrayList<>();
        patients.add("John");
        patients.add("Carl");

        for (int i = 0; i < patients.size(); i++) {
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            btn.setId(i);
            btn.setText(patients.get(i));

            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(PatientListActivity.this, "Button " + v.getId() + " clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PatientListActivity.this, PatientInfoActivity.class);
                    startActivity(intent);
                }
            });

            ll.addView(btn);

        }
    }
}
