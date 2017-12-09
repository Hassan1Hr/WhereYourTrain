package com.example.hassan.know_your_train.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.design.widget.TextInputLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hassan.know_your_train.R;
import com.example.hassan.know_your_train.custom_views.InstantAutoCompleteTextView;
import com.example.hassan.know_your_train.database.Db;
import com.example.hassan.know_your_train.model.Station;

import java.util.ArrayList;
import java.util.List;
import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fromTextView)
    TextView mFromTextView;
    @BindView(R.id.toTextView) TextView mToTextView;
    @BindView(R.id.toggleStations)
    ImageView mToggleStations;
    @BindView(R.id.goButton)
    Button mGoButton;
    @BindView(R.id.arrivalAutocomplete) InstantAutoCompleteTextView mStartAutocomplete;
    @BindView(R.id.startAutocomplete)
    InstantAutoCompleteTextView mArrivalAutocomplete;
    @BindView(R.id.from_input_layout) TextInputLayout mFromInputLayout;
    @BindView(R.id.to_input_layout) TextInputLayout mToInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeData();

    }

    private void initializeData() {


        ArrayList<Station> stations = Db.getStations(this);

        List<String> stationNames = StreamSupport.stream(stations)
                .map(Station::stationArabic)
                .collect(Collectors.toList());

        mStartAutocomplete.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, stationNames));
        mArrivalAutocomplete.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, stationNames));

        mGoButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),ResultActivty.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        });
    }
}
