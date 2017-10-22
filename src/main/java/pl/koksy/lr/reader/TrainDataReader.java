package pl.koksy.lr.reader;

import org.datavec.api.io.filters.BalancedPathFilter;
import org.datavec.api.io.labels.ParentPathLabelGenerator;
import org.datavec.api.split.FileSplit;
import org.datavec.api.split.InputSplit;
import org.datavec.image.loader.BaseImageLoader;
import org.datavec.image.recordreader.ImageRecordReader;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static pl.koksy.lr.config.NeuralNetworkConfig.*;

public class TrainDataReader {

    public static DataSetIterator testData;

    public static DataSetIterator getTrainDataIterator() {

        // Temporary set to big letter to test if this works - parent should be at "LETTERS"
        File parentDir = new File(TRAINING_DATA_DIRECTORY);

        FileSplit filesInDir = new FileSplit(parentDir, BaseImageLoader.ALLOWED_FORMATS);
        ParentPathLabelGenerator labelMaker = new ParentPathLabelGenerator();

        Random randomNum = new Random();
        BalancedPathFilter pathFilter = new BalancedPathFilter(randomNum, BaseImageLoader.ALLOWED_FORMATS, labelMaker);

        InputSplit[] filesInDirSplit = filesInDir.sample(pathFilter, 100, 0);
        InputSplit trainData = filesInDirSplit[0];


        ImageRecordReader recordReader = new ImageRecordReader(IMAGE_HEIGHT, IMAGE_WIDTH, NUMBER_OF_CHANNELS, labelMaker);
        // ImageTransform transform = new MultiImageTransform(randomNum, new CropImageTransform(80), new ShowImageTransform("After transformation"));
        //ImageTransform transform = new MultiImageTransform(randomNum, new CropImageTransform(80));
        //ImageTransform transform = new MultiImageTransform();
        //ImageTransform transform = new MultiImageTransform(randomNum, new ShowImageTransform("After transformation"));

        try {
            recordReader.initialize(trainData, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataSetIterator dataSetIterator = new RecordReaderDataSetIterator(recordReader, NUMBER_OF_IMAGES_IN_LABEL_DIRECTORY, 1, NUMBER_OF_LABELS);

        return dataSetIterator;
    }
}
