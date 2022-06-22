package snap;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;



public class Snap implements ActionListener
{
	//Variables
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JFrame frame = new JFrame("Snap");
	JPanel panel = new JPanel();
	JButton button = new JButton("Play again?");
	JButton button2 = new JButton("Main menu");
	Action space, plr1, plr2, enter;
	static ArrayList<Card> player1 = new ArrayList<Card>();
	static ArrayList<Card> player2 = new ArrayList<Card>();
	ArrayList<Card> deck = new ArrayList<Card>();
	boolean p1 = false, p2 = true, gameover = false;
	int i = 0, j = 0;

	public Snap()
	{
		//Action variables
		space = new SpaceAction();
		plr1 = new qAction();
		plr2 = new pAction();
		enter = new EnterAction();
		
		//Button features
		button.addActionListener(this);
		button2.addActionListener(this);
		button.setText("<HTML><CENTER>Play again?<CENTER></HTML>");
		button2.setText("<HTML><CENTER>Main menu<CENTER></HTML>");
		button.setPreferredSize(new Dimension(200, 100));
		button2.setPreferredSize(new Dimension(200, 100));
		
		//Label features
		label.setIcon(new ImageIcon());
		label2.setIcon(new ImageIcon());
		label2.setIcon(new ImageIcon("C:\\Users\\u\\Pictures\\cards\\back.png"));
		label.setIcon(new ImageIcon("C:\\Users\\u\\Pictures\\cards\\back.png"));
		label.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpaceAction");
		label.getActionMap().put("SpaceAction", space);
		label.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "EnterAction");
		label.getActionMap().put("EnterAction", enter);
		label.getInputMap().put(KeyStroke.getKeyStroke("Q"), "qAction");
		label.getActionMap().put("qAction", plr1);
		label.getInputMap().put(KeyStroke.getKeyStroke("P"), "pAction");
		label.getActionMap().put("pAction", plr2);
		
		//Panel features
		panel.setBorder(BorderFactory.createEmptyBorder(30, 45, 30, 30));
		panel.setLayout(new GridLayout(1, 1));
		panel.add(label);
		panel.add(label2);
		
		//Frame features
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850,650);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		Snap snap = new Snap();
		snap.Deck();
	}
	
	public void Deck()
	{
		//Variables
		i = 0;
		gameover = false;
		
		// Creates/Refreshes the deck and player cards in case of previous game
		deck = Card.createDeck();
		player1.clear();
		player2.clear();
		
		//Splits the deck between the 2 players
		for(Card card: deck)
		{

			if(i < 26)
			{
				player1.add(card);
				i++;
			}
			else
			{
				player2.add(card);
			}
		}
		
		i = 0;
	}
	
	public void endGame(String p)
	{
		//Variables
		gameover = true;
		SpringLayout layout = new SpringLayout();
		
		//Endgame Panel features
		panel.setLayout(layout);
		panel.add(button);
		panel.add(button2);
		
		//Endgame Label features
		label.setSize(100, 100);
		label.setIcon(new ImageIcon());
		label2.setIcon(new ImageIcon());
		
		//Endgame layout features
		layout.putConstraint(SpringLayout.NORTH, label, 90, SpringLayout.NORTH, frame);
		layout.putConstraint(SpringLayout.WEST, label, 330, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.SOUTH, button2, 150, SpringLayout.SOUTH, button);
		layout.putConstraint(SpringLayout.NORTH, button, 150, SpringLayout.NORTH, frame);
		layout.putConstraint(SpringLayout.WEST, button, 270, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.WEST, button2, 270, SpringLayout.WEST, frame);
		
		//Checks if there's a winner or if it's a draw
		if(p == "a")
		{
			label.setText("Player 1 wins!");
		}
		else if(p == "b")
		{
			label.setText("Player 2 wins!");
		}
		
		else if(gameover == true)
		{
			label.setText("Nobody wins! It's a draw!");
			layout.putConstraint(SpringLayout.WEST, label, 300, SpringLayout.WEST, frame);
		}
	}

	public static boolean checkCards(Card a, Card b)
	{
		//Checks if same value
		if(a.getRank() == b.getRank())
		{
			return true;
		}
		
		//Checks if it's a face value (K,Q,J)
		else if(a.getRank()== "j" || a.getRank()== "q" || a.getRank()== "k")
		{
			if(b.getRank() == "j" || b.getRank() == "q" || b.getRank() == "k")
			{
				return true;
			}
		}
		
		return false;
	}

	private class pAction extends AbstractAction
	{
		//What happens when 'P' is pressed
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(gameover == false)
			{
				//Checks if cards match and ends game if true
				boolean win = checkCards(player1.get(i-1), player2.get(j-1));
				if(win == true)
				{
					String b = "b";
					i=26;
					j=26;
					endGame(b);
				}
			}
		}
		
	}
	
	private class qAction extends AbstractAction
	{
		//What happens when 'Q' is pressed
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(gameover == false)
			{
				//Checks if cards match and ends game if true
				boolean win = checkCards(player1.get(i-1), player2.get(j-1));
				if(win == true)
				{
					String a = "a";
					i=26;
					j=26;
					endGame(a);
				}
			}
		}
		
	}
	
	private class SpaceAction extends AbstractAction
	{
		//What happens when 'Space' is pressed
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(gameover == false)
			{	
				//Changes the current card
				if(p1 == false && i < player1.size())
				{
					label.setIcon(new ImageIcon(player1.get(i).getImg()));
					p1 = true;
					p2 = false;
					i++;
				}
				//Ends game after next player2 draw
				else if(i >= player1.size())
				{
					p2 = false;
				}
			}
		}
	}
	
	private class EnterAction extends AbstractAction
	{
		//What hapens when 'Enter' is pressed
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(gameover == false)
			{
				//Changes the current card
				if(p2 == false && j < player2.size())
				{
					label2.setIcon(new ImageIcon(player2.get(j).getImg()));
					p2 = true;
					p1 = false;
					j++;
				}
				//Ends game if no more cards left
				else if(j >= player2.size())
				{
					label.setIcon(new ImageIcon());
					label2.setIcon(new ImageIcon());
					p1 = false;
					String o = "";
					endGame(o);
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent b)
	{
		//Checks which button is pressed
		frame.dispose();
		if(b.getSource() == button)
		{
			new Snap();
			Deck();
		}
		else
		{
			new Menu();
		}
	}

}