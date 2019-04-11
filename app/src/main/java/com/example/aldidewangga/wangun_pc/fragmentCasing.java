package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentCasing extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String casing ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), BuatRencana.class);

        // Put the name variable into the intent
        intent.putExtra( "casing", casing );

        // start the second activity
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_casing);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.
        names.add("NZXT H500 (Black)|Rp.1000000");
        names.add("NZXT H500 (White)|Rp.1100000");
        names.add("Cooler Master MasterBox Q300L|Rp.800000");
        names.add("Deepcool TESSERACT SW|Rp.300000");
        names.add("Corsair 200R|Rp.720000");
        names.add("Cooler Master MasterBox Pro 5 RGB|Rp.450000");
        names.add("Fractal Design Meshify C Dark TG|Rp.360000");
        names.add("Phanteks Eclipse P300 Tempered Glass (Black)|Rp.960000");
        names.add("Corsair Crystal 570X RGB|Rp.1000000");
        names.add("Fractal Design Focus G (Black)|Rp.400000");

        // create a new array adapter for the list
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);

        // set the adapter to use for this view
        mListView.setAdapter(adapter);

        // set up the code to respond to what we have clicked
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                         {
                                             // We fill out the method provided by the setOnItemClickListener interface
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 // Obtain the value of the item we clicked on via it's index
                                                 String value = (String) adapter.getItem(position);

                                                 // Send this to the log so we can see it
                                                 //Log.i("value", value);

                                                 // pass this on so we can send it to another activity
                                                 passNameToShowResult( value );
                                             }
                                         }
        );
    }
}
