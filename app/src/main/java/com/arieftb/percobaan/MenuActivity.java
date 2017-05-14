package com.arieftb.percobaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView tvSambutan;
    LinearLayout llMenuSchedule, llMenuPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("Menu");

        tvSambutan = (TextView) findViewById(R.id.tv_sambutan);
        llMenuPlayer = (LinearLayout) findViewById(R.id.ll_menuPlayer);
        llMenuSchedule = (LinearLayout) findViewById(R.id.ll_menuSchedule);

        Bundle mBundle = getIntent().getExtras();
        tvSambutan.setText("Selamat Datang "+ mBundle.getString("Uname"));

        llMenuSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Click Menu Schedule",
                        Toast.LENGTH_SHORT).show();

                Intent mIntent = new Intent(getApplicationContext(),
                        ScheduleActivity.class);
                startActivity(mIntent);
            }
        });

        llMenuPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Click Menu Player",
                        Toast.LENGTH_SHORT).show();

                Intent mIntent = new Intent(getApplicationContext(),
                        PlayerActivity.class);

                startActivity(mIntent);
            }
        });
    }
}
