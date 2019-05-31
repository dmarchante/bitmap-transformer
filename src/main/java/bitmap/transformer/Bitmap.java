/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Bitmap {
    BufferedImage image;

    public static void main(String[] args) {
//        File imagePath = new File("src/main/resources/image_file.bmp");
        File imagePath = new File(args[0]);


        try {
            BufferedImage image = ImageIO.read(imagePath);
            Bitmap bitmapImage = new Bitmap(image);

            if (args[2] == "grayScale") {
                BufferedImage grayscale = new BufferedImage(image.getWidth(), image.getHeight(), image.TYPE_INT_ARGB);

                for(int i = 0; i < image.getWidth(); i ++){
                    for(int j = 0; i < image.getWidth(); i ++) {
                        Color c = new Color(image.getRGB(j, i));

                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        int a = c.getAlpha();

                        int gr = (r + g + b) / 3;

                        Color gColor = new Color(gr, gr, gr, a);
                        grayscale.setRGB(j, i, gColor.getRGB());
                    }
                }
                bitmapImage.writeImageToFile(grayscale, args[1]);

            }
        } catch (IOException e) {
            e. printStackTrace();
        }

    }

//    public int[][] grayscaleTransform() {
//
//    }


    public void writeImageToFile(BufferedImage image, String output){
        try {
            ImageIO.write(image, "bmp", new File(output));
        } catch (IOException e) {
            e. printStackTrace();
        }
    }

    public Bitmap(BufferedImage image) {
        this.image = image;
    }
}
