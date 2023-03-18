package com.example.guia4_ejercicio4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends ArrayAdapter<Person> {
    private Context context;
    private List<Person> people;

    public PeopleAdapter(Context context, List<Person> people) {
        super(context, R.layout.list_item, people);
        this.context = context;
        this.people = people;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.list_item, null);
        }

        Person person = people.get(position);

        TextView nombreTextView = view.findViewById(R.id.tvNombre);
        nombreTextView.setText(person.getNombre());

        TextView edadTextView = view.findViewById(R.id.tvEdad);
        edadTextView.setText(String.valueOf(person.getEdad()));

        TextView direccionTextView = view.findViewById(R.id.tvDireccion);
        direccionTextView.setText(person.getDireccion());

        return view;
    }
}