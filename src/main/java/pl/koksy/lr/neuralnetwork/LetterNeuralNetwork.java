package pl.koksy.lr.neuralnetwork;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import static pl.koksy.lr.config.NeuralNetworkConfig.*;

public class LetterNeuralNetwork {

    public static MultiLayerNetwork build() {

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(SEED) //include a random seed for reproducibility
                // use stochastic gradient descent as an optimization algorithm
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .iterations(ITERATIONS)
                .learningRate(LEARNING_RATE) //specify the learning rate
                .updater(Updater.NESTEROVS)
                .regularization(true).l2(L2_REGULARIZATION)
                .list()
                .layer(0, new DenseLayer.Builder() //create the first, input layer with xavier initialization
                        .nIn(IMAGE_WIDTH * IMAGE_HEIGHT)
                        .nOut(1000)
                        .activation(Activation.RELU)
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD) //create hidden layer
                        .nIn(1000)
                        .nOut(NUMBER_OF_LABELS)
                        .activation(Activation.SOFTMAX)
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .pretrain(false).backprop(true) //use backpropagation to adjust weights
                .setInputType(InputType.convolutional(IMAGE_HEIGHT, IMAGE_WIDTH, NUMBER_OF_CHANNELS))
                .build();

        MultiLayerNetwork multiLayerNetwork = new MultiLayerNetwork(conf);
        multiLayerNetwork.init();

        multiLayerNetwork.setListeners(new ScoreIterationListener(1));
        return multiLayerNetwork;
    }
}
