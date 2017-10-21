package pl.koksy.lr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.koksy.lr.config.ViewConfig;

/**
 * Created by DKUNERT on 2017-10-14.
 */
public class FxApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		prepareStage(primaryStage);
		loadAndShowScene(primaryStage);
	}

	private void prepareStage(Stage primaryStage) {
		primaryStage.setTitle(ViewConfig.APP_TITLE);
		primaryStage.setResizable(ViewConfig.STAGE_IS_RESIZABLE);
	}

	private void loadAndShowScene(Stage primaryStage) throws java.io.IOException {
		Parent root = FXMLLoader.load(getClass().getResource(ViewConfig.MAIN_VIEW_PATH));
		Scene scene = new Scene(root, ViewConfig.MAIN_SCENE_WIDTH, ViewConfig.MAIN_SCENE_HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
