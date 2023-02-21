package com.proyectobadt2_pedrojimenez.BBDD;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.Terremoto;

public class TerremotosAdapter extends RecyclerView.Adapter<TerremotosAdapter.TerremotosViewHolder> {
    public TerremotosAdapter(Terremoto selectTerremotos) {
    }

    @NonNull
    @Override
    public TerremotosAdapter.TerremotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TerremotosAdapter.TerremotosViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class TerremotosViewHolder extends RecyclerView.ViewHolder {

        public TerremotosViewHolder(@NonNull ViewGroup parent) {
            super(parent);
        }
    }
}
