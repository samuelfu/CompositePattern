import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * GroupsOfObjects implements MovingObject and uses the Composite pattern,
 * acting as the Composite. HotBalloon is the Leaf. GroupsOfObject and
 * HotBalloon are both MovingObject, but GroupsOfObject can also act as a
 * HotBalloon.
 * 
 * @author Samuel Fu ssf2130 COMS1007
 *
 */
public class GroupOfObjects implements MovingObject {
	private final int NUMBEROFBALLOONS = 5;

	private ArrayList<MovingObject> myObjectList = new ArrayList<MovingObject>();

	/**
	 * Creates NUMBEROFBALLOONS amounts of HotBalloons at random locations with
	 * random sizes each and adds them to myObjectList.
	 */
	public GroupOfObjects() {
		Random rand = new Random();
		for (int i = 0; i < NUMBEROFBALLOONS; i++) {
			int size = rand.nextInt(150) + 50;
			int x = rand.nextInt(600);
			int y = rand.nextInt(1000);
			myObjectList.add(new HotBalloon(x, y, size));
		}
	}

	/**
	 * Draws each MovingObject in myObjectList through HotBalloon's method draw
	 */
	public void draw(Graphics2D g2D) {
		for (MovingObject myObj : myObjectList)
			myObj.draw(g2D);
	}

	/**
	 * Translates each MovingObject in myObjectList through HotBalloon's method
	 * translate. xChange and yChange are how much horizontally and vertically the
	 * MovingObjects should be shifted.
	 */
	public void translate(int xChange, int yChange) {
		for (MovingObject myObj : myObjectList)
			myObj.translate(xChange, yChange);
	}

	/**
	 * Jitters each MovingObject in myObjectList through HotBalloon's method jitter.
	 */
	public void jitter() {
		for (MovingObject myObj : myObjectList)
			myObj.jitter();
	}

}
