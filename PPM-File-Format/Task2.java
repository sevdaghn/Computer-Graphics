// Task2.java
// This program reads a PPM image file (P3 or P6 format).
// It shows the image in a window (scaled up) and saves it as a JPG file.
// It also handles color scaling and incomplete data.

import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Task2 {
    public static void main(String[] args) throws Exception {
        // Open the input file
        InputStream in = new BufferedInputStream(new FileInputStream("ppm_images/Task2.p6.ppm"));

        // Read format type (P3 or P6)
        String format = readLine(in).trim();
        String line;

        // Read image width and height
        do { line = readLine(in).trim(); } while (line.startsWith("#") || line.isEmpty());
        String[] dim = line.split(" ");
        int width = Integer.parseInt(dim[0]);
        int height = Integer.parseInt(dim[1]);

        // Read max color value
        do { line = readLine(in).trim(); } while (line.startsWith("#") || line.isEmpty());
        int max = Integer.parseInt(line);

        // Create an empty image with the correct size
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Handle P3 format (text-based)
        if (format.equals("P3")) {
            ByteArrayOutputStream text = new ByteArrayOutputStream();
            int b;
            while ((b = in.read()) != -1) text.write(b);
            String[] values = text.toString().trim().split("\\s+");
            int i = 0;
            for (int y = 0; y < height; y++)
                for (int x = 0; x < width; x++) {
                    int r = scale(Integer.parseInt(values[i++]), max);
                    int g = scale(Integer.parseInt(values[i++]), max);
                    int b2 = scale(Integer.parseInt(values[i++]), max);
                    image.setRGB(x, y, new Color(r, g, b2).getRGB());
                }
        }

        // Handle P6 format (binary-based)
        else if (format.equals("P6")) {
            int bytesPerComponent = (max > 255) ? 2 : 1;
            int totalBytes = width * height * 3 * bytesPerComponent;
            byte[] data = in.readNBytes(totalBytes);
            if (data.length != totalBytes)
                throw new IOException("Incomplete pixel data.");

            int i = 0;
            for (int y = 0; y < height; y++)
                for (int x = 0; x < width; x++) {
                    int r, g, b;
                    if (bytesPerComponent == 1) {
                        r = scale(data[i++] & 0xFF, max);
                        g = scale(data[i++] & 0xFF, max);
                        b = scale(data[i++] & 0xFF, max);
                    } else {
                        r = scale(((data[i++] & 0xFF) << 8) | (data[i++] & 0xFF), max);
                        g = scale(((data[i++] & 0xFF) << 8) | (data[i++] & 0xFF), max);
                        b = scale(((data[i++] & 0xFF) << 8) | (data[i++] & 0xFF), max);
                    }
                    image.setRGB(x, y, new Color(r, g, b).getRGB());
                }
        }

        // Unsupported format
        else {
            throw new IOException("Unsupported format: " + format);
        }

        // Scale the image so it looks bigger on screen
        int scale = 100; // 2x2 image becomes 200x200
        BufferedImage bigImage = scaleImage(image, scale);

        // Show the image in a window
        JFrame frame = new JFrame("Image");
        frame.add(new JLabel(new ImageIcon(bigImage)));
        frame.pack();
        frame.setVisible(true);

        // Save the original image (not scaled) as JPEG
        ImageIO.write(bigImage, "jpg", new File("output.jpg"));

    }

    // Reads a line from the input stream
    static String readLine(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int b;
        while ((b = in.read()) != -1 && b != '\n') buffer.write(b);
        return buffer.toString();
    }

    // Converts color values from 0–max to 0–255 range
    static int scale(int val, int max) {
        return val * 255 / max;
    }

    // Scales an image by repeating pixels
    static BufferedImage scaleImage(BufferedImage original, int scale) {
        int width = original.getWidth() * scale;
        int height = original.getHeight() * scale;
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < original.getHeight(); y++) {
            for (int x = 0; x < original.getWidth(); x++) {
                int rgb = original.getRGB(x, y);
                for (int dy = 0; dy < scale; dy++) {
                    for (int dx = 0; dx < scale; dx++) {
                        scaled.setRGB(x * scale + dx, y * scale + dy, rgb);
                    }
                }
            }
        }

        return scaled;
    }
}
