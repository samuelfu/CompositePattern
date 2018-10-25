import java.awt.*;
import javax.swing.*;

/**
 * MyIcon implements Icon to have a greater control over what is being created
 * and returned.
 * 
 * @author jrk based on cay horstmann
 *
 */

public class MyIcon implements Icon {
	/**
	 * Takes in a MovingObject, width, and height
	 * @param obj
	 * @param w
	 * @param h
	 */
	public MyIcon(MovingObject obj, int w, int h) {
		this.obj = obj;
		this.w = w;
		this.h = h;
	}

	/**
	 * Returns icon width
	 */
	public int getIconWidth() {
		return w;
	}

	/**
	 * Returns icon height
	 */
	public int getIconHeight() {
		return h;
	}

	/**
	 * Implements paintIcon and calls MovingObject's draw(g2D) method.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		obj.draw(g2D);
	}

	private int w;
	private int h;
	private MovingObject obj;
}
