package com.example.parcial2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EmpleadosAdaptador extends ArrayAdapter<Empleados> {
    ArrayList<Empleados> listapersonas;
    Integer[] ImgEmpleados;
    AppCompatActivity appCompatActivity;
    EmpleadosAdaptador(AppCompatActivity context, ArrayList<Empleados> empleados, Integer[] imgs) {
        super(context, R.layout.empleados, empleados);
        appCompatActivity = context;
        listapersonas = empleados;
        ImgEmpleados = imgs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = appCompatActivity.getLayoutInflater();

        View item = inflater.inflate(R.layout.empleados, null);
        TextView textView1 = item.findViewById(R.id.tvNombre);
        textView1.setText(listapersonas.get(position).getNombre());
        TextView textView2 = item.findViewById(R.id.tvCargo);
        textView2.setText(listapersonas.get(position).getCargo());
        TextView textView3 = item.findViewById(R.id.tvCompania);
        textView3.setText(listapersonas.get(position).getCompania());
        ImageView imageView1 = item.findViewById(R.id.imvFoto);
        imageView1.setImageResource(ImgEmpleados[position]);
        return(item);

    }
}
