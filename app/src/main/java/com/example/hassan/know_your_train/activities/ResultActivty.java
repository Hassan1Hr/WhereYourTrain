package com.example.hassan.know_your_train.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.hassan.know_your_train.R;
import com.example.hassan.know_your_train.adapter.TrainResultAdapter;
import com.example.hassan.know_your_train.model.Train;

import java.util.ArrayList;


public class ResultActivty extends AppCompatActivity {

    @BindView(R.id.resultRecyclerView)
    RecyclerView mRecyclerView;

    private TrainResultAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activty);
        ButterKnife.bind(this);
        ArrayList<Train> mTrain = new ArrayList<>();
        mTrain.add(Train.create(1234L,988,"مكيف","القاهرة","اسوان","١٤ ساعة"));
        mTrain.add(Train.create(23434L,2006,"VIP","اسيوط","اسوان","١٤ ساعة"));
        mTrain.add(Train.create(1534L,2007,"VIP","القاهرة","الاقصر","١٤ ساعة"));
        mTrain.add(Train.create(13434L,88,"مكيف","قنا","اسوان","١٤ ساعة"));
        mTrain.add(Train.create(6334L,2012,"VIP","القاهرة","الاقصر","١٤ ساعة"));
        mTrain.add(Train.create(59834L,988,"مكيف","القاهرة","الاقصر","١٥ ساعة"));
        mAdapter = new TrainResultAdapter(this,mTrain);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);




    }
}
