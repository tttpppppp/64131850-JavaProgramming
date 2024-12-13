module org.example.th4fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.th4fx to javafx.fxml;
    exports org.example.th4fx;
}