package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Bitmap {

    private BufferedImage img ;
    private BufferedImage ResultImage;
    private String outputFilename  ;


    public Bitmap(BufferedImage img, String outputFile) {
        this.img = img;
        this.outputFilename = outputFile;
    }


    public void setResultImage() {
        //this.ResultImage = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);
        this.ResultImage = img ;
    }
    public BufferedImage getResultImage() {
        return ResultImage;
    }
    public File ResultImageFile(String filenameOutput) throws IOException {
        //filenameOutput= "app/src/main/resources/Output/"+ filenameOutput ;
        File outputfile = new File(filenameOutput);
        return outputfile;
    }


    public void Gray() throws IOException {
        setResultImage();
        for (int i=0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                //getting RGB color on each pixel
                Color c = new Color(img.getRGB(i, j),true);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();
                //turning color
               int gary = (r+g+b)/3;
                c = new Color(gary, gary, gary,a);
                getResultImage().setRGB(i, j, c.getRGB());
            }
        }
        try {
            ImageIO.write(ResultImage, "bmp", ResultImageFile(outputFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Added a Gray Transform Image");
        }
    }
    public void darker() throws IOException {
        setResultImage();
        for (int i=0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                //getting RGB color on each pixel
                Color c = new Color(img.getRGB(i, j),true);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue() ;
                int a = c.getAlpha();
                r = (int) (.7 * r);
                g = (int) (.7 * g);
                b = (int) (.7 * b);

                c = new Color(r,g,b,a);
               //c.darker();
            getResultImage().setRGB(i, j, c.getRGB());
            }
        }
        try {
            ImageIO.write(ResultImage, "bmp", ResultImageFile(outputFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Added a Darker Transform Image");
        }
    }
    public void Lighter() throws IOException {
        setResultImage();
        for (int i=0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                //getting RGB color on each pixel
                Color c = new Color(img.getRGB(i, j),true);
                int r= c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();
                r = (int) (r + (255 - r) *.7);
                g = (int) (g + (255 - g) *.7);
                b = (int) (b + (255 - b) *.7);

                c = new Color(r,g,b,a);

                getResultImage().setRGB(i, j, c.getRGB());
            }
        }
        try {
            ImageIO.write(ResultImage, "bmp", ResultImageFile(outputFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Added a Lighter Transform Image");
        }
    }
    public void Mirror()  {
        setResultImage();
        for (int i=0; i < img.getWidth()/2; i++) {
            for (int j = 0; j < img.getHeight() ; j++) {

                int swap = img.getRGB(i,j);
                getResultImage().setRGB(i,j,img.getRGB(img.getWidth() - i - 1, j));
                getResultImage().setRGB(img.getWidth() - i - 1, j, swap);
            }
        }
        try {
            ImageIO.write(ResultImage, "bmp", ResultImageFile(outputFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Added a Mirror Transform Image");
        }

    }


}
