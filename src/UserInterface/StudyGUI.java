package UserInterface;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudyGUI {
    
    private JFrame frame;

    private JPanel introPanel;
    private JLabel introQuestionLabel;
    private JTextField introQuestionEntry;
    private JLabel introAnswerLabel;
    private JTextField introAnswerEntry;

    private JButton introAddButton;
    private JButton introSubmitButton;

    public void start() {

    }

    public void buildPanelsAndFrame() {
        frame = new JFrame();


        

        frame.add(introPanel, BorderLayout.CENTER);
        frame.setTitle("Study Cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    private void buildIntro() {

        introPanel = new JPanel();
        introPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        introPanel.setLayout(new GridBagLayout());

        // Add components to panel***********

    }
}
