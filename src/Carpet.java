import javax.swing.*;
import java.awt.*;

public class Carpet extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Fractales");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        Carpet carpet = new Carpet();
        frame.add(carpet);

        frame.setVisible(true);
    }

    public void carpetSierpinski(int iter, Graphics graphics, double x1, double y1, double size) {

        double length = size /3;
        double nextSize = length * 2;

        graphics.fillRect((int) (x1+length), (int) (y1+length), (int) length, (int) length);

        if (iter > 0) {

            carpetSierpinski(iter - 1, graphics, x1, y1, length);  // Carré supérieur gauche
            graphics.setColor(Color.BLUE);
            carpetSierpinski(iter - 1, graphics, x1 + nextSize, y1, length);  // Carré supérieur droit
            graphics.setColor(Color.GREEN);
            carpetSierpinski(iter - 1, graphics, x1, y1 + nextSize, length);  // Carré inférieur gauche
            graphics.setColor(Color.GRAY);
            carpetSierpinski(iter - 1, graphics, x1 + nextSize, y1 + nextSize, length);  // Carré inférieur droit
            graphics.setColor(Color.RED);

            carpetSierpinski(iter - 1, graphics, x1 + length, y1, length);  // Carré supérieur central
            graphics.setColor(Color.BLACK);
            carpetSierpinski(iter - 1, graphics, x1, y1 + length, length);  // Carré central gauche
            graphics.setColor(Color.YELLOW);
            carpetSierpinski(iter - 1, graphics, x1 + nextSize, y1 + length, length);  // Carré central droit
            graphics.setColor(Color.ORANGE);
            carpetSierpinski(iter - 1, graphics, x1 + length, y1 + nextSize, length);  // Carré inférieur central
            graphics.setColor(Color.PINK);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        carpetSierpinski(10, g, 100, 100, 600);

    }
}
