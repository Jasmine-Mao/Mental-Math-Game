import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class play extends JFrame
//levelChoosing class already extends the JFrame class so this is good
{

	private JPanel contentPane;
	private JTextField answerTextField;
	int counter = 1; // Counts the number of questions
	int questionsA[] = new int[20];
	int questionsB[] = new int[20];
	static play framePlay = new play();

	int answers[];
	int index = 0;

	static Integer ansCounter = 0;

	/**
	 * Launch the application.
	 */

	String userAnswer = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// framePlay = new play();
					framePlay.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public play() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();

		JLabel counterLabel = new JLabel("");
		counterLabel.setHorizontalAlignment(SwingConstants.LEFT);
		counterLabel.setForeground(new Color(250, 128, 114));
		counterLabel.setFont(new Font("Cooper Black", Font.PLAIN, 35));
		counterLabel.setBackground(Color.WHITE);
		counterLabel.setBounds(424, 235, 404, 93);
		contentPane.add(counterLabel);
		counterLabel.setText(counter + "/20");

		//////// Generate Numbers for Questions////////
		if (levelChoosing.level == 1 || levelChoosing.level == 4) {
			for (int x = 0; x < 20; x++) {
				Random rand = new Random();
				int upperbound = 11;
				questionsA[x] = rand.nextInt(upperbound);
				questionsB[x] = rand.nextInt(upperbound);
			}
		} else if (levelChoosing.level == 2 || levelChoosing.level == 5) {
			for (int x = 0; x < 20; x++) {
				Random rand = new Random();
				int upperbound = 101;
				questionsA[x] = rand.nextInt(upperbound);
				questionsB[x] = rand.nextInt(upperbound);
			}
		} else if (levelChoosing.level == 3 || levelChoosing.level == 6) {
			for (int x = 0; x < 20; x++) {
				Random rand = new Random();
				int upperbound = 501;
				questionsA[x] = rand.nextInt(upperbound);
				questionsB[x] = rand.nextInt(upperbound);
			}
		} else if (levelChoosing.level == 8) {
			for (int x = 0; x < 20; x++) {
				Random rand = new Random();
				int upperbound = customChoosing.upperNum + 1;
				questionsA[x] = rand.nextInt(upperbound);
				questionsB[x] = rand.nextInt(upperbound);
			}
		}

		/////// Generates the labels for all the questions///////////
		JLabel questionLabel = new JLabel("");
		questionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		questionLabel.setForeground(new Color(0, 0, 0));
		questionLabel.setBackground(new Color(255, 255, 255));
		questionLabel.setFont(new Font("Cooper Black", Font.PLAIN, 45));
		questionLabel.setBounds(50, 81, 404, 93);
		contentPane.add(questionLabel);
		if (levelChoosing.level >= 1 && levelChoosing.level <= 3) {
			questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
		} else if (levelChoosing.level >= 4 && levelChoosing.level <= 6) {
			questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
		} else if (levelChoosing.level == 8) {
			if (customChoosing.addition == true && customChoosing.subtraction == false) {
				questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
			} else if (customChoosing.subtraction == true && customChoosing.addition == false) {
				questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
			} else if (customChoosing.subtraction == true && customChoosing.addition == true) {
				questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
			}
		}
		//////// Checks the users answers/////////////
		answerTextField = new JTextField();
		answerTextField.setFont(new Font("Cooper Black", Font.PLAIN, 45));
		answerTextField.setBounds(475, 81, 236, 93);
		contentPane.add(answerTextField);
		answerTextField.setColumns(10);
		answerTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (levelChoosing.level >= 1 && levelChoosing.level <= 3) {
					int userAns = Integer.parseInt(answerTextField.getText());
					if (index == 19) {
						if (userAns == questionsA[index] + questionsB[index]) {
							++ansCounter;
						}
						end endScreen = new end();
						endScreen.setVisible(true);
						play.this.setVisible(false);
					} else {
						if (userAns == questionsA[index] + questionsB[index]) {
							++ansCounter;
						}
						index++;
						counterLabel.setText((++counter) + "/20");
						questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
						answerTextField.setText("");
					}
				} else if (levelChoosing.level >= 4 && levelChoosing.level <= 6) {
					int userAns = Integer.parseInt(answerTextField.getText());
					if (index == 19) {
						if (userAns == questionsA[index] - questionsB[index]) {
							++ansCounter;
						}
						end endScreen = new end();
						endScreen.setVisible(true);
						play.this.setVisible(false);
					}

					if (userAns == questionsA[index] - questionsB[index]) {
						++ansCounter;
					}
					index++;
					counterLabel.setText((++counter) + "/20");
					questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
					answerTextField.setText("");
				}

				else if (levelChoosing.level == 8) {
					if (customChoosing.addition == true && customChoosing.subtraction == false) {
						int userAns = Integer.parseInt(answerTextField.getText());
						if (index == 19) {
							if (userAns == questionsA[index] + questionsB[index]) {
								++ansCounter;
							}
							end endScreen = new end();
							endScreen.setVisible(true);
							play.this.setVisible(false);
						}

						if (userAns == questionsA[index] + questionsB[index]) {
							++ansCounter;
						}
						index++;
						counterLabel.setText((++counter) + "/20");
						questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
						answerTextField.setText("");
					} else if (customChoosing.subtraction == true && customChoosing.addition == false) {
						int userAns = Integer.parseInt(answerTextField.getText());
						if (index == 19) {
							if (userAns == questionsA[index] - questionsB[index]) {
								++ansCounter;
							}
							end endScreen = new end();
							endScreen.setVisible(true);
							play.this.setVisible(false);
						}

						if (userAns == questionsA[index] - questionsB[index]) {
							++ansCounter;
						}
						index++;
						counterLabel.setText((++counter) + "/20");
						questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
						answerTextField.setText("");
					}

					else if (customChoosing.addition == true && customChoosing.subtraction == true) {
						int userAns = Integer.parseInt(answerTextField.getText());
						if (index == 19) {
							if (userAns == questionsA[index] + questionsB[index]) {
								++ansCounter;
							}
							end endScreen = new end();
							endScreen.setVisible(true);
							play.this.setVisible(false);
						} else {
							if (index % 2 == 0) {
								if (userAns == questionsA[index] + questionsB[index]) {
									++ansCounter;
								}
								index++;
								counterLabel.setText((++counter) + "/20");
								questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
								answerTextField.setText("");
							} else if (index % 2 == 1) {
								if (userAns == questionsA[index] - questionsB[index]) {
									++ansCounter;
								}
								index++;
								counterLabel.setText((++counter) + "/20");
								questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
								answerTextField.setText("");
							}
						}
					}
				}
			}
		});

		JLabel progressLabel = new JLabel("Progress:");
		progressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		progressLabel.setForeground(new Color(250, 128, 114));
		progressLabel.setFont(new Font("Cooper Black", Font.PLAIN, 35));
		progressLabel.setBackground(Color.WHITE);
		progressLabel.setBounds(10, 235, 404, 93);
		contentPane.add(progressLabel);

		JLabel playBackground = new JLabel();
		playBackground.setBounds(10, 10, 900, 60);
		playBackground.setVerticalAlignment(SwingConstants.TOP);
		playBackground.setIcon(new ImageIcon(background));
		playBackground.setBounds(0, 0, 900, 600);
		contentPane.add(playBackground);

		ansCounter = 0;
		counter = 1;
	}
}
