package com.example.aldidewangga.wangun_pc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuatRencana extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2, tonCPU, tonMobo, tonFan, tonRam, tonHardisk, tonSsd, tonCd, tonVga, tonPsu, tonCasing;
    private TextView textCPU, textMobo, textFan, textRam, textHardisk, textSsd, textCd, textVga, textPsu, textCasing;
    EditText textNama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_rencana);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        dbHelper = new DataHelper(this);

        textNama = (EditText) findViewById(R.id.editNama);
        textCPU = (TextView) findViewById(R.id.textCPU);
        textMobo = (TextView) findViewById(R.id.textMobo);
        textFan = (TextView) findViewById(R.id.textFan);
        textRam = (TextView) findViewById(R.id.textRam);
        textHardisk = (TextView) findViewById(R.id.textHardisk);
        textSsd = (TextView) findViewById(R.id.textSsd);
        textCd = (TextView) findViewById(R.id.textCd);
        textVga = (TextView) findViewById(R.id.textVga);
        textPsu = (TextView) findViewById(R.id.textPsu);
        textCasing = (TextView) findViewById(R.id.textCasing);
        ton1 = (Button) findViewById(R.id.tombol1);
        ton2 = (Button) findViewById(R.id.tombol2);
        tonCPU = (Button) findViewById(R.id.tombolCPU);
        tonMobo = (Button) findViewById(R.id.tombolMobo);
        tonFan = (Button) findViewById(R.id.tombolFan);
        tonRam = (Button) findViewById(R.id.tombolRam);
        tonHardisk = (Button) findViewById(R.id.tombolHardisk);
        tonSsd = (Button) findViewById(R.id.tombolSsd);
        tonCd = (Button) findViewById(R.id.tombolCd);
        tonVga = (Button) findViewById(R.id.tombolVga);
        tonPsu = (Button) findViewById(R.id.tombolPsu);
        tonCasing = (Button) findViewById(R.id.tombolCasing);


        tonCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentCPU.class),888);
            }
        });
        tonMobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentMobo.class),999);
            }
        });
        tonFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentFan.class),777);
            }
        });
        tonRam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentRam.class),666);
            }
        });
        tonHardisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentHardisk.class),555);
            }
        });
        tonSsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentSsd.class),444);
            }
        });
        tonCd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentCd.class),333);
            }
        });
        tonVga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentVga.class),222);
            }
        });
        tonPsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentPsu.class),111);
            }
        });
        tonCasing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(),fragmentCasing.class),000);
            }
        });

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into komputer(nama, processor, motherboard, kipas, ram, hardisk, ssd, cd, vga, psu, casing) values('" +
                        textNama.getText().toString() + "','" +
                        textCPU.getText().toString() + "','" +
                        textMobo.getText().toString() + "','" +
                        textFan.getText().toString() + "','" +
                        textRam.getText().toString() + "','" +
                        textHardisk.getText().toString() + "','" +
                        textSsd.getText().toString() + "','" +
                        textCd.getText().toString() + "','" +
                        textVga.getText().toString() + "','" +
                        textPsu.getText().toString() + "','" +
                        textCasing.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Main2Activity.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 888 && resultCode == RESULT_OK){
            textCPU.setText(data.getStringExtra("cpu"));
        }
        if(requestCode == 999 && resultCode == RESULT_OK){
            textMobo.setText(data.getStringExtra("mobo"));
        }
        if(requestCode == 777 && resultCode == RESULT_OK){
            textFan.setText(data.getStringExtra("fan"));
        }
        if(requestCode == 666 && resultCode == RESULT_OK){
            textRam.setText(data.getStringExtra("ram"));
        }
        if(requestCode == 555 && resultCode == RESULT_OK){
            textHardisk.setText(data.getStringExtra("hardisk"));
        }
        if(requestCode == 444 && resultCode == RESULT_OK){
            textSsd.setText(data.getStringExtra("ssd"));
        }
        if(requestCode == 333 && resultCode == RESULT_OK){
            textCd.setText(data.getStringExtra("cd"));
        }
        if(requestCode == 222 && resultCode == RESULT_OK){
            textVga.setText(data.getStringExtra("vga"));
        }
        if(requestCode == 111 && resultCode == RESULT_OK){
            textPsu.setText(data.getStringExtra("psu"));
        }
        if(requestCode == 000 && resultCode == RESULT_OK){
            textCasing.setText(data.getStringExtra("casing"));
        }
    }

}
