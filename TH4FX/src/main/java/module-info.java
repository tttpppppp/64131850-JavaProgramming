module org.example.th3fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.th3fx to javafx.fxml;
    exports org.example.th3fx;
}