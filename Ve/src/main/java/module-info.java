module org.example.ve {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.ve to javafx.fxml;
    exports org.example.ve;
}