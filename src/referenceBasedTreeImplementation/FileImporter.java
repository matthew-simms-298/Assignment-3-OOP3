package referenceBasedTreeImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileImporter {
    
    MyBSTree<String> tree = new MyBSTree<String>();

    //Reads text file and saves each line to MyBSTree, Test to see if the "line" is saved to MyBSTree
    public void fileImport() {
        try{
            BufferedReader bufferedReaderTextFile = new BufferedReader(new FileReader("src/utilities/textfile.txt"));
            String line = bufferedReaderTextFile.readLine();

            while (line != null) {
                if (line != "") {
                    line = bufferedReaderTextFile.readLine();
                    //Save line to MyBSTree 
                    tree.add(line);
                }
            }
            bufferedReaderTextFile.close();
        }
        catch (IOException error) {
            error.getMessage();
        }
    }

}
