module com.example.gasa_nika {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gasa_nika to javafx.fxml;
    exports com.example.gasa_nika;
}