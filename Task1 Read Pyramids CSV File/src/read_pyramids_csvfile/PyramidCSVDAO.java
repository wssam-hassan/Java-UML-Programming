package read_pyramids_csvfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PyramidCSVDAO {
    
    public List <Pyramid> Pyramids;
    
    //Constructor
    public PyramidCSVDAO( String PyramidFilePath)
    {
      
            this.Pyramids = new ArrayList<Pyramid>();
            
            //path file
            File file = new File(PyramidFilePath);
            
            //read file by lines and save it in arraylist
            List <String> fileLines = new ArrayList<String>();
        
        try {
            fileLines = Files.readAllLines(file.toPath());
        }
        catch (IOException ex)
        {
            System.out.println("Error in Reading File ...");
        }
        
        for (int lineIndex = 1; lineIndex < fileLines.size(); lineIndex++)
        {
            
            String line = fileLines.get(lineIndex);
            String columns[] = line.split(",");
                    
            for (int columnIndex = 0; columnIndex < columns.length ; columnIndex++)
            {
            columns[columnIndex] = columns[columnIndex].trim();
            }
            
            Pyramid Obj = new Pyramid(columns[0], columns[1], columns[2], columns[3], columns[4], columns[10], columns[11], columns[14]);
            this.Pyramids.add(Obj);
        }
        
    }
}
