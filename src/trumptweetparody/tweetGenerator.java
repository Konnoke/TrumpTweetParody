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
import java.text.AttributedCharacterIterator;
import java.text.DecimalFormat;
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

  //String tweetText = "";
  static BufferedImage imageTweet;
  static Tweet fakeTweet;
  static BufferedImage pic;
  static BufferedImage outputImage;

  public void setPic(BufferedImage pic) {
    tweetGenerator.pic = pic;
  }

  public static BufferedImage getPic() {
    return pic;
  }

  public tweetGenerator(Tweet sprint2) {
    fakeTweet = sprint2;
    //System.out.println("Constructor: "+fakeTweet.getType());
  }

  public static String formatNumberExample(Number number) {
    char[] suffix = {' ', 'k', 'M', 'B', 'T', 'P', 'E'};
    long numValue = number.longValue();
    int value = (int) Math.floor(Math.log10(numValue));
    int base = value / 3;
    if (value >= 3 && base < suffix.length) {
      return new DecimalFormat("~#0.0").format(numValue / Math.pow(10, base * 3)) + suffix[base];
    } else {
      return new DecimalFormat("#,##0").format(numValue);
    }
  }

  public void generateImage() throws IOException {
    BufferedImage trumpPic = null;
    BufferedImage trumpNameBig = null;
    BufferedImage trumpName = null;
    BufferedImage likes = null;
    BufferedImage replies = null;
    BufferedImage retweet = null;

    /*
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter in the customized Tweet text (140 characters): ");
    tweetText = scan.nextLine();
     */
    //tweetText = "Hi, this is customized Tweet text for Sprint 1 ";
    //image = ImageIO.read(getClass().getResourceAsStream("tweet.images/TrumpPic.jpg"));
    //getClass().getClassLoader().getResourceAsStream(path)
    try {
      trumpPic = ImageIO.read(getClass().getResourceAsStream("/images/TrumpPic.jpg"));
      trumpNameBig = ImageIO.read(getClass().getResourceAsStream("/images/trumpNameBig.jpg"));
      trumpName = ImageIO.read(getClass().getResourceAsStream("/images/TrumpNameV.jpg"));
      likes = ImageIO.read(getClass().getResourceAsStream("/images/like.jpg"));
      replies = ImageIO.read(getClass().getResourceAsStream("/images/reply.jpg"));
      retweet = ImageIO.read(getClass().getResourceAsStream("/images/retweet.jpg"));

    } catch (IOException e) {
    }

    //System.out.println(fakeTweet.getType());
    //fakeTweet.setBigTweet();
    //System.out.println(fakeTweet.getType());
    //type 0 is normal size tweet
    fakeTweet.setStringLike();
    fakeTweet.setStringReply();
    fakeTweet.setStringRetweet();

    if (fakeTweet.getType() == 0) {
      imageTweet = new BufferedImage(fakeTweet.normalWidth, fakeTweet.normalHeight, TYPE_INT_BGR);
      Graphics2D g2 = imageTweet.createGraphics();
      g2.setPaint(new Color(255, 255, 255));
      g2.fillRect(0, 0, fakeTweet.normalWidth, fakeTweet.normalHeight);
      g2.drawImage(trumpPic, 15, 15, null);
      g2.drawImage(trumpName, 105, 15, null);

      g2.drawImage(replies, 30, 100, null);
      g2.drawImage(retweet, 130, 100, null);
      g2.drawImage(likes, 230, 100, null);

      g2.setPaint(Color.black);
      g2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14)); //"Arial" "Helvetica Neue"
      g2.drawString(fakeTweet.text, 110, 50);

      g2.setFont(new Font("Helvetica", Font.PLAIN, 13));
      g2.setColor(Color.GRAY);
      g2.drawString(fakeTweet.date, 360, 30);
      g2.drawString(fakeTweet.stringReply, 70, 115);
      g2.drawString(fakeTweet.stringRetweet, 170, 115);
      g2.drawString(fakeTweet.stringLikes, 260, 115);
      g2.dispose();
      try {
        ImageIO.write(imageTweet, "png", new File("Tweet.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }//*/
    }
    //type 1 is big size tweet
    //type 1 is now the picture tweet
    if (fakeTweet.getType() == 1) {
      imageTweet = new BufferedImage(fakeTweet.bigWidth, fakeTweet.bigHeight, TYPE_INT_BGR);
      Graphics2D g2 = imageTweet.createGraphics();
      g2.setPaint(new Color(255, 255, 255));
      g2.fillRect(0, 0, fakeTweet.width, fakeTweet.height);
      g2.drawImage(trumpPic, 15, 15, null);
      g2.drawImage(trumpName, 105, 15, null);
      g2.drawImage(replies, 40, 540, null);
      g2.drawImage(retweet, 140, 540, null);
      g2.drawImage(likes, 230, 540, null);
      resize(560, 400);
      g2.drawImage(outputImage, 40, 120, null);
      g2.setPaint(Color.black);
      g2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
      g2.drawString(fakeTweet.text, 115, 55);

      g2.setFont(new Font("Helvetica", Font.PLAIN, 13));
      g2.setColor(Color.GRAY);
      g2.drawString(fakeTweet.date, 360, 30);
      g2.drawString(fakeTweet.date, 360, 30);
      g2.drawString(fakeTweet.stringReply, 70, 555);
      g2.drawString(fakeTweet.stringRetweet, 170, 555);
      g2.drawString(fakeTweet.stringLikes, 260, 555);

      g2.dispose();
      try {
        ImageIO.write(imageTweet, "png", new File("PictureTweet.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }//*/
    }

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

  public ImageIcon getImage() {
    ImageIcon previewImage = new ImageIcon(imageTweet);
    return previewImage;
  }

  public static void resize(int scaledWidth, int scaledHeight) throws IOException {
    //File inputFile = new File(inputImagePath);
    //BufferedImage inputImage = ImageIO.read(inputFile);
    String outputImagePath = "";

    // creates output image
    outputImage = new BufferedImage(scaledWidth,
        scaledHeight, TYPE_INT_BGR);

    // scales the input image to the output image
    Graphics2D g2d = outputImage.createGraphics();
    g2d.drawImage(pic, 0, 0, scaledWidth, scaledHeight, null);
    g2d.dispose();

    // extracts extension of output file
    String formatName = outputImagePath.substring(outputImagePath
        .lastIndexOf(".") + 1);

    // writes to output file
    ImageIO.write(outputImage, "picture", new File("/"));

  }

}
