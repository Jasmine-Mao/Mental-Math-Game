import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class Menu {

	//Create initial frame
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false); //Frame can never be resized by the user
		frame.setBounds(100, 100, 900, 600); //Set the frame size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when the user exits the application
		frame.getContentPane().setLayout(null); 
		Image background = new ImageIcon(this.getClass().getResource("Background.png")).getImage(); //Gets an image resource from the image file
		
		//Title label for the game
		JLabel titleLabel = new JLabel("Math Mania!"); //Label with the game title
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER); //Centres the text
		titleLabel.setForeground(new Color(250, 128, 114)); //Set colour of the title to RBG(250,128,114)
		titleLabel.setFont(new Font("Cooper Black", Font.BOLD, 70)); //Set font and style of the title
		titleLabel.setBounds(218, 103, 464, 113); //Coordinates of the edges
		frame.getContentPane().add(titleLabel);
		
		//Description label under the title. Explains to the user what the game is
		JLabel descriptionLabel = new JLabel("A Mental Math Drill Game"); //Label of the caption
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER); //Centres the text
		descriptionLabel.setForeground(new Color(250, 128, 114)); //Set colour of the caption to RBG(250,128,114)
		descriptionLabel.setFont(new Font("Cooper Black", Font.PLAIN, 20)); //Set font and style of the caption
		descriptionLabel.setBounds(316, 179, 268, 107); //Coordinates of the edges
		frame.getContentPane().add(descriptionLabel);
	
		//Play button
		JButton playButton = new JButton("Play"); //Creates a new button with the word "Play" on it
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				levelChoosing screenChoose = new levelChoosing();
				screenChoose.setVisible(true);
				frame.setVisible(false);
				//When the user presses the 'play' button, the current frame closes and a new frame (levelChoosing frame) opens
			}
		});
		playButton.setBackground(new Color(50, 205, 50)); //Set background colour of the Play button to RBG(50,205,50)
		playButton.setForeground(new Color(0, 0, 0)); //Set text colour
		playButton.setFont(new Font("Cooper Black", Font.PLAIN, 18)); // Set font and style
		playButton.setBounds(400, 328, 100, 65);
		frame.getContentPane().add(playButton);

		//Image background for the frame.
		JLabel menuBackground = new JLabel(); //Images are put within a label. Label has no text
		menuBackground.setVerticalAlignment(SwingConstants.TOP); //Vertically aligns from the top, covers the whole backgroung
		menuBackground.setIcon(new ImageIcon(background)); //Sets the background to an image
		menuBackground.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(menuBackground);
	}
}
