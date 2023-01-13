package Organism;
import java.awt.*;

public abstract class Organism{
    private int size;
    private Location location;
    private Shape shapeString;

	/** returns size of the organism
	 * @return int
	 */
	public int getSize() {
		return this.size;
	}

	/** Sets size to this organism
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/** Returns the location of the organism
	 * @return Locaiton
	 */
	public Location getLocation() {
		return this.location;
	}

	/**sets location of this organism
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/** returns the shape of this organism
	 * @return Shape
	 */
	public Shape getShape() {
		return this.shapeString;
	}

	/** sets the shape of the organism
	 * @param shape new shape of the organism
	 */
	public void setShape(Shape shape) {
		this.shapeString = shape;
	}

}