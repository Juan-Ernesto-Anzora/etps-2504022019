package com.example.guia4_ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvlistaPersonas);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Ernesto Rosales", 28, "San Salvador. SV"));
        people.add(new Person("Rosa V Herrera", 18, "La Unión. SV"));
        people.add(new Person("Oscar Campos", 15, "San Miguel. SV"));
        people.add(new Person("Julio Ortiz", 25, "San Salvador. SV"));
        people.add(new Person("Rosa Hernádez", 20, "Santa Tecla. SV"));

        PeopleAdapter adapter = new PeopleAdapter(this, people);
        listView.setAdapter(adapter);
    }
}