package pl.koksy.lr.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-15.
 */
public class Letter {

    private ArrayList<Double> features;
    private String label;

    public Letter(ArrayList<Double> features) {
        this.features = features;
    }

    public Letter(String label, ArrayList<Double> features) {
        this.label = label;
        this.features = features;
    }

    public void setFeatures(ArrayList<Double> features) {
        this.features = features;
    }

    public ArrayList<Double> getFeatures() {
        return features;
    }

    public String getLabel() {
        return label;
    }
}
