package com.example.hassan.know_your_train.model;


import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by hassan on 12/8/17.
 */
@AutoValue
public abstract class Train implements Parcelable{

    public abstract String id();

    public abstract int trainNumber();

    public abstract String trainType();

    public abstract String trainStartTrip();

    public abstract String trainEndTrip();

    public abstract String trainElapsedTime();

    private   Station[] TrainStations;

    public static Train create(String id, int trainNumber, String trainType, String trainStartTrip, String trainEndTrip, String trainElapsedTime) {return new AutoValue_Train(id, trainNumber, trainType, trainStartTrip, trainEndTrip, trainElapsedTime);}


    public void setTrainStations(Station[] trainStations) {
        TrainStations = trainStations;
    }

    public Station[] getTrainStations() {
        return TrainStations;
    }
}
