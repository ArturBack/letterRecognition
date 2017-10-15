package pl.koksy.lr.writer;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-15.
 */
public class WeigthsWriter {

    private static WeigthsWriter instance;

    public static WeigthsWriter getInstance() {
        if(instance == null) {
            instance = new WeigthsWriter();
        }
        return instance;
    }

    public void write(ArrayList<Double> weights) {

    }
}
