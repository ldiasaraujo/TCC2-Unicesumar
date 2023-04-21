module com.example.projetoarrastarsoltar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetoarrastarsoltar to javafx.fxml;
    exports com.example.projetoarrastarsoltar;
}