module org.example.program6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.program6 to javafx.fxml;
    exports org.example.program6;
}