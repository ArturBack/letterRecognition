package pl.koksy.lr.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.WritableImage;
import pl.koksy.lr.neuralnetwork.LetterNeuralNetworkManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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

	private LetterNeuralNetworkManager letterNeuralNetworkManager;

	private DrawingBoard drawingBoard;

	@FXML
	private void initialize() {
		this.letterNeuralNetworkManager = new LetterNeuralNetworkManager();
		this.drawingBoard = new DrawingBoard(letterCanvas, brushSizeSlider.getValue(), brushColorPicker.getValue());
		handleCheckButton();
		handleBrushColorPickerChange();
		handleBrushSizeSliderChange();
		handleClearButton();

        //new Thread(() -> letterNeuralNetworkManager.trainNetwork()).start();

    }


	private void handleCheckButton() {
		checkButton.setOnMouseClicked(event -> {
			WritableImage currentImage = drawingBoard.getCurrentImage();

			try {
				ImageIO.write(SwingFXUtils.fromFXImage(currentImage, null), "png", new File("testFile.png"));
				resultLabel.setText("" + new Random().nextInt(10));
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
