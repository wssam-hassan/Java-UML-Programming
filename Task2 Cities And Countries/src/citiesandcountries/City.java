package citiesandcountries;

public class City implements Comparable <City> {

    private int countryId;
    private int cityId;
    private String name;
    private boolean isCapital;
    private int population;
 
    
    public City ( String countryid, String cityid, String city_name, String is_capital, String pop)
    {
     // Country ID
        this.countryId = Integer.valueOf(countryid);
        
     // City ID
        this.cityId = Integer.valueOf(cityid);
        
      // City Name
        this.name = city_name;
        
      // Is Capital?
      if (is_capital.equalsIgnoreCase("TRUE"))
          this.isCapital = true;
      
      if (is_capital.equalsIgnoreCase("FALSE"))
            this.isCapital = false;
      
      
        // City Population
        this.population = Integer.valueOf(pop);
      
    }

    public int getCountryId() 
    {
        return countryId;
    }

    public int getCityId() 
    {
        return cityId;
    }

    public String getName() 
    {
        return name;
    }

    public boolean isCapital() 
    {
        return isCapital;
    }

    public int getPopulation() 
    {
        return population;
    }

    @Override
    public int compareTo(City Obj) 
    {
            int compareage =((City)Obj).getPopulation();
         return this.population-compareage;
    }
    
}
