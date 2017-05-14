package com.arieftb.percobaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

    ListView lvPlayer;

    private String[] listPlayer = new String[] {
            "Mignolet","Moreno","Milner","Mane","Coutinho"
    };

    private String[] listPosisi = new String[] {
            "Kiper","Bek","Gelandang","Sayap","Penyerang"
    };

    private int[] listGambar = new int[] {
            R.drawable.lfclogo,R.drawable.lfclogo,R.drawable.lfclogo,R.drawable.lfclogo,
            R.drawable.lfclogo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        getSupportActionBar().setTitle("Player");

        lvPlayer = (ListView) findViewById(R.id.lv_player);


        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,listPlayer);

        lvPlayer.setAdapter(mAdapter);

        lvPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Click " + listPlayer[position],
                        Toast.LENGTH_SHORT).show();

                Bundle mBundle = new Bundle();
                mBundle.putString("lNama",listPlayer[position]);
                mBundle.putString("lPosisi", listPosisi[position]);
                mBundle.putInt("lGambar", listGambar[position]);

                Intent mIntent = new Intent(getApplicationContext(),DetailPlayerActivity.class);
                mIntent.putExtras(mBundle);

                startActivity(mIntent);
            }
        });
    }
}
