// Katie Hilliard, M8 Assignment, 04/24/2025

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class KatieThreeThreads extends Application {

    // Minimum of 10000 characters
    private static final int TOTAL = 10000;

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        // Create a thread for each character
        Thread letterThread = new Thread(() -> appendCharacters(textArea, "letters"));
        Thread digitThread = new Thread(() -> appendCharacters(textArea, "digits"));
        Thread symbolThread = new Thread(() -> appendCharacters(textArea, "symbols"));

        // Start threads
        letterThread.start();
        digitThread.start();
        symbolThread.start();

        // Add Title for window
        VBox vbox = new VBox(textArea);
        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setTitle("Katie Three Threads");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Generate characters
    private void appendCharacters(TextArea textArea, String type) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TOTAL; i++) {
            char c;
            switch (type) {
                case "letters":
                    c = (char) (random.nextInt(26) + 'a'); // Any letter from a to z
                    break;
                case "digits":
                    c = (char) (random.nextInt(10) + '0'); // Any digit from 0 to 9
                    break;
                case "symbols":
                    char[] symbols = {'+', '@', '$', '#', '!', '?', '*'}; // Any of these symbols
                    c = symbols[random.nextInt(symbols.length)];
                    break;
                default:
                    throw new IllegalArgumentException("Unknown type: " + type);
            }
            sb.append(c);
            if ((i + 1) % 100 == 0) sb.append("\n");
        }

        String result = type.toUpperCase() + ":\n" + sb + "\n\n";
        javafx.application.Platform.runLater(() -> textArea.appendText(result));
    }

    public static void main(String[] args) {
        launch(args); // Run and launch the app
    }
}
