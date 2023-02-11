package sv.edu.utec.guia2_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final double varIVA = 13.4;
    EditText etPrecio;
    TextView tResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrecio = findViewById(R.id.edtPrecio);
        tResultado = findViewById(R.id.tvResultado);
    }

    @SuppressLint("SetTextI18n")
    public void calculoPrecio(View view){
        double precio, subtotal, resultado;

        precio = Double.parseDouble(etPrecio.getText().toString());
        subtotal = precio * (varIVA / 100);
        resultado = precio + subtotal;

        if(precio > 0){
            tResultado.setText("Precio: "+String.valueOf(precio)+ "\n"+
                    "Iva: "+String.valueOf(varIVA)+"\n"+
                    "SubTotal: "+String.valueOf(subtotal)+"\n"+
                    "Total: "+String.valueOf(resultado)+"\n");
        }else{
            tResultado.setText("El precio debe ser mayor a cero");
        }
    }
}