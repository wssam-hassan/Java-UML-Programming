package read_pyramids_csvfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    public static void main(String[] args) {
       
        String path = "E:\\#ITI\\# In-Courses\\[09] Java and UML\\Assignments\\pyramids.csv";
        PyramidCSVDAO test = new PyramidCSVDAO(path);
        
        int i = 0;        
        for (Pyramid Obj : test.Pyramids)
        {
            i++;
            System.out.println("Pyramid " + i);
            System.out.println("Pyramid Ancient and Modern Name respectively are " + Obj.getAncientName() + " and " + Obj.getModernName());
            System.out.println("Pyramid Pharaoh is " + Obj.getPharaoh());
            System.out.println("Pyramid is located in " + Obj.getSite());
            System.out.println("Pyramid is made from " + Obj.getMaterial());
            System.out.println("Pyramid Dynasty = " + Obj.getDynasty());
            System.out.println("Pyramid Latitude and Longitude coordinated = " + Obj.getLatitude() + " and " + Obj.getLongitude());
            System.out.println(" - - - - - - - - - - - - - - - - - - -");
        }
        

    }
    
}
