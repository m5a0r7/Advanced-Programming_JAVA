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

public class panel extends Application{


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

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;



    double orgSceneX_rect, orgSceneY_rect;
    double orgTranslateX_rect, orgTranslateY_rect;


    double orgSceneX_line, orgSceneY_line;
    double orgTranslateX_line, orgTranslateY_line;

    double orgSceneX_image, orgSceneY_image;
    double orgTranslateX_image, orgTranslateY_image;


    public static void main(String[] args){

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();
        Button rect_button = new Button("Rectangle");
        Button circle_button = new Button("Circle");
        Button line_button = new Button("Line");
        Button image_button = new Button("Image");

        VBox shapes = new VBox();
        VBox rect = new VBox();
        VBox circle = new VBox();
        VBox image = new VBox();
        VBox line = new VBox();


        circle.setPrefSize(180 , 150);
        line.setPrefSize(180 , 150);
        rect.setPrefSize(180 , 150);
        image.setPrefSize(180 , 150);
        shapes.setMinHeight(600);



        VBox properties = new VBox();
        HBox show = new HBox();
        HBox animate = new HBox();

        borderPane.setLeft(shapes);
        shapes.setMinWidth(200);
        shapes.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");


        shapes.setPadding(new Insets(5 ,5 , 5 ,5));
        shapes.getChildren().addAll(rect,circle,image,line);

        rect.setMinHeight(100);
        rect.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: green;");
        circle.setMinHeight(100);
        circle.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: green;");

        line.setMinHeight(100);
        line.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: green;");
        image.setMinHeight(100);
        image.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: green;");


        borderPane.setCenter(show);

        show.setMinWidth(400);
        show.setMinHeight(400);

        show.setMinHeight(100);
        show.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: red;");

        //borderPane.setRight(properties);
        properties.setMinWidth(100);

        properties.setMinHeight(100);
        properties.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: yellow;");


        borderPane.setBottom(animate);

        animate.setMinHeight(100);
        animate.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");

        animate.setMinHeight(175);

        VBox transition_box = new VBox();
        VBox shape_transition_box = new VBox();
        VBox move_box = new VBox();
        VBox shape_move_box = new VBox();

        transition_box.setMinWidth(200);
        shape_transition_box.setMaxWidth(100);
        move_box.setMinWidth(200);
        shape_move_box.setMaxWidth(100);

        HBox setDuration_box = new HBox();
        HBox setDuration_box_move = new HBox();

        HBox set_ratio_box = new HBox();
        HBox set_move_directional_box = new HBox();


        HBox setAutoReverse_box = new HBox();
        HBox setAutoReverse_box_move = new HBox();

        Label tr = new Label("Transition");
        Label tr_move = new Label("Move");

        Label set_duration_label = new Label("Duration : ");
        Label set_duration_label_move = new Label("Duration : ");


        Label set_x_ratio_label = new Label("X_rat : ");
        Label set_x_along_label_move = new Label("X_along : ");

        Label set_y_ratio_label = new Label("Y_rat : ");
        Label set_y_along_label_move = new Label("Y_along : ");

        Label set_AutoReverse_lable = new Label("AutoReverse ");
        Label set_AutoReverse_lable_move = new Label("AutoReverse ");

        TextField set_duration_textfield = new TextField("1000");
        set_duration_textfield.setPrefColumnCount(4);
        TextField set_duration_textfield_move = new TextField("1000");
        set_duration_textfield_move.setPrefColumnCount(4);


        TextField x_ratio = new TextField("1");
        x_ratio.setPrefColumnCount(2);
        TextField x_along = new TextField("200");
        x_along.setPrefColumnCount(2);

        TextField y_ratio = new TextField("1");
        y_ratio.setPrefColumnCount(2);
        TextField y_along = new TextField("200");
        y_along.setPrefColumnCount(2);

        CheckBox set_AutoReverse_checkbox = new CheckBox();
        CheckBox set_AutoReverse_checkbox_move = new CheckBox();

        set_ratio_box.setPadding(new Insets(5 ,5 , 5 ,5));
        set_ratio_box.getChildren().addAll(set_x_ratio_label , x_ratio , set_y_ratio_label , y_ratio);
        set_move_directional_box.setPadding(new Insets(5 ,5 , 5 ,5));
        set_move_directional_box.getChildren().addAll(set_x_along_label_move , x_along , set_y_along_label_move , y_along);


        setAutoReverse_box.setPadding(new Insets(5 ,5 , 5 ,5));
        setAutoReverse_box.getChildren().addAll(set_AutoReverse_lable , set_AutoReverse_checkbox);
        setAutoReverse_box_move.setPadding(new Insets(5 ,5 , 5 ,5));
        setAutoReverse_box_move.getChildren().addAll(set_AutoReverse_lable_move , set_AutoReverse_checkbox_move);

        setDuration_box.setPadding(new Insets(5 ,5 , 5 ,5));
        setDuration_box.getChildren().addAll(set_duration_label , set_duration_textfield);
        setDuration_box_move.setPadding(new Insets(5 ,5 , 5 ,5));
        setDuration_box_move.getChildren().addAll(set_duration_label_move , set_duration_textfield_move);



        HBox rect_tr_box = new HBox();
        Label rect_tr_lable = new Label("Rect_Transition : ");
        CheckBox rect_tr_checkbox = new CheckBox();
        rect_tr_box.getChildren().addAll(rect_tr_lable , rect_tr_checkbox);
        HBox rect_tr_box_move = new HBox();
        Label rect_tr_lable_move = new Label("Rect_Move : ");
        CheckBox rect_tr_checkbox_move = new CheckBox();
        rect_tr_box_move.getChildren().addAll(rect_tr_lable_move , rect_tr_checkbox_move);

        HBox circle_tr_box = new HBox();
        Label circle_tr_lable = new Label("Circle_Transition : ");
        CheckBox circle_tr_checkbox = new CheckBox();
        circle_tr_box.getChildren().addAll(circle_tr_lable , circle_tr_checkbox);
        HBox circle_tr_box_move = new HBox();
        Label circle_tr_lable_move = new Label("Circle_Move : ");
        CheckBox circle_tr_checkbox_move = new CheckBox();
        circle_tr_box_move.getChildren().addAll(circle_tr_lable_move , circle_tr_checkbox_move);

        HBox line_tr_box = new HBox();
        Label line_tr_lable = new Label("Line_Transition : ");
        CheckBox line_tr_checkbox = new CheckBox();
        line_tr_box.getChildren().addAll(line_tr_lable , line_tr_checkbox);
        HBox line_tr_box_move = new HBox();
        Label line_tr_lable_move = new Label("Line_Move : ");
        CheckBox line_tr_checkbox_move = new CheckBox();
        line_tr_box_move.getChildren().addAll(line_tr_lable_move , line_tr_checkbox_move);

        HBox image_tr_box = new HBox();
        Label image_tr_lable = new Label("Image_Transition : ");
        CheckBox image_tr_checkbox = new CheckBox();
        image_tr_box.getChildren().addAll(image_tr_lable , image_tr_checkbox);
        HBox image_tr_box_move = new HBox();
        Label image_tr_lable_move = new Label("Image_Move : ");
        CheckBox image_tr_checkbox_move = new CheckBox();
        image_tr_box_move.getChildren().addAll(image_tr_lable_move , image_tr_checkbox_move);



        transition_box.setPadding(new Insets(5 ,5 , 5 ,5));
        transition_box.getChildren().addAll(tr,setDuration_box , setAutoReverse_box , set_ratio_box);
        move_box.setPadding(new Insets(5 ,5 , 5 ,5));
        move_box.getChildren().addAll(tr_move,setDuration_box_move , setAutoReverse_box_move , set_move_directional_box);



        transition_box.setMinHeight(100);
        transition_box.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: PINK;");

        move_box.setMinHeight(100);
        move_box.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: PINK;");





        circle_tr_box.setPadding(new Insets(5 ,5 , 5 ,5));
        line_tr_box.setPadding(new Insets(5 ,5 , 5 ,5));
        rect_tr_box.setPadding(new Insets(5 ,5 , 5 ,5));
        image_tr_box.setPadding(new Insets(5 ,5 , 5 ,5));
        circle_tr_box_move.setPadding(new Insets(5 ,5 , 5 ,5));
        line_tr_box_move.setPadding(new Insets(5 ,5 , 5 ,5));
        rect_tr_box_move.setPadding(new Insets(5 ,5 , 5 ,5));
        image_tr_box_move.setPadding(new Insets(5 ,5 , 5 ,5));


        rect_tr_box.setMinWidth(200);
        circle_tr_box.setMinWidth(200);
        line_tr_box.setMinWidth(200);
        shape_transition_box.setMinWidth(200);
        shape_transition_box.setPadding(new Insets(5 ,5 , 5 ,5));
        shape_transition_box.getChildren().addAll(rect_tr_box , circle_tr_box , line_tr_box , image_tr_box);
        rect_tr_box_move.setMinWidth(200);
        circle_tr_box_move.setMinWidth(200);
        line_tr_box_move.setMinWidth(200);
        shape_move_box.setMinWidth(200);
        shape_move_box.setPadding(new Insets(5 ,5 , 5 ,5));
        shape_move_box.getChildren().addAll(rect_tr_box_move , circle_tr_box_move , line_tr_box_move , image_tr_box_move);


        shape_transition_box.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: PINK;");

        shape_move_box.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: PINK;");




        animate.getChildren().addAll(transition_box , shape_transition_box , move_box , shape_move_box);


        HBox rect_b = new HBox();
        rect_b.getChildren().addAll(rect_button);

        HBox circle_b = new HBox();
        circle_b.getChildren().addAll(circle_button);

        HBox line_b = new HBox();
        line_b.getChildren().addAll(line_button);

        HBox image_b = new HBox();
        image_b.getChildren().addAll(image_button);


        TextField rect_width = new TextField();
        TextField rect_height = new TextField();

        rect_width.setPrefColumnCount(4);
        rect_height.setPrefColumnCount(4);

        HBox rect_width1 = new HBox();

        Label width = new Label("Width : ");

        HBox rect_height1 = new HBox();

        Label height = new Label("Height :  ");

        rect_width1.getChildren().addAll(width , rect_width);

        rect_height1.getChildren().addAll(height , rect_height);

        rect_height1.setPadding(new Insets(5 ,5 , 5 ,5));

        rect_width1.setPadding(new Insets(5 ,5 , 5 ,5));

        HBox rect_checkbox = new HBox();

        CheckBox rect_check = new CheckBox();

        Label rect_check1_lable = new Label("Enable  ");

        rect_checkbox.getChildren().addAll(rect_check1_lable , rect_check);

        rect_checkbox.setPadding(new Insets(5 ,5 , 5 ,5));

        rect.getChildren().addAll(rect_b,rect_height1,rect_width1 , rect_checkbox);






        TextField start_x_textfield = new TextField();
        TextField start_y_textfield = new TextField();

        start_x_textfield.setPrefColumnCount(2);
        start_y_textfield.setPrefColumnCount(2);

        TextField end_x_textfield = new TextField();
        TextField end_y_textfield = new TextField();

        end_x_textfield.setPrefColumnCount(2);
        end_y_textfield.setPrefColumnCount(2);

        HBox start_box = new HBox();

        Label start_x_lable = new Label("X1 : ");
        Label start_y_lable = new Label("Y1 : ");

        HBox end_box = new HBox();

        Label end_x_lable = new Label("X2 : ");
        Label end_y_lable = new Label("Y2 : ");

        start_box.getChildren().addAll(start_x_lable , start_x_textfield , start_y_lable , start_y_textfield);

        end_box.getChildren().addAll(end_x_lable , end_x_textfield , end_y_lable , end_y_textfield);

        start_box.setPadding(new Insets(5 ,5 , 5 ,5));

        end_box.setPadding(new Insets(5 ,5 , 5 ,5));

        HBox line_checkbox = new HBox();

        CheckBox line_check = new CheckBox();

        Label line_check1_lable = new Label("Enable  ");

        line_checkbox.getChildren().addAll(line_check1_lable , line_check);

        line_checkbox.setPadding(new Insets(5 ,5 , 5 ,5));

        line.getChildren().addAll(line_b,start_box,end_box , line_checkbox);




        TextField radius = new TextField();
        TextField centre_y = new TextField();
        TextField centre_x = new TextField();


        radius.setPrefColumnCount(4);
        centre_x.setPrefColumnCount(2);
        centre_y.setPrefColumnCount(2);

        HBox centre_box = new HBox();

        Label centre_x_lable = new Label("X : ");
        Label centre_y_lable = new Label("Y : ");

        HBox radius_box = new HBox();

        Label radius_lable = new Label("Radius :  ");

        centre_box.getChildren().addAll(centre_x_lable , centre_x , centre_y_lable , centre_y);

        radius_box.getChildren().addAll(radius_lable , radius);

        radius_box.setPadding(new Insets(5 ,5 , 5 ,5));

        centre_box.setPadding(new Insets(5 ,5 , 5 ,5));

        HBox circle_checkbox = new HBox();

        CheckBox circle_check = new CheckBox();

        Label circle_check1_lable = new Label("Enable  ");

        circle_checkbox.getChildren().addAll(circle_check1_lable , circle_check);

        circle_checkbox.setPadding(new Insets(5 ,5 , 5 ,5));

        circle.getChildren().addAll(circle_b,centre_box,radius_box , circle_checkbox);



        HBox image_checkbox_box_earth = new HBox();
        Label image_check1_lable_earth = new Label("Earth  ");
        CheckBox image_checkbox_earth = new CheckBox();
        image_checkbox_box_earth.getChildren().addAll(image_check1_lable_earth,image_checkbox_earth);
        image_checkbox_box_earth.setPadding(new Insets(2 ,2 , 2 ,2));

        HBox image_checkbox_box_airplane = new HBox();
        Label image_check1_lable_airplane = new Label("Airplane  ");
        CheckBox image_checkbox_airplane = new CheckBox();
        image_checkbox_box_airplane.getChildren().addAll(image_check1_lable_airplane,image_checkbox_airplane);
        image_checkbox_box_airplane.setPadding(new Insets(2 ,2 , 2 ,2));

        HBox image_checkbox_box_car = new HBox();
        Label image_check1_lable_car = new Label("Car  ");
        CheckBox image_checkbox_car = new CheckBox();
        image_checkbox_box_car.getChildren().addAll(image_check1_lable_car,image_checkbox_car);
        image_checkbox_box_car.setPadding(new Insets(2 ,2 , 2 ,2));

        HBox image_checkbox_box_ocean = new HBox();
        Label image_check1_lable_ocean = new Label("Ocean  ");
        CheckBox image_checkbox_ocean = new CheckBox();
        image_checkbox_box_ocean.getChildren().addAll(image_check1_lable_ocean,image_checkbox_ocean);
        image_checkbox_box_ocean.setPadding(new Insets(2 ,2 , 2 ,2));





        Image image1 = new Image("file:///C:/Users/MOHAMMAD%20AMIN/Desktop/earth.jpg");
        image.getChildren().addAll(image_b , image_checkbox_box_earth , image_checkbox_box_airplane , image_checkbox_box_car , image_checkbox_box_ocean);
        ImageView imageView = new ImageView(image1);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        image_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(image_checkbox_earth.isSelected()) {

                    Image image1 = new Image("file:///C:/Users/MOHAMMAD%20AMIN/Desktop/earth.jpg");
                    ImageView imageView = new ImageView(image1);
                    imageView.setFitHeight(200);
                    imageView.setFitWidth(200);

                    imageView.setCursor(Cursor.HAND);

                    if (image_tr_checkbox.isSelected()) {
                        String dur = set_duration_textfield.getText();
                        String x_rat = x_ratio.getText();
                        String y_rat = y_ratio.getText();

                        int t = Integer.parseInt(dur);
                        int x_rati = Integer.parseInt(x_rat);
                        int y_rati = Integer.parseInt(y_rat);


                        ScaleTransition scaleTransition = new ScaleTransition();

                        scaleTransition.setDuration(Duration.millis(t));
                        scaleTransition.setNode(imageView);
                        scaleTransition.setByY(x_rati);
                        scaleTransition.setByX(y_rati);
                        scaleTransition.setCycleCount(50);
                        scaleTransition.setAutoReverse(set_AutoReverse_checkbox.isSelected());
                        scaleTransition.play();
                    }


                    if (image_tr_checkbox_move.isSelected()) {
                        String dur_move = set_duration_textfield_move.getText();
                        String x_rat_move = x_along.getText();
                        String y_rat_move = y_along.getText();

                        int t = Integer.parseInt(dur_move);
                        int x_rati_move = Integer.parseInt(x_rat_move);
                        int y_rati_move = Integer.parseInt(y_rat_move);


                        TranslateTransition translateTransition = new TranslateTransition();

                        translateTransition.setDuration(Duration.millis(t));
                        translateTransition.setNode(imageView);
                        translateTransition.setByY(x_rati_move);
                        translateTransition.setByX(y_rati_move);
                        translateTransition.setCycleCount(20);
                        translateTransition.setAutoReverse(set_AutoReverse_checkbox_move.isSelected());
                        translateTransition.play();
                    }
                    show.getChildren().addAll(imageView);
                }

                    if(image_checkbox_airplane.isSelected()) {

                        Image image2 = new Image("file:///C:/Users/MOHAMMAD%20AMIN/Desktop/airplane.jpg");
                        ImageView imageView1 = new ImageView(image2);
                        imageView1.setFitHeight(200);
                        imageView1.setFitWidth(200);

                        imageView1.setCursor(Cursor.HAND);

                        if (image_tr_checkbox.isSelected()) {
                            String dur = set_duration_textfield.getText();
                            String x_rat = x_ratio.getText();
                            String y_rat = y_ratio.getText();

                            int t = Integer.parseInt(dur);
                            int x_rati = Integer.parseInt(x_rat);
                            int y_rati = Integer.parseInt(y_rat);


                            ScaleTransition scaleTransition = new ScaleTransition();

                            scaleTransition.setDuration(Duration.millis(t));
                            scaleTransition.setNode(imageView1);
                            scaleTransition.setByY(x_rati);
                            scaleTransition.setByX(y_rati);
                            scaleTransition.setCycleCount(50);
                            scaleTransition.setAutoReverse(set_AutoReverse_checkbox.isSelected());
                            scaleTransition.play();
                        }


                        if (image_tr_checkbox_move.isSelected()) {
                            String dur_move = set_duration_textfield_move.getText();
                            String x_rat_move = x_along.getText();
                            String y_rat_move = y_along.getText();

                            int t = Integer.parseInt(dur_move);
                            int x_rati_move = Integer.parseInt(x_rat_move);
                            int y_rati_move = Integer.parseInt(y_rat_move);


                            TranslateTransition translateTransition = new TranslateTransition();

                            translateTransition.setDuration(Duration.millis(t));
                            translateTransition.setNode(imageView1);
                            translateTransition.setByY(x_rati_move);
                            translateTransition.setByX(y_rati_move);
                            translateTransition.setCycleCount(20);
                            translateTransition.setAutoReverse(set_AutoReverse_checkbox_move.isSelected());
                            translateTransition.play();
                        }
                        show.getChildren().addAll(imageView1);
                    }

                        if(image_checkbox_car.isSelected()) {

                            Image image3 = new Image("file:///C:/Users/MOHAMMAD%20AMIN/Desktop/car.jpg");
                            ImageView imageView2 = new ImageView(image3);
                            imageView2.setFitHeight(200);
                            imageView2.setFitWidth(200);

                            imageView2.setCursor(Cursor.HAND);

                            if (image_tr_checkbox.isSelected()) {
                                String dur = set_duration_textfield.getText();
                                String x_rat = x_ratio.getText();
                                String y_rat = y_ratio.getText();

                                int t = Integer.parseInt(dur);
                                int x_rati = Integer.parseInt(x_rat);
                                int y_rati = Integer.parseInt(y_rat);


                                ScaleTransition scaleTransition = new ScaleTransition();

                                scaleTransition.setDuration(Duration.millis(t));
                                scaleTransition.setNode(imageView2);
                                scaleTransition.setByY(x_rati);
                                scaleTransition.setByX(y_rati);
                                scaleTransition.setCycleCount(50);
                                scaleTransition.setAutoReverse(set_AutoReverse_checkbox.isSelected());
                                scaleTransition.play();
                            }


                            if (image_tr_checkbox_move.isSelected()) {
                                String dur_move = set_duration_textfield_move.getText();
                                String x_rat_move = x_along.getText();
                                String y_rat_move = y_along.getText();

                                int t = Integer.parseInt(dur_move);
                                int x_rati_move = Integer.parseInt(x_rat_move);
                                int y_rati_move = Integer.parseInt(y_rat_move);


                                TranslateTransition translateTransition = new TranslateTransition();

                                translateTransition.setDuration(Duration.millis(t));
                                translateTransition.setNode(imageView2);
                                translateTransition.setByY(x_rati_move);
                                translateTransition.setByX(y_rati_move);
                                translateTransition.setCycleCount(20);
                                translateTransition.setAutoReverse(set_AutoReverse_checkbox_move.isSelected());
                                translateTransition.play();
                            }

                            show.getChildren().addAll(imageView2);
                        }
                            if(image_checkbox_ocean.isSelected()) {

                                Image image4 = new Image("file:///C:/Users/MOHAMMAD%20AMIN/Desktop/ocean.jpg");
                                ImageView imageView3 = new ImageView(image4);
                                imageView3.setFitHeight(200);
                                imageView3.setFitWidth(200);

                                imageView3.setCursor(Cursor.HAND);

                                if (image_tr_checkbox.isSelected()) {
                                    String dur = set_duration_textfield.getText();
                                    String x_rat = x_ratio.getText();
                                    String y_rat = y_ratio.getText();

                                    int t = Integer.parseInt(dur);
                                    int x_rati = Integer.parseInt(x_rat);
                                    int y_rati = Integer.parseInt(y_rat);


                                    ScaleTransition scaleTransition = new ScaleTransition();

                                    scaleTransition.setDuration(Duration.millis(t));
                                    scaleTransition.setNode(imageView3);
                                    scaleTransition.setByY(x_rati);
                                    scaleTransition.setByX(y_rati);
                                    scaleTransition.setCycleCount(50);
                                    scaleTransition.setAutoReverse(set_AutoReverse_checkbox.isSelected());
                                    scaleTransition.play();
                                }


                                if (image_tr_checkbox_move.isSelected()) {
                                    String dur_move = set_duration_textfield_move.getText();
                                    String x_rat_move = x_along.getText();
                                    String y_rat_move = y_along.getText();

                                    int t = Integer.parseInt(dur_move);
                                    int x_rati_move = Integer.parseInt(x_rat_move);
                                    int y_rati_move = Integer.parseInt(y_rat_move);


                                    TranslateTransition translateTransition = new TranslateTransition();

                                    translateTransition.setDuration(Duration.millis(t));
                                    translateTransition.setNode(imageView3);
                                    translateTransition.setByY(x_rati_move);
                                    translateTransition.setByX(y_rati_move);
                                    translateTransition.setCycleCount(20);
                                    translateTransition.setAutoReverse(set_AutoReverse_checkbox_move.isSelected());
                                    translateTransition.play();
                                }
                                show.getChildren().addAll(imageView3);
                            }





            }
        });








        rect_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(rect_check.isSelected()){

                    String a = rect_width.getText();

                    String b = rect_height.getText();

                    int width = Integer.parseInt(a);

                    int height = Integer.parseInt(b);

                    Rectangle rectangle1 = new Rectangle(width , height);

                    rectangle1.setCursor(Cursor.HAND);

                    rectangle1.setOnMousePressed(rectOnMouseDraggedEventHandler);
                    rectangle1.setOnMouseDragged(rectOnMouseDraggedEventHandler);

                    if (rect_tr_checkbox.isSelected()){
                        String dur = set_duration_textfield.getText();
                        String x_rat = x_ratio.getText();
                        String y_rat = y_ratio.getText();

                        int t = Integer.parseInt(dur);
                        int x_rati = Integer.parseInt(x_rat);
                        int y_rati = Integer.parseInt(y_rat);


                        ScaleTransition scaleTransition = new ScaleTransition();

                        scaleTransition.setDuration(Duration.millis(t));
                        scaleTransition.setNode(rectangle1);
                        scaleTransition.setByY(x_rati);
                        scaleTransition.setByX(y_rati);
                        scaleTransition.setCycleCount(50);
                        scaleTransition.setAutoReverse(set_AutoReverse_checkbox.isSelected());
                        scaleTransition.play();
                    }


                    if (rect_tr_checkbox_move.isSelected()){
                        String dur_move = set_duration_textfield_move.getText();
                        String x_rat_move = x_along.getText();
                        String y_rat_move = y_along.getText();

                        int t = Integer.parseInt(dur_move);
                        int x_rati_move = Integer.parseInt(x_rat_move);
                        int y_rati_move = Integer.parseInt(y_rat_move);


                        TranslateTransition translateTransition = new TranslateTransition();

                        translateTransition.setDuration(Duration.millis(t));
                        translateTransition.setNode(rectangle1);
                        translateTransition.setByY(x_rati_move);
                        translateTransition.setByX(y_rati_move);
                        translateTransition.setCycleCount(20);
                        translateTransition.setAutoReverse(set_AutoReverse_checkbox_move.isSelected());
                        translateTransition.play();
                    }

                    show.getChildren().addAll(rectangle1);
                }


            }
        });

/*
        Circle c = new Circle();

        c.setRadius(100);
        c.setCenterY(200);
        c.setCenterX(200);

        show.getChildren().addAll(c);

*/

/*
        Circle cc = new Circle();

        cc.setCenterX(100);
        cc.setCenterY(100);
        cc.setRadius(100);


        ScaleTransition scaleTransition = new ScaleTransition();

        scaleTransition.setDuration(Duration.millis(2000));
        scaleTransition.setNode(cc);
        scaleTransition.setByY(1.5);
        scaleTransition.setByX(1.5);
        scaleTransition.setCycleCount(50);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();



        show.getChildren().addAll(cc);


*/



        circle_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(circle_check.isSelected()){

                    String a = centre_x.getText();

                    String b = centre_y.getText();

                    String c = radius.getText();

                    int x = Integer.parseInt(a);

                    int y = Integer.parseInt(b);

                    int rad = Integer.parseInt(c);

                    Circle circle1 = new Circle(rad , Color.BLUE);

                    circle1.setCenterX(x);
                    circle1.setCenterY(y);
                    circle1.setRadius(rad);



                    circle1.setCursor(Cursor.HAND);

                    circle1.setOnMousePressed(circleOnMousePressedEventHandler);
                    circle1.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                    if (circle_tr_checkbox.isSelected()){
                        String dur = set_duration_textfield.getText();
                        String x_rat = x_ratio.getText();
                        String y_rat = y_ratio.getText();

                        int t = Integer.parseInt(dur);
                        int x_rati = Integer.parseInt(x_rat);
                        int y_rati = Integer.parseInt(y_rat);


                        ScaleTransition scaleTransition = new ScaleTransition();

                        scaleTransition.setDuration(Duration.millis(t));
                        scaleTransition.setNode(circle1);
                        scaleTransition.setByY(x_rati);
                        scaleTransition.setByX(y_rati);
                        scaleTransition.setCycleCount(50);
                        scaleTransition.setAutoReverse(set_AutoReverse_checkbox.isSelected());
                        scaleTransition.play();
                    }

                    if (circle_tr_checkbox_move.isSelected()){
                        String dur_move = set_duration_textfield_move.getText();
                        String x_rat_move = x_along.getText();
                        String y_rat_move = y_along.getText();

                        int t = Integer.parseInt(dur_move);
                        int x_rati_move = Integer.parseInt(x_rat_move);
                        int y_rati_move = Integer.parseInt(y_rat_move);


                        TranslateTransition translateTransition = new TranslateTransition();

                        translateTransition.setDuration(Duration.millis(t));
                        translateTransition.setNode(circle1);
                        translateTransition.setByY(x_rati_move);
                        translateTransition.setByX(y_rati_move);
                        translateTransition.setCycleCount(20);
                        translateTransition.setAutoReverse(set_AutoReverse_checkbox_move.isSelected());
                        translateTransition.play();
                    }

                    show.getChildren().addAll(circle1);
                }


            }
        });




        line_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(line_check.isSelected()){

                    String a = start_x_textfield.getText();

                    String b = start_y_textfield.getText();

                    String c = end_x_textfield.getText();

                    String d = end_y_textfield.getText();

                    int x1 = Integer.parseInt(a);
                    int y1 = Integer.parseInt(b);
                    int x2 = Integer.parseInt(c);
                    int y2 = Integer.parseInt(c);

                    Line line1 = new Line();

                    line1.setStartX(x1);
                    line1.setStartY(y1);
                    line1.setEndX(x2);
                    line1.setEndY(y2);
                    line1.setStrokeWidth(10);
                    line1.setStroke(Color.RED);
                    line1.setCursor(Cursor.HAND);


                    line1.setOnMousePressed(lineOnMouseDraggedEventHandler);
                    line1.setOnMouseDragged(lineOnMouseDraggedEventHandler);
                    if (line_tr_checkbox.isSelected()){
                        String dur = set_duration_textfield.getText();
                        String x_rat = x_ratio.getText();
                        String y_rat = y_ratio.getText();

                        int t = Integer.parseInt(dur);
                        int x_rati = Integer.parseInt(x_rat);
                        int y_rati = Integer.parseInt(y_rat);


                        ScaleTransition scaleTransition = new ScaleTransition();

                        scaleTransition.setDuration(Duration.millis(t));
                        scaleTransition.setNode(line1);
                        scaleTransition.setByY(x_rati);
                        scaleTransition.setByX(y_rati);
                        scaleTransition.setCycleCount(50);
                        scaleTransition.setAutoReverse(set_AutoReverse_checkbox.isSelected());
                        scaleTransition.play();
                    }

                    if (line_tr_checkbox_move.isSelected()){
                        String dur_move = set_duration_textfield_move.getText();
                        String x_rat_move = x_along.getText();
                        String y_rat_move = y_along.getText();

                        int t = Integer.parseInt(dur_move);
                        int x_rati_move = Integer.parseInt(x_rat_move);
                        int y_rati_move = Integer.parseInt(y_rat_move);


                        TranslateTransition translateTransition = new TranslateTransition();

                        translateTransition.setDuration(Duration.millis(t));
                        translateTransition.setNode(line1);
                        translateTransition.setByY(x_rati_move);
                        translateTransition.setByX(y_rati_move);
                        translateTransition.setCycleCount(20);
                        translateTransition.setAutoReverse(set_AutoReverse_checkbox_move.isSelected());
                        translateTransition.play();
                    }
                    show.getChildren().addAll(line1);
                }


            }
        });



        Button clear = new Button("Clear_Show_Pane");
        clear.setPrefWidth(150);
        clear.setTranslateY(560);
        show.getChildren().addAll(clear);

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.getChildren().clear();
                show.getChildren().addAll(clear);
            }
        });









        Button button = new Button("Hi!");
        Button button1 = new Button("Bye");

        CheckBox checkBox = new CheckBox("Ract");

        checkBox.setTranslateY(50);

        Button button3 = new Button("Rect");

        Button button2 = new Button("print");
        button2.setTranslateY(100);

        //button.setTranslateX(250);
        //button.setPrefWidth(100);
        button3.setPrefWidth(100);

        Rectangle rectangle = new Rectangle(50, 100);
        TextField textField = new TextField();
        textField.setTranslateY(250);



        TextField textField1 = new TextField();
        textField1.setTranslateY(250);

        textField1.setTranslateY(200);

        button3.setTranslateY(150);

        Group root = new Group();

        HBox root1 = new HBox();

        root.getChildren().addAll(button , button1 , textField , button2 , button3 , textField1 , checkBox);



        Scene scene = new Scene(borderPane , 900 , 800);


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
























    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Circle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };








    EventHandler<MouseEvent> rectOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX_rect = t.getSceneX();
                    orgSceneY_rect = t.getSceneY();
                    orgTranslateX_rect = ((Rectangle)(t.getSource())).getTranslateX();
                    orgTranslateY_rect = ((Rectangle)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> rectOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX_rect - 280;
                    double offsetY = t.getSceneY() - orgSceneY_rect -50;
                    double newTranslateX = orgTranslateX_rect + offsetX;
                    double newTranslateY = orgTranslateY_rect + offsetY;

                    ((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };










    EventHandler<MouseEvent> lineOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX_line = t.getSceneX();
                    orgSceneY_line = t.getSceneY();
                    orgTranslateX_line = ((Line)(t.getSource())).getTranslateX();
                    orgTranslateY_line = ((Line)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> lineOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX_line-280;
                    double offsetY = t.getSceneY() - orgSceneY_line-50;
                    double newTranslateX = orgTranslateX_line + offsetX;
                    double newTranslateY = orgTranslateY_line + offsetY;

                    ((Line)(t.getSource())).setTranslateX(newTranslateX);
                    ((Line)(t.getSource())).setTranslateY(newTranslateY);
                }
            };


}
