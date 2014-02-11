package com.galileo.tarea1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/**
 * Created by kuku on 6/02/14.
 */
public class Photography extends Activity {
	
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photography, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int item_id = item.getItemId();
		if(item_id == R.id.Acerca_de){
			Toast.makeText(this, "Yorch Chaclán - 11002633",
	                 Toast.LENGTH_SHORT).show();
		}
		if(item_id == R.id.Listado){
			intent = new Intent(this,
					MainActivity.class);
			 startActivity(intent);
		}else
		if(item_id == R.id.Fotografia){
			intent = new Intent(this,
					Photography.class);
			 startActivity(intent);
		}else
		if(item_id == R.id.Salir){
			finish();	
			moveTaskToBack(true);
		}
		return true;
	}
}
