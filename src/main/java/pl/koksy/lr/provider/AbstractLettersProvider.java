package pl.koksy.lr.provider;

import pl.koksy.lr.model.Letter;

import java.util.ArrayList;

/**
 * Created by Artur on 2017-10-19.
 */
public  abstract class AbstractLettersProvider  {

    private final String directoryPath;

    public AbstractLettersProvider(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public ArrayList<Letter> provide() {
        return null;
    }
}
