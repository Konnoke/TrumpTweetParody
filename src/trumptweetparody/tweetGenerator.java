package trumptweetparody;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
/**
 *
 * @author Zarathustra
 */
public class tweetGenerator {
    
    public void generateIamge(){
        
        BufferedImage trumpPic = null;
        //image = ImageIO.read(getClass().getResourceAsStream("tweet.images/TrumpPic.jpg"));
        //getClass().getClassLoader().getResourceAsStream(path)
        try {
            trumpPic = ImageIO.read(getClass().getResourceAsStream("/images/TrumpPic.jpg"));
        } catch (IOException e) {
        }
        
        String tweetText = "";
        //System.out.println(System.getProperty("user.dir"));
        //HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        
        ///*
        tweetText = "TROLOLOLOLOL";
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
        JEditorPane jep = new JEditorPane("text/html", trumpPic + html);
        jep.setSize(width, height);
        jep.print(graphics);
        // Output the `BufferedImage` via `ImageIO`
        try {
            ImageIO.write(image, "png", new File("Tweet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }//*/
        
    }
    
    
    
}
