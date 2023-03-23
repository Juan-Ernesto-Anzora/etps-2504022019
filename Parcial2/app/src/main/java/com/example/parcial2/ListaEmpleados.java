package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaEmpleados extends AppCompatActivity {

    ArrayList<Empleados> listaempleados;
    ListView lv1;
    Integer[]ImgEmpleados={
            R.drawable.lead_photo_1,
            R.drawable.lead_photo_2,
            R.drawable.lead_photo_3,
            R.drawable.lead_photo_4,
            R.drawable.lead_photo_4,
            R.drawable.lead_photo_5,
            R.drawable.lead_photo_6,
            R.drawable.lead_photo_6,
            R.drawable.lead_photo_7,
            R.drawable.lead_photo_10,
            R.drawable.lead_photo_10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        listaempleados = new ArrayList<Empleados>();
        listaempleados.add(new Empleados("Alexander Pierrot", "CEO", "Insures S.O."));
        listaempleados.add(new Empleados("Carlos Lopez", "Asistente", "Hospital Blue"));
        listaempleados.add(new Empleados("Sara Bonz", "Directora de Marketing", "Electrical Parts ltd"));
        listaempleados.add(new Empleados("Liliana Clarence", "Diseñadora de Producto", "Creativa App"));
        listaempleados.add(new Empleados("Benito Peralta", "Supervisor de Ventas", "Neumaticos Press"));
        listaempleados.add(new Empleados("Juan Jaramillo", "CEO", "Banco Nacional"));
        listaempleados.add(new Empleados("Christian Steps", "CTO", "Cooperativa Verde"));
        listaempleados.add(new Empleados("Alexa Giraldo", "Lead Programmer", "Frutisofy"));
        listaempleados.add(new Empleados("Linda Murillo", "Directora de Marketing", "Seguros Boliver"));
        listaempleados.add(new Empleados("Lizeth Astrada", "CEO", "Concesionario Motolox"));

        EmpleadosAdaptador adaptador = new EmpleadosAdaptador(this, listaempleados, ImgEmpleados);
        lv1 = findViewById(R.id.lvEmpleados);
        lv1.setAdapter(adaptador);
    }
}