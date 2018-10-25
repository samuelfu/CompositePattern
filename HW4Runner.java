import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Runner is the main class. It calls BalloonDrawer to draw the HotBalloons and
 * passes arguments into ThreadCreator which creates 3 threads to keep track of
 * the HotBalloons.
 * 
 * Included is a video of a 15 second clip that tests the different speeds of
 * ascension for the randomly generated balloons.
 * 
 * @author jrk based on cay horstmann
 *
 */
public class HW4Runner {
	/**
	 * Draws the HotBalloons and starts the threads to move them.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BalloonDrawer balloonDrawer = new BalloonDrawer();
		GroupOfObjects myObj = balloonDrawer.getMyObj();
		JLabel myLabel = balloonDrawer.getMyLabel();
		JSlider mySlider = balloonDrawer.getMySlider();

		ThreadCreator ascensionTimer = new ThreadCreator();
		ascensionTimer.start(myObj, myLabel, mySlider);

	}
}
