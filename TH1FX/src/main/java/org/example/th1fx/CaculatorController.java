package org.example.th1fx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CaculatorController {

    @FXML
    private TextField txtA , txtB , txtResult;
    @FXML
    private RadioButton radioCong , radioTru , radioNhan , radioChia;

    @FXML
    private Button btnTinh;

    private ToggleGroup operationGroup;

    @FXML
    public void initialize() {
        operationGroup = new ToggleGroup();
        radioCong.setToggleGroup(operationGroup);
        radioTru.setToggleGroup(operationGroup);
        radioNhan.setToggleGroup(operationGroup);
        radioChia.setToggleGroup(operationGroup);
        btnTinh.setOnAction(event -> calculate());
    }
    private void calculate() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double result = 0;
            RadioButton selectedOperation = (RadioButton) operationGroup.getSelectedToggle();
            if (selectedOperation == null) {
                txtResult.setText("Chọn phép toán!");
                return;
            }
            switch (selectedOperation.getText()) {
                case "Cộng":
                    result = a + b;
                    break;
                case "Trừ":
                    result = a - b;
                    break;
                case "Nhân":
                    result = a * b;
                    break;
                case "Chia":
                    if (b == 0) {
                        txtResult.setText("Không thể chia cho 0!");
                        return;
                    }
                    result = a / b;
                    break;
                default:
                    txtResult.setText("Phép toán không hợp lệ!");
                    return;
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtResult.setText("Nhập số hợp lệ!");
        }
    }
}
