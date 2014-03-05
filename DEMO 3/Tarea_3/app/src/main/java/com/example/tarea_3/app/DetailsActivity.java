package com.example.tarea_3.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends Activity {

    Integer position;
    ArrayList<String> comment;
    ArrayList<String> data;
    ArrayList<String> geo;

    String nombre;
    String direccion;
    String telefono;
    String horarios;
    String website;
    String email;

    String favoritos;

    String comentarios;
    String ubicacion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.createStore();
        this.changeTextView();
        this.call();

    }

    public void call(){
        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(  Uri.parse("tel:"+telefono)   );
                startActivity(intent);

            }
        });
    }
    public void createStore(){


    }



    public void changeTextView(){
        Intent intent = getIntent();

        position = intent.getIntExtra("pos",1);
        data = intent.getStringArrayListExtra("data");
        comment = intent.getStringArrayListExtra("comment");
        geo = intent.getStringArrayListExtra("geo");



        nombre = data.get(0);
        direccion = data.get(1);
        telefono = data.get(2);
        horarios = data.get(3);
        website = data.get(4);
        email = data.get(5);
        favoritos = data.get(6);

        for(Integer i=0; i<comment.size(); i++) comentarios += comment.get(i)+"\n\n";
        ubicacion = "latitud:"+geo.get(0)+"\n longitud:"+geo.get(1);


        ((TextView)findViewById(R.id.txtNombre)).setText(nombre);
        Linkify.addLinks(((TextView)findViewById(R.id.txtNombre)), Linkify.ALL);

        ((TextView)findViewById(R.id.txtDireccion)).setText(direccion);
        Linkify.addLinks(((TextView)findViewById(R.id.txtDireccion)), Linkify.ALL);

        ((TextView)findViewById(R.id.txtTelefono)).setText(telefono);
        Linkify.addLinks(((TextView)findViewById(R.id.txtTelefono)), Linkify.ALL);

        ((TextView)findViewById(R.id.txtHorarios)).setText(horarios);
        Linkify.addLinks(((TextView)findViewById(R.id.txtHorarios)), Linkify.ALL);

        ((TextView)findViewById(R.id.txtWebsite)).setText(website);
        Linkify.addLinks(((TextView)findViewById(R.id.txtWebsite)), Linkify.ALL);

        ((TextView)findViewById(R.id.txtEmail)).setText(email);
        Linkify.addLinks(((TextView)findViewById(R.id.txtEmail)), Linkify.ALL);

        ((TextView)findViewById(R.id.txtFavoritos)).setText(favoritos);
        Linkify.addLinks(((TextView)findViewById(R.id.txtFavoritos)), Linkify.ALL);


        ((TextView)findViewById(R.id.txtUbicacion)).setText(ubicacion);
        Linkify.addLinks(((TextView)findViewById(R.id.txtUbicacion)), Linkify.ALL);

        ((TextView)findViewById(R.id.txtComentarios)).setText(comentarios);
        Linkify.addLinks(((TextView)findViewById(R.id.txtComentarios)), Linkify.ALL);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details, menu);
        return true;
    }

}
