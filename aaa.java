import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author zoranpavlovic.blogspot.com
 */
public class aaa extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Load Image");

        StackPane sp = new StackPane();
        Image img = new Image("file:///C:/Users/MOHAMMAD%20AMIN/Desktop/earth.jpg");

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(500);
        imgView.setFitHeight(500);
        sp.getChildren().add(imgView);

        //Adding HBox to the scene
        Scene scene = new Scene(sp);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}