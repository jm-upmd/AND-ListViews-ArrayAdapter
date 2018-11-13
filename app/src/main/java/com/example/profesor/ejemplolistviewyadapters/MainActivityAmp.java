package com.example.profesor.ejemplolistviewyadapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivityAmp extends AppCompatActivity {
    String[] QUESOS = ListaQuesos.getInstance().getQuesos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos adaptador y sobreescribimos metodo getView
        // Segundo parámetro del constructor indica que no usa ningún xml de recurso
        // con el layout del item.
        final ArrayAdapter<String> quesoAdapter = new ArrayAdapter<String>(
                this,0, QUESOS) {
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                // Se hace el inflate de convertView solo una vez
                if(convertView == null) {
                    convertView = getLayoutInflater()
                            .inflate(R.layout.layout_item_queso_amp, null, false);

                }

                // Asignamos valor al textview con nombre del queso
                TextView queso = convertView.findViewById(R.id.nombre_queso_texview);
                queso.setText(QUESOS[position]);

                // Y al textview que muestra la fecha, la fecha actual
                TextView fecha = convertView.findViewById(R.id.fecha);
                fecha.setText(dameAhora());

                return convertView;
            }
        };

        // Creamos el ListView
        ListView listaQuesos = new ListView(this);

        // Hace el inflate del ListView dentro de la actividad.
        // Ocupara toda la pantalla
        setContentView(listaQuesos);

        // Enlaza el Adapter a la listview
        listaQuesos.setAdapter(quesoAdapter);

        // Listeners para que cuando se pulse item cambie el nombre del
        // queso poniendolo prefijado y sufijado con tres asteriscos.

        listaQuesos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Generamos un mensaje basado en la posición en el array del item pulsado
                String mensaje = "Has pulsado QUESOS["+ position +"] --> " + QUESOS[position];

                // Mostramos el mensaje usando un Toast
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

                // Extraemos y mostramos la fecha del item. Como es un dato que no está en
                // el array, lo cogemos del view directamente
                TextView tView = view.findViewById(R.id.fecha);
                mensaje = "La fecha es: " + tView.getText().toString();
                // También podemos coger el nombre del queso de view en vez de del array
                tView = view.findViewById(R.id.nombre_queso_texview);
                mensaje += "\nEl queso es: " +tView.getText().toString();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();




            }
        });
    }



    public String dameAhora(){
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));

        int hour12 = c.get(Calendar.HOUR);
        int minutes = c.get(Calendar.MINUTE);
        int seconds = c.get(Calendar.SECOND);
        int date = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        return date + "/" + month +"/"+year + " ("+hour12+":"+minutes+":"+seconds+")";
    }
}
