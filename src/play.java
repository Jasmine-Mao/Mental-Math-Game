//Play frame where the questions are generated and answers are checked
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
	int questionsA[] = new int[20]; //The first number
	int questionsB[] = new int[20]; //The second number
	static play framePlay = new play();

	int answers[]; //Array that stores the answers
	int index = 0;

	static Integer ansCounter = 0; //Counts the number of questions answered so far

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
				int upperbound = 11; //Greatest number will be 10
				questionsA[x] = rand.nextInt(upperbound); //Generates random number 1
				questionsB[x] = rand.nextInt(upperbound); //Generates random number 2
			}
			//If the level chosen is easy, the upper bound will be 10			
		} else if (levelChoosing.level == 2 || levelChoosing.level == 5) {
			for (int x = 0; x < 20; x++) {
				Random rand = new Random();
				int upperbound = 101; //Greatest number will be 100
				questionsA[x] = rand.nextInt(upperbound); //Generates random number 1
				questionsB[x] = rand.nextInt(upperbound); //Generates random number 2
			}
			//If the level chosen is medium, the upper bound will be 100
		} else if (levelChoosing.level == 3 || levelChoosing.level == 6) {
			for (int x = 0; x < 20; x++) {
				Random rand = new Random();
				int upperbound = 501; //Greatest number will be 500
				questionsA[x] = rand.nextInt(upperbound); //Generates random number 1
				questionsB[x] = rand.nextInt(upperbound); //Generates random number 2
			}
			//If the level chosen is hard, the upper bound will be 500
		} else if (levelChoosing.level == 8) {
			//If the level chosen is custom
			for (int x = 0; x < 20; x++) {
				Random rand = new Random();
				int upperbound = customChoosing.upperNum + 1; //Greatest number will the the number the user input in the levelChoosing frame
				questionsA[x] = rand.nextInt(upperbound); //Generates random number 1
				questionsB[x] = rand.nextInt(upperbound); //Generates random number 2
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
			questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = "); //Sets the label as "Generated #1 + Generated #2 = "
			//If the level is addition, we need addition labels
		} else if (levelChoosing.level >= 4 && levelChoosing.level <= 6) {
			questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = "); //Sets the label as "Generated #1 - Generated #2 = "
			//If the level is subtraction, we need subtraction labels
		} else if (levelChoosing.level == 8) {
			//Custom level labels are a little trickier
			if (customChoosing.addition == true && customChoosing.subtraction == false) { //If the user chose only addition, make addition labels
				questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
			} else if (customChoosing.subtraction == true && customChoosing.addition == false) { //If the user chose only subtraction, make subtraction labels
				questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
			} else if (customChoosing.subtraction == true && customChoosing.addition == true) { //If the user chose both addition and subtraction, set the VERY FIRST QUESTION AS ADDITION. This will start alternating
				questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
			}
		}
		//////// Checks the users answers/////////////
		answerTextField = new JTextField(); //Create a text field where the user can input an answer
		answerTextField.setFont(new Font("Cooper Black", Font.PLAIN, 45));
		answerTextField.setBounds(475, 81, 236, 93);
		contentPane.add(answerTextField);
		answerTextField.setColumns(10);
		answerTextField.addActionListener(new ActionListener() { //When the user submits their answer:
			public void actionPerformed(ActionEvent e) {
				if (levelChoosing.level >= 1 && levelChoosing.level <= 3) { //If the level is addition
					int userAns = Integer.parseInt(answerTextField.getText()); //Parses the users answer
					if (index == 19) { //If the question is the last one:
						if (userAns == questionsA[index] + questionsB[index]) { //Checks the users answer against the real answer
							++ansCounter; //If it's true, we will add 1 to the correct answer counter
						}
						end endScreen = new end(); //Because it's the last question, the end screen will open and the current frame will close
						endScreen.setVisible(true);
						play.this.setVisible(false);
					} else { //If the question is NOT the last one
						if (userAns == questionsA[index] + questionsB[index]) { //Checks the users answer against the real answer
							++ansCounter; //if the answer is correct, the correct answer counter will go up
						}
						index++; //Increases the index of the question and outputs the next question
						counterLabel.setText((++counter) + "/20"); //Counts the number of questions answered so far
						questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = "); //Clears the old question and puts out a new one
						answerTextField.setText("");
					}
					
				} else if (levelChoosing.level >= 4 && levelChoosing.level <= 6) { //If the level is subtraction:
					int userAns = Integer.parseInt(answerTextField.getText()); //Parses the users answer
					if (index == 19) { //If the question is the last one:
						if (userAns == questionsA[index] - questionsB[index]) { //Checks the users answer against the real answer
							++ansCounter; //If it's true, we will add 1 to the correct answer counter
						}
						end endScreen = new end(); //Because it's the last question, the end screen will open and the current frame will close
						endScreen.setVisible(true);
						play.this.setVisible(false);
					} else { //If the question is NOT the last one
						if (userAns == questionsA[index] - questionsB[index]) { //Checks the users answer against the real answer
							++ansCounter; //if the answer is correct, the correct answer counter will go up
						}
						index++; //Increases the index of the question and outputs the next question
						counterLabel.setText((++counter) + "/20"); //Counts the number of questions answered so far
						questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
						answerTextField.setText(""); //Clears the old question and puts out a new one
					}
				}

				else if (levelChoosing.level == 8) { //If the level was the custom level:
					if (customChoosing.addition == true && customChoosing.subtraction == false) { //If the user said only addition:
						int userAns = Integer.parseInt(answerTextField.getText()); //Checks what the user answered
						if (index == 19) { //If the question is the last one:
							if (userAns == questionsA[index] + questionsB[index]) { //If the user's answer is correct, add one to the correct answer counter
								++ansCounter;
							}
							end endScreen = new end(); //Closer the current screen and go to the end frame
							endScreen.setVisible(true);
							play.this.setVisible(false);
						} else { //If the question is NOT the last one
							if (userAns == questionsA[index] + questionsB[index]) { //If the user's answer is correct, add one to the correct answer counter
								++ansCounter;
							}
							index++;
							counterLabel.setText((++counter) + "/20");
							questionLabel.setText(questionsA[index] + " + " + questionsB[index] + " = ");
							answerTextField.setText("");
						}
						
					} else if (customChoosing.subtraction == true && customChoosing.addition == false) { //If the user only chose subtraction
						int userAns = Integer.parseInt(answerTextField.getText()); //Parses through the users answer
						if (index == 19) { //if the question is the last one:
							if (userAns == questionsA[index] - questionsB[index]) { //If the users answer is correct, add one to the correct answer counter
								++ansCounter;
							}
							end endScreen = new end(); //Close the current frame and go to the end frame
							endScreen.setVisible(true);
							play.this.setVisible(false);
						} else { //if the question is NOT the last one:
							if (userAns == questionsA[index] - questionsB[index]) { //If the users answer is correct, add one to the correct answer counter
								++ansCounter;
							}
							index++;
							counterLabel.setText((++counter) + "/20");
							questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
							answerTextField.setText("");
						}
					}

					else if (customChoosing.addition == true && customChoosing.subtraction == true) { //If the user chose both addition and subtraction:
						int userAns = Integer.parseInt(answerTextField.getText()); //Parse the users answer
						if (index == 19) { //If the question is the last one, check then close the play frame
							if (userAns == questionsA[index] + questionsB[index]) {
								++ansCounter;
							}
							end endScreen = new end();
							endScreen.setVisible(true);
							play.this.setVisible(false);
						} else { //If the question is even, the question number will be addition
							if (index % 2 == 0) {
								if (userAns == questionsA[index] + questionsB[index]) {
									++ansCounter;
								}
								index++;
								counterLabel.setText((++counter) + "/20");
								questionLabel.setText(questionsA[index] + " - " + questionsB[index] + " = ");
								answerTextField.setText("");
							} else if (index % 2 == 1) { //If the question number is odd, the question will be subtraction
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

		//Progress label that tells the user how many questions they've answered and how many more they have to go
		JLabel progressLabel = new JLabel("Progress:");
		progressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		progressLabel.setForeground(new Color(250, 128, 114));
		progressLabel.setFont(new Font("Cooper Black", Font.PLAIN, 35));
		progressLabel.setBackground(Color.WHITE);
		progressLabel.setBounds(10, 235, 404, 93);
		contentPane.add(progressLabel);

		//Background for the frame set in a label
		JLabel playBackground = new JLabel();
		playBackground.setBounds(10, 10, 900, 60);
		playBackground.setVerticalAlignment(SwingConstants.TOP);
		playBackground.setIcon(new ImageIcon(background));
		playBackground.setBounds(0, 0, 900, 600);
		contentPane.add(playBackground);
		
		ansCounter = 0; //The correct answer counter always starts at 0
		counter = 1; //The question counter always starts at 1
	}
}
