import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class xasdsa extends Application{


    /**
     * The current x coordinate of the node.
     */
    public double m_nX = 0;

    /**
     * The current y coordinate of the node.
     */
    public double m_nY = 0;

    /**
     * The current mouse x coordinate when dragging.
     */
    public double m_nMouseX = 0;

    /**
     * The current mouse y coordinate when dragging.
     */
    public double m_nMouseY = 0;

    /**
     * The node that will be draggable.
     */
    public HBox m_draggableNode;



    public static void main(String[] args){

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Hi!");
        Button button1 = new Button("Bye");

        BorderPane borderPane = new BorderPane();



        CheckBox checkBox = new CheckBox("Ract");

        checkBox.setTranslateY(50);

        Button button3 = new Button("Rect");

        Button button2 = new Button("print");
        button2.setTranslateY(100);

        //button.setTranslateX(250);
        //button.setPrefWidth(100);
        button3.setPrefWidth(100);
        Line line = new Line(100, -50, 0, 100);
        Rectangle rectangle = new Rectangle(50, 100);
        TextField textField = new TextField();
        textField.setTranslateY(250);

        TextField textField1 = new TextField();
        textField1.setTranslateY(250);

        textField1.setTranslateY(200);

        button3.setTranslateY(150);

        HBox root = new HBox();

        HBox root1 = new HBox();

        root.getChildren().addAll(button , button1 , textField , button2 , button3 , textField1 , checkBox);


        HBox hBox = new HBox();


        Arc arc = new Arc(0, 0, 50, 100, 0, 90);
        arc.setType(ArcType.ROUND);

        HBox hBox1 = new HBox();
        hBox.setSpacing(20);
        hBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        hBox1.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();

        hBox.getChildren().addAll(hBox2,hBox3);

        hBox2.setSpacing(20);
        hBox2.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        hBox3.setSpacing(20);
        hBox3.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");


        hBox2.setPadding(new Insets(20 ,20 , 20 ,20));
        hBox3.setPadding(new Insets(20 ,20 , 20 ,20));

        hBox2.setMinWidth(50);
        hBox3.setMinWidth(50);

        hBox.setSpacing(20);

        hBox1.setSpacing(20);

        hBox.setMinWidth(200);

        borderPane.setPadding(new Insets(20 ,20 , 20 ,20));

        borderPane.setLeft(hBox);

        borderPane.setCenter(hBox1);

        VBox vbox = new VBox();

        borderPane.setBottom(vbox);

        VBox vbox1 = new VBox();

        VBox vbox2 = new VBox();
        vbox1.setSpacing(20);
        vbox1.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        vbox2.setSpacing(20);
        vbox2.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");


        vbox1.setPadding(new Insets(20 ,20 , 20 ,20));
        vbox2.setPadding(new Insets(20 ,20 , 20 ,20));
vbox1.setMinHeight(100);
        vbox2.setMinHeight(100);
        vbox.getChildren().addAll(vbox1,vbox2);










        Scene scene = new Scene(borderPane , 800, 800);


        primaryStage.setScene(scene);
        button1.setOnAction(e -> System.exit(0));


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hi");
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(textField.getText());
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(checkBox.isSelected()){

                    m_draggableNode = new HBox();

                    String a = textField.getText();

                    String b = textField1.getText();

                    int width = Integer.parseInt(a);

                    int height = Integer.parseInt(b);

                    Rectangle rectangle1 = new Rectangle(width , height);



                    m_draggableNode.getChildren().add(rectangle1);

                    m_draggableNode.setOnMousePressed(pressMouse());
                    m_draggableNode.setOnMouseDragged(dragMouse());

                    root.getChildren().add(m_draggableNode);
                }


            }
        });


        primaryStage.show();

    }



    public EventHandler<MouseEvent> pressMouse() {
        EventHandler<MouseEvent> mousePressHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    // get the current mouse coordinates according to the scene.
                    m_nMouseX = event.getSceneX();
                    m_nMouseY = event.getSceneY();

                    // get the current coordinates of the draggable node.
                    m_nX = m_draggableNode.getLayoutX();
                    m_nY = m_draggableNode.getLayoutY();
                }
            }
        };

        return mousePressHandler;
    }

    /**
     * Creates an event handler that handles a mouse drag on the node.
     *
     * @return the event handler.
     */
    public EventHandler<MouseEvent> dragMouse() {
        EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    // find the delta coordinates by subtracting the new mouse
                    // coordinates with the old.
                    double deltaX = event.getSceneX() - m_nMouseX;
                    double deltaY = event.getSceneY() - m_nMouseY;

                    // add the delta coordinates to the node coordinates.
                    m_nX += deltaX;
                    m_nY += deltaY;

                    // set the layout for the draggable node.
                    m_draggableNode.setLayoutX(m_nX);
                    m_draggableNode.setLayoutY(m_nY);

                    // get the latest mouse coordinate.
                    m_nMouseX = event.getSceneX();
                    m_nMouseY = event.getSceneY();

                }
            }
        };
        return dragHandler;
    }
}
