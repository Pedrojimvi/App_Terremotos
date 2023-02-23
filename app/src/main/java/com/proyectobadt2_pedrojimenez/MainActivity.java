package com.proyectobadt2_pedrojimenez;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.proyectobadt2_pedrojimenez.BBDD.Clases.PaisAfectado;
import com.proyectobadt2_pedrojimenez.BBDD.Clases.Terremoto;
import com.proyectobadt2_pedrojimenez.BBDD.Dao.PaisesDao;
import com.proyectobadt2_pedrojimenez.BBDD.Dao.TerremotosDao;
import com.proyectobadt2_pedrojimenez.BBDD.TerremotosDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnDatosListener {
    static ArrayList<Terremoto> terremotos = new ArrayList<>();
    static ArrayList<PaisAfectado> paises = new ArrayList<>();
    String mes = "";
    String anio = "";
    String pais = "";

    public static void setTerremotos(ArrayList<Terremoto> terremotos) {
        terremotos.add(new Terremoto("22 de mayo de 1960, 15:11", 9.5, "Terremoto de Valdivia de 1960",
                "Valdivia, Región de los Ríos", "38°14′24′′S 73°3′0′′O", "1655 a 2000"));
        terremotos.add(new Terremoto("26 de diciembre de 2004, 07:58", 9.3, "Terremoto del océano Índico de 2004",
                "Frente al norte de la isla de Sumatra", "Sin datos", "230270"));
        terremotos.add(new Terremoto("27 de marzo de 1964, 17:36", 9.2, "Terremoto de Alaska de 1964",
                "Anchorage, Alaska", "61°N 148°O", "128"));
        terremotos.add(new Terremoto("11 de marzo de 2011, 14:46", 9.1, "Terremoto y maremoto de Japón de 2011",
                "Costa Este de la Región de Tōhoku, Honshū", "38°19′19.20′′N 142°22′8.40′′E",
                "15897"));
        terremotos.add(new Terremoto("4 de noviembre de 1952, 16:58", 9.0, "Terremoto de Kamchatka de 1952",
                "Península de Kamchatka", "52°48′N 159°30′E", "2366"));
        terremotos.add(new Terremoto("13 de agosto de 1868, 21:30", 9.0, "Terremoto de Arica de 1868", "Arica",
                "18°36′S 71°0′O", "693"));
        terremotos.add(new Terremoto("28 de octubre de 1746, 22:30", 9.0, "Terremoto de Lima de 1746",
                "Lima y Callao", "11°21′00′′S 77°16′48′′O", "15000 a 20000"));
        terremotos.add(new Terremoto("26 de enero de 1700, 21:30", 9.0, "Terremoto de Cascadia de 1700",
                "California, Oregón, Washington y Columbia Británica", "Sin datos", "Sin datos"));
        terremotos.add(new Terremoto("27 de febrero de 2010, 03:34", 8.8, "Terremoto de Chile de 2010",
                "Cobquecura, Región del Biobío (actual Ñuble)", "35°50′45.6′′S 72°42′57.6′′O",
                "525"));
        terremotos.add(new Terremoto("31 de enero de 1906, 15:36", 8.8, "Terremoto de Ecuador y Colombia de 1906",
                "Frente a las costas de Esmeraldas", "1°0′N 81°30′O", "1500"));
        terremotos.add(new Terremoto("25 de noviembre de 1833, 20:00", 8.8, "Terremoto de Sumatra de 1833",
                "En el mar al sur de la isla de Sumatra, a 175 km al sur de Padang", "3°30′S 102°12′E", "Sin datos"));
        terremotos.add(new Terremoto("1 de noviembre de 1755, 10:16", 8.7, "Terremoto de Lisboa de 1755", "Lisboa",
                "36°N 11°O", "60000 a 100000"));
        terremotos.add(new Terremoto("8 de julio de 1730, 04:45", 8.7, "Terremoto de Valparaíso de 1730",
                "Valparaíso y La Serena", "33°30′S 71°36′O", "300"));
        terremotos.add(new Terremoto("11 de abril de 2012, 15:38", 8.6, "Terremoto del océano Índico de 2012",
                "Frente al norte de la isla de Sumatra", "02°18′39.6′′N 93°03′46.8′′E", "10"));
        terremotos.add(new Terremoto("28 de marzo de 2005, 23:09", 8.6, "Terremoto de Sumatra de 2005",
                "Frente al  norte de la isla de Sumatra", "2°36′N 97°6′E", "1300"));
        terremotos.add(new Terremoto("9 de marzo de 1957, 14:22", 8.6, "Terremoto de las islas Andreanof de 1957",
                "Islas Andreanof, Alaska", "51°33′36′′N 175°23′24′′O", "0"));
        terremotos.add(new Terremoto("15 de agosto de 1950", 8.6, "Terremoto de Assam de 1950",
                "Assam (India), Tíbet (China)", "28°30′N 96°30′O", "1526"));
        terremotos.add(new Terremoto("10 de noviembre de 1922, 23:53", 8.6, "Terremoto de Vallenar de 1922 Chile",
                "Región de Atacama y Provincia de Catamarca", "Sin datos", "1500"));
        terremotos.add(new Terremoto("28 de marzo de 1787, 11:30", 8.6, "Terremoto de Nueva España de 1787",
                "Costas de Oaxaca y Guerrero", "Sin datos", "11"));
        terremotos.add(new Terremoto("3 de febrero de 1923, 04:58", 8.5, "Terremoto de Kamchatka de 1923",
                "Península de Kamchatka", "54°N 161°E", "Sin datos"));
        terremotos.add(new Terremoto("20 de octubre de 1687, 09:15", 8.5, "Terremotos de Lima y Callao de 1687",
                "Lima y Callao", "Sin datos", "5000"));
        terremotos.add(new Terremoto("16 de diciembre de 1575, 14:30", 8.5, "Terremoto de Valdivia de 1575",
                "Valdivia", "39°48′S 73°12′O", "1221"));
        terremotos.add(new Terremoto("16 de septiembre de 2015, 19:54", 8.4, "Terremoto de Coquimbo de 2015",
                "Frente a las costas de la Comuna de Canela, Región de Coquimbo",
                "31°34′52′′S 71°45′07′′O", "12"));
        terremotos.add(new Terremoto("23 de junio de 2001, 15:33", 8.4, "Terremoto del sur del Perú de 2001",
                "Departamentos de Arequipa, Moquegua y Tacna", "16°15′36′′S 73°38′24′′O",
                "102"));
        terremotos.add(new Terremoto("6 de febrero de 2023, 01:17", 7.8, "Terremoto de Turquía y Siria 2023",
                "Turquía, Siria", "37°10′26′′N 37°01′55′′E", "40120"));
    }

    public static void setPaises(ArrayList<PaisAfectado> paises) {
        paises.add(new PaisAfectado("22 de mayo de 1960, 15:11", "Chile"));
        paises.add(new PaisAfectado("26 de diciembre de 2004, 07:58", "Indonesia"));
        paises.add(new PaisAfectado("27 de marzo de 1964, 17:36", "Estados Unidos"));
        paises.add(new PaisAfectado("11 de marzo de 2011, 14:46", "Japón"));
        paises.add(new PaisAfectado("4 de noviembre de 1952, 16:58", "Rusia"));
        paises.add(new PaisAfectado("13 de agosto de 1868, 21:30", "Chile"));
        paises.add(new PaisAfectado("28 de octubre de 1746, 22:30", "Perú"));
        paises.add(new PaisAfectado("26 de enero de 1700, 21:30", "Estados Unidos"));
        paises.add(new PaisAfectado("27 de febrero de 2010, 03:34", "Chile"));
        paises.add(new PaisAfectado("6 de febrero de 2023, 01:17", "Turquía"));
        paises.add(new PaisAfectado("6 de febrero de 2023, 01:17", "Siria"));
        paises.add(new PaisAfectado("31 de enero de 1906, 15:36", "Ecuador"));
        paises.add(new PaisAfectado("31 de enero de 1906, 15:36", "Colombia"));
        paises.add(new PaisAfectado("25 de noviembre de 1833, 20:00", "Indonesia"));
        paises.add(new PaisAfectado("1 de noviembre de 1755, 10:16", "Portugal"));
        paises.add(new PaisAfectado("8 de julio de 1730, 04:45", "Chile"));
        paises.add(new PaisAfectado("11 de abril de 2012, 15:38", "Indonesia"));
        paises.add(new PaisAfectado("28 de marzo de 2005, 23:09", "Indonesia"));
        paises.add(new PaisAfectado("9 de marzo de 1957, 14:22", "Estados Unidos"));
        paises.add(new PaisAfectado("15 de agosto de 1950", "India"));
        paises.add(new PaisAfectado("15 de agosto de 1950", "China"));
        paises.add(new PaisAfectado("10 de noviembre de 1922, 23:53", "Argentina"));
        paises.add(new PaisAfectado("28 de marzo de 1787, 11:30", "México"));
        paises.add(new PaisAfectado("3 de febrero de 1923, 04:58", "Rusia"));
        paises.add(new PaisAfectado("20 de octubre de 1687, 09:15", "Perú"));
        paises.add(new PaisAfectado("16 de diciembre de 1575, 14:30", "Chile"));
        paises.add(new PaisAfectado("16 de septiembre de 2015, 19:54", "Chile"));
        paises.add(new PaisAfectado("23 de junio de 2001, 15:33", "Perú"));
    }

    Button btnFil;
    Button btnCon;
    TextView txtFil;
    RecyclerView rcVRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTerremotos(terremotos);
        setPaises(paises);
        crearBBDD();

        btnFil = findViewById(R.id.btnFil);
        btnCon = findViewById(R.id.btnCon);
        txtFil = findViewById(R.id.txtFil);
        rcVRes = findViewById(R.id.rcVRes);

        btnFil.setOnClickListener(v -> {
            FiltroDialogFragment filtroDialogFragment = new FiltroDialogFragment();
            filtroDialogFragment.show(getSupportFragmentManager(), "FiltroDialogFragment");

            onAceptarDatosListener(mes, anio, pais);
        });

        btnCon.setOnClickListener(v -> {
            rcVRes.setLayoutManager(new LinearLayoutManager(this));
            rcVRes.setItemAnimator(new DefaultItemAnimator());

            if (mes.equals("") || anio.equals("") || pais.equals("")) {
                Toast.makeText(this, "No se ha seleccionado ningún filtro", Toast.LENGTH_SHORT).show();
            }
            else {
                TerremotosDB db = TerremotosDB.getDatabase(this);
                //Comprobar si el mes es "Sin filtro"
                if (mes.equals("Sin filtro")) {
                    //Comprobar si el año es "Sin filtro"
                    if (anio.equals("Sin filtro")) {
                        //Comprobar si el país es "Sin filtro"
                        if (pais.equals("Sin filtro")) {
                            //Mostrar todos los terremotos
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().getAllTerremotos());
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(adapter);
                        }
                        else {
                            //Mostrar los terremotos de un país
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().selectTerremotosPais(pais));
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(adapter);
                        }
                    }
                    else {
                        //Comprobar si el país es "Sin filtro"
                        if (pais.equals("Sin filtro")) {
                            //Mostrar los terremotos de un año
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().selectTerremotosAnio(anio));
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(new TerremotosAdapter(db.terremotosDao().selectTerremotosAnio(anio)));
                        }
                        else {
                            //Mostrar los terremotos de un año y un país
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().selectTerremotosAnioPais(anio, pais));
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(adapter);
                        }
                    }
                }
                else {
                    //Comprobar si el año es "Sin filtro"
                    if (anio.equals("Sin filtro")) {
                        //Comprobar si el país es "Sin filtro"
                        if (pais.equals("Sin filtro")) {
                            //Mostrar los terremotos de un mes
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().selectTerremotosMes(mes));
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(adapter);
                        }
                        else {
                            //Mostrar los terremotos de un mes y un país
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().selectTerremotosMesPais(mes, pais));
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(adapter);
                        }
                    }
                    else {
                        //Comprobar si el país es "Sin filtro"
                        if (pais.equals("Sin filtro")) {
                            //Mostrar los terremotos de un mes y un año
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().selectTerremotosMesAnio(mes, anio));
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(adapter);
                        }
                        else {
                            //Mostrar los terremotos de un mes, un año y un país
                            TerremotosAdapter adapter = new TerremotosAdapter(db.terremotosDao().selectTerremotosMesAnioPais(mes, anio, pais));
                            if (adapter.getItemCount() == 0)
                                Toast.makeText(this, "No se han encontrado terremotos con esos filtros", Toast.LENGTH_SHORT).show();
                            rcVRes.setAdapter(adapter);
                        }
                    }
                }
            }
        });
    }

    private void crearBBDD() {
        TerremotosDB db = TerremotosDB.getDatabase(this);
        TerremotosDao terremotosDao = db.terremotosDao();
        PaisesDao paisesDao = db.paisesDao();

        //Comprobar si la BBDD de terremotos está vacía
        if (terremotosDao.getAllTerremotos().isEmpty()) {
            //Insertar terremotos
            terremotosDao.insertTerremoto(terremotos);
        }

        //Comprobar si la BBDD de paises afectados está vacía
        if (paisesDao.getAllPaises().isEmpty()) {
            //Insertar paises
            paisesDao.insertPais(paises);
        }
    }

    public void onAceptarDatosListener(String mes, String anio, String pais) {
        this.mes = mes;
        this.anio = anio;
        this.pais = pais;
        txtFil.setText("Mes: " + mes + "\nAño: " + anio + "\nPaís: " + pais);
    }
}