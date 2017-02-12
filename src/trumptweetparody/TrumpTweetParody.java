/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trumptweetparody;
//import tweet.images;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;


/**
 *
 * @author Zarathustra aka Kevin Baik
 */
public class TrumpTweetParody {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedImage trumpPic = null;
        try {
            trumpPic = ImageIO.read(new File("TrumpPic.jpg"));
        } catch (IOException e) {
        }
        
        String tweetText = "";
        
        //HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        
        ///*
        tweetText = "TROLOLOLOLOL";
        String html = trumpPic + "<h1>Donald J. Trump.</h1>"
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
    
}
