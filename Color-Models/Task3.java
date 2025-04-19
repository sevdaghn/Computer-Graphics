import javax.swing.*;
import java.awt.*;

public class Task3 {
    public static void main(String[] args) {
        String[] options = {"RGB to CMYK", "CMYK to RGB"};
        int choice = JOptionPane.showOptionDialog(null, "Choose conversion type:", "Color Converter",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            int r = Integer.parseInt(JOptionPane.showInputDialog("Red (0-255):"));
            int g = Integer.parseInt(JOptionPane.showInputDialog("Green (0-255):"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Blue (0-255):"));

            double red = r / 255.0;
            double green = g / 255.0;
            double blue = b / 255.0;

            double k = 1 - Math.max(red, Math.max(green, blue));
            double c = 0, m = 0, y = 0;

            if (k != 1) {
                c = (1 - red - k) / (1 - k);
                m = (1 - green - k) / (1 - k);
                y = (1 - blue - k) / (1 - k);
            }

            String result = String.format("C: %.2f\nM: %.2f\nY: %.2f\nK: %.2f", c, m, y, k);
            JOptionPane.showMessageDialog(null, result);
            showColor(r, g, b);
        }

        else if (choice == 1) {
            double c = Double.parseDouble(JOptionPane.showInputDialog("Cyan (0.0 - 1.0):"));
            double m = Double.parseDouble(JOptionPane.showInputDialog("Magenta (0.0 - 1.0):"));
            double y = Double.parseDouble(JOptionPane.showInputDialog("Yellow (0.0 - 1.0):"));
            double k = Double.parseDouble(JOptionPane.showInputDialog("Black (0.0 - 1.0):"));

            double red = 1 - Math.min(1.0, c * (1 - k) + k);
            double green = 1 - Math.min(1.0, m * (1 - k) + k);
            double blue = 1 - Math.min(1.0, y * (1 - k) + k);

            int r = (int)(red * 255);
            int g = (int)(green * 255);
            int b = (int)(blue * 255);

            String result = "R: " + r + "\nG: " + g + "\nB: " + b;
            JOptionPane.showMessageDialog(null, result);
            showColor(r, g, b);
        }

        else {
            JOptionPane.showMessageDialog(null, "No option selected.");
        }
    }

    public static void showColor(int r, int g, int b) {
        Color color = new Color(r, g, b);
        JPanel panel = new JPanel();
        panel.setBackground(color);

        JFrame window = new JFrame("Color");
        window.setSize(250, 250);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.setVisible(true);
    }
}
