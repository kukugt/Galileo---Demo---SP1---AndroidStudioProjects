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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private ListActivity mClass;

    private List<String> tiendas = new ArrayList<String>();
    ArrayAdapter adapter;
    listData datos;
    Intent detalle;
    private List<listData> detalles = new ArrayList<listData>();

    //Implement each method you want to use.
    public String getInfoFromOtherClass()
    {
        return mClass.getInfoFromOtherClass();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClass = new ListActivity(this);
        setContentView(R.layout.activity_main);








        datos = new listData("Zona 10", "88888888", "Lunea a viernes: 1AM - 1PM", "www.tigo.com", "tigo@tigo.com");
        tiendas.add("Tienda Tigo");
        detalles.add(datos);
        datos = new listData("Zona 10", "88888888", "Lunea a viernes: 1AM - 1PM", "www.tigo.com", "tigo@tigo.com");
        tiendas.add("Tienda Tigo");
        detalles.add(datos);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tiendas);
        setListAdapter(adapter);
        ListView list = (ListView) findViewById(android.R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        Details.class);



                detalle.putExtra("nombre", nombre);
                detalle.putExtra("direccion", direccion);
                detalle.putExtra("telefono", telefono);
                detalle.putExtra("horario", horario);
                detalle.putExtra("website", website);
                detalle.putExtra("email", email);
                startActivity(detalle);
            }
        });
















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
                    Photography.class);
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
