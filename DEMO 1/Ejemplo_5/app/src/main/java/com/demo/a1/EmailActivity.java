package com.demo.a1;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.app.ListActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by kuku on 26/01/14.
 */
public class EmailActivity extends ListActivity implements View.OnClickListener {

    private final static String EMAIL = "";
    private final static String DATE_ADDED = "";
    private List<HashMap<String,String>> emails = new ArrayList<HashMap<String,String>>();

    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_email_list);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);

        SimpleAdapter adapter = new SimpleAdapter(this, emails, android.R.layout.simple_expandable_list_item_2, new String[]{EMAIL, DATE_ADDED}, new int[]{android.R.id.text1,android.R.id.text2} );

        setListAdapter(adapter);
    }

    public void onClick(View view){
        EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        String email = editTextEmail.getText().toString();
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Calendar.getInstance().getTime());
        HashMap<String,String> element = new HashMap<String,String>();


        element.put(EMAIL,email);
        element.put(DATE_ADDED,date);

        if ( !email.trim().equals("") ) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
                emails.add(element);
                SimpleAdapter adapter = (SimpleAdapter) getListAdapter();
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this,"Ocurrio un Error",Toast.LENGTH_SHORT);
            }
        }



    }
}
