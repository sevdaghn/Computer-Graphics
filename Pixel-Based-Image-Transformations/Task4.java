import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File("input.jpg"));
            int w = img.getWidth();
            int h = img.getHeight();

            // NEGATIVE
            BufferedImage negative = new BufferedImage(w, h, img.getType());
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    Color c = new Color(img.getRGB(x, y));
                    int r = 255 - c.getRed();
                    int g = 255 - c.getGreen();
                    int b = 255 - c.getBlue();
                    negative.setRGB(x, y, new Color(r, g, b).getRGB());
                }
            }
            ImageIO.write(negative, "jpg", new File("output_negative.jpg"));

            // ADDITION (+50)
            BufferedImage addition = new BufferedImage(w, h, img.getType());
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    Color c = new Color(img.getRGB(x, y));
                    int r = Math.min(255, c.getRed() + 50);
                    int g = Math.min(255, c.getGreen() + 50);
                    int b = Math.min(255, c.getBlue() + 50);
                    addition.setRGB(x, y, new Color(r, g, b).getRGB());
                }
            }
            ImageIO.write(addition, "jpg", new File("output_addition.jpg"));

            // SUBTRACTION (-50)
            BufferedImage subtraction = new BufferedImage(w, h, img.getType());
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    Color c = new Color(img.getRGB(x, y));
                    int r = Math.max(0, c.getRed() - 50);
                    int g = Math.max(0, c.getGreen() - 50);
                    int b = Math.max(0, c.getBlue() - 50);
                    subtraction.setRGB(x, y, new Color(r, g, b).getRGB());
                }
            }
            ImageIO.write(subtraction, "jpg", new File("output_subtraction.jpg"));

            // MULTIPLICATION (*2)
            BufferedImage multiplication = new BufferedImage(w, h, img.getType());
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    Color c = new Color(img.getRGB(x, y));
                    int r = Math.min(255, (int)(c.getRed() * 2));
                    int g = Math.min(255, (int)(c.getGreen() * 2));
                    int b = Math.min(255, (int)(c.getBlue() * 2));
                    multiplication.setRGB(x, y, new Color(r, g, b).getRGB());
                }
            }
            ImageIO.write(multiplication, "jpg", new File("output_multiplication.jpg"));

            // DIVISION (/2)
            BufferedImage division = new BufferedImage(w, h, img.getType());
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    Color c = new Color(img.getRGB(x, y));
                    int r = c.getRed() / 2;
                    int g = c.getGreen() / 2;
                    int b = c.getBlue() / 2;
                    division.setRGB(x, y, new Color(r, g, b).getRGB());
                }
            }
            ImageIO.write(division, "jpg", new File("output_division.jpg"));

            // GRAYSCALE (linear RGB weights)
            BufferedImage gray1 = new BufferedImage(w, h, img.getType());
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    Color c = new Color(img.getRGB(x, y));
                    int y1 = (int)(0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue());
                    gray1.setRGB(x, y, new Color(y1, y1, y1).getRGB());
                }
            }
            ImageIO.write(gray1, "jpg", new File("output_grayscale1.jpg"));

            // GRAYSCALE (luma coding)
            BufferedImage gray2 = new BufferedImage(w, h, img.getType());
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    Color c = new Color(img.getRGB(x, y));
                    int y2 = (int)(0.299 * c.getRed() + 0.587 * c.getGreen() + 0.114 * c.getBlue());
                    gray2.setRGB(x, y, new Color(y2, y2, y2).getRGB());
                }
            }
            ImageIO.write(gray2, "jpg", new File("output_grayscale2.jpg"));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
