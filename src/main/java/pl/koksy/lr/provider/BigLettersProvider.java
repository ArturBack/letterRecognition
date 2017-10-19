package pl.koksy.lr.provider;

import pl.koksy.lr.model.Letter;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-19.
 */
public class BigLettersProvider extends AbstractLettersProvider {

    private static BigLettersProvider instance;

    public BigLettersProvider(String directoryPath) {
        super(directoryPath);
    }

    public static BigLettersProvider getInstance() {
        if(instance == null) {
            instance = new BigLettersProvider(StoragePathsProvider.getBigLettersDirectoryPath());
        }
        return instance;
    }

    @Override
    public ArrayList<Letter> provide() {
        
        return null;
    }
}
