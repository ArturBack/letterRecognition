package pl.koksy.lr.provider;

/**
 * Created by Artur on 2017-10-19.
 */
public class DigitsProvider extends AbstractLettersProvider {

    private static DigitsProvider instance;

    public DigitsProvider(String directoryPath) {
        super(directoryPath);
    }

    public static DigitsProvider getInstance() {
        if(instance == null) {
            instance = new DigitsProvider(StoragePathsProvider.getDigitsDirectoryPath());
        }
        return instance;
    }
}
