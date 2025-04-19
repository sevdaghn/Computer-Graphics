import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Task3_HSV {
    public static void main(String[] args) {
        JFrame window = new JFrame("HSV Color Circle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(420, 440);
        window.add(new HSVPanel(400, 400));
        window.setVisible(true);
    }
}

class HSVPanel extends JPanel {
    private final BufferedImage image;

    public HSVPanel(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        generateHSVImage(width, height);
    }

    private void generateHSVImage(int width, int height) {
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(centerX, centerY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int dx = x - centerX;
                int dy = y - centerY;
                double dist = Math.hypot(dx, dy);

                if (dist <= radius) {
                    float sat = (float) (dist / radius);
                    float hue = (float) (Math.toDegrees(Math.atan2(dy, dx)) + 360) % 360;
                    Color c = Color.getHSBColor(hue / 360f, sat, 1f);
                    image.setRGB(x, y, c.getRGB());
                } else {
                    image.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
