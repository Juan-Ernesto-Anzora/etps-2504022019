package sv.edu.utec.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**/
RecyclerView mrecyclerView;
Adapatador adapatador;


    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView=findViewById(R.id.rvPeliculas);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapatador=new Adapatador(this,getListado());
        mrecyclerView.setAdapter(adapatador);


        mrecyclerView.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                Toast.makeText(parent.getContext(),"Selecionar",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private ArrayList<Modelo> getListado(){
        ArrayList<Modelo> modelos=new ArrayList<>();
        Modelo modelista = new Modelo();
        modelista.setNoombPeli("Ex-Maquina");
        modelista.setDirecPeli("Juan Perez");
        modelista.setGeneroPeli("Ciencia ficcion");
        modelista.setImgPeli(R.drawable.ex_maquina);
        modelista.setClasifcar(3.45);
        modelista.setDuraPeli("108 min");
        modelista.setAnioPeli("1999");
        modelos.add(modelista);


        modelista = new Modelo();
        modelista.setNoombPeli("La LLegada");
        modelista.setDirecPeli("Juan Perez");
        modelista.setGeneroPeli("Ciencia ficcion");
        modelista.setImgPeli(R.drawable.la_llegada);
        modelista.setClasifcar(3.45);
        modelista.setDuraPeli("108 min");
        modelista.setAnioPeli("1999");
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNoombPeli("Jumanji");
        modelista.setDirecPeli("Juan Perez");
        modelista.setGeneroPeli("Ciencia ficcion");
        modelista.setImgPeli(R.drawable.jumanji);
        modelista.setClasifcar(3.45);
        modelista.setDuraPeli("108 min");
        modelista.setAnioPeli("1999");
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNoombPeli("Inter Estelar");
        modelista.setDirecPeli("Juan Perez");
        modelista.setGeneroPeli("Ciencia ficcion");
        modelista.setImgPeli(R.drawable.interestelar);
        modelista.setClasifcar(3.45);
        modelista.setDuraPeli("108 min");
        modelista.setAnioPeli("1999");
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNoombPeli("Forma de Agua");
        modelista.setDirecPeli("Juan Perez");
        modelista.setGeneroPeli("Ciencia ficcion");
        modelista.setImgPeli(R.drawable.forma_agua);
        modelista.setClasifcar(3.45);
        modelista.setDuraPeli("108 min");
        modelista.setAnioPeli("1999");
        modelos.add(modelista);

        modelista = new Modelo();
        modelista.setNoombPeli("Extraordinario");
        modelista.setDirecPeli("Juan Perez");
        modelista.setGeneroPeli("Ciencia ficcion");
        modelista.setImgPeli(R.drawable.extraordinario);
        modelista.setClasifcar(3.45);
        modelista.setDuraPeli("108 min");
        modelista.setAnioPeli("1999");
        modelos.add(modelista);

        return modelos;
    }
}