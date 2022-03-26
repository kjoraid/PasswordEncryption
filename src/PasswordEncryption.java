
 
import java.util.ArrayList;
import java.util.Date;

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
 
/*
    This class contains Main and Start methods to be used 
    to design JFX screen.
    Work on start method and use the appropriate  FX objects to design 
    a screen that accepts data from user according  to the design and
    follow these actions:
    A) Save the data into array: 
        1- Each time user insert/delete new line, 
            1.1 Call a method to add/delete this line into/from
                the array.
            1.2 Call another method to display the array 
                on screen in a table view.
    B) Each button should be processed as following:
        1- When User Click on Open File button:
            1.1 Call a method to open the file
            1.2 This method will return an array with data from the file
            1.3 Check the data and then call the method to display the Array content 
        2- When user click on Clear Screen:
            2.1 Confirm from user
            2.2 Clear the array
            2.3 Call the method to clear the screen 
        3- When User Click on Encrypt/Decrypt button
            3.1 Call the Encrypt method and pass the Array of data to it
            3.2 The method will return an array with Encrypt/Decrypt data
            4.2 Call the method to display this table on screen
        4- When User Click on Save button
            4.1 Call the Save method and pass the array to it
            4.1 Confirm to the user that the system saves the file
            4.3 Show the file name on the text field
*/


public class PasswordEncryption extends Application {
    private Date date = new Date();
    private String fileName="";
    // Declaring Two Dimentional Array to store only 5 lines of data
    private String [][] passwordData = new String[5][4];

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
        // This is only a test of calling a method in OpenSave class
        OpenSave opensave = new OpenSave();
        String fileName = opensave.saveFile(date, passwordData, "");

        // This is only a test of calling a method in EncryptDecrypt class
        EncryptDecrypt ed = new EncryptDecrypt();
        try {
            String myEncrypttext = ed.encrypt("Password", "k123");
            System.out.println(myEncrypttext);
            String myDecrypttext = ed.decrypt(myEncrypttext, "k123");
            System.out.println(myDecrypttext);
        } catch (Exception e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }



        // The following code is standard and it should be removed or updated
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[][] getPassworData() {
        return passwordData;
    }

    public void setPassworData(String[][] passwordData) {
        this.passwordData = passwordData;
    }


    
}



