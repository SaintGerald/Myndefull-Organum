package com.myndefullorganum;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class PrimaryController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    private void createWhiteboardTab() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("whiteboard.fxml"));
        Tab tempTab = new Tab();
        tempTab.setText("Whiteboard");
        tempTab.setContent(fxmlLoader.load());
        makeNewTab(tempTab);
    }

    @FXML
    private void makeNewTab(Tab tab) throws IOException {
        if (mainTabPane == null) {
            mainTabPane = new TabPane();
        }
        addTabToPane(tab);
    }

    @FXML
    private void addTabToPane(Tab newTab) {
        mainTabPane.getTabs().add(newTab);
    }

}
