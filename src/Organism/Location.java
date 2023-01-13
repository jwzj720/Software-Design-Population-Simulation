package Organism;

public class Location {
    private int x,y;
    
    /** returns x value of location
     * @return int
     */
    public int getX() {
        return x;
    }
    /**
    returns y value of location
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
    sets location based on x and y values
    @param int x
    @param int y */
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    /** finds the distance between two locations
     * @param location
     * @return double distance between the locations
     */
    public double getDistanceTo(Location location){
        double distance = Math.sqrt((this.x - location.getX()) * (this.x - location.getX())
                             + (this.y - location.getY()) * (this.y - location.getY()));
        return distance;
    }
}
