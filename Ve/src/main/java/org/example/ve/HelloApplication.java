package org.example.ve;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(300, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineJoin(StrokeLineJoin.MITER);
        gc.setLineWidth(3);
        gc.setStroke(Color.BLACK);
        gc.setMiterLimit(5);

        gc.beginPath();
        gc.moveTo(130, 100);
        gc.lineTo(50, 220);
        gc.lineTo(250, 220);
        gc.closePath();
        gc.stroke();

        gc.beginPath();
        gc.moveTo(100, 140);
        gc.lineTo(50, 75);
        gc.lineTo(130, 95);
        gc.closePath();
        gc.stroke();

        gc.beginPath();
        gc.moveTo(200, 120);
        gc.lineTo(250, 75);
        gc.lineTo(170, 95);
        gc.closePath();
        gc.stroke();

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.TRANSPARENT);
        gc.strokeOval(70, 220, 160, 160);

        gc.strokeOval(70, 370, 60, 60);

        gc.strokeOval(170, 370, 60, 60);

        gc.setStroke(Color.RED);
        gc.beginPath();
        gc.arc(100, 400, 15, 15, 135, 90);
        gc.stroke();
        gc.beginPath();
        gc.arc(100, 400, 15, 15, 315, 90);
        gc.stroke();

        gc.beginPath();
        gc.arc(200, 400, 15, 15, 135, 90);
        gc.stroke();
        gc.beginPath();
        gc.arc(200, 400, 15, 15, 315, 90);
        gc.stroke();

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 300, 500);
        primaryStage.setTitle("Shape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}