/**
 * Katie Hilliard
 * CSD-420 – Module 10 Assignment
 * 05/09/2025
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;


public class Main extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost/databasedb";
    private static final String USER = "student1";
    private static final String PASS = "pass";

    private TextField idField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField teamField = new TextField();
    private Label statusLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("First Name:"), 0, 1);
        grid.add(firstNameField, 1, 1);
        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastNameField, 1, 2);
        grid.add(new Label("Favorite Team:"), 0, 3);
        grid.add(teamField, 1, 3);

        Button displayButton = new Button("Display");
        Button updateButton = new Button("Update");
        HBox buttonBox = new HBox(10, displayButton, updateButton);
        grid.add(buttonBox, 1, 4);
        grid.add(statusLabel, 1, 5);

        displayButton.setOnAction(e -> displayFan());
        updateButton.setOnAction(e -> updateFan());

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Fan Database Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayFan() {
        String idText = idField.getText();
        String query = "SELECT * FROM fans WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Integer.parseInt(idText));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
                statusLabel.setText("✅ Fan info loaded.");
            } else {
                statusLabel.setText("No fan found with ID " + idText);
            }

        } catch (Exception e) {
            statusLabel.setText("Unable to retrieve record.");
            e.printStackTrace();
        }
    }

    private void updateFan() {
        String idText = idField.getText();
        String first = firstNameField.getText();
        String last = lastNameField.getText();
        String team = teamField.getText();

        String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setString(3, team);
            stmt.setInt(4, Integer.parseInt(idText));

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                statusLabel.setText("Successfully updated");
            } else {
                statusLabel.setText("No record to update.");
            }

        } catch (Exception e) {
            statusLabel.setText("Unable to update record.");
            e.printStackTrace();
        }
    }
}
