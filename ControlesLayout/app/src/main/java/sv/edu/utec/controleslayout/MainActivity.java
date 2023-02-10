package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spPais;
    EditText etNombres,etApellidos,etInfo;
    RadioButton rbFem,rbMas,rbOtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombres = findViewById(R.id.edtNombres);
        etApellidos = findViewById(R.id.edtApellidos);
        etInfo = findViewById(R.id.editTextTextMultiLine);
        spPais = findViewById(R.id.spnPais);
        String[]opciones = {"Guatemala","El Salvador","Honduras","Nicaragua","Costa Rica","Panama"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);

    }
}