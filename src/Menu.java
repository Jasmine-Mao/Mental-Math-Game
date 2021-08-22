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
		frame.setResizable(false);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();
		
		JLabel descriptionLabel = new JLabel("A Mental Math Drill Game");
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setForeground(new Color(250, 128, 114));
		descriptionLabel.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		descriptionLabel.setBounds(316, 179, 268, 107);
		frame.getContentPane().add(descriptionLabel);
		
		JLabel titleLabel = new JLabel("Math Mania!");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(250, 128, 114));
		titleLabel.setFont(new Font("Cooper Black", Font.BOLD, 70));
		titleLabel.setBounds(218, 103, 464, 113);
		frame.getContentPane().add(titleLabel);
		
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				levelChoosing screenChoose = new levelChoosing();
				screenChoose.setVisible(true);
				frame.setVisible(false);
			}
		});
		playButton.setBackground(new Color(50, 205, 50));
		playButton.setForeground(new Color(0, 0, 0));
		playButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		playButton.setBounds(400, 328, 100, 65);
		frame.getContentPane().add(playButton);

		JLabel menuBackground = new JLabel();
		menuBackground.setVerticalAlignment(SwingConstants.TOP);
		menuBackground.setIcon(new ImageIcon(background));
		menuBackground.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(menuBackground);
	}
}
