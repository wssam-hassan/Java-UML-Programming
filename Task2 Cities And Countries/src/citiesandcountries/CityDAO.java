package citiesandcountries;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityDAO {

    public List <City> ListOfCities;
    
    public CityDAO(String CityFilePath)
    {
        this.ListOfCities = new ArrayList<>();
        
        // File
        File filepath = new File(CityFilePath);
        
        // Read Line by Line
        List <String> CityLines = new ArrayList<>();
        
        try
        {
            CityLines = Files.readAllLines(filepath.toPath());
        } catch (IOException ex) 
        {
            System.out.println("Error in Reading City File...");
        }
        
        for ( int CityIndex = 1; CityIndex < CityLines.size() ; CityIndex ++)
        {
            String lineOfCity = CityLines.get(CityIndex);
            String columns[] = lineOfCity.split(",");
            
            for (String value : columns)
                value = value.trim();
            
            City cityObj = new City( columns[0],  columns[1], columns[2], columns[3], columns[4]);
            this.ListOfCities.add(cityObj);
        }


    }

    
    
    
}
