package pl.koksy.lr.provider;

import pl.koksy.lr.model.Letter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by Artur on 2017-10-19.
 */
public  abstract class AbstractLettersProvider  {

    private final String directoryPath;

    public AbstractLettersProvider(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public ArrayList<Letter> provide() {
        ArrayList<Letter> letters = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.skip(1)
                    .parallel()
                    .filter(path -> !Files.isDirectory(path))
                    .map(this::createLetter)
                    .forEach(letters::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return letters;
    }

    private Letter createLetter(Path path) {
        try {
            File imageFile = path.toFile();
            BufferedImage image = ImageIO.read(imageFile);
            System.out.println(imageFile.getName());

            //TODO extract features from image here
            ArrayList<Double> letterFeatures = null;

            return new Letter(path.getParent().toFile().getName(), letterFeatures);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
