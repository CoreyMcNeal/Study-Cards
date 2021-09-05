package UserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import Logic.StudyCard;

public class StudyGUI implements ActionListener {
    
    private DeckHandler deckHandler = new DeckHandler();
    private List<StudyCard> chosenDeck = new ArrayList<>();

    private JFrame frame;                                           // Swing components for the GUI

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
    private JButton introClearButton;
    private JLabel introChooseLabel;
    private JComboBox<String> introChooseBox;
    private JButton introFinishedButton;

    private JPanel studyPanel;
    private GridBagConstraints studyConstraints;
    private JLabel studyCardNumber;
    private JLabel studyQuestionAndAnswer;
    private JButton studyFlipButton;
    private JButton studyNextButton;
    private JButton studyPreviousbutton;
    private JButton studyExitButton;
    

    public void start() {                                       //Queues the building of the frame and panels 
        buildPanelsAndFrame();
    }

    public void buildPanelsAndFrame() {                         //Builds the frame and panels
        frame = new JFrame();


        buildIntro();
        buildStudyPanel();

        frame.add(introPanel, BorderLayout.CENTER);
        frame.setTitle("Study Cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    private void buildIntro() {                                     //Builds the introPanel

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
        spaceMaker(spacer1, 0, 5, 15);

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
        spaceMaker(spacer2, 0, 8, 15);

        introAddButton = new JButton("Add Card");
        introAddButton.addActionListener(this);
        introConstraints.gridx = 0;
        introConstraints.gridy = 9;
        introAddButton.setPreferredSize(new Dimension(200, 100));
        introPanel.add(introAddButton, introConstraints);

        JLabel spacer3 = new JLabel("");
        spaceMaker(spacer3, 0, 10, 10);

        introClearButton = new JButton("Clear Entries");
        introClearButton.addActionListener(this);
        //finish button creation
        introConstraints.gridx = 0;
        introConstraints.gridy= 11;
        introClearButton.setPreferredSize(new Dimension(150, 75));
        introPanel.add(introClearButton, introConstraints);

        JLabel spacer4 = new JLabel("");
        spaceMaker(spacer4, 0, 12, 15);

        introChooseLabel = new JLabel("Choose cards to study:");
        introConstraints.gridx = 0;
        introConstraints.gridy = 13;
        introPanel.add(introChooseLabel, introConstraints);

        JLabel spacer5 = new JLabel("");
        spaceMaker(spacer5, 0, 14, 15);
        
        String[] chosenDifficulty = {"Easy", "Moderate", "Hard", "All"};
        introChooseBox = new JComboBox<String>(chosenDifficulty);
        introConstraints.gridx = 0;
        introConstraints.gridy = 15;
        introChooseBox.setPreferredSize(new Dimension(200, 20));
        introPanel.add(introChooseBox, introConstraints);

        JLabel spacer6 = new JLabel("");
        spaceMaker(spacer6, 0, 16, 15);

        introFinishedButton = new JButton("Start Studying");
        introFinishedButton.addActionListener(this);
        introFinishedButton.setEnabled(false);
        introConstraints.gridx = 0;
        introConstraints.gridy = 17;
        introFinishedButton.setPreferredSize(new Dimension(200, 100));
        introPanel.add(introFinishedButton, introConstraints);
    }

    private void buildStudyPanel() {                                                                         // Builds the studyPanel
        studyPanel = new JPanel();
        studyPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        studyPanel.setLayout(new GridBagLayout());
        studyConstraints = new GridBagConstraints();

        studyCardNumber = new JLabel("");
        studyCardNumber.setVerticalAlignment(SwingConstants.TOP);
        studyCardNumber.setHorizontalAlignment(SwingConstants.CENTER);
        //Needs to go on top, with a number representing which card in the set its on
        studyConstraints.gridx = 0;
        studyConstraints.gridy = 0;
        studyPanel.add(studyCardNumber, studyConstraints);

        JLabel spacer1 = new JLabel("");
        spaceMaker(spacer1, 0, 1, 15);

        studyQuestionAndAnswer = new JLabel("");
        studyQuestionAndAnswer.setPreferredSize(new Dimension(100, 300));
        //Needs to be centered, and start off as the question until the flip button is clicked, changing it to the answer.
        studyConstraints.gridx = 0;
        studyConstraints.gridy = 2;
        studyPanel.add(studyQuestionAndAnswer, studyConstraints);

        JLabel spacer2 = new JLabel("");
        spaceMaker(spacer2, 0, 3, 15);

        studyFlipButton = new JButton("Flip To See Answer");
        studyFlipButton.addActionListener(this);
        studyFlipButton.setPreferredSize(new Dimension(200, 100));
        studyConstraints.gridx = 0;
        studyConstraints.gridy = 4;
        studyPanel.add(studyFlipButton, studyConstraints);

        studyNextButton = new JButton("Next");
        studyNextButton.addActionListener(this);
        studyNextButton.setPreferredSize(new Dimension(200, 100));
        studyConstraints.gridx = 0;
        studyConstraints.gridy = 5;
        studyPanel.add(studyNextButton, studyConstraints);

        studyPreviousbutton = new JButton("Previous");
        studyPreviousbutton.addActionListener(this);
        studyPreviousbutton.setPreferredSize(new Dimension(200, 100));
        studyConstraints.gridx = 0;
        studyConstraints.gridy = 6;
        studyPreviousbutton.setEnabled(false);
        studyPanel.add(studyPreviousbutton, studyConstraints);

        studyExitButton = new JButton("Exit to Menu");
        studyExitButton.addActionListener(this);
        studyExitButton.setPreferredSize(new Dimension(100, 50));
        studyConstraints.gridx = 0;
        studyConstraints.gridy = 7;
        studyPanel.add(studyExitButton, studyConstraints);

    }

    private void spaceMaker(JLabel spacer, int gridx, int gridy, int space) {               //Method to help space out the components
        introConstraints.gridx = gridx;
        introConstraints.gridy = gridy;
        spacer.setPreferredSize(new Dimension(0, space));
        introPanel.add(spacer, introConstraints);
    }

    private void checkEntry(String question, String answer, String difficulty) {                    //Checks user entry to make sure it's not blank. Adds users chosen variables into the deck if successful, and
        if (introQuestionEntry.getText().isBlank() || introAnswerEntry.getText().isBlank()) {       //resets the boxes.
            JOptionPane.showMessageDialog(null, "Cannot leave question or answer blank");
            return;
        }

        introFinishedButton.setEnabled(true);
        deckHandler.addToDeck(question, answer, difficulty);
        introQuestionEntry.setText("");
        introAnswerEntry.setText("");
        introDifficultyBox.setSelectedIndex(0);
    }

    private void cardListChooser() {                                // Decides what deck to give to user based on difficulty chosen in the combobox
        deckHandler.shuffleDecks();
        if (introChooseBox.getSelectedItem().equals("Easy")) {
            chosenDeck = deckHandler.getEasyCardList();

        } else if (introChooseBox.getSelectedItem().equals("Moderate")) {
            chosenDeck = deckHandler.getModCardList();
            
        } else if (introChooseBox.getSelectedItem().equals("Hard")) {
            chosenDeck = deckHandler.getHardCardList();

        } else if (introChooseBox.getSelectedItem().equals("All")) {
            chosenDeck = deckHandler.getAllCardList();

        }
    }

    private void refreshFrame() {                                                       // Method to refresh the frame, to make sure changes are shown
        frame.validate();
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {                                        //Button events for the UI.
        if (e.getSource() == introAddButton) {
            checkEntry(introQuestionEntry.getText(), introAnswerEntry.getText(), introDifficultyBox.getSelectedItem().toString());

        } else if (e.getSource() == introFinishedButton) {
            cardListChooser();
            frame.remove(introPanel);
            frame.add(studyPanel);
            frame.setSize(600, 750);
            refreshFrame();

        } else if (e.getSource() == studyFlipButton) {
            //Code to switch to answer goes here

        } else if (e.getSource() == studyNextButton) {
            //Code to continue to next card goes here

        } else if (e.getSource() == studyPreviousbutton) {

        } else if (e.getSource() == studyExitButton) {

        }
        
    }
}
