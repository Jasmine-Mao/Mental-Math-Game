//Frame that allows a user to choose what kind of questions they want and how large the numbers will be
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

		//Title that tells the user they can make a custom level
		JLabel customLabel = new JLabel("Make your own custom level!"); //Title in a JLabel
		customLabel.setForeground(new Color(250, 128, 114)); //Set text colour
		customLabel.setFont(new Font("Cooper Black", Font.PLAIN, 30)); //Set font and Style
		customLabel.setBounds(20, 20, 688, 105); //Sets where the title is on the frame
		contentPane.add(customLabel);

		//Checkbox for addition
		JCheckBox addCheckBox = new JCheckBox("Addition");
		addCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addition = true;
			//When the user checks this box, the variable addition will be made true. Will become pertinent when the level is made in the play frame
			}
		});
		addCheckBox.setFont(new Font("Cooper Black", Font.PLAIN, 20)); //Set font and style of the checkbox
		addCheckBox.setBounds(30, 131, 257, 55); //Sets the checkbox in the frame
		contentPane.add(addCheckBox);

		//Checkbox for subtraction
		JCheckBox subtractCheckBox = new JCheckBox("Subtraction");
		subtractCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtraction = true;
			//When the user checks this box, the variable subtraction will be made true. Will become pertinent when the level is made in the play frame
			}
		});
		subtractCheckBox.setFont(new Font("Cooper Black", Font.PLAIN, 20)); //Set font and style of the checkbox
		subtractCheckBox.setBounds(30, 195, 257, 55); //Sets the checkbox in the frame
		contentPane.add(subtractCheckBox);

		//Adds a JSpinner that allows the user to choose the largest number that can be used. Ex. if the user puts in 100, the highest number that can be used is 100.
		JSpinner upperBound = new JSpinner();
		upperBound.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				upperNum = (Integer) upperBound.getValue();
			//When the spinner is given a value, that value is made the upper bound. This will become pertinent in the plau frame, when numbers will be randomized for the arithmetic
			}
		});
		upperBound.setFont(new Font("Cooper Black", Font.PLAIN, 20)); //Set font and style
		upperBound.setBounds(219, 306, 125, 48); //Sets the spinner in the frame
		contentPane.add(upperBound);

		//Label beside the JSpinner that tells the user to put in the highest number
		JLabel rangeLabel = new JLabel("Highest Number: ");
		rangeLabel.setFont(new Font("Cooper Black", Font.PLAIN, 20)); //Set font and style
		rangeLabel.setBounds(34, 296, 407, 69); //Sets the label in the frame
		contentPane.add(rangeLabel);

		//Go button
		JButton goButton = new JButton("GO!");
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play screenPlay = new play();
				screenPlay.setVisible(true);
				customChoosing.this.setVisible(false);
			//When the GO button is pressed, the current frame will close and the play frame will open
			}
		});
		goButton.setFont(new Font("Cooper Black", Font.PLAIN, 20)); //Set font and style
		goButton.setBackground(Color.RED); //Sets the text colour
		goButton.setBounds(666, 410, 103, 69); //Sets the background colour
		contentPane.add(goButton);

		//Blank label for the background image
		JLabel descriptionLabel = new JLabel("");
		descriptionLabel.setBounds(0, 0, 900, 600);
		contentPane.add(descriptionLabel);
		descriptionLabel.setIcon(new ImageIcon(background));

		levelChoosing.level = 8;
	}
}
