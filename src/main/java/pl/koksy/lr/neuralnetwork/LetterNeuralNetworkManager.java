package pl.koksy.lr.neuralnetwork;

import pl.koksy.lr.model.Letter;
import pl.koksy.lr.provider.TrainDataProvider;
import pl.koksy.lr.provider.WeigthsProvider;

import java.awt.image.BufferedImage;

/**
 * Created by Artur on 2017-10-15.
 */
public class LetterNeuralNetworkManager {

    private LetterNeuralNetwork network;
    private TrainDataProvider trainDataProvider;
    private WeigthsProvider weigthsProvider;

    public LetterNeuralNetworkManager() {
        this.network = new LetterNeuralNetwork();
        this.trainDataProvider = TrainDataProvider.getInstance();
        this.weigthsProvider = WeigthsProvider.getInstance();
    }

    public String getLabelForLetter(BufferedImage image) {
        return network.getLabel(new Letter(image), weigthsProvider.provide());
    }
}
