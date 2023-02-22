package com.proyectobadt2_pedrojimenez;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.proyectobadt2_pedrojimenez.BBDD.TerremotosDB;

public class FiltroDialogFragment extends DialogFragment {
    TerremotosDB db = TerremotosDB.getDatabase(getContext());
    OnDatosListener listener;
    Spinner spnMes;
    EditText edtAnio;
    Spinner spnPais;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment_filtro, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Filtrar por:");
        builder.setView(v);

        spnMes = v.findViewById(R.id.spnMes);
        edtAnio = v.findViewById(R.id.edtAnio);
        spnPais = v.findViewById(R.id.spnPais);

        //Modificación del Spinner para que muestre los países afectados de la base de datos (SIN REPETIRSE)
        String[] paisesTotales = db.paisesDao().getPaises();

        //Primer elemento del Spinner vacío
        String[] paisesFinal = new String[paisesTotales.length + 1];
        paisesFinal[0] = "Sin filtro";

        //Método para copiar el array de países a otro array en vez de usar un for
        System.arraycopy(paisesTotales, 0, paisesFinal, 1, paisesTotales.length);

        spnPais.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, paisesFinal));

        builder.setPositiveButton(R.string.aceptar, (dialog, id) -> {
            String mes = null;
            String anio = null;
            String pais = null;

            if (edtAnio.getText().toString().isEmpty()) {
                edtAnio.setText("-1");
            }

            if (Integer.parseInt(edtAnio.getText().toString()) > 2023 ) {
                Toast.makeText(getContext(), "El año introducido no es válido", Toast.LENGTH_SHORT).show();
            }
            else {
                mes = spnMes.getSelectedItem().toString();
                anio = edtAnio.getText().toString();
                if (anio.equals("-1")) {
                    anio = "Sin filtro";
                }
                pais = spnPais.getSelectedItem().toString();
            }
            
            listener.onAceptarDatosListener(mes, anio, pais);
        });

        builder.setNegativeButton(R.string.cancelar, (dialog, id) -> dialog.cancel());

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnDatosListener) {
            listener = (OnDatosListener) activity;
        }
        else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnDatosListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (listener != null) {
            listener = null;
        }
    }
}
