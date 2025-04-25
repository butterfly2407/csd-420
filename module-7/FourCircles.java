// Katie Hilliard, Module 7 Assignment, 04/24/2025

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FourCircles extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create two plain circles
        Circle circle1 = new Circle(50);
        circle1.getStyleClass().add("plaincircle");

        Circle circle2 = new Circle(50);
        circle2.getStyleClass().add("plaincircle");

        // Create red and green circles
        Circle circle3 = new Circle(50);
        circle3.setId("redcircle");

        Circle circle4 = new Circle(50);
        circle4.setId("greencircle");

        // Test to check style class and ID
        System.out.println("Circle 1 style class: " + c1.getStyleClass());
        System.out.println("Circle 3 ID: " + c3.getId());
        System.out.println("Circle 4 ID: " + c4.getId());


        // Place a bordered box around the plain circles using vertical stack
        VBox borderedBox = new VBox(20, circle1, circle2);
        borderedBox.getStyleClass().add("border");
        borderedBox.setStyle("-fx-padding: 10; -fx-alignment: center;");

        // Create a horizontal box to display circles
        HBox root = new HBox(20, borderedBox, circle3, circle4);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Scene setup
        Scene scene = new Scene(root);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("M7 Assignment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
