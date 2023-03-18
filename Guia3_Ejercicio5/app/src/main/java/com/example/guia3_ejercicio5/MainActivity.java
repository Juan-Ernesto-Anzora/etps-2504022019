package com.example.guia3_ejercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ladoAEditText, ladoBEditText, ladoCEditText;
    private ImageView triangleImageView;
    private Button submitButton;
    private TextView tvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        ladoAEditText = findViewById(R.id.edtLadoA);
        ladoBEditText = findViewById(R.id.edtLadoB);
        ladoCEditText = findViewById(R.id.edtLadoC);
        triangleImageView = findViewById(R.id.imageView);
        submitButton = findViewById(R.id.btnTriangulo);
        tvNombre = findViewById(R.id.tvTipoTriangulo);

        // Crear el click listener para el botón de comprobar
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lado1String = ladoAEditText.getText().toString();
                String lado2String = ladoBEditText.getText().toString();
                String lado3String = ladoCEditText.getText().toString();

                try {
                    double lado1 = Double.parseDouble(lado1String);
                    double lado2 = Double.parseDouble(lado2String);
                    double lado3 = Double.parseDouble(lado3String);

                    if (esValido(lado1, lado2, lado3)) {
                        String tipoTriangulo = getTipoTriangulo(lado1, lado2, lado3);
                        int imageResource = getRecursoImagenTriangulo(tipoTriangulo);
                        triangleImageView = findViewById(R.id.imageView);
                        triangleImageView.setImageResource(imageResource);
                        getNombreTipoTriangulo(tipoTriangulo);
                        limpiar();
                    } else {
                        Toast.makeText(MainActivity.this, "Triángulo Inválido", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Entrada Inválida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean esValido(double lado1, double lado2, double lado3) {
        return (lado1 + lado2 > lado3) && (lado2 + lado3 > lado1) && (lado1 + lado3 > lado2);
    }

    private String getTipoTriangulo(double lado1, double lado2, double lado3) {
        if (lado1 == lado2 && lado2 == lado3) {
            return "equilatero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "isosceles";
        } else {
            return "escaleno";
        }
    }

    private int getRecursoImagenTriangulo(String tipoTriangulo) {
        switch (tipoTriangulo) {
            case "equilatero":
                return R.drawable.equilateral_triangle;
            case "isosceles":
                return R.drawable.triangulo_isosceles;
            case "escaleno":
                return R.drawable.triangulo_escaleno;
            default:
                throw new IllegalArgumentException("Tipo de Triángulo Inválido");
        }
    }

    private void getNombreTipoTriangulo(String triangleType) {
        switch (triangleType) {
            case "equilatero":
                tvNombre.setText("Triángulo Equilátero");
                break;
            case "isosceles":
                tvNombre.setText("Triángulo Isosceles");
                break;
            case "escaleno":
                tvNombre.setText("Triángulo Escaleno");
                break;
            default:
                tvNombre.setText("Tipo de Triángulo Inválido");
                break;
        }
    }

    private void limpiar(){
        ladoAEditText.getText().clear();
        ladoBEditText.getText().clear();
        ladoCEditText.getText().clear();
    }
}