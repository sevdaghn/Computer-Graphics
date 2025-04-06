import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task1 {
    public static void main(String[] args) {
        new DrawingPanel();
    }
}

class DrawingPanel extends JFrame {
    JTextField inputField;
    JButton drawButton;
    MyCanvas panel;

    public DrawingPanel() {
        setTitle("Task1");

        inputField = new JTextField("rect 100 100 150 150", 20);
        drawButton = new JButton("OK");
        panel = new MyCanvas();

        drawButton.addActionListener(e -> {
            panel.setCommand(inputField.getText());
        });

        JPanel TextField = new JPanel();
        TextField.add(inputField);
        TextField.add(drawButton);

        add(panel, BorderLayout.CENTER);
        add(TextField, BorderLayout.SOUTH);

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class MyCanvas extends JPanel implements MouseListener {
    String shape = "line";
    int[] values = new int[4];

    public MyCanvas() {
        addMouseListener(this);
    }

    public void setCommand(String text) {
        String[] parts = text.split(" ");
        shape = parts[0];
        for (int i = 1; i < parts.length; i++) {
            values[i - 1] = Integer.parseInt(parts[i]);
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shape.equals("line")) {
            g.drawLine(values[0], values[1], values[2], values[3]);
        } else if (shape.equals("rect")) {
            g.drawRect(values[0], values[1], values[2], values[3]);
        } else if (shape.equals("circle")) {
            g.drawOval(values[0], values[1], values[2], values[2]);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (shape.equals("line")) {
            int dx = values[2] - values[0];
            int dy = values[3] - values[1];
            values[0] = x;
            values[1] = y;
            values[2] = x + dx;
            values[3] = y + dy;
        } else {
            values[0] = x;
            values[1] = y;
        }
        repaint();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
