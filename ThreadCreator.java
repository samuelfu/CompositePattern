import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Creates 3 threads. Two timers and one Slider listener. myAscensionTimer moves
 * the hot balloons up and determines the speed at which the balloons move.
 * myJitterTimer tells the balloons to jitter back and forth. The change
 * listener for the slider sets the delay of myAscensionTimer based on the
 * location of the slider.
 * 
 * @author Samuel Fu ssf2130 COMS1007
 *
 */
public class ThreadCreator {
	/**
	 * See the javadoc of the class
	 * 
	 * @param myObj
	 * @param myLabel
	 * @param mySlider
	 */
	public void start(MovingObject myObj, JLabel myLabel, JSlider mySlider) {
		int delay = 50;
		Timer myAscensionTimer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				myObj.translate(0, -1);
				myLabel.repaint();
			}
		});
		myAscensionTimer.start();

		Timer myJitterTimer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				myObj.jitter();
				myLabel.repaint();
			}
		});

		myJitterTimer.start();
		mySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				myAscensionTimer.setDelay(mySlider.getValue() * 10);
			}
		});

	}
}
