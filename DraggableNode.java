import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Code snippet from www.crazyandcoding.com
 *
 * @author Colt
 *
 */
public class DraggableNode extends Application {

    /**
     * The current x coordinate of the node.
     */
    private double m_nX = 0;

    /**
     * The current y coordinate of the node.
     */
    private double m_nY = 0;

    /**
     * The current mouse x coordinate when dragging.
     */
    private double m_nMouseX = 0;

    /**
     * The current mouse y coordinate when dragging.
     */
    private double m_nMouseY = 0;

    /**
     * The node that will be draggable.
     */
    private Group m_draggableNode;

    @Override
    public void start(Stage primaryStage) throws Exception {
        m_draggableNode = new Group();

        // create a rectangle to be displayed.
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(95);
        rectangle.setHeight(55);
        rectangle.setFill(Color.CHARTREUSE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);

        m_draggableNode.getChildren().add(rectangle);

        // add the event handlers to the mouse events.
        m_draggableNode.setOnMousePressed(pressMouse());
        m_draggableNode.setOnMouseDragged(dragMouse());

        // add the draggable node to the root.
        Group root = new Group();

        root.getChildren().add(m_draggableNode);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Draggable Node");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Creates an event handler that handles a mouse press on the node.
     *
     * @return the event handler.
     */
    private EventHandler<MouseEvent> pressMouse() {
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
    private EventHandler<MouseEvent> dragMouse() {
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

    public static void main(String[] args) {
        launch(args);
    }
}