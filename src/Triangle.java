import javax.swing.*;
import java.awt.*;

public class Triangle extends JPanel {

    public void triangleSierpinski(int iter, Graphics graphics, double x1, double y1, double x2, double y2, double x3, double y3) {

        if (iter == 0) {
            int[] xPoints = {(int) x1, (int) x2, (int) x3};
            int[] yPoints = {(int) y1, (int) y2, (int) y3};
            graphics.fillPolygon(xPoints, yPoints, 3);
        } else {

            double midX1 = (x1 + x2) / 2;
            double midY1 = (y1 + y2) / 2;
            double midX2 = (x2 + x3) / 2;
            double midY2 = (y2 + y3) / 2;
            double midX3 = (x1 + x3) / 2;
            double midY3 = (y1 + y3) / 2;

            triangleSierpinski(iter - 1, graphics, x1, y1, midX1, midY1, midX3, midY3);
            graphics.setColor(Color.ORANGE);
            triangleSierpinski(iter - 1, graphics, midX1, midY1, x2, y2, midX2, midY2);
            graphics.setColor(Color.BLACK);
            triangleSierpinski(iter - 1, graphics, midX3, midY3, midX2, midY2, x3, y3);
            graphics.setColor(Color.BLUE);
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        int iter = 7;
        double x1 = 300, y1 = 600;
        double x2 = 900, y2 = 600;
        double x3 = 600, y3 = 100;

        triangleSierpinski(iter, g, x1, y1, x2, y2, x3, y3);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Fractales");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        Triangle triangle = new Triangle();
        frame.add(triangle);

        frame.setVisible(true);
    }
}
