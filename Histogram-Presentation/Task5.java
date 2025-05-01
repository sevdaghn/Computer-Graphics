import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Task5 {
    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File("image.png"));
            BufferedImage gray = makeGray(img);

            showHistogram(getHist(gray), "Original");

            BufferedImage stretched = stretch(gray);
            showHistogram(getHist(stretched), "Stretched");

            BufferedImage equalized = equalize(gray);
            showHistogram(getHist(equalized), "Equalized");

        } catch (Exception e) {
            System.out.println("Error loading image.");
        }
    }

    static BufferedImage makeGray(BufferedImage img) {
        BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = gray.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return gray;
    }

    static int[] getHist(BufferedImage img) {
        int[] h = new int[256];
        for (int y = 0; y < img.getHeight(); y++)
            for (int x = 0; x < img.getWidth(); x++)
                h[img.getRaster().getSample(x, y, 0)]++;
        return h;
    }

    static BufferedImage stretch(BufferedImage img) {
        int w = img.getWidth(), h = img.getHeight();
        int min = 255, max = 0;
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++) {
                int v = img.getRaster().getSample(x, y, 0);
                if (v < min) min = v;
                if (v > max) max = v;
                

            }
            System.out.println("Min: " + min + " Max: " + max);
        BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++) {
                int v = img.getRaster().getSample(x, y, 0);
                int newV = (v - min) * 255 / (max - min);
                out.getRaster().setSample(x, y, 0, newV);
            }
        return out;
    }

    static BufferedImage equalize(BufferedImage img) {
        int w = img.getWidth(), h = img.getHeight(), total = w * h;
        int[] hist = getHist(img), cdf = new int[256], map = new int[256];
        cdf[0] = hist[0];
        for (int i = 1; i < 256; i++) cdf[i] = cdf[i - 1] + hist[i];
        for (int i = 0; i < 256; i++) map[i] = (cdf[i] - cdf[0]) * 255 / (total - cdf[0]);

        BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++) {
                int v = img.getRaster().getSample(x, y, 0);
                out.getRaster().setSample(x, y, 0, map[v]);
            }
        return out;
    }

    static void showHistogram(int[] h, String title) {
        JFrame f = new JFrame(title);
        f.setSize(600, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JPanel() {
            protected void paintComponent(Graphics g) {
                int max = 0;
                for (int v : h) if (v > max) max = v;
                for (int i = 0; i < h.length; i++) {
                    int height = (int)((h[i] / (float) max) * getHeight());
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(i * getWidth() / 256, getHeight() - height, getWidth() / 256, height);
                }
            }
        });
        f.setVisible(true);
    }
}
