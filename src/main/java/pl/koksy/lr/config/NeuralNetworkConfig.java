package pl.koksy.lr.config;

public abstract class NeuralNetworkConfig {

    public static final int IMAGE_WIDTH = 50;
    public static final int IMAGE_HEIGHT = 38;

    public static final int NUMBER_OF_CHANNELS = 1;
    public static final int NUMBER_OF_LABELS = 10; //26
    public static final int ITERATIONS = 500;

    public static final double LEARNING_RATE = 1e-6;
    public static final double L2_REGULARIZATION = 1e-4;
    public static final double L1_REGULARIZATION = 1e-6;


    public static final int SEED = 123;

    public static final int NUMBER_OF_IMAGES_IN_LABEL_DIRECTORY = 55;

    private NeuralNetworkConfig() {};
}