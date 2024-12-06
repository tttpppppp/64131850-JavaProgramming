module org.example.th1fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.th1fx to javafx.fxml;
    exports org.example.th1fx;
}