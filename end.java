import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class end extends JFrame {

	private JPanel contentPane;
	static end frameEnd = new end();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// frameEnd = new end();
					frameEnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public end() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();

		JLabel greatJobLabel = new JLabel("Great Job!!");
		greatJobLabel.setForeground(new Color(250, 128, 114));
		greatJobLabel.setFont(new Font("Cooper Black", Font.PLAIN, 50));
		greatJobLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greatJobLabel.setBounds(280, 100, 340, 200);
		contentPane.add(greatJobLabel);

		JLabel correctAnswerLabel = new JLabel("");
		correctAnswerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		correctAnswerLabel.setForeground(new Color(250, 128, 114));
		correctAnswerLabel.setFont(new Font("Cooper Black", Font.PLAIN, 40));
		correctAnswerLabel.setBounds(220, 150, 460, 200);
		contentPane.add(correctAnswerLabel);
		correctAnswerLabel.setText("You got " + play.ansCounter + "/20 correct!");

		JButton replayButton = new JButton("Replay");
		replayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play playScreen = new play();
				playScreen.setVisible(true);
				end.this.setVisible(false);
			}
		});
		replayButton.setBackground(new Color(50, 205, 50));
		replayButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		replayButton.setBounds(157, 380, 126, 60);
		contentPane.add(replayButton);

		JButton menuButton = new JButton("Menu");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menuScreen = new Menu();
				menuScreen.frame.setVisible(true);
				// frameEnd = new end();
				end.this.setVisible(false);
				customChoosing.addition = false;
				customChoosing.subtraction = false;
				customChoosing.upperNum = 0;
			}
		});
		menuButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		menuButton.setBackground(new Color(50, 205, 50));
		menuButton.setBounds(618, 380, 126, 60);
		contentPane.add(menuButton);

		JLabel endBackground = new JLabel("");
		endBackground.setFont(new Font("Cooper Black", Font.PLAIN, 35));
		endBackground.setBounds(0, 0, 900, 600);
		endBackground.setIcon(new ImageIcon(background));
		contentPane.add(endBackground);
	}
}
