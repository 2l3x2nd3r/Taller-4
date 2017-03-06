package com.example.movil.taller_4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class edit_project extends AppCompatActivity {

    TextView tvp;
    TextView grade;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;

    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        tvp = (TextView) findViewById(R.id.tvp);
        grade = (TextView) findViewById(R.id.grade);

        Intent i = getIntent();
        project = (Project) i.getSerializableExtra("project");

        tvp.setText("Nombre del Proyecto: " + project.getName());
        grade.setText("" + project.getGrade());
        et1.setText("" + project.getNote1());
        et2.setText("" + project.getNote2());
        et3.setText("" + project.getNote3());
        et4.setText("" + project.getNote4());
    }

    public void calculate(View view) {
        String[] data = { et1.getText().toString(),  et2.getText().toString(), et3.getText().toString(), et4.getText().toString() };
        if(data[0].isEmpty() || data[1].isEmpty() || data[2].isEmpty() || data[3].isEmpty()) {
            Toast.makeText(this, "Debe digitar las 4 notas", Toast.LENGTH_SHORT).show();
        }else{
            double n1 = Double.parseDouble(data[0]);
            double n2 = Double.parseDouble(data[1]);
            double n3 = Double.parseDouble(data[2]);
            double n4 = Double.parseDouble(data[3]);
            if (n1 > 5 || n2 > 5 || n3 > 5 || n4 > 5) {
                Toast.makeText(this, "Las 4 notas deben ser menores o iguales a 5", Toast.LENGTH_SHORT).show();
            }else if(n1 < 0 || n2 < 0 || n3 < 0 || n4 < 0){
                Toast.makeText(this, "Las 4 notas deben ser mayores o iguales a 0", Toast.LENGTH_SHORT).show();
            } else {
                double calification = (n1 + n2 + n3 + n4) / 4;
                project.setNote1(n1);
                project.setNote2(n2);
                project.setNote3(n3);
                project.setNote4(n4);
                project.setGrade(calification);

                grade.setText(String.valueOf(project.getGrade()));

                Intent i = new Intent();
                i.putExtra("project", project);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        }
    }
}
