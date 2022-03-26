import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/*
    This class is responsible of:
    A) Open a file and retrieve the data to the caller by following 
    these steps: 
        1- Call the open class to Open a file in any folder
        2- Ceck if the file is correct
        3- Fill the data of the file into Array
        4- Return this array to the caller using return command
    B) Users will send an array to a method in this class to 
        save the data on file by following these steps:
        1- User will pass an array with the data required to be saved
        2- Check the array if it is correct and contains data
        3- Call the save class and pass the array to it

*/
public class OpenSave {
    //PasswordEncryption pe = new PasswordEncryption();

    public String[][] openFile(String fileName) {
        String[][] passData = new String[5][4];
        return passData;
    }

    public String saveFile(Date date, String[][] passData, String fileName) {
        File output = new File("output.txt");
        FileWriter writer;
        try {
            writer = new FileWriter(output);
       
            writer.write("This is how to write a text in a file ");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return fileName;
    }

    
}
