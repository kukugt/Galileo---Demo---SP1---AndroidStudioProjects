package com.demo.a1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    Button btnSearch;
    Button btnOpenActivity;
    public static final String TAG = MainActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnOpenActivity = (Button) findViewById(R.id.btnOpenActivity);

        ButtonListener listener = new ButtonListener();
        btnSearch.setOnClickListener(listener);
        btnOpenActivity.setOnClickListener(listener);






        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText searchQuery = (EditText)findViewById(R.id.editTextSearchQuery);
            String searchQueryText = searchQuery.getText().toString();
            String url = "https://www.google.com/?q=" + searchQueryText + "#q=" + searchQueryText;
            Intent intent = null;
            if ( view.getId() == btnOpenActivity.getId()) {
                intent = new Intent(getApplicationContext(), ShowSearchQueryActivity.class );
                intent.putExtra(ShowSearchQueryActivity.QUERY,searchQueryText);
            } else if ( view.getId() == btnSearch.getId()) {

                intent = new Intent(Intent.ACTION_VIEW);
                getIntent().setData(Uri.parse(url));
            }

            startActivity(intent);
        }
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
