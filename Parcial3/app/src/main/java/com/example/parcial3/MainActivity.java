package com.example.parcial3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.parcial3.ui.CreateFragment;
import com.example.parcial3.ui.DeleteFragment;
import com.example.parcial3.ui.ReadFragment;
import com.example.parcial3.ui.UpdateFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.parcial3.R;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNav;
    public static final int nav_agregar = R.id.nav_agregar;
    public static final int nav_buscar = R.id.nav_buscar;
    public static final int nav_actu = R.id.nav_actu;
    public static final int nav_eliminar = R.id.nav_eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNav=findViewById(R.id.btnNav);

        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag= null;

            switch (item.getItemId()){
                case nav_agregar:
                    seleccionFrag = new CreateFragment();
                    break;
                case nav_buscar:
                    seleccionFrag = new ReadFragment();
                    break;
                case nav_actu:
                    seleccionFrag = new UpdateFragment();
                    break;
                case nav_eliminar:
                    seleccionFrag = new DeleteFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont, seleccionFrag).commit();
            return true;
        }
    };
}