import javax.swing.*;
import java.awt.*;

public class Flake extends JPanel {

    public void flakeCurve(int iter, Graphics graphics, double x1, double y1, double x2, double y2, boolean b) {
        if (iter == 0) {
            graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        flakeCurve(2, g, 300, 300, 800, 300, true);
        flakeCurve(2, g, 300, 300, 800, 300, true);
        flakeCurve(2, g, 300, 300, 800, 300, true);

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Fractales");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        Flake flake = new Flake();
        frame.add(flake);

        frame.setVisible(true);
    }
}
