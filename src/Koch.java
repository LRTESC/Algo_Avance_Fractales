import javax.swing.*;
import java.awt.*;

public class Koch extends JPanel {

    public void kochCurve(int iter, Graphics graphics, double x1, double y1, double x2, double y2, boolean b){
        if (iter == 0) {
            graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        } else {
            double deltaX, deltaY;;

            deltaX = (x2 - x1) / 3;
            deltaY = (y2 - y1) / 3;
            /*
                   B
                  / \
             ___A/   \C___
             */
            double xA = x1 + deltaX;
            double yA = y1 + deltaY;

            double xC = x2 - deltaX;
            double yC = y2 - deltaY;

            double xB = xA + (xC - xA) * Math.cos(Math.toRadians(60)) - (yC - yA) *  Math.sin(Math.toRadians(60));
            double yB = yA + (xC - xA) * Math.sin(Math.toRadians(60)) + (yC - yA) *  Math.cos(Math.toRadians(60));


            kochCurve(iter - 1, graphics, x1, y1, xA, yA, false);
            kochCurve(iter - 1, graphics, xA, yA, xB, yB, false);
            kochCurve(iter - 1, graphics, xB, yB, xC, yC, false);
            kochCurve(iter - 1, graphics, xC, yC, x2, y2, false);

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        kochCurve(10, g, 300,300, 800, 300, true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Fractales");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        Koch koch = new Koch();
        frame.add(koch);

        frame.setVisible(true);
    }
}
