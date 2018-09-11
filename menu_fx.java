import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class menu_fx extends Application{


    private static final javafx.scene.text.Font FONT = Font.font("", FontWeight.BOLD, 24);

    private static final javafx.scene.text.Font FONT1 = Font.font("System", FontWeight.BOLD , FontPosture.ITALIC, 24);

    private VBox menuBox;
    private VBox menuBox1;
    private int currentItem = 0;

    private int x;
    private int y;

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();


    @Override
    public void start(Stage primaryStage) throws Exception {




        BorderPane borferPane = new BorderPane();

        Image image = new Image("bomberman.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

        borferPane.setCenter(imageView);



        MenuItem itemExit = new MenuItem("EXIT");
        itemExit.setOnActivate(() -> System.exit(0));

        MenuItem oneplayer = new MenuItem("ONE PLAYER");
        MenuItem twoplayer = new MenuItem("TWO PLAYER");
        MenuItem online = new MenuItem("ONLINE");
        MenuItem save = new MenuItem("SAVE");
        MenuItem load = new MenuItem("LOAD");
        MenuItem option = new MenuItem("OPTION");

        TextField width_text = new TextField("1250");
        TextField height_text = new TextField("800");

        Label width_lable = new Label("Width :  ");
        Label height_lable = new Label("Height :  ");

        HBox width_box = new HBox();
        HBox height_box = new HBox();

        height_box.getChildren().addAll(height_lable , height_text);
        width_box.getChildren().addAll(width_lable,width_text);

        VBox size = new VBox();
        size.getChildren().addAll(width_box,height_box);
        //borferPane.setTop(size);




        width_text.setMinWidth(50);
        height_text.setMinWidth(50);
        width_lable.setMinWidth(50);
        height_lable.setMinWidth(50);



        String xx = width_text.getText();
        String yy = height_text.getText();

        x = Integer.parseInt(xx);
        y = Integer.parseInt(yy);

        oneplayer.setOnActivate(() -> {

            new Map(x,y);
        });

        option.setOnActivate(() -> {

            VBox vBox = new VBox();

            Button button = new Button("EXIT");
            vBox.getChildren().addAll(width_box, height_box,button);

            Stage stage = new Stage();
            stage.setTitle("OPTIONS");
            stage.setScene(new Scene(vBox, 450, 450));
            stage.show();

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    String xx = width_text.getText();
                    String yy = height_text.getText();

                    x = Integer.parseInt(xx);
                    y = Integer.parseInt(yy);

                    stage.close();

                }
            });



        });

        menuBox = new VBox(20,
                oneplayer,
                twoplayer,
                online,
                save,
                load,
                option,
                itemExit

        );

        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(360);
        menuBox.setTranslateY(150);

        Text about = new Text("BomberMan\n\tby\n    Mohammadamin Roohi");
        about.setTranslateX(50);
        about.setTranslateY(700);
        about.setFill(Color.CADETBLUE);
        about.setFont(FONT1);
        //about.setOpacity(0.2);


        getMenuItem(0).setActive(true);

        borferPane.getChildren().addAll(menuBox, about);


        Scene scene = new Scene(borferPane);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (currentItem > 0) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(--currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.DOWN) {
                if (currentItem < menuBox.getChildren().size() - 1) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(++currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.ENTER) {
                getMenuItem(currentItem).activate();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            bgThread.shutdownNow();
        });










        primaryStage.show();

        imageView.fitWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }





    private MenuItem getMenuItem(int index) {
        return (MenuItem)menuBox.getChildren().get(index);
    }

    static class MenuItem extends HBox {
        private TriCircle c1 = new TriCircle(), c2 = new TriCircle();
        private Text text;
        private Runnable script;

        public MenuItem(String name) {
            super(15);
            setAlignment(Pos.CENTER);

            text = new Text(name);
            text.setFont(FONT);
            text.setEffect(new GaussianBlur(2));

            getChildren().addAll(c1, text, c2);
            setActive(false);
            setOnActivate(() -> System.out.println(name + " activated"));
        }

        public void setActive(boolean b) {
            c1.setVisible(b);
            c2.setVisible(b);
            text.setFill(b ? Color.BLUEVIOLET : Color.BLACK);
        }

        public void setOnActivate(Runnable r) {
            script = r;
        }

        public void activate() {
            if (script != null)
                script.run();
        }
    }

    private static class TriCircle extends Parent {
        public TriCircle() {
            javafx.scene.shape.Shape shape1 = javafx.scene.shape.Shape.subtract(new Circle(10), new Circle(7));
            shape1.setFill(Color.BLUEVIOLET);

            javafx.scene.shape.Shape shape2 = javafx.scene.shape.Shape.subtract(new Circle(10), new Circle(7));
            shape2.setFill(Color.BLUEVIOLET);
            shape2.setTranslateX(5);

            javafx.scene.shape.Shape shape3 = Shape.subtract(new Circle(10), new Circle(7));
            shape3.setFill(Color.BLUEVIOLET);
            shape3.setTranslateX(2.5);
            shape3.setTranslateY(-5);

            getChildren().addAll(shape1, shape2, shape3);

            setEffect(new GaussianBlur(2));
        }
    }

}