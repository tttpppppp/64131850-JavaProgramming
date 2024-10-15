package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText textCourse;
    Button buttonAddCourse;
    ArrayList<String> listCourse = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewCourse);
        textCourse = findViewById(R.id.txtCourse);
        buttonAddCourse = findViewById(R.id.btnAddCourse);

        listCourse.add("PHP");
        listCourse.add("Java");
        listCourse.add("Javascript");
        listCourse.add("Spring Boot");
        listCourse.add("Laravel");
        listCourse.add("NextJs");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCourse);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this , listCourse.get(i) , Toast.LENGTH_LONG).show();
                textCourse.setText(listCourse.get(i));
            }
        });
        buttonAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String course = textCourse.getText().toString();
                listCourse.add(course);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
