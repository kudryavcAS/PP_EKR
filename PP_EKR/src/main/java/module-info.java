module lab.xml.pp_ekr {
    requires javafx.controls;
    requires javafx.fxml;

    opens lab.xml.pp_ekr to javafx.fxml;
    exports lab.xml.pp_ekr;
}