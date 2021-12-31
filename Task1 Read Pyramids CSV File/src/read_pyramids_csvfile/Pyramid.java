package read_pyramids_csvfile;

public class Pyramid {
    
    //Variables
    private String Pharaoh;
    private String AncientName;
    private String ModernName;
    private int Dynasty;
    private String Site;
    private float Latitude;
    private float Longitude;
    private String Material;
    
    
    //Constructor
    public Pyramid(String Pharaoh, String AncientName, String ModernName, String Dynasty, String Site, String Latitude, String Longitude, String Material)
    {
        //Pharaoh
        this.Pharaoh = Pharaoh.replace(" (?)", "");
        
        //AncientName
        this.AncientName = AncientName.replace("-", ModernName);
        
        //ModernName
        this.ModernName = ModernName;
        
        //Dynasty
        this.Dynasty = Integer.valueOf(Dynasty);
        
        //Site
        this.Site = Site;
        
        //Latitude
        this.Latitude = Float.valueOf(Latitude);
        
        //Longitude
        this.Longitude = Float.valueOf(Longitude);
        
        //Material
        this.Material = Material;
        
    }


    //Getters
    public String getPharaoh() 
    {
        return Pharaoh;
    }

    public String getAncientName() 
    {
        return AncientName;
    }

    public String getModernName() 
    {
        return ModernName;
    }

    public int getDynasty() 
    {
        return Dynasty;
    }

    public String getSite() 
    {
        return Site;
    }

    public float getLatitude() 
    {
        return Latitude;
    }

    public float getLongitude() 
    {
        return Longitude;
    }

    public String getMaterial() 
    {
        return Material;
    }


}
