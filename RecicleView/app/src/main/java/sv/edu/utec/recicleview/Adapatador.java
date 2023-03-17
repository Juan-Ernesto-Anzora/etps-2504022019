package sv.edu.utec.recicleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapatador extends RecyclerView.Adapter<Elementos> {
    Context context;
    ArrayList<Modelo> modelos;


    public Adapatador(Context context, ArrayList<Modelo> modelos) {
        this.context = context;
        this.modelos = modelos;
    }




    @NonNull
    @Override
    public Elementos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.peliculas_listado,null);
        return new Elementos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Elementos holder, int position) {
        Elementos.tvnomPel.setText(modelos.get(position).getNoombPeli());
        Elementos.tvGenPeli.setText(modelos.get(position).getGeneroPeli());
        Elementos.imvimgPel.setImageResource(modelos.get(position).getImgPeli());

      /*  Elementos.tvnomPel.setText(modelos.get(position).getNoombPeli());
        Elementos.tvnomPel.setText(modelos.get(position).getNoombPeli());
        Elementos.tvnomPel.setText(modelos.get(position).getNoombPeli());
        Elementos.tvnomPel.setText(modelos.get(position).getNoombPeli());
        Elementos.tvnomPel.setText(modelos.get(position).getNoombPeli());

       */


    }

    @Override
    public int getItemCount() {

       return modelos.size();
    }
}
