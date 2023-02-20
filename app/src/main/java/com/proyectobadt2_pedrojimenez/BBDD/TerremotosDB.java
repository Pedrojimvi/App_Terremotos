package com.proyectobadt2_pedrojimenez.BBDD;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.PaisAfectado;
import com.proyectobadt2_pedrojimenez.BBDD.Clases.Terremoto;
import com.proyectobadt2_pedrojimenez.BBDD.Dao.PaisesDao;
import com.proyectobadt2_pedrojimenez.BBDD.Dao.TerremotosDao;

@Database(entities = {Terremoto.class, PaisAfectado.class}, version = 1)
public abstract class TerremotosDB extends RoomDatabase {
    public abstract TerremotosDao terremotosDao();
    public abstract PaisesDao paisesDao();

    private static TerremotosDB TERREMOTOS_DATABASE;

    public static TerremotosDB getDatabase(Context context) {
        if (TERREMOTOS_DATABASE == null) {
            TERREMOTOS_DATABASE = Room.databaseBuilder(context.getApplicationContext(), TerremotosDB.class, "TERREMOTOS_DB").allowMainThreadQueries().build();
        }

        return TERREMOTOS_DATABASE;
    }

}
