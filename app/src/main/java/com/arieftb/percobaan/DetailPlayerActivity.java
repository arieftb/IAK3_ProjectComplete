package com.arieftb.percobaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPlayerActivity extends AppCompatActivity {

    ImageView ivGambarPlayer;
    TextView tvNamaPlayer, tvPosisiPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_player);


        ivGambarPlayer = (ImageView) findViewById(R.id.iv_gambarPlayer);
        tvNamaPlayer = (TextView) findViewById(R.id.tv_namaPlayer);
        tvPosisiPlayer = (TextView) findViewById(R.id.tv_posisiPlayer);

        Bundle mBundle = getIntent().getExtras();

        ivGambarPlayer.setImageResource(mBundle.getInt("lGambar"));
        tvNamaPlayer.setText(mBundle.getString("lNama"));
        tvPosisiPlayer.setText(mBundle.getString("lPosisi"));

    }
}
