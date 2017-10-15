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
    private BufferedImage image;

    public Letter(BufferedImage image) {
        this.image = image;
    }

    public Letter(String label, BufferedImage image) {
        this.label = label;
        this.image = image;
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

    public BufferedImage getImage() {
        return image;
    }
}
