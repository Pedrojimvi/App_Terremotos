package com.proyectobadt2_pedrojimenez.BBDD.Clases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "PAISES_AFECTADOS", indices = @Index(value = {"fecha_hora", "pais"}, unique = true), primaryKeys = {"fecha_hora", "pais"},
        foreignKeys = @ForeignKey(entity = Terremoto.class, parentColumns = "fecha_hora", childColumns = "fecha_hora", onDelete = ForeignKey.CASCADE))
public class PaisAfectado {
    @ColumnInfo(name = "fecha_hora")
    @NonNull
    private String fec_hor;
    @ColumnInfo(name = "pais")
    @NonNull
    private String pais;

    public PaisAfectado(String fec_hor, String pais) {
        this.fec_hor = fec_hor;
        this.pais = pais;
    }

    public String getFec_hor() {
        return fec_hor;
    }

    public String getPais() {
        return pais;
    }
}
