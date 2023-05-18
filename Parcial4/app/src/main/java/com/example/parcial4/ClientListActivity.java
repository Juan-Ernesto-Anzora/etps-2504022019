package com.example.parcial4;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial4.helper.BaseHelper;
import com.example.parcial4.helper.DBManager;

public class ClientListActivity extends AppCompatActivity {
    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { BaseHelper._ID,
            BaseHelper.NOMBRES, BaseHelper.APELLIDOS, BaseHelper.DIRECCION, BaseHelper.CIUDAD };

    final int[] to = new int[] { R.id.id, R.id.nombre, R.id.apellido,  R.id.direcc, R.id.ciudad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView nombreTextView = (TextView) view.findViewById(R.id.nombre);
                TextView apellidoTextView = (TextView) view.findViewById(R.id.apellido);
                TextView direccionTextView = (TextView) view.findViewById(R.id.direcc);
                TextView ciudadTextView = (TextView) view.findViewById(R.id.ciudad);

                String id = idTextView.getText().toString();
                String nombre = nombreTextView.getText().toString();
                String apellido = apellidoTextView.getText().toString();
                String direccion = direccionTextView.getText().toString();
                String ciudad = ciudadTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModifyClientActivity.class);
                modify_intent.putExtra("nombre", nombre);
                modify_intent.putExtra("apellido", apellido);
                modify_intent.putExtra("direccion", direccion);
                modify_intent.putExtra("ciudad", ciudad);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, AddClientActivity.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }
}
