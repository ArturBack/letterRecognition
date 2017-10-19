package pl.koksy.lr.neuralnetwork;

import pl.koksy.lr.model.Letter;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-15.
 */
public interface ILetterNeuralNetwork {

    String getLabel(Letter letter, ArrayList<Double> weigths);

    void train(Letter letter);

}
