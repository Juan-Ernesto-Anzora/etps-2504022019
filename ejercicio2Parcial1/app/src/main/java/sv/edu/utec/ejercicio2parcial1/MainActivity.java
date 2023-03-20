package sv.edu.utec.ejercicio2parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etPeso, etAltura;
    TextView tResultado;

    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.edtPeso);
        etAltura = findViewById(R.id.edtAltura);
        tResultado = findViewById(R.id.tvResultado);

        edt1 = findViewById(R.id.edtPeso);
        edt1 = findViewById(R.id.edtAltura);
    }

    public void calculoFormula(View view){
        double peso, altura, formulaIMC;
        String resultado;

        peso = Double.parseDouble(etPeso.getText().toString());
        altura = Double.parseDouble(etAltura.getText().toString());
        formulaIMC = peso / (altura * altura);

        if(formulaIMC < 10.5){
            resultado = "Críticamente Bajo de Peso";
            tResultado.setText(String.valueOf(resultado));
        } else if (formulaIMC > 10.5 && formulaIMC < 15.9) {
            resultado = "Severamente Bajo de Peso";
            tResultado.setText(String.valueOf(resultado));
        } else if (formulaIMC > 15.9 && formulaIMC < 18.5) {
            resultado = "Bajo de Peso";
            tResultado.setText(String.valueOf(resultado));
        } else if (formulaIMC > 18.5 && formulaIMC < 25) {
            resultado = "Normal (peso saludable)";
            tResultado.setText(String.valueOf(resultado));
        } else if (formulaIMC > 25 && formulaIMC < 30) {
            resultado = "Sobrepeso";
            tResultado.setText(String.valueOf(resultado));
        } else if (formulaIMC > 30 && formulaIMC < 35) {
            resultado = "Obesidad Clase 1 - Moderadamente Obeso";
            tResultado.setText(String.valueOf(resultado));
        } else if (formulaIMC > 35 && formulaIMC < 40) {
            resultado = "Obesidad Clase 2 - Severamente Obeso";
            tResultado.setText(String.valueOf(resultado));
        } else if (formulaIMC > 40) {
            resultado = "Obesidad Clase 3 - Críticamente Obeso";
            tResultado.setText(String.valueOf(resultado));
        } else {
            resultado = "No hay resultado";
            tResultado.setText(String.valueOf(resultado));
        }
    }
}