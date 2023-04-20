package com.example.parcial3.ui;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.parcial3.R;
import com.example.parcial3.helper.AdminSQLiteOpenHelper;

public class CreateFragment extends Fragment {
    private EditText nombreEditText, apellidoEditText, telefonoEditText, correoEditText;
    private Button btnInserts;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragmento_agregar,container,false);

        // Find the TextViews by their ID
        nombreEditText = (EditText) view.findViewById(R.id.edtNombre);
        apellidoEditText = (EditText) view.findViewById(R.id.edtApellido);
        telefonoEditText = (EditText) view.findViewById(R.id.edtTelefono);
        correoEditText = (EditText) view.findViewById(R.id.edtCorreo);
        btnInserts= (Button) view.findViewById(R.id.btnAgregar);

        btnInserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(),"parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String nom=nombreEditText.getText().toString();
                String ape=apellidoEditText.getText().toString();
                String tel=telefonoEditText.getText().toString();
                String cor=correoEditText.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("nombre",nom);
                informacion.put("apellido",ape);
                informacion.put("telefono",tel);
                informacion.put("correo",cor);

                bd.insert("contactos", null, informacion);

                Toast.makeText(getContext(), "Se inserto el Contacto", Toast.LENGTH_LONG).show();
                limpiar();
                bd.close();
            }
        });

        return view;
    }

    private void limpiar() {
        nombreEditText.getText().clear();
        apellidoEditText.getText().clear();
        telefonoEditText.getText().clear();
        correoEditText.getText().clear();
    }
}


