package sv.edu.utec.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lstDias;
ArrayAdapter<CharSequence> adapatador;
ArrayAdapter adaptadores;
    ArrayList<String> listaEmpleados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDias=findViewById(R.id.lvlistaDias);
        adapatador=ArrayAdapter.createFromResource(this,R.array.arregloDias,android.R.layout.simple_list_item_1);
        lstDias.setAdapter(adapatador);

        //llenado desde un archivo string


        /*
//llenado desde un array list
        listaEmpleados= new ArrayList<>();
        listaEmpleados.add("Juan");
        listaEmpleados.add("Karla");
        listaEmpleados.add("Roberto");
        listaEmpleados.add("Maria");
        listaEmpleados.add("Daniela");
        listaEmpleados.add("Jose");


        for(int i =0;i<100;i++)
        {
            listaEmpleados.add("Jazmin "+i);

        }


        adaptadores= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaEmpleados);

        lstDias.setAdapter(adaptadores);
         */
        lstDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Selecciono"+parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });




    }
}