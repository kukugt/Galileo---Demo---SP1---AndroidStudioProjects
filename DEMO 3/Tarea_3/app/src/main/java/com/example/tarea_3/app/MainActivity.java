package com.example.tarea_3.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {


            View rootView = null;
            switch (   getArguments().getInt(ARG_SECTION_NUMBER)   ) {
                case 1: // STORE
                    rootView = inflater.inflate(R.layout.fragment_store, container, false);

                    this.Store(rootView);

                    break;
                case 2: // Photo
                    rootView = inflater.inflate(R.layout.fragment_photo, container, false);
                    break;
                case 3: // Credits
                    rootView = inflater.inflate(R.layout.fragment_credits, container, false);
                    break;
            }

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }






        ListView lista;
        ArrayAdapter<String> adaptador;
        Intent intent = null;

        listDetails datos;
        List<listDetails> detalles = new ArrayList<listDetails>();
        ArrayList<String> stores;


        public void Store(View v){

            datos = new listDetails("Tienda Tigo","3ra. Calle Guatemala", "12345678", "Lunea a viernes: 8AM - 8PM", "http://tigo.com", "info@tigo.com", new comments("Hola Mundo"), 4, new geolocation(1.0,4.0) );
            detalles.add(datos);

            datos = new listDetails("Tienda Zapatos","3ra. Calle Guatemala", "12345678", "Lunea a viernes: 8AM - 8PM", "http://tigo.com", "info@tigo.com", new comments("Hola Mundo"), 4, new geolocation(1.0,4.0) );
            detalles.add(datos);

            datos = new listDetails("Tienda Fruta","3ra. Calle Guatemala", "12345678", "Lunea a viernes: 8AM - 8PM", "http://tigo.com", "info@tigo.com", new comments("Hola Mundo"), 4, new geolocation(1.0,4.0) );
            detalles.add(datos);




            Iterator<listDetails> i = detalles.iterator();
            while( i.hasNext() ) stores.add( (i.next()).nombre );

            lista = (ListView) v.findViewById(R.id.list_stores);
            adaptador = new ArrayAdapter<String>( v.getContext() ,android.R.layout.simple_list_item_1,  stores   );

            lista.setAdapter(adaptador);
            lista.setTextFilterEnabled(true);
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                    intent = new Intent( v.getContext() , DetailsActivity.class);
                    intent.putExtra("pos", (int)position);
                    intent.putStringArrayListExtra("data", detalles.get(position).getArrayListDatos() );
                    intent.putStringArrayListExtra("comment", detalles.get(position).getArrayListComment() );
                    intent.putStringArrayListExtra("geo", detalles.get(position).getArrayListGeo() );


                    startActivity(intent);
                }
            });
        }







































    }

}
