module org.example.th2fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.th2fx to javafx.fxml;
    exports org.example.th2fx;
}