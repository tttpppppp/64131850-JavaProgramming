module org.example.ve {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ve to javafx.fxml;
    exports org.example.ve;
}