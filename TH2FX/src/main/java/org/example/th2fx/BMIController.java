package org.example.th2fx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class BMIController {

    @FXML
    private TextField txtChieuCao , txtCanNang , txtResult;

    @FXML
    private RadioButton radioChauA , radioChauAu;

    @FXML
    public void calculateBMI() {
        try {
            double height = Double.parseDouble(txtChieuCao.getText());
            double weight = Double.parseDouble(txtCanNang.getText());

            if (height <= 0 || weight <= 0) {
                txtResult.setText("Chiều cao và cân nặng phải lớn hơn 0.");
                return;
            }

            double bmi = weight / (height * height);

            String result;
            if (radioChauA.isSelected()) {
                if (bmi < 17.5) {
                    result = "Gầy (Châu Á)";
                } else if (bmi > 17.5 && bmi < 22.99) {
                    result = "Bình thường (Châu Á)";
                } else if (bmi < 23.00 && bmi > 27.99) {
                    result = "Thừa cân (Châu Á)";
                } else {
                    result = "Béo phì (Châu Á)";
                }
            } else if (radioChauAu.isSelected()) {
                if (bmi < 18.5) {
                    result = "Gầy (Châu Âu)";
                } else if (bmi < 18.8 && bmi < 24.99) {
                    result = "Bình thường (Châu Âu)";
                } else if (bmi < 25.00 && bmi > 29.99) {
                    result = "Thừa cân (Châu Âu)";
                } else {
                    result = "Béo phì (Châu Âu)";
                }
            } else {
                txtResult.setText("Vui lòng chọn  Châu Á hoặc Châu Âu.");
                return;
            }
            txtResult.setText(String.format("BMI: %.2f - %s", bmi, result));
        } catch (NumberFormatException e) {
            txtResult.setText("Vui lòng nhập số hợp lệ cho chiều cao và cân nặng.");
        }
    }
}
