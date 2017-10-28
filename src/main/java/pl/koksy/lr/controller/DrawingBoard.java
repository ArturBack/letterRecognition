package pl.koksy.lr.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class DrawingBoard {

    public static Color BACKGROUND_COLOR = Color.WHITE;

    private Canvas canvas;

    private double brushSize;
    private Color brushColor;

    public DrawingBoard(Canvas canvas, double brushSize, Color brushColor) {
        this.canvas = canvas;
        this.brushSize = brushSize;
        this.brushColor = brushColor;

        clearBoard();
        enableDrawing();
    }

    public void clearBoard() {
        GraphicsContext graphicContext = canvas.getGraphicsContext2D();
        graphicContext.setFill(BACKGROUND_COLOR);
        graphicContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public WritableImage getCurrentImage() {
        return canvas.snapshot(null, null);
    }

    public void setBrushSize(double brushSize) {
        this.brushSize = brushSize;
    }

    public void setBrushColor(Color brushColor) {
        this.brushColor = brushColor;
    }

    private void enableDrawing() {
        canvas.setOnMouseDragged(event -> {
            drawPoint(event.getX(), event.getY(), brushSize, brushColor);
        });
    }

    private void drawPoint(double x, double y, double size, Color color) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(color);
        graphicsContext.fillRect(x - size/2, y - size / 2, size, size);
    }
}
