package com.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;

public class QuizGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private SpringLayout springLayout;
	
	private int currentQuestion;
	private JLabel currentQuestionNumberLabel;
	private JTextPane currentQuestionLabel;
	private boolean firstChoice ;
	private JButton optionA, optionB, optionC, optionD;
	
	JButton nextButton;
	
	Questions qn = new Questions();
	
	int score = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizGUI frame = new QuizGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuizGUI() {
		
		super("Java Quiz Game");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 223, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);  // center the window
		
		springLayout = new SpringLayout();
		currentQuestion = 0;
		firstChoice = false;
		
		// initialize Questions class
		Questions qns = new Questions();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addComponents();
		
	}
	
	private void addComponents() {
		
		qn.getQuesAndOption(currentQuestion);
		
		// heading
		JLabel header = new JLabel("Java Quiz Game !");
		header.setForeground(new Color(64, 0, 128));
		header.setFont(new Font("Bauhaus 93", Font.PLAIN, 44));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(10, 23, 716, 50);
		contentPane.add(header);
		
		// Question Label
		currentQuestionNumberLabel = new JLabel("Question : " + (++currentQuestion));
		currentQuestionNumberLabel.setFont(new Font("Courier New", Font.BOLD, 18));
		currentQuestionNumberLabel.setBounds(87,120,147,41);
		contentPane.add(currentQuestionNumberLabel);
		
		// The Question
		currentQuestionLabel = new JTextPane();
		currentQuestionLabel.setText(qn.getQuesAndOption(currentQuestion).get(0));
		currentQuestionLabel.setForeground(new Color(0, 0, 0));
		currentQuestionLabel.setBackground(new Color(255, 223, 223));
		currentQuestionLabel.setFont(new Font("DialogInput", Font.BOLD, 18));
		currentQuestionLabel.setBounds(40,199,247,143);
		
		StyledDocument doc = currentQuestionLabel.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		contentPane.add(currentQuestionLabel);

		// buttons
		
		optionA = new JButton(qn.getQuesAndOption(currentQuestion).get(1));
		optionA.setBounds(374, 166, 147, 68);
		contentPane.add(optionA);
		optionA.addActionListener(this);
		
		optionB = new JButton(qn.getQuesAndOption(currentQuestion).get(2));
		optionB.setBounds(549, 166, 147, 68);
		contentPane.add(optionB);
		optionB.addActionListener(this);
		
		optionC = new JButton(qn.getQuesAndOption(currentQuestion).get(3));
		optionC.setBounds(374, 274, 147, 68);
		contentPane.add(optionC);
		optionC.addActionListener(this);
		
		optionD = new JButton(qn.getQuesAndOption(currentQuestion).get(4));
		optionD.setBounds(549, 274, 147, 68);
		contentPane.add(optionD);
		optionD.addActionListener(this);
		
		// next button
		nextButton = new JButton("Next");
		nextButton.setBounds(492, 398, 85, 21);
		contentPane.add(nextButton);
		nextButton.setVisible(false);
		nextButton.addActionListener(this);

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Next") && currentQuestion!=10) {
			nextButton.setVisible(false);
			firstChoice = false;
			//System.out.println(score);
			updateGUI();
		} else {
			JButton btn = (JButton) e.getSource();
			if(qn.getCorrectAnswer(currentQuestion).equals(command)) {
				btn.setBackground(Color.GREEN);
				if(!firstChoice)
					score++; 
			} else {
				btn.setBackground(Color.RED);
			}
			nextButton.setVisible(true);
			firstChoice = true;
		}
		if(firstChoice && currentQuestion==10) {
			showPopUp(score);
			return;
		}
	}
	
	private void updateGUI() {
		currentQuestionNumberLabel.setText(("Question : " + (++currentQuestion)));
		currentQuestionLabel.setText(qn.getQuesAndOption(currentQuestion).get(0));
		optionA.setBackground(new Color(240, 240, 240));
		optionB.setBackground(new Color(240, 240, 240));
		optionC.setBackground(new Color(240, 240, 240));
		optionD.setBackground(new Color(240, 240, 240));
		optionA.setText(qn.getQuesAndOption(currentQuestion).get(1));
		optionB.setText(qn.getQuesAndOption(currentQuestion).get(2));
		optionC.setText(qn.getQuesAndOption(currentQuestion).get(3));
		optionD.setText(qn.getQuesAndOption(currentQuestion).get(4));
		
	}
	
private void showPopUp(int score) {
		
		JDialog resultPopUp = new JDialog();
		resultPopUp.setSize(227,124);
		resultPopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultPopUp.setResizable(false);
		
		JLabel resultLabel = new JLabel("Your Score is : " + score + "/10");
		resultLabel.setFont(new Font("Dialog",Font.PLAIN,18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultPopUp.getContentPane().add(resultLabel,BorderLayout.CENTER);
		
		resultPopUp.add(resultLabel);
		resultPopUp.setVisible(true);
		resultPopUp.setLocationRelativeTo(this);
		
	}
	
	
	
	
	
}
