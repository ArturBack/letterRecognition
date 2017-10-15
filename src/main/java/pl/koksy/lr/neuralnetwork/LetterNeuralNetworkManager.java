package pl.koksy.lr.neuralnetwork;

import pl.koksy.lr.model.Letter;

import java.awt.image.BufferedImage;

/**
 * Created by Artur on 2017-10-15.
 */
public class LetterNeuralNetworkManager {

    private LetterNeuralNetwork network;

    public LetterNeuralNetworkManager() {
        this.network = new LetterNeuralNetwork();
    }

    public String getLabelForLetter(BufferedImage image) {
        return network.getLabel(new Letter(image));
    }
}
