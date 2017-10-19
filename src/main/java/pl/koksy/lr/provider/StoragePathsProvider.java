package pl.koksy.lr.provider;

import pl.koksy.lr.util.Constants;

import java.io.File;

/**
 * Created by Artur on 2017-10-19.
 */
public class StoragePathsProvider {

    public static String getBigLettersDirectoryPath() {
        return Constants.ALL_LETTER_DIRECTORY_PATH + File.separator + Constants.BIG_LETTER_DIRECTORY_NAME;
    }

    public static String getSmallLettersDirectoryPath() {
        return Constants.ALL_LETTER_DIRECTORY_PATH + File.separator + Constants.SMALL_LETTER_DIRECTORY_NAME;
    }

    public static String getDigitsDirectoryPath() {
        return Constants.ALL_LETTER_DIRECTORY_PATH + File.separator + Constants.DIGITS_DIRECTORY_NAME;
    }
}
