package snap;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Help
{
	public Help()
	{
		//Variables
		JFrame frame = new JFrame("Help");
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		SpringLayout layout = new SpringLayout();
		
		//Label features
		label.setText("<HTML>How to play this game:<br>"
				+ "<br>1. Cards match if the cards share the same number,"
				+ "<br>or are both a face value card."
				+ "<br>2. Ace counts as a number, not a face value card."
				+ "<br>3. Face value cards consist of K, Q, J. This means "
				+ "<br> that a Jack can match with a King and so on.<br>"
				+ "<br>The controls for player 1 are: "
				+ "<br>'Space' to draw a card"
				+ "<br>'Q' to call snap<br>"
				+ "<br>The controls for player 2 are: "
				+ "<br>'Enter' to draw a card"
				+ "<br>'P' to call snap</HTML>");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		
		//Panel features
		panel.setLayout(layout);
		panel.add(label);
		
		//Layout features
		layout.putConstraint(SpringLayout.NORTH, label, 40, SpringLayout.NORTH, frame);
		layout.putConstraint(SpringLayout.WEST, label, 60, SpringLayout.WEST, frame);
		
		//Frame features
		frame.add(panel);
		frame.setSize(new Dimension(600, 530));
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	/*public static void main(String[] arg0)
	{
		new Help();
	}*/
}
