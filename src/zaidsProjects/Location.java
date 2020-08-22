package zaidsProjects;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private Map<String, Integer> exists;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exists = new HashMap<String, Integer>();

    }

    public void addExit(String direction, int location) {
        exists.put(direction, location);
    }
    public int getExitDirection(String discription)
    {
        return exists.get(discription);
    }
    public  void printValues()
    {
        for(String s : exists.keySet())
        {
            System.out.println(s + ": " + exists.get(s));
        }
    }
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExists() {
        return new HashMap<String, Integer>(exists);
    }

}
