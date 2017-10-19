package pl.koksy.lr.neuralnetwork;

import pl.koksy.lr.model.Letter;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-15.
 */
public class LetterNeuralNetwork implements ILetterNeuralNetwork {


    @Override
    public String getLabel(Letter letter, ArrayList<Double> weigths) {
        return " ";
    }

    @Override
    public void train(Letter letter) {

    }
}
