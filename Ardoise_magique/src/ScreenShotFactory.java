
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//romaric
public class ScreenShotFactory {

    public final static String IMAGE_TYPE_JPEG = "jpeg";

    public final static String IMAGE_TYPE_GIF = "gif";

    public final static String IMAGE_TYPE_PNG = "png";

    public static void screenShot(Rectangle screenArea,
            Dimension screenshotFinalDimension, String pictureName,
            String compressionType) {
        	BufferedImage buf = null; // Notre capture d'�cran originale
        	BufferedImage bufFinal = null; // Notre capture d'�cran redimensionn�e
        	BufferedImage roma =null;
        try {
            // Cr�ation de notre capture d'�cran
            buf = new Robot().createScreenCapture(screenArea);
            
        } catch (AWTException e) {
            e.printStackTrace(); 
        }
        // Cr�ation de la capture finale
        bufFinal = new BufferedImage(screenshotFinalDimension.width,
                screenshotFinalDimension.height, BufferedImage.TYPE_INT_RGB);
        // Redimensionnement de la capture originale
        Graphics2D g = (Graphics2D) bufFinal.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(buf, 0, 0, screenshotFinalDimension.width, screenshotFinalDimension.height, null);
        g.dispose();

        //Ecriture de notre capture d'�cran redimensionn�e
        try {
            ImageIO.write(bufFinal, compressionType, new File(pictureName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScreenShotFactory.screenShot(new Rectangle(0, 0, 1980, 1080),
                new Dimension(1980, 1080), "test.png",
                ScreenShotFactory.IMAGE_TYPE_PNG);
    }
}