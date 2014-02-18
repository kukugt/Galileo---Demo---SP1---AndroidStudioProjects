package com.galileo.tarea1;

/**
 * Created by kuku on 11/02/14.
 */
public class listDetails {
    String direccion;
    String telefono;
    String horario;
    String website;
    String email;

    public listDetails(String dir,String tel,String schedule, String web_site, String e_mail){
        direccion = dir;
        telefono = tel;
        horario = schedule;
        website = web_site;
        email = e_mail;
    }

    public String getdireccion(){
        return direccion;
    }

    public String gettelefono(){
        return telefono;
    }

    public String gethorario(){
        return horario;
    }

    public String getwebsite(){
        return website;
    }

    public String getemail(){
        return email;
    }
}
