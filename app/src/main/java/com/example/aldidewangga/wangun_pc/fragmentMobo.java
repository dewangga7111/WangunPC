package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentMobo extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String mobo  ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), BuatRencana.class);

        // Put the name variable into the intent
        intent.putExtra( "mobo", mobo );

        // start the second activity
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_mobo);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.

        names.add("Asus Prime Z370-A|LGA1151|Rp.5000000");
        names.add("MSI Z370-A PRO|LGA1151|Rp.4500000");
        names.add("Asus ROG STRIX Z390-E GAMING|LGA1151|Rp.4000000");
        names.add("MSI Z390-A PRO|LGA1151|Rp.4800000");
        names.add("Asus ROG MAXIMUS XI HERO (WI-FI)|LGA1151|Rp.5100000");
        names.add("MSI Z370 GAMING PLUS|LGA1151|Rp.4600000");
        names.add("Asus PRIME Z390-A|LGA1151|Rp.5500000");
        names.add("Gigabyte B360M DS3H|LGA1151|Rp.3000000");
        names.add("Gigabyte Z390 AORUS PRO WIFI|LGA1151|Rp.2030000");
        names.add("Asus ROG STRIX Z390-I GAMING|LGA1151|Rp.4400000");



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

