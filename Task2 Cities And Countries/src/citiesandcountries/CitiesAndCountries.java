package citiesandcountries;
import java.util.*;

public class CitiesAndCountries {

 
    public static void main(String[] args) {
        
        //Reading City File
        String cityPath = "E:\\#ITI\\# In-Courses\\[08] Java and UML\\Assignments\\cities.csv";
        CityDAO testCity = new CityDAO(cityPath);
        System.out.println(testCity.ListOfCities.get(0).getName());
        
        //Reading Country File
        String countryPath = "E:\\#ITI\\# In-Courses\\[08] Java and UML\\Assignments\\countries.csv";
        CountryDAO testCountry = new CountryDAO(countryPath);
        System.out.println(testCountry.ListOfCountries.get(0).getName());
        
        //Mapping
        Map < Integer , List<City> > citiesOfCountry = new HashMap<>();
        
        for (Country Obj : testCountry.ListOfCountries)
        {
            citiesOfCountry.put(Obj.getCountryId(), new ArrayList<>());        
        }
        
        
        for ( City Obj : testCity.ListOfCities)
        {
            citiesOfCountry.get(Obj.getCountryId()).add(Obj);
        }
        
        
        //Sorting
        citiesOfCountry.forEach((k,v) -> {
        Collections.sort(v);});
        
        //Test Sort
        System.out.println(citiesOfCountry.get(1).get(0).getPopulation());
        System.out.println(citiesOfCountry.get(1).get(1).getPopulation());
        System.out.println(citiesOfCountry.get(1).get(2).getPopulation());
        System.out.println(citiesOfCountry.get(1).get(3).getPopulation());


    }
    
}
