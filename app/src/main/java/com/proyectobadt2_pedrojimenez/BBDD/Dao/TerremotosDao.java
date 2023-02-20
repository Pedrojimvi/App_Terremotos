package com.proyectobadt2_pedrojimenez.BBDD.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.Terremoto;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TerremotosDao {
    @Query("SELECT * FROM TERREMOTOS")
    List<Terremoto> getAllTerremotos();

    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora = :fec_hor")
    Terremoto selectTerremotoByFec_hor(String fec_hor);

    @Insert
    void insertTerremoto(ArrayList<Terremoto> terremoto);
}
