package sv.edu.utec.ejercicio1parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPrincipal;
    EditText etUser, etContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.edtUser);
        etContra = findViewById(R.id.edtPassword);
    }

    public void login(View view){
        String user, contrasena;
        user = etUser.getText().toString();
        contrasena = etContra.getText().toString();

        if (user.equals("parcialETps1") && contrasena.equals("p4rC14l#tp$")){

            btnPrincipal=findViewById(R.id.btnLogin);
            btnPrincipal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intento=new Intent(getApplicationContext(),Principal.class);
                    startActivity(intento);
                }
            });
        }else {
            Toast mensaje= Toast.makeText(this,"Contraseña y Usuario no son correctos",Toast.LENGTH_SHORT);
            mensaje.show();
        }
    }
}