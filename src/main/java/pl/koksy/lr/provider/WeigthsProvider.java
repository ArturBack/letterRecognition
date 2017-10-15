package pl.koksy.lr.provider;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-15.
 */
public class WeigthsProvider {

    private static WeigthsProvider instance;

    public static WeigthsProvider getInstance() {
        if(instance == null) {
            instance = new WeigthsProvider();
        }
        return instance;
    }

    public ArrayList<Double> provide() {
        return null;
    }
}
