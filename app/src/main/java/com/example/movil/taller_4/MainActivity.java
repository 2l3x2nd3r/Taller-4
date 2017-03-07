package com.example.movil.taller_4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Project> projects = new ArrayList<Project>();
    ProjectAdapter pa = new ProjectAdapter(this, projects);
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        projects.add(new Project(0,0,0,0,"Projecto 1",0));
        projects.add(new Project(0,0,0,0,"Projecto 2",0));
        projects.add(new Project(0,0,0,0,"Projecto 3",0));
        projects.add(new Project(0,0,0,0,"Projecto 4",0));

        lv = (ListView) findViewById(R.id.lv);
        lv.setDivider(null);
        lv.setAdapter(pa);
    }

    public void createNewProject(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ingrese el nombre del Proyecto");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                projects.add(new Project(0,0,0,0,input.getText().toString(),0));
                pa.setData(projects);
                ((ProjectAdapter) lv.getAdapter()).notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public void editProject(View view){
        int position = (Integer) view.getTag();
        Intent i = new Intent(this, edit_project.class);
        i.putExtra("project", projects.get(position));

        startActivityForResult(i, position);
    }

    public void showProject(View view){
        int position = (Integer) view.getTag();

        Intent i = new Intent(this, Project_show.class);
        i.putExtra("project", projects.get(position));

        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            projects.set(requestCode, (Project) data.getSerializableExtra("project"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
