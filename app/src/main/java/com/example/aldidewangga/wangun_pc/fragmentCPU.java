package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentCPU extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String cpu  ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), BuatRencana.class);

        // Put the name variable into the intent
        intent.putExtra( "cpu", cpu );

        // start the second activity
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_cpu);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.

        names.add("Intel Core i7-8700K | 3.7 GHz|Rp.5750000");
        names.add("Intel Core i9-9900K | 3.6 GHz|Rp.7200000");
        names.add("Intel Core i5-9600K | 3.7 GHz|Rp.7000000");
        names.add("Intel Core i7-9700K | 3.6 GHz|Rp.7150000");
        names.add("Intel Core i5-8400  | 2.8 GHz|Rp.3000000");
        names.add("Intel Core i5-8600K | 3.6 GHz|Rp.3500000");
        names.add("Intel Core i3-8100  | 3.6 GHz|Rp.1800000");
        names.add("Intel Core i7-8700  | 3.2 GHz|Rp.8000000");
        names.add("Intel Core i7-6700K | 4 GHz|Rp.6500000");
        names.add("Intel Core i7-7700K | 4.2 GHz|Rp.6800000");

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
