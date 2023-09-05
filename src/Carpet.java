import javax.swing.*;
import java.awt.*;

public class Carpet extends JPanel {

    public void carpetSierpinski(int iter, Graphics graphics, double x1, double y1, double x2, double y2, boolean b){
        if (iter == 0){

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Fractales");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        Carpet carpet = new Carpet();
        frame.add(carpet);

        frame.setVisible(true);
    }
}
