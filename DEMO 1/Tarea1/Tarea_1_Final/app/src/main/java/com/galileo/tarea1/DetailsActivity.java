package com.galileo.tarea1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends Activity {

    Button llamar;
    Intent llamar_activity;
    String tel_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details);

        Intent intent = getIntent();

        String name_text = intent.getStringExtra("nombre");
        String dir_text = intent.getStringExtra("direccion");
        tel_text = intent.getStringExtra("telefono");
        String shedule_text = intent.getStringExtra("horario");
        String website_text = intent.getStringExtra("website");
        String email_text = intent.getStringExtra("email");


        TextView nombre = (TextView)findViewById(R.id.txtName);
        TextView direccion = (TextView)findViewById(R.id.txt_address);
        TextView telefono = (TextView)findViewById(R.id.txt_phone);
        TextView horario = (TextView)findViewById(R.id.txtDate);
        TextView website = (TextView)findViewById(R.id.txtSite);
        TextView email = (TextView)findViewById(R.id.txtEmail);


        nombre.setText(name_text);
        direccion.setText(dir_text);
        Linkify.addLinks(direccion, Linkify.ALL);
        telefono.setText(tel_text);
        Linkify.addLinks(telefono, Linkify.ALL);
        horario.setText(shedule_text);
        Linkify.addLinks(horario, Linkify.ALL);
        website.setText(website_text);
        Linkify.addLinks(website, Linkify.ALL);
        email.setText(email_text);
        Linkify.addLinks(email, Linkify.ALL);
        llamar = (Button)findViewById(R.id.btnCall);
        ButtonListener listener = new ButtonListener();
        llamar.setOnClickListener(listener);






        if (savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction()
              //      .add(R.id.container, new PlaceholderFragment())
                //    .commit();
        }
    }

    class ButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId() == llamar.getId()){
                llamar_activity = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + tel_text));
                startActivity(llamar_activity);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_details, container, false);
            return rootView;
        }
    }

}
