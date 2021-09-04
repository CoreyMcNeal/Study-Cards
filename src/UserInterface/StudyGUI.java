package UserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StudyGUI implements ActionListener{
    
    private JFrame frame;

    private JPanel introPanel;
    private GridBagConstraints introConstraints;
    private JLabel introWelcomeLabel;
    private JLabel introQuestionLabel;
    private JTextField introQuestionEntry;
    private JLabel introAnswerLabel;
    private JTextField introAnswerEntry;
    private JLabel introDifficultyLabel;
    private JComboBox<String> introDifficultyBox;
    private JButton introAddButton;
    private JButton introFinishedButton;


    public void start() {
        buildPanelsAndFrame();
    }

    public void buildPanelsAndFrame() {
        frame = new JFrame();


        buildIntro();

        frame.add(introPanel, BorderLayout.CENTER);
        frame.setTitle("Study Cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    private void buildIntro() {

        introPanel = new JPanel();
        introPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        introPanel.setLayout(new GridBagLayout());
        introConstraints = new GridBagConstraints();

        introWelcomeLabel = new JLabel("Welcome to Study Cards, Java Edition!", SwingConstants.CENTER);
        introConstraints.gridx = 0;
        introConstraints.gridy = 0;
        introPanel.add(introWelcomeLabel, introConstraints);

        introQuestionLabel = new JLabel("Enter Question: ");
        introConstraints.gridx = 0;
        introConstraints.gridy = 1;
        introQuestionLabel.setBorder(new EmptyBorder(20, 0, 10, 0));
        introPanel.add(introQuestionLabel, introConstraints);

        introQuestionEntry = new JTextField();
        introConstraints.gridx = 0;
        introConstraints.gridy = 2;
        introQuestionEntry.setPreferredSize(new Dimension(200, 20));
        introPanel.add(introQuestionEntry, introConstraints);

        introAnswerLabel = new JLabel("Enter Answer: ");
        introConstraints.gridx = 0;
        introConstraints.gridy = 3;
        introAnswerLabel.setBorder(new EmptyBorder(15, 0, 10, 0));
        introPanel.add(introAnswerLabel, introConstraints);

        introAnswerEntry = new JTextField();
        introConstraints.gridx = 0;
        introConstraints.gridy = 4;
        introAnswerEntry.setPreferredSize(new Dimension(200, 20));
        introPanel.add(introAnswerEntry, introConstraints);

        JLabel spacer1 = new JLabel("");
        introConstraints.gridx = 0;
        introConstraints.gridy = 5;
        spacer1.setPreferredSize(new Dimension(0, 15));
        introPanel.add(spacer1, introConstraints);

        introDifficultyLabel = new JLabel("Choose Difficulty: ");
        introConstraints.gridx = 0;
        introConstraints.gridy = 6;
        introDifficultyLabel.setBorder(new EmptyBorder(15, 0, 10, 0));
        introPanel.add(introDifficultyLabel, introConstraints);

        String[] difficulties = {"Easy", "Moderate", "Hard"};
        introDifficultyBox = new JComboBox<String>(difficulties);
        introConstraints.gridx = 0;
        introConstraints.gridy = 7;
        introDifficultyBox.setPreferredSize(new Dimension(200, 20));
        introPanel.add(introDifficultyBox, introConstraints);

        JLabel spacer2 = new JLabel("");
        introConstraints.gridx = 0;
        introConstraints.gridy = 8;
        spacer2.setPreferredSize(new Dimension(0, 15));
        introPanel.add(spacer2, introConstraints);

        introAddButton = new JButton("Add Card");
        introAddButton.addActionListener(this);
        introConstraints.gridx = 0;
        introConstraints.gridy = 9;
        introAddButton.setPreferredSize(new Dimension(200, 100));
        introPanel.add(introAddButton, introConstraints);

        JLabel spacer3 = new JLabel("");
        introConstraints.gridx = 0;
        introConstraints.gridy = 10;
        spacer3.setPreferredSize(new Dimension(0, 15));
        introPanel.add(spacer3, introConstraints);

        introFinishedButton = new JButton("Start Studying");
        introFinishedButton.addActionListener(this);
        introFinishedButton.setEnabled(false);
        introConstraints.gridx = 0;
        introConstraints.gridy = 11;
        introFinishedButton.setPreferredSize(new Dimension(200, 100));
        introPanel.add(introFinishedButton, introConstraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == introAddButton) {
            introFinishedButton.setEnabled(true);

        }
        
    }
}
