package pl.koksy.lr.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pl.koksy.lr.neuralnetwork.LetterNeuralNetworkManager;

/**
 * Created by DKUNERT on 2017-10-14.
 */
public class MainController {

	@FXML
	private Canvas letterCanvas;

	@FXML
	private Button checkButton;

	@FXML
	private Label resultLabel;

	private LetterNeuralNetworkManager letterNeuralNetworkManager;

	@FXML
	private void initialize() {
		this.letterNeuralNetworkManager = new LetterNeuralNetworkManager();
		System.out.println("Lubie placki");

		checkButton.setOnMouseClicked(event -> {
			System.out.println("Lubie mięso");


		});
	}
}
