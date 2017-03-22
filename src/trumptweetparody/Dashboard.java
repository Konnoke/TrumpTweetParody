/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trumptweetparody;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zarathustra aka Kevin aka Konnoke
 */
public class Dashboard extends JFrame {

  private static final int FRAME_WIDTH = 1000;
  private static final int FRAME_HEIGHT = 500;
  static final Tweet fakeTweet = new Tweet();
  static final JFrame frame = new JFrame();
  static final JPanel buttonPanel = new JPanel();

  public static void Dashboard() {
    //initComponents();
  }

  public static void initComponents() {
    /*
    final Tweet fakeTweet = new Tweet();
    final JFrame frame = new JFrame();
    final JPanel buttonPanel = new JPanel(); */
    frame.add(buttonPanel);
    buttonPanel.setLayout(null);

    // Set up Add button and its location
    final JButton buttonAdd = new JButton(" Add ");
    buttonAdd.setBounds(50, 425, 100, 20);
    buttonPanel.add(buttonAdd);
    ///* Set up Generate Tweet Button
    final JButton buttonGenerate = new JButton("Generate Tweet");
    buttonGenerate.setBounds(40, 385, 200, 20);
    buttonPanel.add(buttonGenerate);

    // Set up Exit button and its location
    final JButton buttonExit = new JButton("Exit");
    buttonExit.setBounds(200, 425, 100, 20);
    buttonPanel.add(buttonExit);

    // Set up Labels for Tweet text, date, and pay rate
    final JLabel labelTweetText = new JLabel("Enter Tweet Text: ");
    labelTweetText.setBounds(20, 5, 150, 100);
    buttonPanel.add(labelTweetText);

    final JLabel labelDate = new JLabel("Enter Date: ");
    labelDate.setBounds(20, 60, 150, 100);
    buttonPanel.add(labelDate);

    final JLabel labelLike = new JLabel("Enter number of likes");
    labelLike.setBounds(20, 115, 150, 100);
    buttonPanel.add(labelLike);
///*
    final JLabel labelRetweet = new JLabel("Enter number of retweets");
    labelRetweet.setBounds(20, 165, 150, 100);
    buttonPanel.add(labelRetweet);

    final JLabel labelReply = new JLabel("Enter number of replies");
    labelReply.setBounds(20, 215, 150, 100);
    buttonPanel.add(labelReply);
    //*/  

    // Set up textboxes for all expected inputs
    final JTextField textTweetText = new JTextField();
    textTweetText.setBounds(180, 40, 100, 25);
    buttonPanel.add(textTweetText);

    final JTextField textDate = new JTextField();
    textDate.setBounds(180, 95, 100, 25);
    buttonPanel.add(textDate);

    final JTextField textLike = new JTextField("0");
    textLike.setBounds(180, 150, 100, 25);
    buttonPanel.add(textLike);

    final JTextField textRetweet = new JTextField("0");
    textRetweet.setBounds(180, 205, 100, 25);
    buttonPanel.add(textRetweet);

    final JTextField textReply = new JTextField("0");
    textReply.setBounds(180, 260, 100, 25);
    buttonPanel.add(textReply);

    JRadioButton normalTweetButton = new JRadioButton("Normal Size Tweet");
    normalTweetButton.setMnemonic(KeyEvent.VK_C);
    //normalTweetButton.setActionCommand("Normal Size Tweet");
    normalTweetButton.setBounds(15, 300, 200, 25);
    normalTweetButton.setSelected(true);
    buttonPanel.add(normalTweetButton);

    JRadioButton bigTweetButton = new JRadioButton("Big Size Tweet");
    bigTweetButton.setMnemonic(KeyEvent.VK_C);
    //bigTweetButton.setActionCommand("Big Size Tweet");
    bigTweetButton.setBounds(15, 325, 200, 25);
    buttonPanel.add(bigTweetButton);
    ///*
    ButtonGroup group = new ButtonGroup();
    group.add(normalTweetButton);
    group.add(bigTweetButton);
    //*/

    normalTweetButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fakeTweet.setNormalTweet();
        System.out.println(fakeTweet.getType());
      }
    });

    bigTweetButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fakeTweet.setBigTweet();
        System.out.println(fakeTweet.getType());
      }
    });

    buttonGenerate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //fakeTweet.setNormalTweet();
        ///*
        fakeTweet.setText(textTweetText.getText());
        fakeTweet.setDate(textDate.getText());
        fakeTweet.setLikes(Integer.parseInt(textLike.getText()));
        fakeTweet.setRetweet(Integer.parseInt(textRetweet.getText()));
        fakeTweet.setReplies(Integer.parseInt(textReply.getText()));
        //*/
        tweetGenerator Bing = new tweetGenerator(fakeTweet);
        Bing.generateImage();
        //getImagePreview();

        /*
        
        BufferedImage displayTweet = Bing.getImage();
        ImageIcon image = new ImageIcon(displayTweet);
        JLabel tweetPreview = new JLabel(image);
        tweetPreview.setBounds(400, 20, fakeTweet.getWidth(), fakeTweet.getHeight());
        tweetPreview.setVisible(true);
        buttonPanel.add(tweetPreview);
         //*/
        /*
        ImageIcon tweetPreview = new ImageIcon("Tweet.png");
        JLabel tweetImagePreview = new JLabel(tweetPreview);
        tweetImagePreview.setBounds(300, 10, 640, 400);
        tweetImagePreview.setVisible(true);
        buttonPanel.add(tweetImagePreview);

        //*/
      }
    });

    buttonExit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        System.exit(0);
      }
    });

    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setTitle("Dashboard");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    frame.setLocationRelativeTo(null);
    /*
    ImageIcon tweetPreview = new ImageIcon("Tweet.png");
    JLabel tweetImagePreview = new JLabel(tweetPreview);
    tweetImagePreview.setBounds(300, 10, 640, 400);
    tweetImagePreview.setVisible(true);
    buttonPanel.add(tweetImagePreview);
    //*///

  }

  public static void getImagePreview() {
    ImageIcon tweetPreview = new ImageIcon("Tweet.png");
    JLabel tweetImagePreview = new JLabel(tweetPreview);
    tweetImagePreview.setBounds(300, 10, 640, 400);
    tweetImagePreview.setVisible(true);
    buttonPanel.add(tweetImagePreview);

  }

}
