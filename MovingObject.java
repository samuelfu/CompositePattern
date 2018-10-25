import java.awt.*;

/**
 * Interface for composite pattern. GroupOfObjects is the composite and is a
 * MovingObject. HotBalloon make up GroupOfObjects as the leaf and is a
 * MovingObject as well. By using the composite pattern the composite and the
 * leaf share the same methods, and they are easier to manipulate. MovingObject
 * is "a new interface" because I added jitter(). This MovingObject and the old
 * MovingObject otherwise serve the same purpose.
 * 
 * @author jrk based on cay horstmann
 *
 */
public interface MovingObject {
	/**
	 * Draws some kind of a picture
	 * 
	 * @param g2D
	 */
	void draw(Graphics2D g2D);

	/**
	 * Moves the picture by x and y changes
	 * 
	 * @param xChange
	 * @param yChange
	 */
	void translate(int xChange, int yChange);

	/**
	 * Moves the picture left and right
	 */
	void jitter();
}