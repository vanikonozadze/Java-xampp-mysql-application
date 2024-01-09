module com.example.jj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires lombok;

    opens com.example.jj to javafx.fxml;
    exports com.example.jj;
}