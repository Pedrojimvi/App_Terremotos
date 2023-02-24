package com.proyectobadt2_pedrojimenez.BBDD.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.PaisAfectado;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PaisesDao {
    @Query("SELECT DISTINCT * FROM PAISES_AFECTADOS")
    List<PaisAfectado> getAllPaises();
    //Método para obtener los paises SIN REPETIRSE
    @Query("SELECT DISTINCT pais FROM PAISES_AFECTADOS")
    String[] getPaises();

    @Insert
    void insertPais(ArrayList<PaisAfectado> pais);
}
