/*
    Ejemplo de ArrayListAdapter con su implementación por defecto.
    Solo puede mostrar un Textview en cada item de la ListView.
 */

package com.example.profesor.ejemplolistviewyadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ArrayListAdapterActivity extends AppCompatActivity {

    /*static final String[] QUESOS = {
            "Parmesan",
            "Ricotta",
            "Fontina",
            "Mozzarella",
            "Cheddar"
    };*/
    String[] QUESOS = ListaQuesos.getInstance().getQuesos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creamos adaptador
        ArrayAdapter<String> quesoAdapter = new ArrayAdapter<>(
                this,
                R.layout.layout_item_queso, // XML con layout de item
                R.id.nombre_queso_texview, // textview dentro de xml que contendra dato
                QUESOS);

        // Creamos el ListView
        ListView listaQuesos = new ListView(this);

        // Hace el inflate del ListView dentro de la actividad.
        // Ocupara todo la pantalla
        setContentView(listaQuesos);

        // Enlaza el Adapter a la listview
        listaQuesos.setAdapter(quesoAdapter);

        // Generamos Listeners para recoger el vento de click sobre un item de la lista

        listaQuesos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Código a ejecutar cuando se produce el evento

                // Generamos un mensaje basado en la posición en el array del item pulsado
                String mensaje = "Has pulsado QUESOS["+ position +"] --> " + QUESOS[position];

                // Mostramos el mensaje usando un Toast

                Toast.makeText(ArrayListAdapterActivity.this, mensaje, Toast.LENGTH_LONG).show();

                // Si fuera necesario también disponemos de la view que representa el item que
                // hemos pulsado en la lista. Lo tenemos en el parametro view.
                // Por ejemplo podemos extraer el textview que contiene el nombre del queso de
                // dicho view (que recordar que es un linear layout)

                TextView tv = (TextView) ((LinearLayout) view).getChildAt(0);
                mensaje = "** Has pulsado QUESOS["+ position +"] --> " + tv.getText().toString();
                Toast.makeText(ArrayListAdapterActivity.this, mensaje, Toast.LENGTH_LONG).show();



            }
        });

    }
}
