package com.arieftb.percobaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import com.arieftb.percobaan.ScheduleAdapter;
import com.arieftb.percobaan.ScheduleModel;

public class ScheduleActivity extends AppCompatActivity {

    String[][] mData1 = new String[][] {
            {
                    "Liverpool Vs West Ham","Anfield","14-Mei-2017 20.00"
            },
            {
                    "Liverpool Vs West Ham1","Anfield1","14-Mei-2017 20.00"
            },
            {
                    "Liverpool Vs West Ham2","Anfield2","14-Mei-2017 20.00"
            },
            {
                    "Liverpool Vs West Ham3","Anfield3","14-Mei-2017 20.00"
            },
            {
                    "Liverpool Vs West Ham4","Anfield4","14-Mei-2017 20.00"
            }
    } ;

    int[][] mData2 = new int[][]{
            {
                    R.drawable.lfclogo, 150000
            },
            {
                    R.drawable.lfclogo, 150000
            },
            {
                    R.drawable.lfclogo, 150000
            },
            {
                    R.drawable.lfclogo, 150000
            },
            {
                    R.drawable.lfclogo, 150000
            }
    };

    private     ListView lvSchedule;
    private ArrayList listSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        lvSchedule = (ListView) findViewById(R.id.lv_schedule);
        listSchedule = new ArrayList<>();

        ScheduleModel mScheduleModel = null;

        for (int i = 0; i < mData1.length;i++){

            mScheduleModel = new ScheduleModel();

            mScheduleModel.setJudul(mData1[i][0]);
            mScheduleModel.setLokasi(mData1[i][1]);
            mScheduleModel.setWaktu(mData1[i][2]);
            mScheduleModel.setGambar(mData2[i][0]);
            mScheduleModel.setHarga(mData2[i][1]);

            listSchedule.add(mScheduleModel);
        }

        final ScheduleAdapter mScheduleAdapter = new ScheduleAdapter(ScheduleActivity.this,
                listSchedule);
        lvSchedule.setAdapter(mScheduleAdapter);

        lvSchedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"Clicked " + mData1[position][0], Toast.LENGTH_SHORT ).show();

                Bundle mBundle = new Bundle();
                mBundle.putString("judul", mData1[position][0]);
                mBundle.putString("lokasi", mData1[position][1]);
                mBundle.putString("waktu", mData1[position][2]);
                mBundle.putInt("gambar", mData2 [position][0]);
                mBundle.putInt("harga", mData2[position][1]);
                Intent mIntent = new Intent(getApplicationContext(),DetailScheduleActivity.class);
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });
    }
}
