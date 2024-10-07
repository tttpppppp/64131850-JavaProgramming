package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField txtChieuCao, txtCanNang, txtKetQua, txtTrangThai;

    public void tinhBMI(ActionEvent event) {
        try {
            double chieuCao = Double.parseDouble(txtChieuCao.getText()) / 100;
            double canNang = Double.parseDouble(txtCanNang.getText());

            double bmi = canNang / (chieuCao * chieuCao);
            txtKetQua.setText(String.format("%.2f", bmi));

            String trangThai = getBMI(bmi);
            txtTrangThai.setText(trangThai);

        } catch (NumberFormatException e) {
            txtKetQua.setText("Invalid input");
            txtTrangThai.setText("");
        }
    }

    private String getBMI(double bmi) {
        if (bmi < 18.5) {
            return "Thiếu cân";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Bình thường";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Thừu cân";
        } else {
            return "Béo phì";
        }
    }
}

