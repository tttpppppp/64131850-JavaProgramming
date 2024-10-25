package org.example.testsql;

import config.MysqlConnection;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.User;
import service.UserService;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try (Connection connection = MysqlConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Database connection established successfully.");
            } else {
                System.err.println("Failed to establish database connection.");
            }
        } catch (Exception e) {

        }
        UserService userService = new UserService();
        for (User user : userService.getAllUsers()) {
            System.out.println(user.toString());
        }
        launch();
    }
}