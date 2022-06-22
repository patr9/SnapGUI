package snap;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;



public class Menu implements ActionListener
{
	//Variables
	JLabel label = new JLabel();
	JFrame frame = new JFrame("Snap");
	JPanel panel = new JPanel();
	JButton button = new JButton("New game");
	JButton button2 = new JButton("Help");
	
	public Menu()
	{
		SpringLayout layout = new SpringLayout();
		
		//Button features
		button.setFont(new Font(button.getFont().getName(), Font.PLAIN, 20));
		button2.setFont(new Font(button2.getFont().getName(), Font.PLAIN, 20));
		button.setPreferredSize(new Dimension(200, 100));
		button.addActionListener(this);
		button2.setPreferredSize(new Dimension(200, 100));
		button2.addActionListener(this);

		//Panel features
		panel.setLayout(layout);
		panel.add(button);
		panel.add(button2);
		
		//Layout features
		layout.putConstraint(SpringLayout.NORTH, button2, 85, SpringLayout.SOUTH, button);
		layout.putConstraint(SpringLayout.NORTH, button, 165, SpringLayout.NORTH, frame);
		layout.putConstraint(SpringLayout.WEST, button, 300, SpringLayout.EAST, frame);
		layout.putConstraint(SpringLayout.WEST, button2, 300, SpringLayout.EAST, frame);
		
		//Frame features
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850,650);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new Menu();
	}
	
	@Override
	public void actionPerformed(ActionEvent a)
	{
		//Works out which button is pressed
		if(a.getSource() == button)
		{
			frame.dispose();
			Snap.main(null);
		}
		else if(a.getSource() == button2)
		{
			new Help();
		}
	}
	
	

}