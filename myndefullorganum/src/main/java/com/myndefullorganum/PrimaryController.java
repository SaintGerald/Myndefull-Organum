package com.myndefullorganum;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Slider brushSizeSlider;

    private GraphicsContext gc;

    @FXML
    public void initialize() {
        // Initialize GraphicsContext for the canvas
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(brushSizeSlider.getValue());

        // Set up the canvas for drawing
        canvas.setOnMousePressed(this::onMousePressed);
        canvas.setOnMouseDragged(this::onMouseDragged);

        // Listen for changes in color picker
        colorPicker.setValue(Color.BLACK);  // Default color
        colorPicker.setOnAction(event -> gc.setStroke(colorPicker.getValue()));

        // Listen for changes in brush size slider
        brushSizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> 
            gc.setLineWidth(newValue.doubleValue())
        );
    }

    private void onMousePressed(MouseEvent event) {
        gc.beginPath();
        gc.moveTo(event.getX(), event.getY());
        gc.stroke();
    }

    private void onMouseDragged(MouseEvent event) {
        gc.lineTo(event.getX(), event.getY());
        gc.stroke();
    }
}
