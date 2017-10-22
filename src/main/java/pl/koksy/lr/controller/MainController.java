package pl.koksy.lr.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.WritableImage;
import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import pl.koksy.lr.neuralnetwork.LetterNeuralNetwork;
import pl.koksy.lr.reader.TrainDataReader;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static pl.koksy.lr.config.NeuralNetworkConfig.*;

/**
 * Created by DKUNERT on 2017-10-14.
 */
public class MainController {

    @FXML
    private Canvas letterCanvas;

    @FXML
    private ColorPicker brushColorPicker;

    @FXML
    private Slider brushSizeSlider;

    @FXML
    private Button clearButton;

    @FXML
    private Button checkButton;

    @FXML
    private Label resultLabel;


    private DrawingBoard drawingBoard;
    private MultiLayerNetwork neuralNetwork;

    @FXML
    private void initialize() {
        this.drawingBoard = new DrawingBoard(letterCanvas, brushSizeSlider.getValue(), brushColorPicker.getValue());
        handleCheckButton();
        handleBrushColorPickerChange();
        handleBrushSizeSliderChange();
        handleClearButton();

        neuralNetwork = LetterNeuralNetwork.build();
        neuralNetwork.fit(TrainDataReader.getTrainDataIterator());

        DataSetIterator trainDataIterator = TrainDataReader.getTrainDataIterator();
        System.out.println("EVALUATE: " + neuralNetwork.evaluate(trainDataIterator));

        for (int i = 0; i < 0; i++) {
            neuralNetwork.fit(TrainDataReader.getTrainDataIterator());
            System.out.println("EVALUATE: " + neuralNetwork.evaluate(trainDataIterator));
        }

    }


    private void handleCheckButton() {
        checkButton.setOnMouseClicked(event -> {
            WritableImage currentImage = drawingBoard.getCurrentImage();

            try {
                BufferedImage image = SwingFXUtils.fromFXImage(currentImage, null);
                NativeImageLoader loader = new NativeImageLoader(IMAGE_HEIGHT, IMAGE_WIDTH, NUMBER_OF_CHANNELS);
                INDArray inputImage = loader.asRowVector(image);
                INDArray prediction = neuralNetwork.output(inputImage);

                System.out.println("PREDICTIONS: " + prediction.toString());

                String result = "" + neuralNetwork.predict(inputImage)[0]; // TODO: change to get label
                resultLabel.setText(result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void handleBrushColorPickerChange() {
        brushColorPicker.setOnAction(event -> {
            drawingBoard.setBrushColor(brushColorPicker.getValue());
        });
    }

    private void handleBrushSizeSliderChange() {
        brushSizeSlider.valueProperty().addListener((ov, oldValue, newValue) -> {
            drawingBoard.setBrushSize(newValue.doubleValue());
        });
    }

    private void handleClearButton() {
        clearButton.setOnMouseClicked(event -> {
            drawingBoard.clearBoard();
        });
    }
}
