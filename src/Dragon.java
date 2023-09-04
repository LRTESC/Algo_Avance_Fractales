import javax.swing.*;
import java.awt.*;

public class Dragon extends JPanel {


    public void drawDragon(int iter, Graphics graphics, double x1, double y1, double x2, double y2, boolean left) {
        if (iter == 0) {
            graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        } else {
            double newX, newY;
            if (left) {
                newX = (x1 + x2 + y1 - y2) / 2;
                newY = (x2 - x1 + y1 + y2) / 2;
            } else {
                newX = (x1 + x2 - y1 + y2) / 2;
                newY = (x1 - x2 + y1 + y2) / 2;

            }
            drawDragon(iter - 1, graphics, x1, y1, newX, newY, true);
            drawDragon(iter - 1, graphics, newX, newY, x2, y2, false);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        drawDragon(20, g, 300,300, 800, 300, true);
    }

    /*private static void drawline(int x1, int y1, int x2, int y2) {

    }*/

    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Fractales");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        Dragon dragon = new Dragon();
        frame.add(dragon);

        frame.setVisible(true);
    }
}
