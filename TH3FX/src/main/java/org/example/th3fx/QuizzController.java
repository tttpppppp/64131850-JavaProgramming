package org.example.th3fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class QuizzController {

    @FXML
    private Button BtnD;

    @FXML
    private Button btnA;

    @FXML
    private Button btnB;

    @FXML
    private Button btnC;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        btnA.setStyle("-fx-background-color: #ffffff;");
        btnB.setStyle("-fx-background-color: #ffffff;");
        btnC.setStyle("-fx-background-color: #ffffff;");
        BtnD.setStyle("-fx-background-color:#ffffff;");

        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #FF2929; -fx-text-fill: white;");
    }
}
