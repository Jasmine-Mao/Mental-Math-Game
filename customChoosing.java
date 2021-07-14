import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class customChoosing extends JFrame {

	private JPanel contentPane;
	static customChoosing frameCustom = new customChoosing();
	static Integer upperNum = 0;
	static boolean addition = false;
	static boolean subtraction = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameCustom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public customChoosing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();

		JLabel customLabel = new JLabel("Make your own custom level!");
		customLabel.setForeground(new Color(250, 128, 114));
		customLabel.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		customLabel.setBounds(20, 20, 688, 105);
		contentPane.add(customLabel);

		JCheckBox addCheckBox = new JCheckBox("Addition");
		addCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addition = true;
			}
		});
		addCheckBox.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		addCheckBox.setBounds(30, 131, 257, 55);
		contentPane.add(addCheckBox);

		JCheckBox subtractCheckBox = new JCheckBox("Subtraction");
		subtractCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtraction = true;
			}
		});
		subtractCheckBox.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		subtractCheckBox.setBounds(30, 195, 257, 55);
		contentPane.add(subtractCheckBox);

		JSpinner upperBound = new JSpinner();
		upperBound.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				upperNum = (Integer) upperBound.getValue();
			}
		});
		upperBound.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		upperBound.setBounds(219, 306, 125, 48);
		contentPane.add(upperBound);

		JLabel rangeLabel = new JLabel("Highest Number: ");
		rangeLabel.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		rangeLabel.setBounds(34, 296, 407, 69);
		contentPane.add(rangeLabel);

		JButton goButton = new JButton("GO!");
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play screenPlay = new play();
				screenPlay.setVisible(true);
				customChoosing.this.setVisible(false);
			}
		});
		goButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		goButton.setBackground(Color.RED);
		goButton.setBounds(666, 410, 103, 69);
		contentPane.add(goButton);

		JLabel descriptionLabel = new JLabel("");
		descriptionLabel.setBounds(0, 0, 900, 600);
		contentPane.add(descriptionLabel);
		descriptionLabel.setIcon(new ImageIcon(background));

		levelChoosing.level = 8;
	}
}