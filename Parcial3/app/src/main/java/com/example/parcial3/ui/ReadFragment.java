package com.example.parcial3.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.parcial3.R;
import com.example.parcial3.helper.AdminSQLiteOpenHelper;

public class ReadFragment extends Fragment {
    private EditText nombreEditText, apellidoEditText, telefonoEditText, correoEditText;
    private Button btnBuscar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragmento_buscar,container,false);

        // Find the TextViews by their ID
        nombreEditText = (EditText) view.findViewById(R.id.edtNombre);
        apellidoEditText = (EditText) view.findViewById(R.id.edtApellido);
        telefonoEditText = (EditText) view.findViewById(R.id.edtTelefono);
        correoEditText = (EditText) view.findViewById(R.id.edtCorreo);
        btnBuscar= (Button) view.findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String cod=nombreEditText.getText().toString();

                Cursor filas=bd.rawQuery("select nombre,apellido, telefono, correo " +
                        "from contactos where codProducto="+cod,null);

                if(filas.moveToFirst()){
                    nombreEditText.setText(filas.getString(0));
                    apellidoEditText.setText(filas.getString(1));
                    telefonoEditText.setText(filas.getString(2));
                    correoEditText.setText(filas.getString(3));
                }
                else{
                    Toast.makeText(getContext(),"No se encontro" + " el contacto",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });

        return view;
    }
}
