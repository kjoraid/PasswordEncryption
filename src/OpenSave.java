import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

/*
    This class is responsible of:
    A) Open a file and retrieve the data to the caller by following 
    these steps: 
        1- Call the open class to Open a file in any folder
        2- Check if the file is correct
        3- Fill the data of the file into Array
        4- Return this array to the caller using return command
    B) Users will send an array to a method in this class to 
        save the data on file by following these steps:
        1- User will pass an array with the data required to be saved
        2- Check the array if it is correct and contains data
        3- Call the save class and pass the array to it

*/
public class OpenSave {
    private String fileName="";

    public String[][] openFile(String fileName) throws Exception{
        String[][] passData = new String[5][4];
        File dataFile = new File(fileName);
        try (Scanner inputFile = new Scanner(dataFile)) {
            for (int i=0;i<passData.length;i++)
                for (int j=0;j<passData[0].length;j++)         
                    passData[i][j]= inputFile.nextLine();

        } catch (FileNotFoundException e) {
            throw new Exception(e);
        }

        return passData;
    }

    public String saveFile(Date date, String[][] passData, String fileName) throws Exception {
        File output = new File(fileName);
        PrintWriter writer;
        try {
            writer = new PrintWriter(output);
            for (int i=0;i<passData.length;i++)
                for (int j=0;j<passData[0].length;j++){
                    writer.println(passData[i][j]);
                    }
                    //writer.println("");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new Exception(e);
        }
        return fileName;
    }

    public String ChooseFile(Stage primaryStage)  throws Exception{
        String fileName = "";
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Encryption Text File");
            fileChooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Files", "*.txt"));
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
            fileChooser.setInitialDirectory(new File(currentPath));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                fileName = selectedFile.getName();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        return fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
}
