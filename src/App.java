
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 



public class App extends Application {
    public static void main(String[] args) {
        //System.out.println(args);
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        /*
            Step-1: Set title for the parameter(Stage)
            Step-2: 
                Create Button object
                Set text for the button
                set action for the button
                override handle method
            Step-3
                Define a root from StackPan
                add button to the root using getChildren.add method
            Step-4
                Stage.setScene(new scene(root, 250, 250))
                Stage.show()
        */
 
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!"+ event);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        // ----
        Stage secondStage = new Stage();
        secondStage.setTitle("Second Window");
        Button btn2 = new Button();
        btn2.setText("Say 'Second Button'");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Second Button");
            }
        });
        
        StackPane root1 = new StackPane();
        root1.getChildren().add(btn2);
        secondStage.setScene(new Scene(root1, 500, 350));
        secondStage.show();
    }
}

