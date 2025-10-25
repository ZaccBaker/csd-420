import java.util.Random;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application{
    @Override
    public void start(Stage stage){
        
        VBox vbox = new VBox();
        GridPane gridPane = new GridPane();
        Label title = new Label("Four Cards");



        // Display cards
        displayCards(gridPane);

        // Refresh button, event listener
        Button refresh = new Button("Refresh");
        refresh.setOnAction(e ->{
            gridPane.getChildren().clear();
            displayCards(gridPane);
        });

        vbox.getChildren().addAll(title, gridPane, refresh);

        Scene scene = new Scene(vbox, 300, 300);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Zac Baker - M1 Programming Assignment");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    // Gets png, displays cards
    private void displayCards(GridPane gridPane){
        int[] cardNumbers = getNumbers();
        
        // Can this be a lambda expression?
        Image card1 = new Image(String.format("file:cards/%d.png",cardNumbers[0]));
        Image card2 = new Image(String.format("file:cards/%d.png",cardNumbers[1]));
        Image card3 = new Image(String.format("file:cards/%d.png",cardNumbers[2]));
        Image card4 = new Image(String.format("file:cards/%d.png",cardNumbers[3]));

        ImageView viewCard1 = new ImageView(card1);
        ImageView viewCard2 = new ImageView(card2);
        ImageView viewCard3 = new ImageView(card3);
        ImageView viewCard4 = new ImageView(card4);

        gridPane.add(viewCard1, 0, 0);
        gridPane.add(viewCard2, 1, 0);
        gridPane.add(viewCard3, 0, 1);
        gridPane.add(viewCard4, 1, 1);
    }


    // Gets four random numbers, no duplicates, lambda
    private int[] getNumbers(){
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(52) + 1)
                        .distinct()
                        .limit(4)
                        .toArray();
    }


    public static void main(String[] args){
        launch(args);
    }
}
