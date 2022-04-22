
 
import java.util.Date;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
/*
    This class contains Main and Start methods to be used 
    to design JFX screen.
    Work on start method and use the appropriate FX objects to design 
    a screen that accepts data from user according  to the design.
*/
public class PasswordEncryption extends Application {
    private String [][] passwordData = new String[5][4];
    private TextField [][] textFields = new TextField[5][4];
    
    //public String myEncrypttext="";


    public static void main(String[] args) {
        //System.out.println(args);
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        OpenSave opensave = new OpenSave();
        EncryptDecrypt ED = new EncryptDecrypt();
        final String secretKey = "ABCDEFGHIJKLMNOP";

        // The following code is standard and it should be removed or updated
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,50,50,25));
        // First Label and Text Field
 
        Label lblFile = new Label("File Name");
        TextField txtFile = new TextField();
        VBox hbheader = new VBox(5);
        hbheader.setAlignment(Pos.TOP_LEFT);
        hbheader.getChildren().addAll(lblFile, txtFile); 
        grid.add(hbheader,1,0);
        
        // Table Header
        Label lblPwd = new Label("User ID");
        Label lblNote = new Label("Password");
        Label lblUsedIn = new Label("URL");
        Label lblEncrypt = new Label("Notes");
        HBox hbtable = new HBox(125);
        hbheader.setAlignment(Pos.CENTER);
        hbtable.getChildren().addAll(lblPwd,lblNote,lblUsedIn,lblEncrypt); 
        grid.add(hbtable,1,2);
        
         // First row
        HBox hbRow01 = new HBox(10);
        hbRow01.setAlignment(Pos.CENTER);
        for (int i=0;i<4;i++){
            textFields[0][i] = new TextField();
            hbRow01.getChildren().add(textFields[0][i]);
        }
        //textFields[0][3].setDisable(true);
        grid.add(hbRow01,1,3);

        // Second row
        HBox hbRow02 = new HBox(10);
        hbRow02.setAlignment(Pos.CENTER);
        for (int i=0;i<4;i++){
            textFields[1][i] = new TextField();
            hbRow02.getChildren().add(textFields[1][i]);
        }
        //textFields[1][3].setDisable(true);
        grid.add(hbRow02,1,4);

        // Third row
        HBox hbRow03 = new HBox(10);
        hbRow03.setAlignment(Pos.CENTER);
        for (int i=0;i<4;i++){
            textFields[2][i] = new TextField();
            hbRow03.getChildren().add(textFields[2][i]);
        }
        //textFields[2][3].setDisable(true);
        grid.add(hbRow03,1,5);

        // Fourth row
        HBox hbRow04 = new HBox(10);
        hbRow04.setAlignment(Pos.CENTER);
        for (int i=0;i<4;i++){
            textFields[3][i] = new TextField();
            hbRow04.getChildren().add(textFields[3][i]);
        }
        //textFields[3][3].setDisable(true);
        grid.add(hbRow04,1,6);


        // Fourth row
        HBox hbRow05 = new HBox(10);
        hbRow05.setAlignment(Pos.CENTER);
        for (int i=0;i<4;i++){
            textFields[4][i] = new TextField();
            hbRow05.getChildren().add(textFields[4][i]);
        }
        //textFields[4][3].setDisable(true);
        grid.add(hbRow05,1,7);


        Button btnOpen = new Button("Open");
        Button btnNew = new Button("New");
        Button btnSave = new Button("Save");
        btnOpen.setPrefWidth(200);
        btnSave.setPrefWidth(200);
        btnNew.setPrefWidth(200);
        
        // Add all buttons into HBOX
        HBox hbBtn = new HBox(35);
        hbBtn.setAlignment(Pos.BASELINE_LEFT);
        hbBtn.getChildren().addAll(btnOpen, btnSave, btnNew); 
        grid.add(hbBtn,1,8);

        // System Messages Textbox
        Label lblMessage = new Label("System Messages");
        TextField txtMessage = new TextField();
        txtMessage.setDisable(true);
        VBox btnheader = new VBox(5);
        btnheader.setAlignment(Pos.BOTTOM_LEFT);
        btnheader.getChildren().addAll(lblMessage, txtMessage); 
        grid.add(btnheader,1,9);
        
        // Primary Stage
        primaryStage.setTitle("Password Encryption");
        Scene scene = new Scene(grid, 650, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        

        // Event handler
        btnOpen.setOnAction(e-> { try {
            txtFile.setText(
            opensave.ChooseFile(primaryStage));
            passwordData = opensave.openFile(txtFile.getText());
            for (int i=0;i<5;i++)
            for (int j=0;j<4;j++){
                passwordData[i][j] = ED.decrypt(passwordData[i][j], secretKey);
                textFields[i][j].setText(passwordData[i][j]);}
            txtMessage.setText("");
        } catch (Exception e1) {
            txtMessage.setText(e1.toString());
        }  
        });
        btnSave.setOnAction(e-> { try {
                setPassworData(textFields);
                for (int i=0;i<5;i++)
                for (int j=0; j<4;j++)
                    passwordData[i][j] = ED.encrypt(passwordData[i][j], secretKey);
                opensave.saveFile(getPassworData(), txtFile.getText());
                txtMessage.setText("The file, "+txtFile.getText()+", is saved successfully");
        } catch (Exception e1) {
           
            txtMessage.setText(e1.toString()+" "+"Please enter a file name");
        }  
        });
        btnNew.setOnAction(e-> { try {
            ClearScreen();
            txtFile.setText("");
            txtMessage.setText("");
            txtFile.requestFocus();;
        } catch (Exception e1) {
            txtMessage.setText(e1.toString());
        }  
        });
        
    }
    public void ClearScreen() {
        for (int i=0;i<5;i++)
        for (int j=0; j<4;j++){
            textFields[i][j].setText("");
            this.passwordData[i][j]=textFields[i][j].getText();
        }
        
    }
    public String[][] getPassworData() {
        
        return passwordData;
    }

    public void setPassworData(TextField[][] textFields) {
        for (int i=0;i<5;i++)
        for (int j=0;j<4;j++){
            this.passwordData[i][j]=textFields[i][j].getText();
        }
    }    
}
