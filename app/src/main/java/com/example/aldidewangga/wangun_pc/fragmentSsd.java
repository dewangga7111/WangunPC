package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentSsd extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String ssd  ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), BuatRencana.class);

        // Put the name variable into the intent
        intent.putExtra( "ssd", ssd );

        // start the second activity
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_ssd);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.
        names.add("ADATA - XPG SX850 128 GB |Rp.1500000");
        names.add("ADATA - XPG SX850 512 GB |Rp.4000000");
        names.add("ADATA - XPG SX850 256 GB |Rp.3000000");
        names.add("Intel - SSD DC S3500 Series 800 GB |Rp.10000000");
        names.add("Intel - 530 Series 480 GB |Rp.5000000");
        names.add("Intel - Pro 2500 120 GB |Rp.2000000");
        names.add("Intel - SSD DC S3500 Series 800 GB |Rp.12000000");
        names.add("Intel - 520 Series Cherryville 60 GB |Rp.800000");
        names.add("Intel - 520 Series Cherryville 120 GB |Rp.1300000");
        names.add("Intel - 520 Series Cherryville 180 GB |Rp.2000000");
        names.add("Intel - 320 Series 40 GB |Rp.1300000");

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

