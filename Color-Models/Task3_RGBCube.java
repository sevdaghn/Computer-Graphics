import javax.swing.*;
import java.awt.*;

public class Task3_RGBCube {
    public static void main(String[] args) {
        JFrame window = new JFrame("RGB Cube");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 500);
        window.add(new RGBPanel());
        window.setVisible(true);
    }
}

class RGBPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int block = 20;
        int gap = 2;
        int interval = 51;

        for (int red = 0; red <= 255; red += interval) {
            for (int green = 0; green <= 255; green += interval) {
                for (int blue = 0; blue <= 255; blue += interval) {
                    g.setColor(new Color(red, green, blue));

                    int x = (red / interval) * (block + gap) + (blue / interval) * 140;
                    int y = (green / interval) * (block + gap);

                    g.fillRect(x, y, block, block);
                }
            }
        }
    }
}
