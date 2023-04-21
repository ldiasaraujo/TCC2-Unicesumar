package com.example.projetoarrastarsoltar;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onInglesButtonClick() throws IOException {
        //welcomeText.setText("Inglês");

        // Crie um novo objeto FXMLLoader para carregar a nova cena
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/projetoarrastarsoltar/ingles-arrastar-view.fxml"));

        Parent root = fxmlLoader.load(); // Carregue a nova cena como um objeto Parent

        // Crie um novo objeto Scene com a nova cena carregada
        Scene novaCena = new Scene(root);

        // Obtenha a referência ao Stage atual da aplicação
        Stage stage = (Stage) welcomeText.getScene().getWindow();

        // Defina a nova cena no Stage
        stage.setScene(novaCena);

        // Exiba a nova cena
        stage.show();
    }

    @FXML
    protected void onPortuguesButtonClick() {
        welcomeText.setText("Português");
    }

    @FXML
    protected void onGeografiaButtonClick() {
        welcomeText.setText("Geografia");
    }
}