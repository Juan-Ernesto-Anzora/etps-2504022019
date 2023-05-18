package com.example.parcial4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parcial4.helper.DBManager;

public class AddClientActivity extends Activity implements View.OnClickListener {
    private Button addTodoBtn;
    private EditText edtNombre;
    private EditText edtApellido;
    private EditText edtDireccion;
    private EditText edtCiudad;

    private DBManager dbManager;
    private static final int ADD_RECORD = R.id.add_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.activity_add_record);

        edtNombre = (EditText) findViewById(R.id.tvName);
        edtApellido = (EditText) findViewById(R.id.tvLastName);
        edtDireccion = (EditText) findViewById(R.id.tvAddress);
        edtCiudad = (EditText) findViewById(R.id.tvCity);

        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ADD_RECORD) {
            final String nombre = edtNombre.getText().toString();
            final String apellido = edtApellido.getText().toString();
            final String direccion = edtDireccion.getText().toString();
            final String ciudad = edtCiudad.getText().toString();

            dbManager.insert(nombre, apellido, direccion, ciudad);

            Intent main = new Intent(AddClientActivity.this, ClientListActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(main);
        }
    }
}
