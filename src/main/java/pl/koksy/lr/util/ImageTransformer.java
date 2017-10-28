package pl.koksy.lr.util;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import pl.koksy.lr.controller.DrawingBoard;

public class ImageTransformer {

    public Image transformImage(Image writableImage) {
        PixelReader pixelReader = writableImage.getPixelReader();
        int width = (int) writableImage.getWidth();
        int height = (int) writableImage.getHeight();
        int leftX = findFirstNonBackgroundPixelFromLeft(pixelReader, width, height).getX();
        int rightX = findFirstNonBackgroundPixelFromRight(pixelReader, width, height).getX();

        int topY = findFirstNonBackgroundPixelFromTop(pixelReader, width, height).getY();
        int bottomY = findFirstNonBackgroundPixelFromBottom(pixelReader, width, height).getY();

        Image croppedWritableImage = cropImage(pixelReader, leftX, topY, rightX, bottomY);


        Image squareSize = makeImageSquareSize(croppedWritableImage);

        return squareSize;
    }

    private Image cropImage(PixelReader pixelReader, int leftX, int topY, int rightX, int bottomY) {
        int width = rightX - leftX;
        int height = bottomY - topY;

        WritableImage croppedImage = new WritableImage(width, height);
        PixelWriter croppedImagePixelWriter = croppedImage.getPixelWriter();

        int croppedImageX = 0;
        int croppedImageY = 0;
        for (int i = leftX; i < rightX; i++) {
            for (int j = topY; j < bottomY; j++) {
                croppedImagePixelWriter.setColor(croppedImageX, croppedImageY, pixelReader.getColor(i, j));
                croppedImageY++;
            }
            croppedImageX++;
            croppedImageY = 0;
        }

        return croppedImage;
    }

    private Image makeImageSquareSize(Image writableImage) {
        int width = (int) writableImage.getWidth();
        int height = (int) writableImage.getHeight();
        PixelReader pixelReader = writableImage.getPixelReader();

        if (width == height) {
            return writableImage;
        }

        WritableImage squareSizeImage;

        if (width > height) {
            int topBottomMargin = (width - height) / 2;

            squareSizeImage = new WritableImage(width, width);
            PixelWriter squareSizeImagePixelWriter = squareSizeImage.getPixelWriter();

            for (int i = 0; i < topBottomMargin; i++) {
                for (int j = 0; j < width; j++) {
                    squareSizeImagePixelWriter.setColor(j, i, DrawingBoard.BACKGROUND_COLOR);
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    squareSizeImagePixelWriter.setColor(j, i + topBottomMargin, pixelReader.getColor(j, i));
                }
            }
            for (int i = height + topBottomMargin; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    squareSizeImagePixelWriter.setColor(j, i, DrawingBoard.BACKGROUND_COLOR);
                }
            }

        } else {
            int leftRightMargin = (height - width) / 2;

            squareSizeImage = new WritableImage(height, height);
            PixelWriter squareSizeImagePixelWriter = squareSizeImage.getPixelWriter();

            for (int i = 0; i < leftRightMargin; i++) {
                for (int j = 0; j < height; j++) {
                    squareSizeImagePixelWriter.setColor(i, j, DrawingBoard.BACKGROUND_COLOR);
                }
            }

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    squareSizeImagePixelWriter.setColor(i + leftRightMargin, j, pixelReader.getColor(i, j));
                }
            }
            for (int i = width + leftRightMargin; i < height; i++) {
                for (int j = 0; j < height; j++) {
                    squareSizeImagePixelWriter.setColor(i, j, DrawingBoard.BACKGROUND_COLOR);
                }
            }
        }

        return squareSizeImage;
    }

    private Pixel findFirstNonBackgroundPixelFromLeft(PixelReader pixelReader, int imageWidth, int imageHeight) {
        for (int i = 0; i < imageWidth; i++) {
            for (int j = 0; j < imageHeight; j++) {
                if (!pixelReader.getColor(i, j).equals(DrawingBoard.BACKGROUND_COLOR)) {
                   return new Pixel(i, j);
                }
            }
        }
        return new Pixel(-1, -1);
    }

    private Pixel findFirstNonBackgroundPixelFromRight(PixelReader pixelReader, int imageWidth, int imageHeight) {
        for (int i = imageWidth - 1; i >= 0; i--) {
            for (int j = 0; j < imageHeight; j++) {
                if (!pixelReader.getColor(i, j).equals(DrawingBoard.BACKGROUND_COLOR)) {
                    return new Pixel(i, j);
                }
            }
        }
        return new Pixel(-1, -1);
    }

    private Pixel findFirstNonBackgroundPixelFromTop(PixelReader pixelReader, int imageWidth, int imageHeight) {
        for (int i = 0; i < imageHeight; i++) {
            for (int j = 0; j < imageWidth; j++) {
                if (!pixelReader.getColor(j, i).equals(DrawingBoard.BACKGROUND_COLOR)) {
                    return new Pixel(j, i);
                }
            }
        }
        return new Pixel(-1, -1);
    }

    private Pixel findFirstNonBackgroundPixelFromBottom(PixelReader pixelReader, int imageWidth, int imageHeight) {
        for (int i = imageHeight - 1; i >= 0; i--) {
            for (int j = 0; j < imageWidth; j++) {
                if (!pixelReader.getColor(j, i).equals(DrawingBoard.BACKGROUND_COLOR)) {
                    return new Pixel(j, i);
                }
            }
        }
        return new Pixel(-1, -1);
    }

    private class Pixel {
        private int x;
        private int y;

        public Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
