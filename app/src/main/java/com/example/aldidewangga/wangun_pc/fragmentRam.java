package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentRam extends AppCompatActivity {

    // A view for our list view
    private ListView mListView;

    // The method that is called when a list view element is clicked on

    private void passNameToShowResult( String ram  ) {
        // build a new Intent
        Intent intent = new Intent(getApplicationContext(), BuatRencana.class);

        // Put the name variable into the intent
        intent.putExtra( "ram", ram );

        // start the second activity
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_ram);

        // obtain resource id of list view
        mListView = (ListView) findViewById(R.id.nameListView);

        // An arraylist to hold our names
        final ArrayList<String> names = new ArrayList<>();

        // Add in 4 names as instructed.

        names.add("Kingston ValueRAM|DDR3-1333|Rp.300000");
        names.add("Kingston|DDR3-1333|Rp.400000");
        names.add("G.Skill Value Series|DDR3-1333|Rp.10000000");
        names.add("G.Skill Ripjaws X Series|DDR3-1333|Rp.400000");
        names.add("G.Skill Ripjaws X Series|DDR3-1333|Rp.450000");
        names.add("Kingston|DDR4-2666|Rp.500000");
        names.add("G.Skill Aegis|DDR4-2666|Rp.650000");
        names.add("Corsair Vengeance LPX|DDR4-2666|Rp.350000");
        names.add("Crucial Ballistix Sport LT|DDR4-2666|Rp.650000");
        names.add("Kingston FURY|DDR4-2666|Rp.340000");



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

