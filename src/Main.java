import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    //TODO: Create a builder class for UI objects
    Board board = new Board();
    Input input = new Input();
    Output output = new Output();
    GridPane mainGrid = new GridPane();
    VBox container = new VBox();
    AnchorPane anchor = new AnchorPane();
    AnchorPane anchorL2 = new AnchorPane();
    TextBuilder t1 = new TextBuilder("Input:");
    TextBuilder t2 = new TextBuilder("Output:");

    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start(Stage primaryStage) {
            //TODO: Call insertCircle through mouseClick
            board.insertCircle("red",1,3);
            board.insertCircle("blue",2,3);
            board.insertCircle("red",1,4);
            board.insertCircle("blue",1,2);

            //TODO: implement a layout builder/manager so they are not all clumped up in main
            //Layout Hierarchy:
                //Grid: main
                    //Grid: board
                    //Anchor: Control
                        //VBox: input
                            //Anchor
                                //Input field
                                //Output field
            //Board
            mainGrid.add(board.getRoot(), 1, 0);

            //btn and boxes
            mainGrid.add(anchor, 2,0);


            //
            anchor.getChildren().addAll(container);
            AnchorPane.setTopAnchor(container, 20.0);
            AnchorPane.setLeftAnchor(container, 20.0);
            //AnchorPane.setRightAnchor(container, 0.0);

            //container
            container.getChildren().addAll(anchorL2);

            //anchorl2
            anchorL2.getChildren().addAll(input.getInput(), t1.getText(), output.getOutput(), t2.getText());
            AnchorPane.setTopAnchor(t1.getText(), 0.0);
            AnchorPane.setTopAnchor(input.getInput(), 30.0);
            AnchorPane.setTopAnchor(t2.getText(), 120.0);
            AnchorPane.setTopAnchor(output.getOutput(), 150.0);


            //Main Scene
            Scene mainScene = new Scene(mainGrid, board.getCOLS() * 50, board.getROWS() * 50);

            //TODO: Start Menu Scene
            Canvas canvas = new Canvas(board.getCOLS() * 100,200);
            GraphicsContext pen = canvas.getGraphicsContext2D();

            Group root = new Group();
            Scene start = new Scene(root);
            root.getChildren().add(canvas);
            start.setRoot(root);

            //Stage
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Connect 4 Assistant");
            primaryStage.show();
            primaryStage.setMinHeight(325);
            primaryStage.setMinWidth(600);
        }
    };