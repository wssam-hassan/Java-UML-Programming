package citiesandcountries;

public class Country {
    
    private int countryId;
    private String name;
    private String continent;
 
    
    public Country ( String countryid, String country_name, String continent)
    {
     // Country ID
        this.countryId = Integer.valueOf(countryid);
        
      // City Name
        this.name = country_name;
        
      // Continent
      this.continent = continent;
      
    }

    public int getCountryId() 
    {
        return countryId;
    }

    public String getName() 
    {
        return name;
    }

    public String getContinent()
    {
        return continent;
    }


}
