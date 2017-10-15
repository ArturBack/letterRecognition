package pl.koksy.lr.neuralnetwork;

import pl.koksy.lr.model.Letter;

/**
 * Created by Artur on 2017-10-15.
 */
public interface ILetterNeuralNetwork {

    String getLabel(Letter letter);

    void train(Letter letter);

}
