package org.example.th4fx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DictionaryController {
    @FXML
    private TextField inputWord;

    @FXML
    private TextArea outputMeaning;

    private HashMap<String, String> dictionary;

    public void initialize() {
        dictionary = new HashMap<>();
        loadDictionaryFromFile("dictionary.txt");
    }
    void loadDictionaryFromFile(String fileName) {
        // Đọc từ điển từ file resource
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(fileName)))) {
            if (reader == null) {
                outputMeaning.setText("Không thể tải dữ liệu từ điển: Không tìm thấy file " + fileName);
                return;
            }
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    dictionary.put(parts[0].trim().toLowerCase(), parts[1].trim());
                }
            }
        } catch (Exception e) {
            outputMeaning.setText("Không thể tải dữ liệu từ điển: " + e.getMessage());
        }
    }

    @FXML
    public void onSearchWord() {
        String word = inputWord.getText().trim().toLowerCase();
        if (word.isEmpty()) {
            outputMeaning.setText("Vui lòng nhập từ cần tìm");
            return;
        }
        String meaning = dictionary.get(word);
        if (meaning != null) {
            outputMeaning.setText(meaning);
        } else {
            outputMeaning.setText("Từ này không có trong từ điển.");
        }
    }
}
