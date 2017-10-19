package pl.koksy.lr.provider;

import pl.koksy.lr.model.Letter;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-15.
 */
public class TrainDataProvider {

    private static TrainDataProvider instance;

    private BigLettersProvider bigLettersProvider;
    private SmallLettersProvider smallLettersProvider;
    private DigitsProvider digitsProvider;

    private TrainDataProvider() {
        this.bigLettersProvider = BigLettersProvider.getInstance();
        this.smallLettersProvider = SmallLettersProvider.getInstance();
        this.digitsProvider = DigitsProvider.getInstance();
    }

    public static TrainDataProvider getInstance() {
        if(instance == null) {
            instance = new TrainDataProvider();
        }
        return instance;
    }

    public ArrayList<Letter> provideTrainData() {
        ArrayList<Letter> trainData = new ArrayList<>();

        trainData.addAll(bigLettersProvider.provide());
        trainData.addAll(smallLettersProvider.provide());
        trainData.addAll(digitsProvider.provide());

        return trainData;
    }
}
