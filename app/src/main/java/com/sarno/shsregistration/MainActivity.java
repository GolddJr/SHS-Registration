package com.sarno.shsregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner ap1;
    EditText etLastName, etMiddleName, etFirstName;
    RadioButton rbMale, rbFemale;
    CheckBox cbxReq1, cbxReq2, cbxReq3, cbxReq4;

    String AcademicProgram, LastName, FirstName, MiddleName, gender, requirements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ap1 = findViewById(R.id.ap1);
        etLastName = findViewById(R.id.etLastName);
        etFirstName = findViewById(R.id.etFirstName);
        etMiddleName = findViewById(R.id.etMiddleName);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbxReq1 = findViewById(R.id.cbxReq1);
        cbxReq2 = findViewById(R.id.cbxReq2);
        cbxReq3 = findViewById(R.id.cbxReq3);
        cbxReq4 = findViewById(R.id.cbxReq4);

    }

    public void submit(View view) {
        AcademicProgram = ap1.getSelectedItem().toString();
        LastName = etLastName.getText().toString();
        FirstName = etFirstName.getText().toString();
        MiddleName = etMiddleName.getText().toString();

        if (rbMale.isChecked()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        requirements = "";

        if (cbxReq1.isChecked()) {
            requirements = cbxReq1.getText().toString() + "\n";
        }
        if (cbxReq2.isChecked()) {
            requirements = requirements + cbxReq2.getText().toString() + "\n";
        }
        if (cbxReq3.isChecked()) {
            requirements = requirements + cbxReq3.getText().toString() + "\n";
        }
        if (cbxReq4.isChecked()) {
            requirements = requirements + cbxReq4.getText().toString() + "\n";
        }

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("academicProgram", AcademicProgram);
        intent.putExtra("lastname", LastName);
        intent.putExtra("firstname", FirstName);
        intent.putExtra("middlename", MiddleName);
        intent.putExtra("gender", gender);
        intent.putExtra("requirements", requirements);
        startActivity(intent);
    }
}