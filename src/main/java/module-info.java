module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires spring.security.crypto;

    opens appli to javafx.fxml;
    exports appli;
    opens appli.liste to javafx.fxml;
    exports appli.accueil;
    opens appli.accueil to javafx.fxml;
    exports database;
    opens database to javafx.fxml;
}