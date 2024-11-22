module com.myndefullorganum {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.myndefullorganum to javafx.fxml;
    opens com.myndefullorganum.Controllers to javafx.fxml;
    exports com.myndefullorganum;
    exports com.myndefullorganum.Controllers;
}
