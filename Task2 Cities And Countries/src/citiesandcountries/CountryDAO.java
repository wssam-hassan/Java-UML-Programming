package citiesandcountries;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    
    public List <Country> ListOfCountries;
    
    public CountryDAO (String CountryFilePath)
    {
        this.ListOfCountries = new ArrayList<>();
        
        // File
        File filepath = new File(CountryFilePath);
        
        // Read Line by Line
        List <String> CountryLines = new ArrayList<>();
        
        try
        {
            CountryLines = Files.readAllLines(filepath.toPath());
        } catch (IOException ex) 
        {
            System.out.println("Error in Reading Country File...");
        }
        
        for ( int CountryIndex = 1; CountryIndex < CountryLines.size() ; CountryIndex ++)
        {
            String lineOfCity = CountryLines.get(CountryIndex);
            String columns[] = lineOfCity.split(",");
            
            for (String value : columns)
                value = value.trim();
            
            Country countryObj = new Country (columns[1],  columns[0], columns[2]);
            this.ListOfCountries.add(countryObj);
        }
        
    }  
}
