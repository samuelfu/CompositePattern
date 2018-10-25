import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
/**
 * BalloonDrawer handles the GUI part of the project.
 * @author Samuel Fu ssf2130 COMS1007
 *
 */
public class BalloonDrawer {
	private final GroupOfObjects myObj;
	private final JLabel myLabel;
	private final JSlider mySlider;
	private final int ICON_W = 600;
	private final int ICON_H = 1000;
	
	/**
	 * Creates a JFrame with JSlider and JLabel (which contains MyIcon and myObj)
	 */
	public BalloonDrawer() {

		JFrame myFrame = new JFrame();
		mySlider = new JSlider(SwingConstants.VERTICAL,0,10,5);
		
		myObj = new GroupOfObjects();

		MyIcon myIcon = new MyIcon(myObj, ICON_W, ICON_H);

		myLabel = new JLabel(myIcon);

		myFrame.add(myLabel);
		myFrame.add(mySlider);
		myFrame.setLayout(new FlowLayout());
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);

	}
	
	/**
	 * Returns myObj
	 * @return
	 */
	public GroupOfObjects getMyObj() {
		return myObj;
	}
	
	/**
	 * Returns myLabel
	 * @return
	 */
	public JLabel getMyLabel() {
		return myLabel;
	}
	
	/**
	 * Returns mySlider
	 */
	public JSlider getMySlider() {
		return mySlider;
	}

}
