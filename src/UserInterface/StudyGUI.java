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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Logic.DeckHandler;

public class StudyGUI implements ActionListener{
    
    private DeckHandler deckHandler = new DeckHandler();

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
    private JLabel introChooseLabel;
    private JComboBox<String> introChooseBox;
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
        spaceMaker(spacer1, 0, 5);

        introDifficultyLabel = new JLabel("Choose Difficulty: ");
        introConstraints.gridx = 0;
        introConstraints.gridy = 6;
        introDifficultyLabel.setBorder(new EmptyBorder(1, 0, 10, 0));
        introPanel.add(introDifficultyLabel, introConstraints);

        String[] difficulties = {"Easy", "Moderate", "Hard"};
        introDifficultyBox = new JComboBox<String>(difficulties);
        introConstraints.gridx = 0;
        introConstraints.gridy = 7;
        introDifficultyBox.setPreferredSize(new Dimension(200, 20));
        introPanel.add(introDifficultyBox, introConstraints);

        JLabel spacer2 = new JLabel("");
        spaceMaker(spacer2, 0, 8);

        introAddButton = new JButton("Add Card");
        introAddButton.addActionListener(this);
        introConstraints.gridx = 0;
        introConstraints.gridy = 9;
        introAddButton.setPreferredSize(new Dimension(200, 100));
        introPanel.add(introAddButton, introConstraints);

        JLabel spacer3 = new JLabel("");
        spaceMaker(spacer3, 0, 10);

        introChooseLabel = new JLabel("Choose cards to study:");
        introConstraints.gridx = 0;
        introConstraints.gridy = 11;
        introPanel.add(introChooseLabel, introConstraints);

        JLabel spacer4 = new JLabel("");
        spaceMaker(spacer4, 0, 12);
        
        introChooseBox = new JComboBox<String>(difficulties);
        introConstraints.gridx = 0;
        introConstraints.gridy = 13;
        introChooseBox.setPreferredSize(new Dimension(200, 20));
        introPanel.add(introChooseBox, introConstraints);

        JLabel spacer5 = new JLabel("");
        spaceMaker(spacer5, 0, 14);

        introFinishedButton = new JButton("Start Studying");
        introFinishedButton.addActionListener(this);
        introFinishedButton.setEnabled(false);
        introConstraints.gridx = 0;
        introConstraints.gridy = 15;
        introFinishedButton.setPreferredSize(new Dimension(200, 100));
        introPanel.add(introFinishedButton, introConstraints);
    }

    private void spaceMaker(JLabel spacer, int gridx, int gridy) {
        introConstraints.gridx = gridx;
        introConstraints.gridy = gridy;
        spacer.setPreferredSize(new Dimension(0, 15));
        introPanel.add(spacer, introConstraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == introAddButton) {
            checkEntry(introQuestionEntry.getText(), introAnswerEntry.getText(), introDifficultyBox.getSelectedItem().toString());
        } else if (e.getSource() == introFinishedButton) {

        }
        
    }

    private void checkEntry(String question, String answer, String difficulty) {
        if (introQuestionEntry.getText().isBlank() || introAnswerEntry.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Cannot leave question or answer blank");
            return;
        }

        introFinishedButton.setEnabled(true);
        deckHandler.addToDeck(question, answer, difficulty);
        introQuestionEntry.setText("");
        introAnswerEntry.setText("");
        introDifficultyBox.setSelectedIndex(0);
    }
}
