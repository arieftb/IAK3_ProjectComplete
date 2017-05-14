package com.arieftb.percobaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailScheduleActivity extends AppCompatActivity {

    TextView tvDetailJudulSchedule, tvDetailLokasiSchedule, tvDetailWaktuSchedule
            , tvDetailHargaSchedule, tvJumlahTicketSchedule, tvTotalHargaSchedule;
    ImageView ivDetailGambarSchedule;
    Button btnIncraseTicket, btnDecraseTicket, btnOrderTicket;

    private int tampungJumlah, tampungHarga, totalHarga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedule);

        tvDetailJudulSchedule = (TextView) findViewById(R.id.tv_detailJudulSchedule);
        tvDetailLokasiSchedule = (TextView) findViewById(R.id.tv_detailLokasiSchedule);
        tvDetailWaktuSchedule = (TextView) findViewById(R.id.tv_detailWaktuSchedule);
        tvDetailHargaSchedule = (TextView) findViewById(R.id.tv_detailHargaSchedule);
        tvJumlahTicketSchedule = (TextView) findViewById(R.id.tv_jumlahTicketSchedule);
        tvTotalHargaSchedule = (TextView) findViewById(R.id.tv_totalHargaSchedule);
        ivDetailGambarSchedule = (ImageView) findViewById(R.id.iv_detailGambarSchedule);
        btnIncraseTicket = (Button) findViewById(R.id.btn_incraseTicketSchedule);
        btnDecraseTicket = (Button) findViewById(R.id.btn_decreaseTicketSchedule);
        btnOrderTicket = (Button) findViewById(R.id.btn_orderTicketSchedule);


        Bundle mBundle = getIntent().getExtras();

        tampungJumlah = 1;
        tampungHarga = mBundle.getInt("harga");

        tvDetailJudulSchedule.setText(mBundle.getString("judul"));
        tvDetailLokasiSchedule.setText(mBundle.getString("lokasi"));
        tvDetailWaktuSchedule.setText(mBundle.getString("waktu"));
        ivDetailGambarSchedule.setImageResource(mBundle.getInt("gambar"));

        tvDetailHargaSchedule.setText(String.valueOf(tampungHarga));
        tvJumlahTicketSchedule.setText(String.valueOf(tampungJumlah));
        tvTotalHargaSchedule.setText(String.valueOf(tampungHarga));


        btnIncraseTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampungJumlah = tampungJumlah + 1;
                tampungHarga = tampungHarga * tampungJumlah;

                tvJumlahTicketSchedule.setText(String.valueOf(tampungJumlah));
                tvTotalHargaSchedule.setText(String.valueOf(tampungHarga));
            }
        });

        btnDecraseTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampungJumlah = tampungJumlah - 1;
                tampungHarga = tampungHarga * tampungJumlah;

                if (tampungJumlah <= 1){
                    tampungJumlah = 1;
                }

                tvJumlahTicketSchedule.setText(String.valueOf(tampungJumlah));
                tvTotalHargaSchedule.setText(String.valueOf(tampungHarga));
            }
        });


        btnOrderTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Order Ticket Sebanyak " +
                        tampungJumlah + " Harga " + tampungHarga,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
