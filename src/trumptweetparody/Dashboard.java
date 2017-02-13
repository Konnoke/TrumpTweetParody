/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trumptweetparody;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zarathustra aka Kevin aka Konnoke
 */
public class Dashboard extends JFrame{
    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 400;
    
    public void Dashboard(){
        initComponents();
    }
    
    public void initComponents(){
        
        final JFrame frame = new JFrame();
        final JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel);
        buttonPanel.setLayout(null);

        // Set up Add button and its location
        final JButton buttonAdd = new JButton(" Add ");
        buttonAdd.setBounds(50, 325, 100, 20);
        buttonPanel.add(buttonAdd);
        ///* Set up Generate Tweet Button
        final JButton buttonRandom = new JButton("Generate Tweet");
        buttonRandom.setBounds(40, 200, 200, 20);
        buttonPanel.add(buttonRandom);        
        
        // Set up Exit button and its location
        final JButton buttonExit = new JButton("Exit");
        buttonExit.setBounds(200, 325, 100, 20);
        buttonPanel.add(buttonExit);
        
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        
        // Set up Labels for Tweet text, date, and pay rate
        final JLabel labelTweetText = new JLabel("Enter tweet Text: ");
        labelTweetText.setBounds(20, 5, 150, 100);
        buttonPanel.add(labelTweetText);

        final JLabel labelDate = new JLabel("Enter Date: ");
        labelDate.setBounds(20, 60, 150, 100);
        buttonPanel.add(labelDate);

        final JLabel labelLike = new JLabel("Enter number of likes");
        labelLike.setBounds(20, 115, 150, 100);
        buttonPanel.add(labelLike);



        // Set up textboxes for all expected inputs
        final JTextField textTweetText = new JTextField();
        textTweetText.setBounds(180, 40, 100, 25);
        buttonPanel.add(textTweetText);

        final JTextField textDate = new JTextField();
        textDate.setBounds(180, 95, 100, 25);
        buttonPanel.add(textDate);

        final JTextField textLike = new JTextField();
        textLike.setBounds(180, 150, 100, 25);
        buttonPanel.add(textLike);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame.setLocationRelativeTo(null);
        
    }
    
}
