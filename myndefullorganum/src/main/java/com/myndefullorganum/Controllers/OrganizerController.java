package com.myndefullorganum.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrganizerController {

    @FXML
    private TextField taskTitleField;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<String> taskListView;

    @FXML
    private TextArea taskDetailsArea;

    private ObservableList<String> tasks;
    private ObservableList<String> categories;

    @FXML
    public void initialize() {
        // Initialize task and category lists
        tasks = FXCollections.observableArrayList();
        categories = FXCollections.observableArrayList("Work", "Personal", "Urgent");

        // Bind categories to ComboBox
        categoryComboBox.setItems(categories);

        // Bind tasks to ListView
        taskListView.setItems(tasks);

        // Add event listener to show task details
        taskListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                showTaskDetails(newVal);
            }
        });
    }

    @FXML
    private void addTask() {
        String title = taskTitleField.getText();
        String category = categoryComboBox.getValue();

        if (title == null || title.trim().isEmpty() || category == null) {
            showAlert("Error", "Please enter a task title and select a category.");
            return;
        }

        String task = title + " [" + category + "]";
        tasks.add(task);
        taskTitleField.clear();
        categoryComboBox.setValue(null);
    }

    @FXML
    private void deleteTask() {
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            tasks.remove(selectedTask);
            taskDetailsArea.clear();
        } else {
            showAlert("Error", "No task selected.");
        }
    }

    private void showTaskDetails(String task) {
        taskDetailsArea.setText("Task: " + task);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
