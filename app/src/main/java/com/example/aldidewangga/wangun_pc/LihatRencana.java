package com.example.aldidewangga.wangun_pc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LihatRencana extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    private TextView textNama, textCpu, textMobo, textFan, textRam, textHardisk, textSsd, textCd, textVga, textPsu, textCasing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_rencana);
        dbHelper = new DataHelper(this);
        textNama = (TextView) findViewById(R.id.nama_rencan);
        textCpu = (TextView) findViewById(R.id.pilihCpu);
        textMobo = (TextView) findViewById(R.id.pilihMobo);
        textFan = (TextView) findViewById(R.id.pilihFan);
        textRam = (TextView) findViewById(R.id.pilihRam);
        textHardisk = (TextView) findViewById(R.id.pilihHardisk);
        textSsd = (TextView) findViewById(R.id.pilihSsd);
        textCd = (TextView) findViewById(R.id.pilihCd);
        textVga = (TextView) findViewById(R.id.pilihVga);
        textPsu = (TextView) findViewById(R.id.pilihPsu);
        textCasing = (TextView) findViewById(R.id.pilihCasing);



        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM komputer WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            textNama.setText(cursor.getString(1).toString());
            textCpu.setText(cursor.getString(2).toString());
            textMobo.setText(cursor.getString(3).toString());
            textFan.setText(cursor.getString(4).toString());
            textRam.setText(cursor.getString(5).toString());
            textHardisk.setText(cursor.getString(6).toString());
            textSsd.setText(cursor.getString(7).toString());
            textCd.setText(cursor.getString(8).toString());
            textVga.setText(cursor.getString(9).toString());
            textPsu.setText(cursor.getString(10).toString());
            textCasing.setText(cursor.getString(11).toString());
        }
        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
