import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BakeryMenuBar extends Application {

    public void start(Stage s) {
        s.setTitle("Berryman's Bakery");

        // Create menu listings
        Menu homeMenu = new Menu("Home");
        Menu productsMenu = new Menu("Sweet Treats");
        Menu orderMenu = new Menu("Order Now");
        Menu aboutMenu = new Menu("Contact Us");

        // Create menu items
        MenuItem browniesItem = new MenuItem("Brownies");
        MenuItem cakesItem = new MenuItem("Cakes");
        MenuItem cookiesItem = new MenuItem("Cookies");

        MenuItem newOrderItem = new MenuItem("New Order");
        MenuItem trackOrderItem = new MenuItem("Track Order");

        // Pair items with related menu
        productsMenu.getItems().addAll(browniesItem, cakesItem, cookiesItem);
        orderMenu.getItems().addAll(newOrderItem, trackOrderItem);

        // Label for selected item
        Label l = new Label("\t\t\t\tNo menu item selected");

        // Create single event handler for all items
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                l.setText("\t\t\t\t" + ((MenuItem) e.getSource()).getText() + " selected");
            }
        };

        // Attach event handlers
        browniesItem.setOnAction(event);
        cakesItem.setOnAction(event);
        browniesItem.setOnAction(event);
        newOrderItem.setOnAction(event);
        trackOrderItem.setOnAction(event);

        // Create MenuBar with all the menus
        MenuBar mb = new MenuBar();
        mb.getMenus().addAll(homeMenu, productsMenu, orderMenu);

        // Pick layout and scene
        VBox vb = new VBox(mb, l);
        Scene sc = new Scene(vb, 600, 300);

        // Set scene and show stage
        s.setScene(sc);
        s.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
