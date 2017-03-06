package com.example.movil.taller_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Project_show extends AppCompatActivity {

    TextView tvp;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_show);

        tvp = (TextView) findViewById(R.id.tvp);
        tv1 = (TextView) findViewById(R.id.tvn1);
        tv2 = (TextView) findViewById(R.id.tvn2);
        tv3 = (TextView) findViewById(R.id.tvn3);
        tv4 = (TextView) findViewById(R.id.tvn4);

        Intent i = getIntent();

        project = (Project) i.getSerializableExtra("project");

        tvp.setText("Nombre del Proyecto: " + project.getName());
        tv1.setText(String.valueOf(project.getNote1()));
        tv2.setText(String.valueOf(project.getNote2()));
        tv3.setText(String.valueOf(project.getNote3()));
        tv4.setText(String.valueOf(project.getNote4()));
    }
}
