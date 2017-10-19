package pl.koksy.lr.provider;

import pl.koksy.lr.model.Letter;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-15.
 */
public class TrainDataProvider {

    private static TrainDataProvider instance;

    public static TrainDataProvider getInstance() {
        if(instance == null) {
            instance = new TrainDataProvider();
        }
        return instance;
    }

    public ArrayList<Letter> provide() {
        ArrayList<Letter> trainData = new ArrayList<>();


        return null;
    }
}
