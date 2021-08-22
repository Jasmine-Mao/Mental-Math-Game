import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;

public class levelChoosing extends JFrame {
	// Global variable to keep track of what level the user chose
	private JPanel contentPane;
	static Integer level = 0;
	static levelChoosing frameLevel = new levelChoosing();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameLevel = new levelChoosing();
					frameLevel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public levelChoosing() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();
		Image addIcon = new ImageIcon(this.getClass().getResource("addition.png")).getImage();
		Image subIcon = new ImageIcon(this.getClass().getResource("subtraction.png")).getImage();
		Image addsubIcon = new ImageIcon(this.getClass().getResource("addsubtract.png")).getImage();

		JButton goButton = new JButton("GO!");
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level > 0) {
					if (level < 7) {
						play screenPlay = new play();
						screenPlay.setVisible(true);
						levelChoosing.this.setVisible(false);
					} else {
						customChoosing screenCustom = new customChoosing();
						screenCustom.setVisible(true);
						frameLevel.setVisible(false);
						levelChoosing.this.setVisible(false);
					}
				}
			}
		});
		goButton.setBackground(Color.RED);
		goButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		goButton.setBounds(666, 410, 103, 69);
		contentPane.add(goButton);

		JLabel additionIcon = new JLabel();
		additionIcon.setVerticalAlignment(SwingConstants.TOP);
		additionIcon.setIcon(new ImageIcon(addIcon));
		additionIcon.setBounds(10, 50, 200, 200);
		contentPane.add(additionIcon);

		JLabel subtractionIcon = new JLabel();
		subtractionIcon.setVerticalAlignment(SwingConstants.TOP);
		subtractionIcon.setIcon(new ImageIcon(subIcon));
		subtractionIcon.setBounds(406, 50, 200, 200);
		contentPane.add(subtractionIcon);

		JLabel addLabel = new JLabel("Addition");
		addLabel.setForeground(new Color(250, 128, 114));
		addLabel.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		addLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addLabel.setBounds(220, 50, 220, 44);
		contentPane.add(addLabel);

		JLabel subtractLabel = new JLabel("Subtraction");
		subtractLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subtractLabel.setForeground(new Color(250, 128, 114));
		subtractLabel.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		subtractLabel.setBounds(616, 50, 259, 44);
		contentPane.add(subtractLabel);

		JRadioButton easyAddRadioButton = new JRadioButton("Easy");
		easyAddRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 1;
			}
		});
		easyAddRadioButton.setBackground(new Color(240, 240, 240));
		easyAddRadioButton.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		easyAddRadioButton.setBounds(230, 100, 103, 21);
		contentPane.add(easyAddRadioButton);

		JRadioButton mediumAddRadioButton = new JRadioButton("Medium");
		mediumAddRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 2;
			}
		});
		mediumAddRadioButton.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		mediumAddRadioButton.setBounds(230, 125, 103, 21);
		contentPane.add(mediumAddRadioButton);

		JRadioButton hardAddRadioButton = new JRadioButton("Hard");
		hardAddRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 3;
			}
		});
		hardAddRadioButton.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		hardAddRadioButton.setBounds(230, 150, 103, 21);
		contentPane.add(hardAddRadioButton);

		JRadioButton easySubRadioButton = new JRadioButton("Easy");
		easySubRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 4;
			}
		});
		easySubRadioButton.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		easySubRadioButton.setBounds(626, 100, 103, 21);
		contentPane.add(easySubRadioButton);

		JRadioButton mediumSubRadioButton = new JRadioButton("Medium");
		mediumSubRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 5;
			}
		});
		mediumSubRadioButton.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		mediumSubRadioButton.setBounds(626, 125, 103, 21);
		contentPane.add(mediumSubRadioButton);

		JRadioButton hardSubRadioButton = new JRadioButton("Hard");
		hardSubRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 6;
			}
		});
		hardSubRadioButton.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		hardSubRadioButton.setBounds(626, 150, 103, 21);
		contentPane.add(hardSubRadioButton);

		JLabel addsubtractIcon = new JLabel("");
		addsubtractIcon.setBounds(10, 320, 200, 200);
		contentPane.add(addsubtractIcon);
		addsubtractIcon.setIcon(new ImageIcon(addsubIcon));

		JLabel mixLabel = new JLabel("Custom");
		mixLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mixLabel.setForeground(new Color(250, 128, 114));
		mixLabel.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		mixLabel.setBounds(220, 320, 220, 44);
		contentPane.add(mixLabel);

		JRadioButton rdbtnCustomizeYourOwn = new JRadioButton("Customize your own level");
		rdbtnCustomizeYourOwn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level = 7;
			}
		});
		rdbtnCustomizeYourOwn.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		rdbtnCustomizeYourOwn.setBackground(SystemColor.menu);
		rdbtnCustomizeYourOwn.setBounds(230, 370, 227, 21);
		contentPane.add(rdbtnCustomizeYourOwn);

		JLabel levelBackground = new JLabel();
		levelBackground.setVerticalAlignment(SwingConstants.TOP);
		levelBackground.setIcon(new ImageIcon(background));
		levelBackground.setBounds(0, 0, 900, 600);
		contentPane.add(levelBackground);
	}
}
