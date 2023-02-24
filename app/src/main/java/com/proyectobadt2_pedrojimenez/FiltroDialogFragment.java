package com.proyectobadt2_pedrojimenez;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.proyectobadt2_pedrojimenez.BBDD.TerremotosDB;

import java.util.Calendar;

public class FiltroDialogFragment extends DialogFragment {
    TerremotosDB db = TerremotosDB.getDatabase(getContext());
    OnDatosListener listener;
    Spinner spnMes;
    EditText edtAnio;
    Spinner spnPais;
    static int opMes = 0;
    static int opAnio = 0;
    static int opPais = 0;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment_filtro, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Creación del título del diálogo con el color correspondiente y negrita
        SpannableString titulo = new SpannableString("Filtrar por:");
        titulo.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, titulo.length(), 0);
        titulo.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.brown_500)), 0, titulo.length(), 0);
        builder.setTitle(titulo);
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

        //Modificación de los Spinners y EditText para que muestren los valores que se han filtrado anteriormente
        spnMes.setSelection(opMes);
        if (opAnio > 0) edtAnio.setText(String.valueOf(opAnio));
        spnPais.setSelection(opPais);

        builder.setPositiveButton(R.string.aceptar, (dialog, id) -> {
            String mes;
            String anio;
            String pais;

            if (edtAnio.getText().toString().isEmpty()) {
                edtAnio.setText("-1");
            }

            //Comprobamos que la versión de Android sea la necesaria para usar LocalDate (SITUACIÓN MUY PUNTUAL Y QUE NO SE DA EN LA MAYORÍA DE LOS CASOS)
            int anioInt = Calendar.getInstance().get(Calendar.YEAR);

            if (Integer.parseInt(edtAnio.getText().toString()) > anioInt || (edtAnio.length() >= 1 && edtAnio.length() < 4 && !edtAnio.getText().toString().equals("-1"))) Toast.makeText(getContext(), "Año introducido no válido porque no tiene 4 cifras o supera el actual", Toast.LENGTH_SHORT).show();
            else {
                mes = spnMes.getSelectedItem().toString();
                anio = edtAnio.getText().toString();
                if (anio.equals("-1")) {
                    anio = "Sin filtro";
                }
                pais = spnPais.getSelectedItem().toString();

                listener.onAceptarDatosListener(mes, anio, pais);

                //Guardamos los valores de los filtros para que se muestren en el diálogo cuando se vuelva a abrir
                opMes = spnMes.getSelectedItemPosition();
                opAnio = Integer.parseInt(edtAnio.getText().toString());
                opPais = spnPais.getSelectedItemPosition();
            }
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
