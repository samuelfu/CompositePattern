import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * HotBalloon class implements MovingObject and creates a HotBalloon object that
 * can move, be drawn, and can jitter left and right. HotBalloon is the leaf of
 * the composite pattern. By using the composite pattern, HotBalloon and
 * GroupsOfObjects now share their methods through implementing MovingObject.
 * What is acted upon a HotBalloon can also be used on a bunch of HotBalloons,
 * which is GroupOfObjects.
 * 
 * @author Samuel Fu ssf2130 COMS1007
 *
 */
public class HotBalloon implements MovingObject {
	private int x;
	private int y;
	private int unit;
	private final int LINELENGTH = 2;
	private int xChangeWind = 1;
	private int counter = 0;
	final private int MAXDISTANCE = 100;

	/**
	 * Creates a hot air balloon with a gondola, a burner, and a balloon.
	 */
	public void draw(Graphics2D g2d) {

		// basic x symmetry
		int xCenter = x + unit / 2;

		// balloon
		int balloonXUpLeft = x;
		int balloonYUpLeft = y;
		int balloonSize = unit;
		Ellipse2D.Double balloon = new Ellipse2D.Double(balloonXUpLeft, balloonYUpLeft, balloonSize, balloonSize);

		// burner
		int burnerXTop = balloonXUpLeft;
		int burnerYTop = balloonYUpLeft + unit / 2;
		int burnerXBottom = xCenter;
		int burnerYBottom = balloonYUpLeft + LINELENGTH * unit;
		Line2D.Double burnerLeft = new Line2D.Double(burnerXTop, burnerYTop, burnerXBottom, burnerYBottom);
		Line2D.Double burnerRight = new Line2D.Double(burnerXTop + unit, burnerYTop, burnerXBottom, burnerYBottom);

		// gondola
		Rectangle2D.Double gondola = new Rectangle2D.Double(x, y + LINELENGTH * unit, unit, unit);

		GeneralPath body = new GeneralPath();
		body.append(burnerLeft, false);
		body.append(burnerRight, false);

		g2d.fill(balloon);
		g2d.fill(gondola);
		g2d.draw(body);
	}

	/**
	 * Changes the balloon's x and y coordinates based on the parameters.
	 */
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;

	}

	/**
	 * Creates a HotBalloon at the coordinates x and y, with diameter of the sphere
	 * as unit.
	 * 
	 * @param x
	 * @param y
	 * @param unit
	 */
	public HotBalloon(int x, int y, int unit) {
		this.x = x;
		this.y = y;
		this.unit = unit;
	}

	/**
	 * Moves the balloon MAXDISTANCE to the right and then left.
	 */
	public void jitter() {
		if (counter < MAXDISTANCE) {
			translate(xChangeWind, 0);
			counter++;
		} else {
			counter = 0;
			xChangeWind *= -1;
		}

	}
}
