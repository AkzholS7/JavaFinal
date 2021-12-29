module com.example.demo14 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo14 to javafx.fxml;
    exports com.example.demo14;
}