package pl.koksy.lr.writer;

import pl.koksy.lr.util.Constants;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
        try {
            FileOutputStream fout = new FileOutputStream(Constants.WEIGHTS_FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(weights);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
