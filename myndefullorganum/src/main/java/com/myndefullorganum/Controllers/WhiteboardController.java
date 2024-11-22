package com.myndefullorganum.Controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class WhiteboardController {

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Slider brushSizeSlider;

    private GraphicsContext gc;

    @FXML
    public void initialize() {

        if (canvas == null) {
            canvas = new Canvas(640, 480);
        }

        

        // Initialize GraphicsContext for the canvas
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(brushSizeSlider.getValue());
        gc.setLineCap(StrokeLineCap.ROUND);

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
        //System.out.println("mousePressedTriggered");
        gc.beginPath();
        gc.moveTo(event.getX(), event.getY());
        gc.stroke();
    }

    private void onMouseDragged(MouseEvent event) {
        //System.out.println("mouseDraggedTriggered");
        gc.lineTo(event.getX(), event.getY());
        gc.stroke();
    }

}