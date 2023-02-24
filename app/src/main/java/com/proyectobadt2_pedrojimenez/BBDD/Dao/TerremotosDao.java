package com.proyectobadt2_pedrojimenez.BBDD.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.Terremoto;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TerremotosDao {
    //Obtener todos los terremotos
    @Query("SELECT * FROM TERREMOTOS")
    List<Terremoto> getAllTerremotos();

    //Obtener Terremotos por mes
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes||  '%'")
    List<Terremoto> selectTerremotosMes(String mes);

    //Obtener Terremotos por mes y año
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND fecha_hora LIKE '%' ||:anio|| '%'")
    List<Terremoto> selectTerremotosMesAnio(String mes, String anio);

    //Obtener Terremotos por mes y pais
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE t.fecha_hora = p.fecha_hora AND t.fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND pais LIKE '%' ||:pais|| '%'")
    List<Terremoto> selectTerremotosMesPais(String mes, String pais);

    //Obtener Terremotos por mes, año y pais
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE t.fecha_hora = p.fecha_hora AND t.fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND t.fecha_hora LIKE '%' ||:anio|| '%' AND pais LIKE '%' ||:pais|| '%'")
    List<Terremoto> selectTerremotosMesAnioPais(String mes, String anio, String pais);

    //Obtener Terremotos por año
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:anio|| '%'")
    List<Terremoto> selectTerremotosAnio(String anio);

    //Obtener Terremotos por año y pais
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE t.fecha_hora = p.fecha_hora AND t.fecha_hora LIKE '%' ||:anio|| '%' " +
            "AND pais LIKE '%' ||:pais|| '%'")
    List<Terremoto> selectTerremotosAnioPais(String anio, String pais);

    //Obtener Terremotos por pais
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE pais LIKE '%' ||:pais|| '%' AND t.fecha_hora = p.fecha_hora")
    List<Terremoto> selectTerremotosPais(String pais);

    @Insert
    void insertTerremoto(ArrayList<Terremoto> terremoto);
}
