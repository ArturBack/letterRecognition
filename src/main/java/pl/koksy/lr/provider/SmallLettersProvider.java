package pl.koksy.lr.provider;

/**
 * Created by Artur on 2017-10-19.
 */
public class SmallLettersProvider extends AbstractLettersProvider {

    private static SmallLettersProvider instance;

    public SmallLettersProvider(String directoryPath) {
        super(directoryPath);
    }

    public static SmallLettersProvider getInstance() {
        if(instance == null) {
            instance = new SmallLettersProvider(StoragePathsProvider.getSmallLettersDirectoryPath());
        }
        return instance;
    }

}
