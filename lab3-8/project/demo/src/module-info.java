module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.prefs;

    requires com.dlsc.formsfx;

    opens ch.makery.address to javafx.fxml, java.xml.bind, com.sun.xml.bind;
    opens ch.makery.address.model to java.xml.bind, com.sun.xml.bind;
    exports ch.makery.address;
    exports ch.makery.address.view;
    exports ch.makery.address.model;
    opens ch.makery.address.view to javafx.fxml;
}