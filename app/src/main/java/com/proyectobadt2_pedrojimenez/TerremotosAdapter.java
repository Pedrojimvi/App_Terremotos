package com.proyectobadt2_pedrojimenez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.Terremoto;

import java.util.List;

public class TerremotosAdapter extends RecyclerView.Adapter<TerremotosAdapter.TerremotosViewHolder> {
    //Creamos la lista de terremotos
    List<Terremoto> listaTerremotos;
    public TerremotosAdapter(List<Terremoto> listaTerremotos) {
        this.listaTerremotos = listaTerremotos;
    }

    @NonNull
    @Override
    public TerremotosAdapter.TerremotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.terremoto_item, parent, false);
        return new TerremotosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TerremotosAdapter.TerremotosViewHolder holder, int position) {
        //Añadir los datos de la lista al ViewHolder
        Terremoto terremoto = listaTerremotos.get(position);
        holder.txtFec.setText(terremoto.getFec_hor());
        holder.txtMag.setText(String.valueOf(terremoto.getMag()));
        holder.txtNom_dis.setText(terremoto.getNom_disp());
        holder.txtCoor.setText(terremoto.getCoor_epic());
        holder.txtLug.setText(terremoto.getLug());
        holder.txtCant.setText(terremoto.getCant_mue());
    }

    @Override
    public int getItemCount() {
        return listaTerremotos.size();
    }

    public static class TerremotosViewHolder extends RecyclerView.ViewHolder {
        public TextView txtFec, txtMag, txtNom_dis, txtCoor, txtLug, txtCant;
        //Añadimos los elementos del layout terremoto_item al ViewHolder

        public TerremotosViewHolder(@NonNull View v) {
            super(v);
            txtFec = v.findViewById(R.id.txtFec);
            txtMag = v.findViewById(R.id.txtMag);
            txtNom_dis = v.findViewById(R.id.txtNom_dis);
            txtCoor = v.findViewById(R.id.txtCoor);
            txtLug = v.findViewById(R.id.txtLug);
            txtCant = v.findViewById(R.id.txtCant);
        }
    }
}
