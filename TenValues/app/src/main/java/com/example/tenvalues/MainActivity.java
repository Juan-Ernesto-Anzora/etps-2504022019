package com.example.tenvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etValores;
    Button button;
    TextView tResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValores = findViewById(R.id.edtValores);
        button = findViewById(R.id.btnComprobar);
        tResultado = findViewById(R.id.tvResultado);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int intValue = 0;
                int negativos,positivos,mult15,sumapares;
                negativos=0;
                positivos=0;
                mult15=0;
                sumapares=0;

                if (!etValores.getText().toString().isEmpty()) {
                    if (etValores.getText().toString().length() >= 0) {

                        String input = etValores.getText().toString();
                        String[] values = input.split("\\s+");

                        for (String value : values) {
                            intValue = Integer.parseInt(value);
                            if (intValue > 0) {
                                positivos++;
                            } else if (intValue < 0) {
                                negativos++;
                            }
                            if (intValue % 15 == 0) {
                                mult15++;
                            }
                            if (intValue % 2 == 0) {
                                sumapares=sumapares+intValue;
                            }
                        }

                        /*
                        String[] replace = etValores.getText().toString().split(" ");
                        //tResultado.setText(String.valueOf(replace[1]));

                        for(f=1;f<=10;f++) {
                            if (items<0) {
                                negativos++;
                            } else {
                                if (items>0) {
                                    positivos++;
                                }
                            }
                            if (items%15==0) {
                                mult15++;
                            }
                            if (items%2==0) {
                                sumapares=sumapares+items;
                            }
                        }

                         */
                        tResultado.setText("Negativos: "+String.valueOf(negativos)+ "\n"+
                                "Positivos: "+String.valueOf(positivos)+"\n"+
                                "Multiplos de 15: "+String.valueOf(mult15)+"\n"+
                                "Acumulado: "+String.valueOf(sumapares)+"\n");
                    }
                } else {
                    etValores.setError("Por favor Ingrese Valores");
                }
            }
        });
    }
}