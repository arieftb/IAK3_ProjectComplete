package com.arieftb.percobaan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.arieftb.percobaan.R;
import com.arieftb.percobaan.ScheduleActivity;
import com.arieftb.percobaan.ScheduleModel;

/**
 * Created by root on 14/05/17.
 */

public class ScheduleAdapter extends BaseAdapter {

    ArrayList listSchedule;
    Activity activity;

    public ScheduleAdapter(Activity activity, ArrayList listSchedule){
        this.listSchedule = listSchedule;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listSchedule.size();
    }

    @Override
    public Object getItem(int position) {
        return listSchedule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;
        ViewHolder mViewHolder = null;

        if (mView == null){
            mViewHolder = new ViewHolder();

            LayoutInflater mInflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            mView = mInflater.inflate(R.layout.list_schedule, null);
            mViewHolder.ivGambarSchedule = (ImageView)
                    mView.findViewById(R.id.iv_gambarSchedule);
            mViewHolder.tvJudulSchedule = (TextView)
                    mView.findViewById(R.id.tv_judulSchedule);
            mViewHolder.tvWaktuSchedule = (TextView)
                    mView.findViewById(R.id.tv_waktuSchedule);

            mView.setTag(mViewHolder);
        }
        else {
            mViewHolder = (ViewHolder) mView.getTag();
        }

        ScheduleModel mScheduleModel = (ScheduleModel) getItem(position);
        mViewHolder.ivGambarSchedule.setImageResource(mScheduleModel.getGambar());
        mViewHolder.tvJudulSchedule.setText(mScheduleModel.getJudul());
        mViewHolder.tvWaktuSchedule.setText(mScheduleModel.getWaktu());

        return mView;
    }

    static class ViewHolder{
        ImageView ivGambarSchedule;
        TextView tvJudulSchedule, tvWaktuSchedule;
    }
}
