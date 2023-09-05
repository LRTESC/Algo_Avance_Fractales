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
        graphics.fillRect((int) (x1+length), (int) (y1+length), (int) length, (int) length);
        if (iter == 0) {
            return;
//            graphics.fillRect((int) x1, (int) y1, (int) size, (int) size);
        } else {
            carpetSierpinski(iter-1,graphics,x1,y1,length);
            carpetSierpinski(iter-1,graphics,x1+length,y1,length);
            carpetSierpinski(iter-1,graphics,x1+2*length,y1,length);
            carpetSierpinski(iter-1,graphics,x1,y1+length,length);
            carpetSierpinski(iter-1,graphics,x1,y1+2*length,length);
            carpetSierpinski(iter-1,graphics,x1+length,y1+2*length,length);

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        carpetSierpinski(2, g, 100, 100, 600);

    }
}
