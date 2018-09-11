import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Arc arc = new Arc(0, 0, 50, 100, 0, 90);
        arc.setFill(Color.GRAY);
        arc.setStroke(Color.BLACK);
        arc.setType(ArcType.ROUND);

        HBox box = new HBox(arc);

        box.setSpacing(10);
        box.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        box.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");


        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();
    }
}