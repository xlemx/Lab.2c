module pl.lublin.wsei.java.cwiczenia.lab2c {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.lublin.wsei.java.cwiczenia.lab2c to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.lab2c;
}