// Katie Hilliard, Module 1 Programming Assignment, 03/23/2025

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCardGame extends Application {

    private static final String CARD_IMAGES = "cards/"; // Subdirectory with card images
    private static final int TOTAL_CARDS = 52; // Total number of cards in deck
    private static final int DISPLAY_COUNT = 4; // Display four random cards
    private final List<ImageView> cardViews = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        // HBox with card images
        HBox cardBox = new HBox(10);
        cardBox.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        // Create display of cards
        for (int i = 0; i < DISPLAY_COUNT; i++) {
            ImageView imageView = new ImageView();
            imageView.setFitWidth(120);
            imageView.setFitHeight(180);
            cardViews.add(imageView);
            cardBox.getChildren().add(imageView);
        }

        // Refresh button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> updateCards());

        // VBox to arrange elements
        VBox root = new VBox(15, cardBox, refreshButton);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        // Display updated cards
        updateCards();

        // Initialize card display
        primaryStage.setTitle("My Card Game");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }

    // Update new random cards
    private void updateCards() {
        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            cardNumbers.add(i);
        }
        Collections.shuffle(cardNumbers); // Shuffle cards

        for (int i = 0; i < DISPLAY_COUNT; i++) {
            String imagePath = CARD_IMAGES + cardNumbers.get(i) + ".png";
            File file = new File(imagePath);
            if (file.exists()) {
                cardViews.get(i).setImage(new Image(file.toURI().toString()));
            } else {
                System.out.println("Missing file: " + imagePath);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
