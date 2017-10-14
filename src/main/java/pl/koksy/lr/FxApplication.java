package pl.koksy.lr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by DKUNERT on 2017-10-14.
 */
public class FxApplication extends Application {

	private static final String APP_TITLE = "Letter recognition";
	private static final String MAIN_VIEW_PATH = "/view/mainView.fxml";

	private static final double MAIN_SCENE_WIDTH = 500;
	private static final double MAIN_SCENE_HEIGHT = 600;
	private static final boolean STAGE_IS_RESIZABLE = false;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(APP_TITLE);
		primaryStage.setResizable(STAGE_IS_RESIZABLE);

		Parent root = FXMLLoader.load(getClass().getResource(MAIN_VIEW_PATH));

		Scene scene = new Scene(root, MAIN_SCENE_WIDTH, MAIN_SCENE_HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
