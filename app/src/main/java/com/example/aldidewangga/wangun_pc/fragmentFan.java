package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentFan extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String fan  ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), BuatRencana.class);

        // Put the name variable into the intent
        intent.putExtra( "fan", fan );

        // start the second activity
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_fan);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.

        names.add("Cooler Master Hyper 212 EVO|Rp.500000");
        names.add("Cooler Master MasterLiquid ML240L RGB|Rp.350000");
        names.add("NZXT Kraken X62 Rev 2|Rp.200000");
        names.add("Corsair H100i PRO|Rp.|Rp.300000");
        names.add("Corsair H60 (2018)|Rp.259000");
        names.add("Asus ROG RYUJIN 360|Rp.302000");
        names.add("Corsair H100i v2|Rp.400000");
        names.add("Corsair H150i PRO|Rp.102000");
        names.add("Noctua NH-D15|Rp.300000");
        names.add("Corsair H100i RGB PLATINUM|Rp.1250000");


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

