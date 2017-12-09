package com.example.hassan.know_your_train.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hassan.know_your_train.R;
import com.example.hassan.know_your_train.model.Train;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hassan on 12/9/17.
 */

public class TrainResultAdapter extends RecyclerView.Adapter<TrainResultAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mInflater;
    //private final Train mLock = (Train ::create);

    private List<Train> mObjects;

    public TrainResultAdapter(Context context, List<Train> objects) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjects = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_result, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Train train = mObjects.get(position);
        holder.trainName.setText(train.trainNumber() + " " + train.trainType());
        holder.trainStartTime.setText("٨:٥٠");
        holder.trainStart.setText(train.trainStartTrip());
        holder.trainEndTime.setText("٩:٥٠");
        holder.trainEnd.setText(train.trainEndTrip());
        holder.trainTime.setText(train.trainElapsedTime());

    }

    @Override
    public long getItemId(int i) {
        return mObjects.get(i).id();
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.trainName)
        TextView trainName;
        @BindView(R.id.startStationTime)
        TextView trainStartTime;
        @BindView(R.id.startStationName)
        TextView trainStart;
        @BindView(R.id.arrivalStationTime)
        TextView trainEndTime;
        @BindView(R.id.arrivalStationName)
        TextView trainEnd;
        @BindView(R.id.tripTime)
        TextView trainTime;

        public ViewHolder(View view) {

            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
