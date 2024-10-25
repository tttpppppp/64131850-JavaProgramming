module org.example.testsql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens model to javafx.base;
    opens org.example.testsql to javafx.fxml;
    exports org.example.testsql;
}