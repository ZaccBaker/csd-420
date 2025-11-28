import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        Circle circle_001 = new Circle(100.0f, 100.0f, 50.f);
        circle_001.getStyleClass().add("circle-general");
        Circle circle_002 = new Circle(100.0f, 100.0f, 50.f);
        circle_002.getStyleClass().add("circle-general");
        Circle circle_003 = new Circle(100.0f, 100.0f, 50.f);
        circle_003.setId("circle-red");
        Circle circle_004 = new Circle(100.0f, 100.0f, 50.f);
        circle_004.setId("circle-green");

        StackPane pane = new StackPane();
        pane.getChildren().add(circle_001);

        HBox root = new HBox();
        root.getChildren().addAll(pane,circle_002,circle_003,circle_004);

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("Zac Baker M7 Assignment");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
