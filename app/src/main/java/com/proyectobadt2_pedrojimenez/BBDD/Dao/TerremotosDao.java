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

    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes||  '%'")
    List<Terremoto> selectTerremotosMes(String mes);
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND fecha_hora LIKE '%' ||:anio|| '%'")
    List<Terremoto> selectTerremotosMesAnio(String mes, String anio);
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND lugar LIKE '%' ||:pais|| '%'")
    List<Terremoto> selectTerremotosMesPais(String mes, String pais);
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND fecha_hora LIKE '%' ||:anio|| '%' AND lugar LIKE '%' ||:pais|| '%'")
    List<Terremoto> selectTerremotosMesAnioPais(String mes, String anio, String pais);
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:anio|| '%'")
    List<Terremoto> selectTerremotosAnio(String anio);
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:anio|| '%' " +
            "AND lugar LIKE '%' ||:pais|| '%'")
    List<Terremoto> selectTerremotosAnioPais(String anio, String pais);
    @Query("SELECT * FROM TERREMOTOS WHERE lugar LIKE '%' ||:pais|| '%'")
    List<Terremoto> selectTerremotosPais(String pais);

    @Insert
    void insertTerremoto(ArrayList<Terremoto> terremoto);
}
