package com.example.parcial3.ui;

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

public class DeleteFragment extends Fragment {
    private EditText IdContactoEditText, nombreEditText, apellidoEditText, telefonoEditText, correoEditText;
    private Button btnDelete;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_eliminar,container,false);

        // Find the TextViews by their ID
        IdContactoEditText = (EditText) view.findViewById(R.id.edtIdContacto);
        btnDelete= (Button) view.findViewById(R.id.btnliminar);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(),"bodega",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=IdContactoEditText.getText().toString();

                int cat=bd.delete("contactos",
                        "IdContacto="+cod,null);
                bd.close();
                limpiar();

                if(cat==1){
                    Toast.makeText(getContext(),"Se borro el contacto",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getContext(),"No se borro el contacto",Toast.LENGTH_LONG).show();

                }
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
