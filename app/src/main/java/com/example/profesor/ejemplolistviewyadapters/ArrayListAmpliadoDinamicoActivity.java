/*
ArrayListAmpliadoDinamicoActivity.java
Sobrescriber método getView del ArrayAdapter para que pueda mostrar en cada item más
información que un simple textview (comportamiento por defecto de ArrayAdapter).
En el getView hace un inflate de R.layout.layout_item_queso, que cotiene el layout del
item con un solo textview, para poblar con nombre queso extraido del array de quesos

Adicionalmente crea de forma dinamica (programática) otro textview, que añade al layout
que representa el item en el listView, y lo puebla con la fecha en que se muestra dicho
item.


 */

package com.example.profesor.ejemplolistviewyadapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;



import java.util.Calendar;

import java.util.TimeZone;

public class ArrayListAmpliadoDinamicoActivity extends AppCompatActivity {
    String[] QUESOS = ListaQuesos.getInstance().getQuesos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // Creamos adaptador y sobreescribimos metodo getView
        // Segundo parámetro del constructor indica que no usa ningún xml de recurso
        // con el layout del item.
        final ArrayAdapter<String> quesoAdapter = new ArrayAdapter<String>(
                this,0, QUESOS) {
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                Log.d("jmd","Dentro de getView()");

                // Se hace el inflate de convertView solo una vez
                if(convertView == null) {
                    Log.d("jmd","Haciento el inflate del layout del item");
                    convertView = getLayoutInflater()
                            .inflate(R.layout.layout_item_queso, null, false);

                }

                // Asignamos valor al textview con nombre del queso
                TextView queso = convertView.findViewById(R.id.nombre_queso_texview);
                queso.setText(QUESOS[position]);



                // *** Ahora vamos a añadir de forma programatica otro textview a convertView
                // con el instante en que se visualiza en el ListView


                // Hacemos cast de View a ViewGroup.
                // Recordar que ViewGroup es subclase de View
                ViewGroup gv = (ViewGroup)convertView;

                // Si convertView no tiene añadido el segundo textedit con la fecha lo creamos
                // y se la añadimos

                // Si el layout del item solo tiene una view hija, es que solo tiene la del nombre
                // del queso, luego se crea la view para la fecha y se le añade al layout
                if(gv.getChildCount() == 1){
                    TextView fecha = new TextView(getContext());
                    fecha.setText(dameAhora());
                    gv.addView(fecha);   // Añádimos nuevo texview a su layout (el convertView)

                    // Cambiamos márgenes del View fecha programáticamente, asignandole el mismo
                    // margen izquierdo que tiene el view queso
                    LinearLayout.LayoutParams paramsFecha = (LinearLayout.LayoutParams) fecha.getLayoutParams();
                    LinearLayout.LayoutParams paramsQueso = (LinearLayout.LayoutParams) queso.getLayoutParams();
                    paramsFecha.setMarginStart(paramsQueso.getMarginStart());
                    fecha.setLayoutParams(paramsFecha);

                    Log.d("jmd","AÑADIENDO TEXTVIEW");
               } else {  // Si ya tiene el textedit de la fecha solo actualizamos su contenido
                    ((TextView)gv.getChildAt(1)).setText(dameAhora());
                    Log.d("jmd","REUTILIZANDO TEXTVIEW");
                }

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
                QUESOS[position] = "*** " + QUESOS[position] + " ***";

                // Ejecutamos método notifyDataSetChanged() del adapter para que
                // actualice la ListView con los nuevos valores contenidos en el array.

                quesoAdapter.notifyDataSetChanged();


                // Forma no correcta de hacerlo manualmente sin uso del adapter
                // Tras modificar el valor en el array cambiar tb
                // el la view del item que la lista

                //TextView tv = (TextView) ((ViewGroup) view).getChildAt(0);
                //tv.setText("*** " + QUESOS[position] + " ***");

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
