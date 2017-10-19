package pl.koksy.lr.provider;

import pl.koksy.lr.util.Constants;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
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
        ArrayList<Double> weights = readWeights();
        if(weights == null) {
            weights = new ArrayList<>();
        }
        return weights;
    }

    private ArrayList<Double> readWeights() {
        ArrayList<Double> weights = null;
        try {
            FileInputStream fin = new FileInputStream(Constants.WEIGHTS_FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fin);
            weights = (ArrayList<Double>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weights;
    }
}
