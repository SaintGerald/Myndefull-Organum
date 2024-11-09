module com.myndefullorganum {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.myndefullorganum to javafx.fxml;
    exports com.myndefullorganum;
}
