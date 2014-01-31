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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    Button btnSearch;
    Button btnOpenActivity;
    ScrollView inputControls;
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




        Button btnList = new Button(this);
        btnList.setText(getString(R.string.btn_list));
        btnList.setLayoutParams(new ViewGroup.LayoutParams(android.app.ActionBar.LayoutParams.MATCH_PARENT, android.app.ActionBar.LayoutParams.WRAP_CONTENT ));
        LinearLayout mainContent = (LinearLayout)findViewById(R.id.mainContent);

        inputControls = (ScrollView) View.inflate(this, R.layout.input_controls_content, null);

        mainContent.addView(btnList);

        setInputControls();

        mainContent.addView(inputControls);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void setInputControls(){
        SeekBar seekbar = (SeekBar)inputControls.findViewById(R.id.seekBar1);
        RatingBar ratingBar =(RatingBar) inputControls.findViewById(R.id.ratingBar);
        Spinner spinner = (Spinner)inputControls.findViewById(R.id.spinner);
        CheckBox checkbox = (CheckBox)inputControls.findViewById(R.id.checkBox);
        RadioGroup radioGroup = (RadioGroup)inputControls.findViewById(R.id.radioGroup);


        RadioGroup.OnCheckedChangeListener checkedChangeListener= new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String option = "";
                switch (i){
                    case R.id.radio1:
                        option = "A";
                    break;
                    case R.id.radio2:
                        option = "B";
                        break;
                    case R.id.radio3:
                        option = "C";
                        break;
                }
                Log.e(TAG, "Seleccionado " + option );
            }
        };





        checkbox.setChecked(true);


        ArrayList<String> names = new ArrayList<String>();
        names.add("Hugo");
        names.add("Paco");
        names.add("Luis");
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, names);
        spinner.setAdapter(namesAdapter);



        ratingBar.setRating((float)2.5);



        seekbar.setMax(10);
        seekbar.setProgress(5);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(),"Cambio a " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
