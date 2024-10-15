package com.example.adroi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnCong , btnTru , btnNhan , btnChia;
    EditText txtA , txtB ;
    TextView txtKetQua;

    protected void findControl(){
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtKetQua = findViewById(R.id.txtKetQua);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findControl();
        btnCong.setOnClickListener(v -> tinhToan("+"));
        btnTru.setOnClickListener(v -> tinhToan("-"));
        btnNhan.setOnClickListener(v -> tinhToan("*"));
        btnChia.setOnClickListener(v -> tinhToan("/"));
    }

    public void tinhToan(String phepToan){
        double a = Double.parseDouble(txtA.getText().toString());
        double b = Double.parseDouble(txtB.getText().toString());
        double ketQua = 0;
        switch (phepToan) {
            case "+":
                ketQua = a + b;
                txtKetQua.setText(String.valueOf(ketQua));
                break;
            case "-":
                ketQua = a - b;
                txtKetQua.setText(String.valueOf(ketQua));

                break;
            case "*":
                ketQua = a * b;
                txtKetQua.setText(String.valueOf(ketQua));
                break;
            case "/":
                if (b != 0) {
                    ketQua = a / b;
                } else {
                    Toast.makeText(this, "Không thể chia không", Toast.LENGTH_SHORT).show();
                    return;
                }
                txtKetQua.setText(String.valueOf(ketQua));
                break;
            default:
                break;
        }
    }

}