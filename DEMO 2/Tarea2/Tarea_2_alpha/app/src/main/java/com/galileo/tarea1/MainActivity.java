package com.galileo.tarea1;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    // ActionBarActivity
   // ListActivity listAc = new ListActivity();
    private List<String> tiendas = new ArrayList<String>();
    ArrayAdapter adapter;
    listDetails datos;
    Intent detalle;
    private List<listDetails> detalles = new ArrayList<listDetails>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        datos = new listDetails("18av 4-24 zona 12", "24569875", "Lunea a viernes: 8AM - 8PM", "www.tiendalego.com", "tiendalego@tienda.com");
        tiendas.add("Tienda de Lego");
        detalles.add(datos);
        datos = new listDetails("4av 8-24 zona 6", "2221895", "Lunes a Sabado: 7AM - 8PM", "www.tiendalibro.com", "tiendalibro@tienda.com");
        tiendas.add("Tienda de Libros");
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
                String horario;
                String website;
                String email;
                nombre = tiendas.get(position).toString();
                direccion = detalles.get(position).getdireccion().toString();
                telefono = detalles.get(position).gettelefono().toString();
                horario = detalles.get(position).gethorario().toString();
                website = detalles.get(position).getwebsite().toString();
                email = detalles.get(position).getemail().toString();
                detalle = new Intent(MainActivity.this,
                        DetailsActivity.class);
                detalle.putExtra("nombre", nombre);
                detalle.putExtra("direccion", direccion);
                detalle.putExtra("telefono", telefono);
                detalle.putExtra("horario", horario);
                detalle.putExtra("website", website);
                detalle.putExtra("email", email);
                startActivity(detalle);
            }
        });

        if (savedInstanceState == null) {
           // getSupportFragmentManager().beginTransaction()
                  //  .add(R.id.container, new PlaceholderFragment())
                //    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        Intent intent;
        if(item_id == R.id.About){
            Toast.makeText(this, "Yorch Chaclán - 11002633",
                    Toast.LENGTH_SHORT).show();
        }
        if(item_id == R.id.List){
            intent = new Intent(this,
                    MainActivity.class);
            startActivity(intent);
        }else
        if(item_id == R.id.Photo){
            intent = new Intent(this,
                    PhotographyActivity.class);
            startActivity(intent);
        }else
        if(item_id == R.id.Exit){
            finish();
            moveTaskToBack(true);
        }
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }


}
