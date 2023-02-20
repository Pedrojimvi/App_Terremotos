package com.proyectobadt2_pedrojimenez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.Terremoto;
import com.proyectobadt2_pedrojimenez.BBDD.Dao.PaisesDao;
import com.proyectobadt2_pedrojimenez.BBDD.Dao.TerremotosDao;
import com.proyectobadt2_pedrojimenez.BBDD.TerremotosDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<Terremoto> terremotos = new ArrayList<Terremoto>();

    public static void setTerremotos(ArrayList<Terremoto> terremotos) {
        terremotos.add(new Terremoto("22 de mayo de 1960, 15:11", 9.5, "Terremoto de Valdivia de 1960",
        "Valdivia, Región de los Ríos", "38°14′24′′S 73°3′0′′O", "1655 a 2000"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTerremotos(terremotos);
        crearBBDD();
    }

    private void crearBBDD() {
        TerremotosDB db = TerremotosDB.getDatabase(this);
        TerremotosDao terremotosDao = db.terremotosDao();
        PaisesDao paisesDao = db.paisesDao();

        //Comprobar si la BBDD está vacía
        if (terremotosDao.getAllTerremotos().size() == 0) {
            //Insertar terremotos
            terremotosDao.insertTerremoto(terremotos);
        }
    }
}