package com.myndefullorganum.Controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PostitboardController {

    @FXML
    private BorderPane postitBoard;
    
    @FXML
    private void addPostit() {
        if (postitBoard == null) {
            postitBoard = new BorderPane();
        }

        VBox postit = createPostit(100, 100);

        System.out.println(postit);

        postitBoard.getChildren().add(postit);
    }

    private VBox createPostit(double x, double y) {

        // Create a note container
        VBox postIt = new VBox();
        postIt.setStyle("-fx-background-color: #ffd700; -fx-border-color: black; -fx-border-width: 1;");
        postIt.setPadding(new Insets(5));
        postIt.setSpacing(5);
        postIt.setLayoutX(x);
        postIt.setLayoutY(y);

        // Make it draggable
        makeDraggable(postIt);

        // Add a text area
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefSize(150, 100);

        // Add a delete button
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> postitBoard.getChildren().remove(postIt));

        postIt.getChildren().addAll(textArea, deleteButton);
        
        return postIt;
    }

    private void makeDraggable(VBox postit) {
        final double[] dragOffset = new double[2];

        postit.setOnMousePressed(e -> {
            dragOffset[0] = e.getSceneX() - postit.getLayoutX();
            dragOffset[1] = e.getSceneY() - postit.getLayoutY();
        });

        postit.setOnMouseDragged(e -> {
            postit.setLayoutX(e.getSceneX() - dragOffset[0]);
            postit.setLayoutY(e.getSceneY() - dragOffset[1]);
        });
    }

}
