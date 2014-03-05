package com.example.tarea_3.app;

import java.util.LinkedList;

/**
 * Created by kuku on 4/03/14.
 */
public class comments {

    LinkedList<String> comment = new LinkedList<String>();

    public comments ( LinkedList<String> comment ) {
        this.comment = comment;
    }


    public comments ( String comment ) {
        this.comment.add(comment);
    }


}
