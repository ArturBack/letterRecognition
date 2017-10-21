package pl.koksy.lr.config;

public abstract class NeuralNetworkConfig {

    public static final int IMAGE_WIDTH = 50;
    public static final int IMAGE_HEIGHT = 50;

    public static final int NUMBER_OF_CHANNELS = 1;
    public static final int NUMBER_OF_LABELS = 26;
    public static final int ITERATIONS = 1;

    public static final double LEARNING_RATE = 0.006;
    public static final double L2_REGULARIZATION = 1e-4;

    public static final int SEED = 123;

    private NeuralNetworkConfig() {};
}
