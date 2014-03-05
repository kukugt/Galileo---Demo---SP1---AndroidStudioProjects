package com.example.tarea_3.app;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Store extends Activity {

    private List<String> tiendas = new ArrayList<String>();
    ArrayAdapter adapter;
    listDetails datos;
    Intent detalle;
    private List<listDetails> detalles = new ArrayList<listDetails>();



    ListView lista;
    ArrayAdapter<String> adaptador;
    ArrayList<String> stores;
    Intent intent = null;



    public Store (View v){



        stores = new ArrayList<String>();
        stores.add("Tienda de Zapatos");

        stores.add("Tienda de Ropa");

//        stores.add("Tienda de Libros");

        stores.add("Tienda de Tecnologia");


        lista = (ListView) findViewById(R.id.list_stores);

        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, stores);
        lista.setAdapter(adaptador);
        lista.setTextFilterEnabled(true);
        lista.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                intent = new Intent(getApplicationContext(),DetailsActivity.class);
                intent.putExtra("pos", (int)position);
                startActivity(intent);
            }
        });

/*
        datos = new listDetails("Tienda Tigo","3ra. Calle Guatemala", "12345678", "Lunea a viernes: 8AM - 8PM", "http://tigo.com", "info@tigo.com", new comments("Hola Mundo"), "fav", new geolocation(1.0,4.0) );
        tiendas.add("Tienda Tigo");
        detalles.add(datos);


        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tiendas);
        setListAdapter(adapter);


        ListView list = (ListView) findViewById(android.R.id.list);
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String nombre;
                String direccion;
                String telefono;
                String horarios;
                String website;
                String email;
                comments comentarios;
                String favoritos;
                geolocation ubicacion;

                nombre = detalles.get(position).nombre;
                direccion = detalles.get(position).direccion;
                telefono = detalles.get(position).telefono;
                horarios = detalles.get(position).horarios;
                website = detalles.get(position).website;
                email = detalles.get(position).email;
                comentarios = detalles.get(position).comentarios;
                favoritos = detalles.get(position).favoritos;
                ubicacion = detalles.get(position).ubicacion;

              //  detalle = new Intent(Store.this, DetailsActivity.class);

                detalle.putExtra("nombre", nombre);
                detalle.putExtra("direccion", direccion);
                detalle.putExtra("telefono", telefono);
                detalle.putExtra("horarios", horarios);
                detalle.putExtra("website", website);
                detalle.putExtra("email", email);
                //detalle.putExtra("comentarios", comentarios);
                detalle.putExtra("favoritos", favoritos);
                //detalle.putExtra("ubicacion", ubicacion);


                startActivity(detalle);
            }
        });
*/

    }

}
