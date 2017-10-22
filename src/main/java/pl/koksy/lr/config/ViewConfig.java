package pl.koksy.lr.config;

public abstract class ViewConfig {

    private ViewConfig() {}

    public static final String APP_TITLE = "Letter recognition";
    public static final String MAIN_VIEW_PATH = "/view/mainView.fxml";
    public static final double MAIN_SCENE_WIDTH = 500;
    public static final double MAIN_SCENE_HEIGHT = 600;
    public static final boolean STAGE_IS_RESIZABLE = false;
}
