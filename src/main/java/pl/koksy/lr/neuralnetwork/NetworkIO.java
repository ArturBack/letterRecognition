package pl.koksy.lr.neuralnetwork;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.util.ModelSerializer;

import java.io.File;
import java.io.IOException;

import static pl.koksy.lr.config.NeuralNetworkConfig.NETWORK_PATH;

/**
 * Created by Artur on 2017-10-23.
 */
public class NetworkIO {

    public static void saveNetwork(MultiLayerNetwork network) {
        File locationToSave = new File(NETWORK_PATH);
        try {
            ModelSerializer.writeModel(network, locationToSave, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MultiLayerNetwork loadNetwork() {
        File locationToSave = new File(NETWORK_PATH);
        try {
            return ModelSerializer.restoreMultiLayerNetwork(locationToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
