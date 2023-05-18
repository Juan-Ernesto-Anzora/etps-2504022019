package com.example.parcial4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parcial4.helper.DBManager;

public class ModifyClientActivity extends Activity implements View.OnClickListener {
    private Button updateBtn, deleteBtn;
    private EditText edtNombre;
    private EditText edtApellido;
    private EditText edtDireccion;
    private EditText edtCiudad;

    private long _id;
    private static final int UPDATE_RECORD = R.id.btn_update;
    private static final int DELETE_RECORD = R.id.btn_delete;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.activity_modify_record);

        dbManager = new DBManager(this);
        dbManager.open();

        edtNombre = (EditText) findViewById(R.id.tvName);
        edtApellido = (EditText) findViewById(R.id.tvLastName);
        edtDireccion = (EditText) findViewById(R.id.tvAddress);
        edtCiudad = (EditText) findViewById(R.id.tvCity);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String direccion = intent.getStringExtra("direccion");
        String ciudad = intent.getStringExtra("ciudad");

        _id = Long.parseLong(id);

        edtNombre.setText(nombre);
        edtApellido.setText(apellido);
        edtDireccion.setText(direccion);
        edtCiudad.setText(ciudad);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == UPDATE_RECORD){
            String nombre = edtNombre.getText().toString();
            String apellido = edtApellido.getText().toString();
            String direccion = edtDireccion.getText().toString();
            String ciudad = edtCiudad.getText().toString();

            dbManager.update(_id, nombre, apellido, direccion, ciudad);
            this.returnHome();
        } else if (v.getId() == DELETE_RECORD) {
            dbManager.delete(_id);
            this.returnHome();
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ClientListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
