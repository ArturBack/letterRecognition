package pl.koksy.lr.config;

public abstract class NeuralNetworkConfig {

    public static final int IMAGE_WIDTH = 20;
    public static final int IMAGE_HEIGHT = 20;

    public static final int NUMBER_OF_CHANNELS = 1;
    public static final int NUMBER_OF_LABELS = 26;
    public static final int ITERATIONS = 200;

    public static final double LEARNING_RATE = 1e-6;
    public static final double L2_REGULARIZATION = 1e-4;
    public static final double L1_REGULARIZATION = 1e-6;

    public static final int EPOCS_NUMBER = 5;

    public static final int NEURONS = 200;

    public static final int SEED = 123;

    public static final int NUMBER_OF_IMAGES_IN_LABEL_DIRECTORY = 55;

    public static String TRAINING_DATA_DIRECTORY = "Letters";

    public static String NETWORK_PATH = "network.zip";


    private NeuralNetworkConfig() {};
}
