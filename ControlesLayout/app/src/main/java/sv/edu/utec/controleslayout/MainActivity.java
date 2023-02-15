package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spPais;
    EditText etNombres,etApellidos,etInfo;
    RadioButton rbFem,rbMas,rbOtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        etNombres=findViewById(R.id.edtNombres);
        etApellidos=findViewById(R.id.edtApellidos);
        etInfo=findViewById(R.id.editTextTextMultiLine);
        //Spinner
        spPais=findViewById(R.id.spnPais);
        //Radiobuttons
        rbFem= findViewById(R.id.rbFemenino);
        rbMas=findViewById(R.id.rbMasculino);
        rbOtr=findViewById(R.id.rbOtros);

        /* forma 1
        spPais.setSelection(0, false);
        String[]opciones={"Seleccione un Pais","Guatemala","El Salvador","Honduras","Nicaragua","Costa Rica","Panama"};
       ArrayAdapter<String> adaptador=
                new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
        spPais.setAdapter(adaptador);
        */

        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){

            public View getView(int posicion, View contenido, ViewGroup parent){
                View vista=super.getView(posicion,contenido,parent);
                if(posicion==getCount()){
                    ((TextView)vista.findViewById(android.R.id.text1)).setText("");
                    ((TextView)vista.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }
                return vista;
            }

            public int getCount(){
                return super.getCount()-1;
            }
        };

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptador.add("Guatemala");
        adaptador.add("El Salvador");
        adaptador.add("Honduras");
        adaptador.add("Nicaragua");
        adaptador.add("Panama");
        adaptador.add("Costa Rica");
        adaptador.add("Seleccione un Pais");//este es el elemento a quitar del spinner
        spPais.setAdapter(adaptador);
        spPais.setSelection(adaptador.getCount());

    }



    public void Almacenar(View v){
        String datos="";
        String seleccion = spPais.getSelectedItem().toString();
        //get traer
        //set enviar
        String nombre=etNombres.getText().toString();
        String apellido=etApellidos.getText().toString();
        String genero="";
        String info;


        if(rbMas.isChecked()==false && rbMas.isChecked()==false && rbOtr.isChecked()==false)
        {
            Toast mensaje= Toast.makeText(this,"seleccione un genero",Toast.LENGTH_SHORT);
            mensaje.show();
        }
        else {
            if (rbMas.isChecked() == true) {
                genero = "Masculino";
            } else if (rbFem.isChecked() == true) {
                genero = "Femenino";
            } else {
                genero = "Otros";
            }
        }

        if(seleccion.equals("Seleccione un Pais")){
            datos="No selecciono ningun Pais";
            etInfo.append(datos);
        }
        else if(seleccion.equals("Guatemala")){
            datos="Guatemala";
            etInfo.append(datos);
        }
        else if(seleccion.equals("El Salvador")){
            datos="El Salvador";
            etInfo.append(datos);
        }
        else if(seleccion.equals("Honduras")){
            datos="Honduras";
            etInfo.append(datos);
        }

        info="Los datos ingresados son los siguientes \n"+
                "Nombre     : "+nombre+"\n"+
                "Apellido   : "+apellido+"\n"+
                "Genero     : "+genero +"\n"+
                "Pais       :  "+datos+ "\n";

        etInfo.append(info);
//08/02/2023
    }
}