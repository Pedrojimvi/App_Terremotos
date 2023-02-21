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

    @Query("SELECT DISTINCT * FROM PAISES_AFECTADOS WHERE fecha_hora = :fec_hor")
    PaisAfectado selectPaisByFec_hor(String fec_hor);

    @Query("SELECT DISTINCT * FROM PAISES_AFECTADOS WHERE pais = :pais")
    PaisAfectado selectPaisByPais(String pais);

    //Método para obtener los paises SIN REPETIRSE
    @Query("SELECT DISTINCT pais FROM PAISES_AFECTADOS")
    String[] getPaises();

    @Insert
    void insertPais(ArrayList<PaisAfectado> pais);
}
