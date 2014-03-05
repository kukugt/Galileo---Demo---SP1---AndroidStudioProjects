package com.example.tarea_3.app;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by kuku on 11/02/14.
 */
public class listDetails {

    String nombre;
    String direccion;
    String telefono;
    String horarios;
    String website;
    String email;
    comments comentarios;
    Integer favoritos;
    geolocation ubicacion;

    public listDetails (
            String nombre,
            String direccion,
            String telefono,
            String horarios,
            String website,
            String email,
            comments comentarios,
            Integer favoritos,
            geolocation ubicacion){

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horarios = horarios;
        this.website = website;
        this.email = email;
        this.comentarios = comentarios;
        this.favoritos = favoritos;
        this.ubicacion = ubicacion;
    }

    public ArrayList<String> getArrayListDatos (){
        ArrayList<String> a = new ArrayList<String>();

        a.add(this.nombre);
        a.add(this.direccion);
        a.add(this.telefono);
        a.add(this.horarios);
        a.add(this.website);
        a.add(this.nombre);
        a.add(this.email);
        a.add(this.favoritos.toString());

        return a;
    }

    public ArrayList<String> getArrayListComment(){
        ArrayList<String> a = new ArrayList<String>();
        for(Integer i=0; i< this.comentarios.comment.size(); i++ ){
            a.add(this.comentarios.comment.get(i)  );
        }
        return a;
    }

    public ArrayList<String> getArrayListGeo(){
        ArrayList<String> a = new ArrayList<String>();
        a.add( this.ubicacion.latitud.toString() );
        a.add( this.ubicacion.longitud.toString() );
        return a;
    }


    public String toString(){
        return nombre;
    }


}
