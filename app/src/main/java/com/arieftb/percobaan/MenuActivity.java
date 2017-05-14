package com.arieftb.percobaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView tvSambutan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvSambutan = (TextView) findViewById(R.id.tv_sambutan);

        Bundle mBundle = getIntent().getExtras();
        tvSambutan.setText("Selamat Datang "+ mBundle.getString("Uname"));
    }
}
