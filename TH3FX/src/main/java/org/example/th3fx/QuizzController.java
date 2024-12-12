package org.example.th3fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;

public class QuizzController {
    @FXML
    private VBox questionsVBox;
    @FXML
    private Button btnA, btnB, btnC, btnD;
    @FXML
    private Label txtCauHoi;
    @FXML
    private Label txtDiem;

    private List<Question> questions = new ArrayList<>();
    private int currentIndex = 0;
    private int score = 0;

    @FXML
    public void initialize() {
        questions.add(new Question("Câu hỏi 1: Spring Boot giúp gì trong việc phát triển ứng dụng Java?", new String[]{"Tự động cấu hình ứng dụng", "Quản lý cơ sở dữ liệu", "Tạo ra các lớp DAO", "Tạo các servlet tự động"}, 0));
        questions.add(new Question("Câu hỏi 2: Cái nào sau đây là cách để chạy một ứng dụng Spring Boot?", new String[]{"java -jar app.jar", "mvn run", "spring run app.java", "java run app.java"}, 0));
        questions.add(new Question("Câu hỏi 3: Annotation nào trong Spring Boot được dùng để khai báo một ứng dụng web?", new String[]{"@SpringBootApplication", "@WebServlet", "@RestController", "@EnableAutoConfiguration"}, 0));
        questions.add(new Question("Câu hỏi 4: Spring Boot sử dụng cái gì để tự động cấu hình ứng dụng?", new String[]{"Spring Configuration", "AutoConfiguration", "Spring Boot Starter", "Spring Data"}, 1));
        questions.add(new Question("Câu hỏi 5: Để kết nối Spring Boot với cơ sở dữ liệu, chúng ta cần làm gì?", new String[]{"Cấu hình DataSource", "Khai báo JPA Repository", "Cài đặt Hibernate", "Tất cả các đáp án trên"}, 3));
        questions.add(new Question("Câu hỏi 6: Trong Spring Boot, cái nào là điểm bắt đầu của ứng dụng?", new String[]{"ApplicationContext", "SpringApplication.run()", "main() method", "DispatcherServlet"}, 1));
        questions.add(new Question("Câu hỏi 7: Để tạo REST API trong Spring Boot, bạn sử dụng cái nào?", new String[]{"@RestController", "@Service", "@Controller", "@Api"}, 0));
        questions.add(new Question("Câu hỏi 8: Spring Boot mặc định sử dụng cái nào để quản lý cấu hình?", new String[]{"application.properties", "application.yml", "config.xml", "spring-config.xml"}, 0));
        questions.add(new Question("Câu hỏi 9: Spring Boot hỗ trợ cái nào để tạo các dịch vụ web không đồng bộ?", new String[]{"@Async", "@Scheduled", "@RestController", "@Service"}, 0));
        questions.add(new Question("Câu hỏi 10: Spring Boot giúp gì trong việc phát triển các microservices?", new String[]{"Tự động cấu hình API Gateway", "Cung cấp Spring Cloud", "Cung cấp các Spring Starter cho microservices", "Tất cả các đáp án trên"}, 3));
        questions.add(new Question("Câu hỏi 11: Cái nào trong Spring Boot giúp bạn dễ dàng cấu hình các kết nối tới cơ sở dữ liệu?", new String[]{"Spring Data JPA", "Spring Boot Starter JDBC", "Hibernate", "Spring Cloud"}, 1));
        questions.add(new Question("Câu hỏi 12: Trong Spring Boot, cái nào giúp bạn cấu hình các dependency của ứng dụng?", new String[]{"@Autowired", "application.properties", "@EnableAutoConfiguration", "@SpringBootApplication"}, 2));
        questions.add(new Question("Câu hỏi 13: Spring Boot sử dụng cái nào để cấu hình các thành phần của ứng dụng mà không cần tệp XML?", new String[]{"JavaConfig", "Spring Data", "Annotation", "Spring Boot Actuator"}, 0));

        List<Button> questionButtons = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            int index = i;
            Button questionButton = new Button("Câu " + (i + 1));
            questionButton.setPrefWidth(200);
            questionButton.setPrefHeight(30);
            questionButton.setOnMouseClicked(event -> {
                loadQuestion(index);
                questionButtons.forEach(button -> button.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;"));
                questionButton.setStyle("-fx-background-color: #4F75FF; -fx-text-fill: white;");
            });
            VBox.setMargin(questionButton, new Insets(5));
            questionsVBox.getChildren().add(questionButton);
            questionButtons.add(questionButton);
        }
        if (!questionButtons.isEmpty()) {
            Button firstButton = questionButtons.get(0);
            firstButton.setStyle("-fx-background-color: #4F75FF; -fx-text-fill: white;");
            loadQuestion(currentIndex);
        }
    }


    @FXML
    void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int answerIndex = -1;
        if (clickedButton == btnA) {
            answerIndex = 0;
        } else if (clickedButton == btnB) {
            answerIndex = 1;
        } else if (clickedButton == btnC) {
            answerIndex = 2;
        } else if (clickedButton == btnD) {
            answerIndex = 3;
        }

        Question currentQuestion = questions.get(currentIndex);

        setAnswerButtonStyles(currentQuestion, answerIndex);

        if (answerIndex == currentQuestion.getCorrectAnswerIndex()) {
            score += 10;
        }else{
           if(score != 0){
               score -= 10;
           }
        }
        txtDiem.setText(String.valueOf(score));
        if (currentIndex < questions.size() - 1) {
            currentIndex++;
        }
    }

    private void setAnswerButtonStyles(Question question, int selectedAnswerIndex) {
        for (int i = 0; i < 4; i++) {
            Button btn = getButtonByIndex(i);
            if (i == question.getCorrectAnswerIndex()) {
                btn.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
            } else {
                btn.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white;");
            }
        }
    }

    private Button getButtonByIndex(int index) {
        switch (index) {
            case 0: return btnA;
            case 1: return btnB;
            case 2: return btnC;
            case 3: return btnD;
            default: return null;
        }
    }

    private void loadQuestion(int index) {
        if (index < questions.size()) {
            Question question = questions.get(index);
            txtCauHoi.setText(question.getQuestionText());
            btnA.setText(question.getOptions()[0]);
            btnB.setText(question.getOptions()[1]);
            btnC.setText(question.getOptions()[2]);
            btnD.setText(question.getOptions()[3]);
            resetButtonStyles();
        }
    }

    private void resetButtonStyles() {
        btnA.setStyle("-fx-background-color: #f8f9fa; -fx-text-fill: black;");
        btnB.setStyle("-fx-background-color: #f8f9fa; -fx-text-fill: black;");
        btnC.setStyle("-fx-background-color: #f8f9fa; -fx-text-fill: black;");
        btnD.setStyle("-fx-background-color: #f8f9fa; -fx-text-fill: black;");
    }
}
