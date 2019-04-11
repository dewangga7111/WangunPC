package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentHardisk extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String hardisk  ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), BuatRencana.class);

        // Put the name variable into the intent
        intent.putExtra( "hardisk", hardisk );

        // start the second activity
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_hardisk);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.

        names.add("Buffalo Technology|1 TB|Rp.800000");
        names.add("Apricom|2 TB|Rp.850000");
        names.add("Western Digital|500 GB|Rp.450000");
        names.add("Apricom|1 TB|Rp.840000");
        names.add("Buffalo Technology|500 GB|Rp.650000");
        names.add("Buslink|2 TB|Rp.1000000");
        names.add("Apricom|250 GB|Rp.300000");


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

