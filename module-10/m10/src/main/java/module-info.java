module database {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens database to javafx.fxml;
    exports database;
}
