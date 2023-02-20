package com.proyectobadt2_pedrojimenez.BBDD.Clases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "TERREMOTOS", indices = @Index(value = {"fecha_hora"}, unique = true))
public class Terremoto {
    @PrimaryKey()
    @ColumnInfo(name = "fecha_hora")
    @NonNull
    private String fec_hor;
    @ColumnInfo(name = "magnitud")
    private Double mag;
    @ColumnInfo(name = "nom_disp")
    private String nom_disp;
    @ColumnInfo(name = "coor_epi")
    private String coor_epic;
    @ColumnInfo(name = "lugar")
    private String lug;
    @ColumnInfo(name = "cant_mue")
    private String cant_mue;

    public Terremoto(String fec_hor, Double mag, String nom_disp, String coor_epic, String lug, String cant_mue) {
        this.fec_hor = fec_hor;
        this.mag = mag;
        this.nom_disp = nom_disp;
        this.coor_epic = coor_epic;
        this.lug = lug;
        this.cant_mue = cant_mue;
    }

    @NonNull
    public String getFec_hor() {
        return fec_hor;
    }

    public Double getMag() {
        return mag;
    }

    public String getNom_disp() {
        return nom_disp;
    }

    public String getCoor_epic() {
        return coor_epic;
    }

    public String getLug() {
        return lug;
    }

    public String getCant_mue() {
        return cant_mue;
    }
}
