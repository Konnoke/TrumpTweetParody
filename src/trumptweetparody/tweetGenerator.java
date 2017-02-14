package trumptweetparody;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_3BYTE_BGR;
import static java.awt.image.BufferedImage.TYPE_BYTE_INDEXED;
import static java.awt.image.BufferedImage.TYPE_CUSTOM;
import static java.awt.image.BufferedImage.TYPE_INT_BGR;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Zarathustra aka Kevin aka Konnoke
 */
public class tweetGenerator {
  String tweetText = "";
  
  
  public void generateIamge() {
    BufferedImage trumpPic = null;
    BufferedImage trumpName = null;
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter in the customized Tweet text (140 characters): ");
    tweetText = scan.nextLine();
    
    //tweetText = "Hi, this is customized Tweet text for Sprint 1 ";
    
    //image = ImageIO.read(getClass().getResourceAsStream("tweet.images/TrumpPic.jpg"));
    //getClass().getClassLoader().getResourceAsStream(path)
    try {
      trumpPic = ImageIO.read(getClass().getResourceAsStream("/images/TrumpPic.jpg"));
      trumpName = ImageIO.read(getClass().getResourceAsStream("/images/TrumpName.jpg"));
    } catch (IOException e) {
    }
    Tweet sprint1 = new Tweet();
    sprint1.setNormalTweet();
    sprint1.setText(tweetText);
    
    BufferedImage imageTweet = new BufferedImage(sprint1.width, sprint1.height, TYPE_INT_BGR);
    Graphics2D g2 = imageTweet.createGraphics();
    g2.setPaint(new Color(255,255,255));
    g2.fillRect(0,0,sprint1.width, sprint1.height);
    g2.drawImage(trumpPic, 15, 15, null);
    g2.drawImage(trumpName, 105, 15, null);
    g2.setPaint(Color.black);
    g2.setFont(new Font("Arial", Font.PLAIN, 14));
    g2.drawString(sprint1.text, 105, 45);
    g2.dispose();
    
    
    try {
      ImageIO.write(imageTweet, "png", new File("Tweet.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }//*/
    
    //System.out.println(System.getProperty("user.dir"));
    //HtmlImageGenerator imageGenerator = new HtmlImageGenerator();

    /*
    String html = "<h1>Donald J. Trump.</h1>"
        + tweetText
        + " ";
    int width = 600, height = 135;

    // Create a `BufferedImage` and create the its `Graphics`
    BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getDefaultScreenDevice().getDefaultConfiguration()
        .createCompatibleImage(width, height);

    Graphics graphics = image.createGraphics();

    // Create an `JEditorPane` and invoke `print(Graphics)`
    JEditorPane jep = new JEditorPane("text/html", html);
    jep.setSize(width, height);
    jep.print(graphics);

    // Output the `BufferedImage` via `ImageIO`
    try {
      ImageIO.write(image, "png", new File("Tweet.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }//*/

  }

  public void display(BufferedImage image) {
    JFrame f = new JFrame("Preview");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JLabel(new ImageIcon(image)));
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }

}
